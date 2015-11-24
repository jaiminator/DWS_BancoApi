
package com.fpmislata.bancoapi.presentacion.database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author alumno
 */
public class ServletContextListenerImpl implements ServletContextListener {

    @Autowired
    DatabaseMigration databaseMigration;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
//    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
//    AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
//    autowireCapableBeanFactory.autowireBean(this);
        
        System.out.println("Tomcat inicializado");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
//    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
//    AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
//    autowireCapableBeanFactory.autowireBean(this);
        
        System.out.println("Tomcat parado");
    }

}
