package com.springbootinterview.springbootinterview.configurations;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MyWebApplicationInitializer /* implements WebApplicationInitializer */ {

    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletRegistration.Dynamic dispatcherServletRegistration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dispatcherServletRegistration.setLoadOnStartup(1);
        dispatcherServletRegistration.addMapping("/testSpring");
    }
}

