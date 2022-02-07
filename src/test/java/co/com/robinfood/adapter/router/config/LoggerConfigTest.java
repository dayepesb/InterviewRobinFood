package co.com.robinfood.adapter.router.config;

import co.com.robinfood.domain.service.logger.LogStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerConfigTest {

    private LoggerConfig loggerConfig;

    @Before
    public void setup() {
        loggerConfig = new LoggerConfig();
    }

    @Test
    public void getLoggerStrategyTest() {
        LogStrategy logStrategy = loggerConfig.getLoggerStrategyPoll();
        Assert.assertNotNull(logStrategy);
    }
}
