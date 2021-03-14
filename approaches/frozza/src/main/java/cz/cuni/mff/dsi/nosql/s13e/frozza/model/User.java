package cz.cuni.mff.dsi.nosql.s13e.frozza.model;

public class User {

    public final String username;
    public final String email;
    public final String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
