package io.sterodium.harness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SeleniumGridTest {

    SeleniumGridHarness harness;

    @Before
    public void setUp() throws Exception {
        harness = new SeleniumGridHarness();
        harness.hub().build().start();
        harness.node().build().start();
    }

    @Test
    public void shouldStartSeleniumGrid() throws Exception {
        harness.startWebServer();
        WebDriver driver = harness.startSession();

        WebDriver.Navigation navigate = driver.navigate();
        navigate.to(new URL("http://localhost:8080"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        WebElement element = driver.findElement(By.id("test"));
        assertThat(element.getText(), equalTo("Hello"));
    }

    @After
    public void tearDown() throws Exception {

    }

}
