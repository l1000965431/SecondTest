package config;

import org.springframework.core.annotation.Order;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Order(3)
public class HttpSessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {

}
