package io.sterodium.harness.extension;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.internal.TestSession;
import org.openqa.grid.selenium.proxy.DefaultRemoteProxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class RecordingHubRemoteProxy extends DefaultRemoteProxy {

    public RecordingHubRemoteProxy(RegistrationRequest request, Registry registry) {
        super(request, registry);
    }

    private final static List<TestSession> testSessions = new ArrayList<>();

    public static List<TestSession> getTestSessions() {
        return testSessions;
    }

    @Override
    public void beforeSession(TestSession session) {
        super.beforeSession(session);

        testSessions.add(session);
    }

    @Override
    public void afterSession(TestSession session) {
        super.afterSession(session);
    }

    @Override
    public void beforeCommand(TestSession session, HttpServletRequest request, HttpServletResponse response) {
        super.beforeCommand(session, request, response);
    }

    @Override
    public void afterCommand(TestSession session, HttpServletRequest request, HttpServletResponse response) {
        super.afterCommand(session, request, response);
    }

}
