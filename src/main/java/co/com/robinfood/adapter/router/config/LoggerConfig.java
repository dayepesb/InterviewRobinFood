package co.com.robinfood.adapter.router.config;

import co.com.robinfood.domain.service.logger.LogStrategy;
import co.com.robinfood.domain.service.logger.impl.PollLogStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
public class LoggerConfig {

    @ConditionalOnProperty(name = "logger.impl", havingValue = "PollLogStrategy")
    public LogStrategy getLoggerStrategyPoll() {
        return new PollLogStrategy();
    }
}
