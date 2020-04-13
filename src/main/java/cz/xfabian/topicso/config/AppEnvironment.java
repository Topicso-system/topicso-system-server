package cz.xfabian.topicso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppEnvironment {

    private static final String TEST = "test";
    private static final String DEBUG = "debug";
    private static final String PRODUCTION = "prod";

    @Value( "${environment.mode}" )
    private String environmentMode;

    public boolean isTest() {
        return environmentMode.equals(TEST);
    }

    public boolean isDebug() {
        return environmentMode.equals(DEBUG);
    }

    public boolean isProduction() {
        return environmentMode.equals(PRODUCTION);
    }

}
