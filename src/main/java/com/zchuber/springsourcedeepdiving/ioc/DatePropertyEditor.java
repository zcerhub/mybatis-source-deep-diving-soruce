package com.zchuber.springsourcedeepdiving.ioc;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

    private String format = "yyyy-MM-dd";

    public DatePropertyEditor() {
    }

    public DatePropertyEditor(String format) {
        this.format=format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String argo) {
        System.out.println(argo);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d=sdf.parse(argo);
            this.setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}
