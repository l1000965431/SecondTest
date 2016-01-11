package config;

import com.base.ServletTest.FilterTest;
import com.base.until.CP_SpringContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by liumin on 16/1/11.
 */
@Order(2)
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{Appconfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        FilterTest filterTest = new FilterTest();


        return new Filter[]{characterEncodingFilter,filterTest};
    }

    /*
 * 创建一个可以在非spring管理bean中获得spring管理的相关bean的对象：CP_SpringContext.getBean(String beanName)
 */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // TODO Auto-generated method stub
        WebApplicationContext ctx = super.createRootApplicationContext();
        CP_SpringContext.getInstance().setApplicationContext(ctx);
        return ctx;
    }

}
