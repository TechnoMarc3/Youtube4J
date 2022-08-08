package de.linux3000.base;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {

    private String name;
    private String channel_id;
    private List<YoutubeVideo> videos = new ArrayList<>();

    private int subscribers;

    private static List<YoutubeChannel> channels = new ArrayList<>();

    public YoutubeChannel(String name, String channel_id) {
        this.name = name;
        this.channel_id = channel_id;

        channels.add(this);
    }

    public YoutubeChannel(String name) {
        this.name = name;

        channels.add(this);
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public String getName() {
        return name;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void addVideo(YoutubeVideo video) {
        videos.add(video);
    }

    public List<YoutubeVideo> getAllVideos() {
        return videos;
    }

    public static List<YoutubeChannel> getAllChannels() {
        return channels;
    }

    public static YoutubeChannel getYoutubeChannel(String name){
        for(YoutubeChannel channel : getAllChannels()) {
            if(channel.getName().equalsIgnoreCase(name)) {
                return channel;
            }
        }
        return new YoutubeChannel(name);
    }
}
