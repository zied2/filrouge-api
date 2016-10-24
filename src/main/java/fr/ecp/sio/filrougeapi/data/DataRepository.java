package fr.ecp.sio.filrougeapi.data;

import fr.ecp.sio.filrougeapi.model.Station;

import java.util.List;

/**
 * Created by usersio on 24/10/2016.
 */
public interface DataRepository {

    Station getStation(long id);
    List<Station> getStations();

}
