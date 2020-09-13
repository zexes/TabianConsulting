package com.zikozee.tabianconsulting.models;

public class User {
    private String name;
    private String phone;
    private String profile_image;
    private String user_id;
    private String security_level;
    private String messaging_token;
    private String department;

    public User(String name, String phone, String profile_image, String user_id, String security_level, String messaging_token, String department) {
        this.name = name;
        this.phone = phone;
        this.profile_image = profile_image;
        this.user_id = user_id;
        this.security_level = security_level;
        this.messaging_token = messaging_token;
        this.department = department;
    }

    public User() {

    }

    private User(Builder builder) {
        setName(builder.name);
        setPhone(builder.phone);
        setProfile_image(builder.profile_image);
        setUser_id(builder.user_id);
        setSecurity_level(builder.security_level);
        messaging_token = builder.messaging_token;
        department = builder.department;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSecurity_level() {
        return security_level;
    }

    public void setSecurity_level(String security_level) {
        this.security_level = security_level;
    }

    public String getMessaging_token() {
        return messaging_token;
    }

    public void setMessaging_token(String messaging_token) {
        this.messaging_token = messaging_token;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static final class Builder {
        private String name;
        private String phone;
        private String profile_image;
        private String security_level;
        private String messaging_token;
        private String department;
        private String user_id;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder profile_image(String val) {
            profile_image = val;
            return this;
        }

        public Builder security_level(String val) {
            security_level = val;
            return this;
        }

        public Builder messaging_token(String val) {
            messaging_token = val;
            return this;
        }

        public Builder department(String val) {
            department = val;
            return this;
        }

        public Builder user_id(String val) {
            user_id = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
