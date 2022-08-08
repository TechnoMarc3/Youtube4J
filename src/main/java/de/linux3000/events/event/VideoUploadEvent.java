package de.linux3000.events.event;

import de.linux3000.base.YoutubeChannel;
import de.linux3000.base.YoutubeVideo;
import de.linux3000.events.IEvent;

public class VideoUploadEvent implements IEvent {

    private YoutubeChannel channel;
    private YoutubeVideo newVideo;

    public VideoUploadEvent(YoutubeChannel channel, YoutubeVideo newVideo) {
        this.channel = channel;
        this.newVideo = newVideo;
    }

    public YoutubeChannel getChannel() {
        return channel;
    }

    public YoutubeVideo getNewVideo() {
        return newVideo;
    }
}
