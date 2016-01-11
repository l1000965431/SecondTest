package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * Created by liumin on 16/1/11.
 */
@Configuration
@ComponentScan(basePackages = "com.base",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
@Import({HibnateConfig.class})
public class Appconfig {

}
