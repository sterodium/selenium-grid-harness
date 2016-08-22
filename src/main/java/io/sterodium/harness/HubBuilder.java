package io.sterodium.harness;

import org.openqa.grid.internal.utils.GridHubConfiguration;
import org.openqa.grid.web.Hub;
import org.openqa.grid.web.servlet.RegistryBasedServlet;

import java.util.ArrayList;
import java.util.List;

public final class HubBuilder {

    List<String> servlets = new ArrayList<String>();

    HubBuilder() {
    }

    public EmbeddedHub build() throws SeleniumHarnessException {
        GridHubConfiguration configuration = new GridHubConfiguration();
        configuration.setServlets(servlets);
        Hub hub = new Hub(configuration);
        return new EmbeddedHub(hub);
    }

    public HubBuilder withServlet(Class<? extends RegistryBasedServlet> servlet) {
        servlets.add(servlet.getClass().getName());
        return this;
    }

}
