package com.example.personalwellness;

public class CurrentUser {
    private static CurrentUser curr = null;
    private static User user;

    private CurrentUser (User user) {
        this.user = user;
    }

    public static User getCurrentUser (User user) {
        if (curr == null) {
            curr = new CurrentUser(user);
        }
        return user;
    }
}
