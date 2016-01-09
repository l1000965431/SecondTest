package com.base.ServletTest;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by liumin on 15/12/26.
 */
public class HttpSessionListenerTest implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
       int a = 0;
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
       int a = 0;
    }
}
