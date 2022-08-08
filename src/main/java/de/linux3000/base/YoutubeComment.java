package de.linux3000.base;

public class YoutubeComment {

    private YoutubeChannel channel;
    private String comment;

    public YoutubeComment(YoutubeChannel channel, String comment) {
        this.channel = channel;
        this.comment = comment;
    }

    public YoutubeChannel getChannel() {
        return channel;
    }

    public String getComment() {
        return comment;
    }
}
