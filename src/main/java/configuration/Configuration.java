package configuration;

public class Configuration {

    private Configuration() {
    }

    public static String getProperties(String key) {
        return Environment.getCurrentData("data.json").getValue("/" + key).toString();
    }
}