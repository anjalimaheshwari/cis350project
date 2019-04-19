package com.example.personalwellness;

public class CurrentUser {
    private static CurrentUser curr = null;
    private static User user;

    private CurrentUser (User user) {
        this.user = user;
    }

    public static User getCurrentUser (User u) {
        if (curr == null) {
            curr = new CurrentUser(u);
        }
        return user;
    }
}
