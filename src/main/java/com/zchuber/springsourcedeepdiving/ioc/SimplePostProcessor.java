package com.zchuber.springsourcedeepdiving.ioc;

public class SimplePostProcessor {

    private String connectionString;
    private String password;
    private String uername;

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUername(String uername) {
        this.uername = uername;
    }

    @Override
    public String toString() {
        return "SimplePostProcessor{" +
                "connectionString='" + connectionString + '\'' +
                ", password='" + password + '\'' +
                ", uername='" + uername + '\'' +
                '}';
    }
}
