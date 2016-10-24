package fr.ecp.sio.filrougeapi.endpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by usersio on 24/10/2016.
 */
public class ApiServlet extends HttpServlet {

    protected void sendResponse(Object data, HttpServletResponse resp) throws IOException {
        Gson gson = new GsonBuilder().create();
        gson.toJson(data, resp.getWriter());
    }

}
