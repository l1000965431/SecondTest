package com.base.ServletTest;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liumin on 15/12/3.
 */
public class ListenerTest implements ServletRequestListener,ServletRequestAttributeListener {
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest req = (HttpServletRequest)servletRequestEvent.getServletRequest();

        System.out.println( "访问req监听器结束:"+req.getRequestURI() );

    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest req = (HttpServletRequest)servletRequestEvent.getServletRequest();

        System.out.println( "访问req监听器开始:"+req.getRequestURI() );
    }

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println( "req增加了属性名字:"+
                servletRequestAttributeEvent.getName()+"值:"+servletRequestAttributeEvent.getValue() );
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println( "req删除了属性名字:"+
                servletRequestAttributeEvent.getName()+"值:"+servletRequestAttributeEvent.getValue() );
    }

    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println( "req替换了属性名字:"+
                servletRequestAttributeEvent.getName()+"值:"+servletRequestAttributeEvent.getValue() );
    }
}
