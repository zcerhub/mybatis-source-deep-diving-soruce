package com.zchuber.springsourcedeepdiving.ioc;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Date;

public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {


    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class,new DatePropertyEditor("yyyy-MM-dd"));
    }


}
