package io.sterodium.harness;

import org.openqa.grid.web.Hub;

public class EmbeddedHub {

    private Hub hub;

    public EmbeddedHub(Hub hub) {
        this.hub = hub;
    }

    public void start() throws Exception {
        hub.start();
    }

    public void stop() throws Exception {
        hub.stop();
    }

}
