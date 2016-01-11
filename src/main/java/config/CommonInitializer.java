package config;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by liumin on 16/1/11.
 */
@Order(1)
public class CommonInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}
