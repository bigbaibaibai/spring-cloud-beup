package cc.beup.starter.web.config;

import cc.beup.starter.web.aop.WebLogAop;
import org.springframework.context.annotation.Bean;

public class BeupWebAutoConfiguration {

    @Bean
    public BeupWebConfig beupWebConfig() {
        return new BeupWebConfig();
    }

    @Bean
    public WebLogAop webLogAop() {
        return new WebLogAop();
    }

}
