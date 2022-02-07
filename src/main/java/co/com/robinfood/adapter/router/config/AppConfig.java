package co.com.robinfood.adapter.router.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "co.com.robinfood.adapter", "co.com.robinfood.domain", "co.com.robinfood.util", "co.com.robinfood.domain.repository" })
public class AppConfig {
}
