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
import java.util.List;

/**
 * Created by usersio on 24/10/2016.
 */
public class StationsServlet extends ApiServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataRepository rep = DataUtils.getRepository();
        List<Station> stations = rep.getStations();

        sendResponse(stations, resp);

    }

}
