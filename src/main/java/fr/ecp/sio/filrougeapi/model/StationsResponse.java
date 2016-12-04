package fr.ecp.sio.filrougeapi.model;

import java.util.List;

/**
 * Created by Zied on 27/11/2016.
 */
public class StationsResponse {
    private List<Station> stations;

    private int totalBikes = 0;

    private int totalAvailableBikes = 0;

    public StationsResponse(List<Station> stations) {
        this.stations = stations;

        for (Station station : this.stations) {
            this.totalBikes += station.getAvailableBikes();
            this.totalAvailableBikes += station.getAvailableBikeStands();
        }
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getTotalBikes() {
        return totalBikes;
    }

    public int getTotalAvailableBikes() {
        return totalAvailableBikes;
    }
}
