package model;

import java.util.ArrayList;

public class UserDatabase {

    private static ArrayList<User> users = new ArrayList<>();

    public static boolean register(String username, String password) {

        for(User u : users) {
            if(u.getUsername().equals(username))
                return false; 
        }

        users.add(new User(username, password));
        return true;
    }

    public static boolean login(String username, String password) {

        for(User u : users) {
            if(u.getUsername().equals(username) &&
               u.getPassword().equals(password))
                return true;
        }

        return false;
    }
}