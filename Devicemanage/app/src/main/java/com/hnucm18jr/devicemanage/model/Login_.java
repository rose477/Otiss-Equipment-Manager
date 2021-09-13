package com.hnucm18jr.devicemanage.model;

import com.google.gson.Gson;

public class Login_ {

    /**
     * msg : success
     * code : 200
     * data : {"id":1,"account":"10086","userName":"社会主义非常队","pass":"123456","sex":"娚","phone":"10086","email":"10086@qq.com","age":18,"img":"http://8.136.141.131:8090/user/head_img.png","address":"湖南中医药大学","job":"学生","face":"padding","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsInVzZXJOYW1lIjoiMTAwODYiLCJleHAiOjE2MTY3NjI5NzJ9.EcE9_PVS-VuZsCiSlRbKyMpFufvmdnUTRn9yEkA-NyM","creditScore":100}
     */

    private String msg;
    private int code;
    private DataBean data;

    public static Login_ objectFromData(String str) {

        return new Gson().fromJson(str, Login_.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * account : 10086
         * userName : 社会主义非常队
         * pass : 123456
         * sex : 娚
         * phone : 10086
         * email : 10086@qq.com
         * age : 18
         * img : http://8.136.141.131:8090/user/head_img.png
         * address : 湖南中医药大学
         * job : 学生
         * face : padding
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsInVzZXJOYW1lIjoiMTAwODYiLCJleHAiOjE2MTY3NjI5NzJ9.EcE9_PVS-VuZsCiSlRbKyMpFufvmdnUTRn9yEkA-NyM
         * creditScore : 100
         */

        private int id;
        private String account;
        private String userName;
        private String pass;
        private String sex;
        private String phone;
        private String email;
        private int age;
        private String img;
        private String address;
        private String job;
        private String face;
        private String token;
        private int creditScore;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getCreditScore() {
            return creditScore;
        }

        public void setCreditScore(int creditScore) {
            this.creditScore = creditScore;
        }
    }
}

