package de.linux3000.listener;

import de.linux3000.events.event.VideoUploadEvent;

public class TestListener extends EventListener{

    public void onUpload(VideoUploadEvent event) {
        System.out.println(event.getChannel().getName() + " just uploaded a video");
    }

}
