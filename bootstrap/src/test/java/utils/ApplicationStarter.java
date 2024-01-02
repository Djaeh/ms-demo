package utils;

import com.example.karatemsdemo.KarateMsDemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.springframework.test.util.TestSocketUtils.findAvailableTcpPort;

public class ApplicationStarter {

    private static boolean containersStarted = false;
    private static ConfigurableApplicationContext context;


    public static final int FIRST_AVAILABLE_TCP_PORT = findAvailableTcpPort();
    public static final MongoDBContainer MONGO_DB_CONTAINER = new MongoDBContainer("mongo:6.0.10");
    public static final KafkaContainer KAFKA_CONTAINER = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));

    public static void startTestsContainers() {
        if (!containersStarted) {
            Stream.of(MONGO_DB_CONTAINER, KAFKA_CONTAINER)
                    .parallel()
                    .forEach(GenericContainer::start);
            containersStarted = true;
        }
    }

    public static void stopTestsContainers() {
        if (containersStarted) {
            Stream.of(MONGO_DB_CONTAINER, KAFKA_CONTAINER)
                    .parallel()
                    .forEach(GenericContainer::stop);
            containersStarted = false;
        }
    }

    public static void startApplication(String... profiles) {
        if (context == null) {
            SpringApplication app = new SpringApplication(KarateMsDemoApplication.class);
            app.addInitializers(new ApplicationStarter.Initializer());
            app.setAdditionalProfiles(profiles);
            context = app.run();
        }
    }

    public static void stopApplication() {
        if(context != null) {
            context.close();
        }
    }

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        private static final Map<String, Object> TEST_PROPERTIES = new HashMap<>();

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TEST_PROPERTIES.put("server.port", FIRST_AVAILABLE_TCP_PORT);
            TEST_PROPERTIES.put("management.server.port", FIRST_AVAILABLE_TCP_PORT);
            TEST_PROPERTIES.put("spring.data.mongodb.uri", MONGO_DB_CONTAINER.getReplicaSetUrl());
            TEST_PROPERTIES.forEach((key, value) -> TestPropertySourceUtils.addInlinedPropertiesToEnvironment(applicationContext, key + "=" + value));
        }
    }
}
