package configuration;

import configuration.model.Browser;
import configuration.model.Environment;

public class Config {
    public Browser browser;
    public Environment environment;


    public Browser getBrowser() {
        return browser;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
