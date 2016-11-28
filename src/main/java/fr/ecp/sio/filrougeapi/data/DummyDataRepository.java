package fr.ecp.sio.filrougeapi.data;

import fr.ecp.sio.filrougeapi.model.Location;
import fr.ecp.sio.filrougeapi.model.Station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A DataRepository that returns fake data.
 */
public class DummyDataRepository implements DataRepository {

    @Override
    public Station getStation(long id) {
        if (id == 25) {
            Station station = new Station();
            station.setId(25);
            station.setName("Station chatenay");
            station.setAvailableBikes(25);
            station.setAvailableBikeStands(15);
            Location loc = new Location();
            loc.setLatitude(46.0f);
            loc.setLongitude(1.0f);
            loc.setAltitude(1.1f);
            station.setLocation(loc);
            return station;
        } else if (id == 30) {
            Station station = new Station();
            station.setId(30);
            station.setName("Station chatelet");
            station.setAvailableBikes(50);
            station.setAvailableBikeStands(20);
            Location loc = new Location();
            loc.setLatitude(48.0f);
            loc.setLongitude(2.0f);
            loc.setAltitude(2.1f);
            station.setLocation(loc);
            return station;
        } else if (id == 10) {
            Station station = new Station();
            station.setId(10);
            station.setName("Station bastille");
            station.setAvailableBikes(45);
            station.setAvailableBikeStands(10);
            Location loc = new Location();
            loc.setLatitude(38.0f);
            loc.setLongitude(1.6f);
            loc.setAltitude(0.1f);
            station.setLocation(loc);
            return station;
        } else if (id == 5) {
            Station station = new Station();
            station.setId(5);
            station.setName("Station la republique");
            station.setAvailableBikes(40);
            station.setAvailableBikeStands(18);
            Location loc = new Location();
            loc.setLatitude(28.0f);
            loc.setLongitude(0.5f);
            loc.setAltitude(0.2f);
            station.setLocation(loc);
            return station;
        } else {
            return null;
        }
    }

    @Override
    public List<Station> getStations() {
        return Arrays.asList(getStation(25), getStation(30), getStation(10), getStation(5));
    }

    public List<Station> getStations(int offset, int limit) {
        List<Station> stations = getStations();

        // used to store paginated stations
        List<Station> responseStations = new ArrayList<>();

        // limit cannot be 0, if then set to max
        if (limit == 0) {
            limit = stations.size();
        }

        int o = 0, l = 0;
        for (Station station : stations) {
            if (o == offset) {
                if (l < limit) {
                    responseStations.add(station);
                }

                l++;
            } else {
                o++;
            }
        }

        return responseStations;
    }

    @Override
    public List<Station> getStations(String name) throws IOException {
        List<Station> stations = getStations();

        // used to store paginated stations
        List<Station> responseStations = new ArrayList<>();

        for (Station station : stations) {
            if (station.getName().contains(name)) {
                responseStations.add(station);
            }
        }

        return responseStations;
    }

}
