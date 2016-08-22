package io.sterodium.harness;

import org.openqa.grid.common.RegistrationRequest;

import java.util.HashMap;
import java.util.Map;

public final class NodeBuilder {

    private String id;

    NodeBuilder() {
    }

    public NodeBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public EmbeddedNode build() throws SeleniumHarnessException {
        RegistrationRequest config = new RegistrationRequest();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(RegistrationRequest.HUB_HOST, "127.0.0.1");
        attributes.put(RegistrationRequest.HUB_PORT, 4444);
        attributes.put(RegistrationRequest.PORT, 5555);
        attributes.put(RegistrationRequest.HOST, "127.0.0.1");
        attributes.put(RegistrationRequest.REMOTE_HOST, "http://127.0.0.1:5555");
        attributes.put(RegistrationRequest.ID, id);
        attributes.put("register", true);
        config.setConfiguration(attributes);
        return new EmbeddedNode(config);
    }

}
