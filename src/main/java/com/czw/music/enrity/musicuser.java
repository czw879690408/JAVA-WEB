package com.czw.music.enrity;

public class musicuser {
    private Integer userId;
    private String  userName;
    private Integer userPromission;
    private String  userAccount;
    private String  userPassword;

    @Override
    public String toString() {
        return "musicuser{" +
                "userId=" + userId +
                ", usdrName='" + userName + '\'' +
                ", userPromission=" + userPromission +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsdrName() {
        return userName;
    }

    public void setUsdrName(String usdrName) {
        this.userName = usdrName;
    }

    public Integer getUserPromission() {
        return userPromission;
    }

    public void setUserPromission(Integer userPromission) {
        this.userPromission = userPromission;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
