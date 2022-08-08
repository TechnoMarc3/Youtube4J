package de.linux3000;

import de.linux3000.api.YoutubeAPI;
import de.linux3000.api.YoutubeApiImpl;
import de.linux3000.base.YoutubeChannel;
import de.linux3000.base.YoutubeVideo;
import de.linux3000.formats.URLFormatter;
import de.linux3000.listener.EventListener;
import de.linux3000.listener.TestListener;
import de.linux3000.manager.ChannelManager;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

    //gives the last 31 videos on the youtube channel
    public static void main(String[] args) {

        YoutubeAPI.setInstance(new YoutubeApiImpl());

        YoutubeChannel youtubeChannel = new ChannelManager().getYoutubeChannel("https://www.youtube.com/c/Mrmobilefanboy");

        YoutubeAPI.getINSTANCE().getEventManager().registerListener(new TestListener());
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                new URLFormatter().getPage(youtubeChannel);
            }
        };
        timer.scheduleAtFixedRate(task, 10*1000,10*1000);



    }

}
