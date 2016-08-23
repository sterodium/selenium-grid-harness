package io.sterodium.harness;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.BaseRemoteProxy;
import org.openqa.grid.internal.RemoteProxy;

import java.util.HashMap;
import java.util.Map;

public final class NodeBuilder {

    private String id = "node";
    private String remoteProxy = BaseRemoteProxy.class.getCanonicalName();
    private int port = 5555;

    NodeBuilder() {
    }

    public NodeBuilder withRemoteProxy(Class<? extends RemoteProxy> remoteProxy) {
        this.remoteProxy = remoteProxy.getCanonicalName();
        return this;
    }

    public NodeBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public NodeBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    public EmbeddedNode build() throws SeleniumHarnessException {
        RegistrationRequest config = new RegistrationRequest();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(RegistrationRequest.HUB_HOST, "127.0.0.1");
        attributes.put(RegistrationRequest.HUB_PORT, 4444);
        attributes.put(RegistrationRequest.PORT, port);
        attributes.put(RegistrationRequest.HOST, "127.0.0.1");
        attributes.put(RegistrationRequest.REMOTE_HOST, "http://127.0.0.1:5555");
        attributes.put(RegistrationRequest.ID, id);
        attributes.put(RegistrationRequest.PROXY_CLASS, remoteProxy);
        attributes.put("register", true);
        config.setConfiguration(attributes);
        return new EmbeddedNode(config);
    }

}
