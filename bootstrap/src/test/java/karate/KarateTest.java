package karate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ApplicationStarter;

import static org.assertj.core.api.Assertions.assertThat;

class KarateTest {

    @BeforeAll
    static void startApplication() {
        ApplicationStarter.startTestsContainers();
        ApplicationStarter.startApplication("mongo");
    }

    @AfterAll
    static void stopApplication() {
        ApplicationStarter.stopApplication();
        ApplicationStarter.stopTestsContainers();
    }

    @Test
    void testFeature() {
        Results results = Runner.path("classpath:karate/features")
                .systemProperty("server.url", "http://localhost:" + ApplicationStarter.FIRST_AVAILABLE_TCP_PORT)
                .parallel(1);
        assertThat(results.getFailCount())
                .withFailMessage(results.getErrorMessages())
                .isZero();
    }
}
