package fr.ecp.sio.filrougeapi.data;

import fr.ecp.sio.filrougeapi.model.Location;
import fr.ecp.sio.filrougeapi.model.Station;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usersio on 24/10/2016.
 */
public class SQLDataRepository implements DataRepository {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/velib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "promo2016";

    private Connection openConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }

    private Station createStation(ResultSet rs) throws SQLException {
        Station s = new Station();
        s.setId(rs.getLong("id"));
        Location l = new Location();
        l.setLatitude(rs.getFloat("latitude"));
        l.setLongitude(rs.getFloat("longitude"));
        l.setAltitude(rs.getFloat("altitude"));
        s.setLocation(l);
        s.setName(rs.getString("name"));
        s.setAvailableBikes(rs.getInt("availableBikes"));
        s.setAvailableBikeStands(rs.getInt("availableBikeStands"));
        return s;
    }

    @Override
    public Station getStation(long id) throws IOException {
        try (
            Connection c = openConnection();
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM stations WHERE id = ?");
        ) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) return null;
                return createStation(rs);
            }
        } catch (SQLException e) {
            throw new IOException("Database error", e);
        }
    }

    @Override
    public List<Station> getStations() throws IOException {
        List<Station> list = new ArrayList<>();
        try (
            Connection c = openConnection();
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM stations");
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                list.add(createStation(rs));
            }
        } catch (SQLException e) {
            throw new IOException("Database error", e);
        }
        return list;
    }
}
