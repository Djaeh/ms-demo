package cucumber.feature;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.spring.CucumberContextConfiguration;
import utils.ApplicationStarter;

@CucumberContextConfiguration
public class CucumberApplicationStarter {
    @BeforeAll
    public static void startApplication() {
        ApplicationStarter.startTestsContainers();
        ApplicationStarter.startApplication("mongo");
    }

    @AfterAll
    public static void stopApplication() {
        ApplicationStarter.stopApplication();
        ApplicationStarter.stopTestsContainers();
    }
}
