package authentifizierungPackage;

import java.util.HashMap;
import java.util.Map;

public class PasswortManager {
    Map<String, String> database = new HashMap<>();
    private static PasswortManager passwortManager = new PasswortManager();

    private PasswortManager() {
        database.put("Admin", "Test");
    }

    public static PasswortManager getPasswortManager() {
        return passwortManager;
    }

    public Map getMap() {
        return database;
    }

    public void setMap(String username, String passwort) {
        database.put(username, passwort);
    }

}
