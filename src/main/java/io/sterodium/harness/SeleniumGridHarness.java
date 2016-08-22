package io.sterodium.harness;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class SeleniumGridHarness {

    public void startWebServer() {
        EmbeddedWebServer webServer = new EmbeddedWebServer();
        webServer.init();
    }

    public WebDriver startSession() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.htmlUnitWithJs();
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new SeleniumHarnessException(e);
        }
        return new RemoteWebDriver(url, capabilities);
    }

    public HubBuilder hub() {
        return new HubBuilder();
    }

    public NodeBuilder node() {
        return new NodeBuilder();
    }

}
