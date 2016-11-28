package fr.ecp.sio.filrougeapi.auth;

import fr.ecp.sio.filrougeapi.mock.Users;
import fr.ecp.sio.filrougeapi.model.User;

/**
 * Created by Zied on 27/11/2016.
 */
public class AuthManager {

    public static String getAPIKey(String username, String password) {
        for (User user : Users.users) {
            if (user.getLogin().equals(username) && user.getPassword().equals(password))
                return user.getApiKey();
        }

        return null;
    }

    public static boolean isValidApiKey(String key) {
        for (User user : Users.users) {
            if (user.getApiKey().equals(key))
                return true;
        }

        return false;
    }
}
