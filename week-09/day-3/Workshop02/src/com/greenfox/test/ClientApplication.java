package com.greenfox.test;

import com.greenfox.configuration.DIConfiguration;
import com.greenfox.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
AnnotationConfigApplicationContext is the implementation of AbstractApplicationContext abstract class and it’s used for
autowiring the services to components when annotations are used. AnnotationConfigApplicationContext constructor takes
Class as argument that will be used to get the bean implementation to inject in component classes.

getBean(Class) method returns the Component object and uses the configuration for autowiring the objects.
Context objects are resource intensive, so we should close them when we are done with it
*/

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hi Pankaj", "pankaj@abc.com");

        //close the context
        context.close();
    }

}
