package fr.ecp.sio.filrougeapi.endpoints;

import fr.ecp.sio.filrougeapi.data.DataRepository;
import fr.ecp.sio.filrougeapi.data.DataUtils;
import fr.ecp.sio.filrougeapi.model.Station;
import fr.ecp.sio.filrougeapi.model.StationsResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to handle requests for a list of stations.
 * This servlet receives requests to URLs /stations.
 */
public class StationsServlet extends ApiServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int offset, limit;
        try {
            limit = Integer.parseInt(req.getParameter("limit"));
        } catch (NumberFormatException e) {
            limit = 0;
        }
        try {
            offset = Integer.parseInt(req.getParameter("offset"));
        } catch (NumberFormatException e) {
            offset = 0;
        }

        String name = req.getParameter("name");

        DataRepository rep = DataUtils.getRepository();

        List<Station> stations;
        if (name != null && !name.isEmpty()) {
            stations = rep.getStations(name);
        } else if (offset > 0 || limit > 0) {
            stations = rep.getStations(offset, limit);
        } else {
            stations = rep.getStations();
        }

        resp.setContentType("application/json");
        sendResponse(new StationsResponse(stations), resp);
    }

}
