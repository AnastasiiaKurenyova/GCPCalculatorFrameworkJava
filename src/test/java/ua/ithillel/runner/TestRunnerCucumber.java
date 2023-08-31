package ua.ithillel.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ua.ithillel.steps"),
        //@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Smoke"),
})

public class TestRunnerCucumber {

}
