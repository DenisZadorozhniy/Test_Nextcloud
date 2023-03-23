package configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

class Environment {

    private Environment() {
    }

    static ISettingsFile getCurrentData(String fileName) {
        String envName = (String) AqualityServices.get(ISettingsFile.class).getValue("/data");
        Path resourcePath = Paths.get( envName, fileName);
        return new JsonSettingsFile(resourcePath.toString());
    }
}
