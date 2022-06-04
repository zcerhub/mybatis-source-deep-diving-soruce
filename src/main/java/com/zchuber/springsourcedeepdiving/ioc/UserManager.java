package com.zchuber.springsourcedeepdiving.ioc;

import java.util.Date;

public class UserManager {

    private Date dataValue;

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "dataValue: "+dataValue;
    }

}
