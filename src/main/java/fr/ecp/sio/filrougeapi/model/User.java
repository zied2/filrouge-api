package fr.ecp.sio.filrougeapi.model;

/**
 * Created by Zied on 27/11/2016.
 */
public class User {
    private String login;
    private String password;
    private String apiKey;

    public User(String login, String password, String apiKey) {
        this.login = login;
        this.password = password;
        this.apiKey = apiKey;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
