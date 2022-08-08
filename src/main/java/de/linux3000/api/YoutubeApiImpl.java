package de.linux3000.api;

import de.linux3000.listener.BaseEventManager;
import de.linux3000.listener.IEventManager;

public class YoutubeApiImpl extends YoutubeAPI{

    private IEventManager manager;

    public YoutubeApiImpl() {
        manager = new BaseEventManager();
    }

    @Override
    public IEventManager getEventManager() {
        return manager;
    }
}
