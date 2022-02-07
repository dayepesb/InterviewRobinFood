package co.com.robinfood.domain.service.logger.impl;

import co.com.robinfood.domain.service.logger.LogStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("PollLogStrategy")
public class PollLogStrategy implements LogStrategy {

    protected final Logger logger;

    public PollLogStrategy(Logger logger) {
        this.logger = logger;
    }

    public PollLogStrategy() {
        this.logger = LoggerFactory.getLogger(PollLogStrategy.class);
    }
    @Override
    public void logInfo(String logInfo) {
        this.logger.info(logInfo);
    }

    @Override
    public void logError(String logError) {
        this.logger.error(logError);
    }
}
