package io.sterodium.harness;

import io.sterodium.harness.extension.RecordingHubRemoteProxy;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomRemoteProxyTest {

    SeleniumGridHarness harness;

    @Before
    public void setUp() throws Exception {
        harness = new SeleniumGridHarness();
        harness.hub().build().start();
        harness.node().withRemoteProxy(RecordingHubRemoteProxy.class).build().start();

        assertThat(RecordingHubRemoteProxy.getTestSessions()).isEmpty();
    }

    @Test
    public void shouldRegisterProxy() throws Exception{
        harness.startWebServer();
        WebDriver driver = harness.startSession();
        driver.close();

        assertThat(RecordingHubRemoteProxy.getTestSessions()).hasSize(1);
    }

}
