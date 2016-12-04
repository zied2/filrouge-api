package fr.ecp.sio.filrougeapi.endpoints;

import fr.ecp.sio.filrougeapi.auth.AuthManager;
import fr.ecp.sio.filrougeapi.data.DataRepository;
import fr.ecp.sio.filrougeapi.data.DataUtils;
import fr.ecp.sio.filrougeapi.model.Station;
import fr.ecp.sio.filrougeapi.model.TokenResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A servlet to handle requests for a single station.
 * This servlet receives requests to URLs /stations/{id}.
 */
public class AuthServlet extends ApiServlet {

    // HttpServlet has protected doXxx() methods that correspond to HTTP verbs (GET, POST...).
    // These methods receive objects to represent both the request (to inspect or read from) and the response (to write to).
    // Default implementation sends a 405 error, so we must override doGet() to support GET requests and NOT call super implementation.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(403, "Use HTTP POST method instead.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String token = AuthManager.getAPIKey(login, password);

        if (token != null) {
            sendResponse(new TokenResponse(token), resp);
        } else {
            resp.sendError(401, "Invalid username/password");
        }
    }

}
