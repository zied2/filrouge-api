package fr.ecp.sio.filrougeapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by usersio on 24/10/2016.
 */
public class GsonUtils {

    public static Gson getGson() {
        return new GsonBuilder().create();
    }

}
