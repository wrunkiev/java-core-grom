package lesson36.model;

public class Session {
    private long id;
    private String name;
    private String userName;
    private long userId;
    private UserType userType;



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public long getUserId() {
        return userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
