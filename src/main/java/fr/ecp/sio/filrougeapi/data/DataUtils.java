package fr.ecp.sio.filrougeapi.data;

/**
 * Created by usersio on 24/10/2016.
 */
public class DataUtils {

    private static DataRepository sRepository;

    public static DataRepository getRepository() {
        if (sRepository == null) {
            sRepository = new DummyDataRepository();
        }
        return sRepository;
    }

}
