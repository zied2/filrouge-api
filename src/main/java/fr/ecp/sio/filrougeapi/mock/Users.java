package fr.ecp.sio.filrougeapi.mock;

import fr.ecp.sio.filrougeapi.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zied on 27/11/2016.
 */
public class Users {

    public static List<User> users = new ArrayList<User>()
    {{
        add(new User("zied", "pass55", "af56d90ae59e55feea"));
        add(new User("paul", "pass55", "eef565219f93e2862d"));
    }};
}
