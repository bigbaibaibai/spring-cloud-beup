package cc.beup.starter.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class BeupWebAutoConfiguration {

    @ConditionalOnMissingBean(BeupWebConfig.class)
    @Bean
    public BeupWebConfig beupWebConfig() {
        return new BeupWebConfig();
    }

}
