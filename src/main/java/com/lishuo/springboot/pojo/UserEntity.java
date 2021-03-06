package com.lishuo.springboot.pojo;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "test_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_telephone")
    private String userTelephone;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "version")
    private Integer version;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userTelephone='" + userTelephone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", version=" + version +
                '}';
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
