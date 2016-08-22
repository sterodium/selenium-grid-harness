package io.sterodium.harness;

import io.sterodium.harness.extension.JMXServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CustomServletTest {

    SeleniumGridHarness harness;

    @Before
    public void setUp() throws Exception {
        harness = new SeleniumGridHarness();
        harness.hub().withServlet(JMXServlet.class);
        harness.node();
    }

    @Test
    public void shouldStartSeleniumGrid() throws Exception {
        harness.startWebServer();
        WebDriver driver = harness.startSession();

    }

    @After
    public void tearDown() throws Exception {

    }

}
