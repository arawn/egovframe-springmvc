package egovframe.model;

public class User {

    String username;

    public User() { }
    
    public User(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public boolean isAnonymous() {
        return "anonymous".equals(username);
    }
    
    public static User anonymous() {
        return new User("anonymous");
    }
    
}
