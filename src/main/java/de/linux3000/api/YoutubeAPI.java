package de.linux3000.api;

public abstract class YoutubeAPI implements IYoutubeAPI{

    static YoutubeAPI INSTANCE;

    public YoutubeAPI() {
        INSTANCE = this;
    }

    public static YoutubeAPI getINSTANCE() {
        return INSTANCE;
    }

    public static void setInstance(YoutubeAPI INSTANCE) {
        YoutubeAPI.INSTANCE = INSTANCE;
    }

}
