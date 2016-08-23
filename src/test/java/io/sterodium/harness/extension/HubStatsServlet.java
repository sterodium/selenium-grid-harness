package io.sterodium.harness.extension;

import com.google.gson.Gson;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.web.servlet.RegistryBasedServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class HubStatsServlet extends RegistryBasedServlet {

    Gson gson = new Gson();

    public HubStatsServlet() {
        super(null);
    }

    public HubStatsServlet(Registry registry) {
        super(registry);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        Registry registry = getRegistry();

        HubStats stats = new HubStats();

        String json = gson.toJson(stats);
        response.getWriter().write(json);
    }

}
