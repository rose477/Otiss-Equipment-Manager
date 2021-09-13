package com.hnucm18jr.devicemanage.model;

import com.google.gson.Gson;

import java.util.List;

public class Main_ {
    /**
     * msg : success
     * code : 200
     * data : {"user":{"token":null,"account":"002","pass":"123456","id":2,"userName":"伊娜","sex":"女","phone":"18965376727","email":"1318121527@qq.com","age":20,"img":"http://8.136.141.131:8090/messages/file/head.png","address":"湖南中医药大学","job":"财务部","face":"padding","creditScore":100},"newMachine":[{"id":22,"machineName":"未发售手机","machineImg":null,"machineCode":"0000022","markNum":"PRO WIRELESS","machineType":"电子产品","manufacturer":"罗技","supplier":"罗技","money":780,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"罗技","outDate":"2020-03-14T00:00:00.000+00:00","userId":"0","startDate":"2020-03-20T00:00:00.000+00:00"},{"id":21,"machineName":"未发售手机","machineImg":null,"machineCode":"0000021","markNum":"PRO WIRELESS","machineType":"电子产品","manufacturer":"罗技","supplier":"罗技","money":780,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"罗技","outDate":"2020-03-14T00:00:00.000+00:00","userId":"0","startDate":"2020-03-20T00:00:00.000+00:00"},{"id":20,"machineName":"未发售手机","machineImg":null,"machineCode":"0000020","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":19,"machineName":"未发售手机","machineImg":null,"machineCode":"0000019","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"-1","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":18,"machineName":"未发售手机","machineImg":null,"machineCode":"0000018","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":17,"machineName":"未发售手机","machineImg":null,"machineCode":"0000017","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"-1","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":16,"machineName":"未发售手机","machineImg":null,"machineCode":"0000016","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":15,"machineName":"未发售手机","machineImg":null,"machineCode":"0000015","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":14,"machineName":"未发售手机","machineImg":null,"machineCode":"0000014","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"-1","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":13,"machineName":"未发售手机","machineImg":"http://8.136.141.131:8090/messages/file/Applebook air.jpg","machineCode":"0000013","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"}],"suggestMachine":{"total":0,"list":null,"pageNum":0,"pageSize":0,"size":0,"startRow":0,"endRow":0,"pages":0,"prePage":0,"nextPage":0,"isFirstPage":false,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":0,"navigatepageNums":null,"navigateFirstPage":0,"navigateLastPage":0},"departMachine":{"total":0,"list":null,"pageNum":0,"pageSize":0,"size":0,"startRow":0,"endRow":0,"pages":0,"prePage":0,"nextPage":0,"isFirstPage":false,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":0,"navigatepageNums":null,"navigateFirstPage":0,"navigateLastPage":0}}
     */

    private String msg;
    private int code;
    private DataBean data;

