package config;

import com.base.ServletTest.CP_InitializingInterceptor;
import com.base.until.CP_PropertyEditorRegistrar;
import com.base.until.CP_SimpleMappingExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Properties;

/**
 * Created by liumin on 16/1/11.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.base",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = {Controller.class})})
public class MvcConfig extends WebMvcConfigurationSupport{

    @Bean
    public CP_InitializingInterceptor initializingInterceptor(){
        return new CP_InitializingInterceptor();
    }

    /**
     * 描述 : <RequestMappingHandlerMapping需要显示声明，否则不能注册自定义的拦截器>. <br>
     *<p>
     <这个比较奇怪,理论上应该是不需要的>
     </p>
     * @return
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return super.requestMappingHandlerMapping();
    }

    /**
     * 描述 : <添加拦截器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initializingInterceptor());
    }

    /**
     * 描述 : <异常处理器>. <br>
     *<p>
     <系统运行时遇到指定的异常将会跳转到指定的页面>
     </p>
     * @return
     */
    @Bean(name="exceptionResolver")
    public CP_SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        CP_SimpleMappingExceptionResolver simpleMappingExceptionResolver= new CP_SimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.setDefaultErrorView("common_error");
        simpleMappingExceptionResolver.setExceptionAttribute("exception");
        Properties properties = new Properties();
        properties.setProperty("java.lang.RuntimeException", "common_error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

    /**
     * 描述 : <RequestMappingHandlerAdapter需要显示声明，否则不能注册通用属性编辑器>. <br>
     *<p>
     <这个比较奇怪,理论上应该是不需要的>
     </p>
     * @return
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        return super.requestMappingHandlerAdapter();
    }

    /**
     * 描述 : <注册通用属性编辑器>. <br>
     *<p>
     <这里只增加了字符串转日期和字符串两边去空格的处理>
     </p>
     * @return
     */
    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
        CP_PropertyEditorRegistrar register = new CP_PropertyEditorRegistrar();
        register.setFormat("yyyy-MM-dd");
        initializer.setPropertyEditorRegistrar(register);
        return initializer;
    }
}
