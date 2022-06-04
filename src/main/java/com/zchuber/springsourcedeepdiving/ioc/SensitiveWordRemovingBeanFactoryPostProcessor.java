package com.zchuber.springsourcedeepdiving.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

public class SensitiveWordRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> sensitiveWord = new HashSet<String>();



    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for(String beanName:beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver(){

                public String resolveStringValue(String word) {
                    if(isSensitiveWord(word)){
                        return "******";
                    }
                    return word;
                }

                private boolean isSensitiveWord(String word) {
                    return sensitiveWord.contains(word);
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }
    }


    public void setSensitiveWord(Set sensitiveWord) {
        this.sensitiveWord = sensitiveWord;
    }
}
