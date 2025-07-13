package ir.baharn.demobaharan.utility;

import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.model.User;
import jakarta.servlet.http.HttpSession;

public class GettingSession {

    public static Role getCurrentUserRole(HttpSession session) {
        if (session == null) {
            return null;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return null;
        }

        return user.getRole();
    }

    public static boolean hasRole(HttpSession session, Role... roles) {
        Role currentRole = getCurrentUserRole(session);
        if (currentRole == null) {
            return false;
        }

        for (Role role : roles) {
            if (currentRole == role) {
                return true;
            }
        }
        return false;
    }
}
