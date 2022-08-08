package de.linux3000.base;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YoutubeVideo {

    private YoutubeChannel channel;
    private String title;
    private int views;
    private int likes;
    private String id;
    private String description;
    private List<YoutubeComment> comments;
    private Date timeCreated;

    private static List<YoutubeVideo> videos = new ArrayList<>();

    public YoutubeVideo(String title, String id) {
        this.title = title;
        this.id = id;

        videos.add(this);
    }

    public void setChannel(YoutubeChannel channel) {
        this.channel = channel;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected void registerComment(YoutubeComment comment ) {
        this.comments.add(comment);
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public YoutubeChannel getChannel() {
        return channel;
    }

    public String getTitle() {
        return title;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<YoutubeComment> getComments() {
        return comments;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public static List<YoutubeVideo> getVideos() {
        return videos;
    }

    public static boolean hasVideo(String videoId) {
        for(YoutubeVideo video : getVideos()) {
            if(video.getId().equalsIgnoreCase(videoId)) {
                return true;
            }
        }
        return false;
    }
}
