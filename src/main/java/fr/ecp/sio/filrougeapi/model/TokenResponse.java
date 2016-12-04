package fr.ecp.sio.filrougeapi.model;

/**
 * Created by Zied on 04/12/2016.
 */
public class TokenResponse {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public TokenResponse(String token) {
        this.token = token;
    }
}
