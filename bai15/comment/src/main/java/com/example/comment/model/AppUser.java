package com.example.comment.model;

import javax.persistence.*;

@Entity
@Table(name="App_User",uniqueConstraints ={@UniqueConstraint(name="APP_ROLE_UK",columnNames = "User_Name")})
public class AppUser {
   @Id
    @GeneratedValue
    @Column(name="User_Id",nullable = false)
    private Long userId;

   @Column(name="User_name",length = 36,nullable = false)
    private String userName;

   @Column(name="Encrypted_Password",length = 128,nullable = false)
    private String encryptedPassword;

   @Column(name="Enabled",length = 1,nullable = false)
    private boolean enabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
