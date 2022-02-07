package co.com.robinfood.adapter.router.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigurationTest {

    private SwaggerConfiguration swaggerConfiguration;

    @Before
    public void setup() {
        swaggerConfiguration = new SwaggerConfiguration();
    }

    @Test
    public void swaggerConfigurationTest() {
        Docket docket = swaggerConfiguration.spring2dbApi();
        Assert.assertNotNull(docket);
    }
}
