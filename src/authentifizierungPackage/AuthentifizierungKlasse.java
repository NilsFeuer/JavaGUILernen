package authentifizierungPackage;

import guiPackage.LoginFrame;

import java.util.Map;

public class AuthentifizierungKlasse {
    public Boolean checkLogin(Map<String, String> db, LoginFrame lF) {
        try {
            return db.get(lF.getUserText()).equals(lF.getPasswordField());
        } catch (Exception e) {
            return false;
        }
    }
}
