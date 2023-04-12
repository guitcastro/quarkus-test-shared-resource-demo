package com.example;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.jboss.logging.Logger;

import java.util.Map;

public class SharedResource implements QuarkusTestResourceLifecycleManager {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Map<String, String> start() {
        logger.info(this.getClass().getSimpleName()+ " started");
        return null;
    }

    @Override
    public void stop() {
        logger.info(this.getClass().getSimpleName()+ " stopped");
    }
}
