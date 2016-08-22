package io.sterodium.harness;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.SeleniumServer;

public final class EmbeddedNode {

    private final RegistrationRequest config;

    public EmbeddedNode(RegistrationRequest config) {
        this.config = config;
    }

    public void start() throws Exception {
        SelfRegisteringRemote remote = new SelfRegisteringRemote(config);
        remote.addBrowser(DesiredCapabilities.htmlUnitWithJs(), 1);
        SeleniumServer server = new SeleniumServer(5555);
        remote.setRemoteServer(server);
        remote.startRemoteServer();
        remote.startRegistrationProcess();
    }

}