    public static Main_ objectFromData(String str) {

        return new Gson().fromJson(str, Main_.class);
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
         * user : {"token":null,"account":"002","pass":"123456","id":2,"userName":"伊娜","sex":"女","phone":"18965376727","email":"1318121527@qq.com","age":20,"img":"http://8.136.141.131:8090/messages/file/head.png","address":"湖南中医药大学","job":"财务部","face":"padding","creditScore":100}
         * newMachine : [{"id":22,"machineName":"未发售手机","machineImg":null,"machineCode":"0000022","markNum":"PRO WIRELESS","machineType":"电子产品","manufacturer":"罗技","supplier":"罗技","money":780,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"罗技","outDate":"2020-03-14T00:00:00.000+00:00","userId":"0","startDate":"2020-03-20T00:00:00.000+00:00"},{"id":21,"machineName":"未发售手机","machineImg":null,"machineCode":"0000021","markNum":"PRO WIRELESS","machineType":"电子产品","manufacturer":"罗技","supplier":"罗技","money":780,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"罗技","outDate":"2020-03-14T00:00:00.000+00:00","userId":"0","startDate":"2020-03-20T00:00:00.000+00:00"},{"id":20,"machineName":"未发售手机","machineImg":null,"machineCode":"0000020","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":19,"machineName":"未发售手机","machineImg":null,"machineCode":"0000019","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"-1","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":18,"machineName":"未发售手机","machineImg":null,"machineCode":"0000018","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":17,"machineName":"未发售手机","machineImg":null,"machineCode":"0000017","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"-1","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":16,"machineName":"未发售手机","machineImg":null,"machineCode":"0000016","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":15,"machineName":"未发售手机","machineImg":null,"machineCode":"0000015","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":14,"machineName":"未发售手机","machineImg":null,"machineCode":"0000014","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"-1","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"},{"id":13,"machineName":"未发售手机","machineImg":"http://8.136.141.131:8090/messages/file/Applebook air.jpg","machineCode":"0000013","markNum":"Air","machineType":"电子产品","manufacturer":"Apple","supplier":"Apple","money":7999,"qrCode":null,"machineStatus":"空闲","isImportant":"是","oldYear":5,"residual":5,"brand":"Apple","outDate":"2018-03-14T00:00:00.000+00:00","userId":"0","startDate":"2018-03-20T00:00:00.000+00:00"}]
         * suggestMachine : {"total":0,"list":null,"pageNum":0,"pageSize":0,"size":0,"startRow":0,"endRow":0,"pages":0,"prePage":0,"nextPage":0,"isFirstPage":false,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":0,"navigatepageNums":null,"navigateFirstPage":0,"navigateLastPage":0}
         * departMachine : {"total":0,"list":null,"pageNum":0,"pageSize":0,"size":0,"startRow":0,"endRow":0,"pages":0,"prePage":0,"nextPage":0,"isFirstPage":false,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":0,"navigatepageNums":null,"navigateFirstPage":0,"navigateLastPage":0}
         */

        private UserBean user;
        private SuggestMachineBean suggestMachine;
        private DepartMachineBean departMachine;
        private List<NewMachineBean> newMachine;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public SuggestMachineBean getSuggestMachine() {
            return suggestMachine;
        }

        public void setSuggestMachine(SuggestMachineBean suggestMachine) {
            this.suggestMachine = suggestMachine;
        }

        public DepartMachineBean getDepartMachine() {
            return departMachine;
        }

        public void setDepartMachine(DepartMachineBean departMachine) {
            this.departMachine = departMachine;
        }

        public List<NewMachineBean> getNewMachine() {
            return newMachine;
        }

        public void setNewMachine(List<NewMachineBean> newMachine) {
            this.newMachine = newMachine;
        }

        public static class UserBean {
            /**
             * token : null
             * account : 002
             * pass : 123456
             * id : 2
             * userName : 伊娜
             * sex : 女
             * phone : 18965376727
             * email : 1318121527@qq.com
             * age : 20
             * img : http://8.136.141.131:8090/messages/file/head.png
             * address : 湖南中医药大学
             * job : 财务部
             * face : padding
             * creditScore : 100
             */

            private Object token;
            private String account;
            private String pass;
            private int id;
            private String userName;
            private String sex;
            private String phone;
            private String email;
            private int age;
            private String img;
            private String address;
            private String job;
            private String face;
            private int creditScore;

            public static UserBean objectFromData(String str) {

                return new Gson().fromJson(str, UserBean.class);
            }

            public Object getToken() {
                return token;
            }

            public void setToken(Object token) {
                this.token = token;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getPass() {
                return pass;
            }

            public void setPass(String pass) {
                this.pass = pass;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
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

            public int getCreditScore() {
                return creditScore;
            }

            public void setCreditScore(int creditScore) {
                this.creditScore = creditScore;
            }
        }

        public static class SuggestMachineBean {
            /**
             * total : 0
             * list : null
             * pageNum : 0
             * pageSize : 0
             * size : 0
             * startRow : 0
             * endRow : 0
             * pages : 0
             * prePage : 0
             * nextPage : 0
             * isFirstPage : false
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 0
             * navigatepageNums : null
             * navigateFirstPage : 0
             * navigateLastPage : 0
             */

            private int total;
            private Object list;
            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private Object navigatepageNums;
            private int navigateFirstPage;
            private int navigateLastPage;

            public static SuggestMachineBean objectFromData(String str) {

                return new Gson().fromJson(str, SuggestMachineBean.class);
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public Object getList() {
                return list;
            }

            public void setList(Object list) {
                this.list = list;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public Object getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(Object navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }
        }

        public static class DepartMachineBean {
            /**
             * total : 0
             * list : null
             * pageNum : 0
             * pageSize : 0
             * size : 0
             * startRow : 0
             * endRow : 0
             * pages : 0
             * prePage : 0
             * nextPage : 0
             * isFirstPage : false
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 0
             * navigatepageNums : null
             * navigateFirstPage : 0
             * navigateLastPage : 0
             */

            private int total;
            private Object list;
            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private Object navigatepageNums;
            private int navigateFirstPage;
            private int navigateLastPage;

            public static DepartMachineBean objectFromData(String str) {

                return new Gson().fromJson(str, DepartMachineBean.class);
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public Object getList() {
                return list;
            }

            public void setList(Object list) {
                this.list = list;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public Object getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(Object navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }
        }

        public static class NewMachineBean {
            /**
             * id : 22
             * machineName : 未发售手机
             * machineImg : null
             * machineCode : 0000022
             * markNum : PRO WIRELESS
             * machineType : 电子产品
             * manufacturer : 罗技
             * supplier : 罗技
             * money : 780
             * qrCode : null
             * machineStatus : 空闲
             * isImportant : 是
             * oldYear : 5
             * residual : 5
             * brand : 罗技
             * outDate : 2020-03-14T00:00:00.000+00:00
             * userId : 0
             * startDate : 2020-03-20T00:00:00.000+00:00
             */

            private int id;
            private String machineName;
            private Object machineImg;
            private String machineCode;
            private String markNum;
            private String machineType;
            private String manufacturer;
            private String supplier;
            private int money;
            private Object qrCode;
            private String machineStatus;
            private String isImportant;
            private int oldYear;
            private int residual;
            private String brand;
            private String outDate;
            private String userId;
            private String startDate;

            public static NewMachineBean objectFromData(String str) {

                return new Gson().fromJson(str, NewMachineBean.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMachineName() {
                return machineName;
            }

            public void setMachineName(String machineName) {
                this.machineName = machineName;
            }

            public Object getMachineImg() {
                return machineImg;
            }

            public void setMachineImg(Object machineImg) {
                this.machineImg = machineImg;
            }

            public String getMachineCode() {
                return machineCode;
            }

            public void setMachineCode(String machineCode) {
                this.machineCode = machineCode;
            }

            public String getMarkNum() {
                return markNum;
            }

            public void setMarkNum(String markNum) {
                this.markNum = markNum;
            }

            public String getMachineType() {
                return machineType;
            }

            public void setMachineType(String machineType) {
                this.machineType = machineType;
            }

            public String getManufacturer() {
                return manufacturer;
            }

            public void setManufacturer(String manufacturer) {
                this.manufacturer = manufacturer;
            }

            public String getSupplier() {
                return supplier;
            }

            public void setSupplier(String supplier) {
                this.supplier = supplier;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public Object getQrCode() {
                return qrCode;
            }

            public void setQrCode(Object qrCode) {
                this.qrCode = qrCode;
            }

            public String getMachineStatus() {
                return machineStatus;
            }

            public void setMachineStatus(String machineStatus) {
                this.machineStatus = machineStatus;
            }

            public String getIsImportant() {
                return isImportant;
            }

            public void setIsImportant(String isImportant) {
                this.isImportant = isImportant;
            }

            public int getOldYear() {
                return oldYear;
            }

            public void setOldYear(int oldYear) {
                this.oldYear = oldYear;
            }

            public int getResidual() {
                return residual;
            }

            public void setResidual(int residual) {
                this.residual = residual;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getOutDate() {
                return outDate;
            }

            public void setOutDate(String outDate) {
                this.outDate = outDate;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }
        }
    }
}
