package fr.ecp.sio.filrougeapi.endpoints;

import com.google.gson.Gson;
import fr.ecp.sio.filrougeapi.GsonUtils;
import fr.ecp.sio.filrougeapi.data.DataRepository;
import fr.ecp.sio.filrougeapi.data.DataUtils;
import fr.ecp.sio.filrougeapi.model.Station;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by usersio on 24/10/2016.
 */
public class StationServlet extends ApiServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id;
        try {
            id = Long.parseLong(req.getPathInfo().substring(1));
        } catch (NumberFormatException ex) {
            resp.sendError(400, "Invalid station id");
            return;
        }

        DataRepository rep = DataUtils.getRepository();
        Station station = rep.getStation(id);

        if (station == null) {
            resp.sendError(404, "Station not found");
        }

        sendResponse(station, resp);

    }

}
