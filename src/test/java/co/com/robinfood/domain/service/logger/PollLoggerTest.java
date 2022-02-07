package co.com.robinfood.domain.service.logger;

import co.com.robinfood.domain.service.logger.impl.PollLogStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class PollLoggerTest {

    private LogStrategy logStrategy;

    @Mock
    Logger logger;

    @Before
    public void setup () {
        MockitoAnnotations.initMocks(this);
        PollLogStrategy pollLogStrategy = new PollLogStrategy();
        logStrategy = new PollLogStrategy(logger);
    }

    @Test
    public void logInfoTest() {
        logStrategy.logInfo("This is a test");
        Mockito.verify(logger).info("This is a test");
    }

    @Test
    public void logErrorTest() {
        logStrategy.logError("This is a test");
        Mockito.verify(logger).error("This is a test");
    }
}
