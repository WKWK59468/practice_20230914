package demo.practice_20230914.models;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private String email;
    private String username;
    private String password;
    private Date createTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Date  getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date  createTime) {
            this.createTime = createTime;
        }
        @Override
        public String toString() {
            return "User{" +
                    "email='" + email + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", createTime=" + createTime +
                    '}';
    }
}
