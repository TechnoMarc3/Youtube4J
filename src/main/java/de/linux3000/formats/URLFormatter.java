package de.linux3000.formats;

import de.linux3000.api.YoutubeAPI;
import de.linux3000.base.YoutubeChannel;
import de.linux3000.base.YoutubeVideo;
import de.linux3000.events.event.VideoUploadEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLFormatter {

    boolean hasNewVideos = false;

    public void getPage(YoutubeChannel channel) {
        try {
            URLConnection connection = new URL("https://youtube.com/c/" + channel.getName() + "/videos").openConnection();
            connection.setRequestProperty("User-Agent", "1.1.2 - BETA");
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\A");
            String raw = "";
            while (scanner.hasNext()) {
                raw += scanner.next();
            }

            getInfos(raw, channel);
        } catch (IOException ignored) {

        }
    }

    private void getInfos(String raw, YoutubeChannel channel) {
        String[] infos = raw.split("}]}}}]}}");

        for(int i = 0; i<infos.length; i++) {

            String info = infos[i];
            if(!info.contains("gridVideoRenderer")) continue;
            if(i == 0) {
                int index = info.indexOf("gridVideoRenderer");
                info = info.substring(index-1);
                info  = info.replace("gridVideoRenderer", "{\"gridVideoRenderer");
            }
            info = info.substring(1);
            info += "}]}}}]}}";
            info = info.replaceAll(":", ": ");
            try {
                readJsonData(info, channel);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("has new videos: " + hasNewVideos);
    }

    private void readJsonData(String info, YoutubeChannel channel) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(info);
        JSONObject infos = (JSONObject) object.get("gridVideoRenderer");

        String videoID = infos.get("videoId").toString();
        String title = getTitle(infos);
        if(!YoutubeVideo.hasVideo(videoID)) {
            YoutubeVideo youtubeVideo = new YoutubeVideo(title, videoID);
            youtubeVideo.setChannel(channel);
            channel.addVideo(youtubeVideo);
            YoutubeAPI.getINSTANCE().getEventManager().callEvent(new VideoUploadEvent(channel, youtubeVideo));
            hasNewVideos = true;
        }
    }

    private String getTitle(JSONObject object) {
        JSONObject plainTitle = (JSONObject) object.get("title");
        JSONArray runs = (JSONArray) plainTitle.get("runs");
        JSONObject obj = (JSONObject) runs.get(0);
        return obj.get("text").toString();
    }

}
