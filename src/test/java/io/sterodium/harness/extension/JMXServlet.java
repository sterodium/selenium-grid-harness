package io.sterodium.harness.extension;

import org.openqa.grid.internal.Registry;
import org.openqa.grid.web.servlet.RegistryBasedServlet;

public final class JMXServlet extends RegistryBasedServlet {

    public JMXServlet() {
        super(null);
    }

    public JMXServlet(Registry registry) {
        super(registry);
    }

}
