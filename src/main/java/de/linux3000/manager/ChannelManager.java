package de.linux3000.manager;

import de.linux3000.base.YoutubeChannel;

import java.util.stream.Collectors;


public class ChannelManager {

    public YoutubeChannel getYoutubeChannel(String url) {

        if (!url.contains("youtube.com")) return null;
        url = url.replace("https://", "");
        String[] split = url.split("/");
        return YoutubeChannel.getYoutubeChannel(split[2]);

    }





}
