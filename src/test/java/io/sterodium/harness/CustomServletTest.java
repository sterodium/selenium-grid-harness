package io.sterodium.harness;

import io.sterodium.harness.extension.JMXServlet;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.StringWriter;

public class CustomServletTest {

    SeleniumGridHarness harness;

    @Before
    public void setUp() throws Exception {
        harness = new SeleniumGridHarness();
        harness.hub().withServlet(JMXServlet.class).build().start();
        harness.node().build().start();
    }

    @Test
    public void shouldStartSeleniumGrid() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        String path = "http://127.0.0.1:4444/grid/admin/"
                + JMXServlet.class.getSimpleName();
        HttpGet httpGet = new HttpGet(path);
        HttpResponse response = client.execute(httpGet);
        InputStream content = response.getEntity().getContent();
        StringWriter writer = new StringWriter();
        IOUtils.copy(content, writer, "UTF-8");
        String output = writer.toString();
        System.out.println(output);
    }

    @After
    public void tearDown() throws Exception {

    }

}
