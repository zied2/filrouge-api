package fr.ecp.sio.filrougeapi.model;

/**
 * Created by usersio on 24/10/2016.
 */
public class Location {

    private float latitude, longitude;
    private float altitude;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

}
