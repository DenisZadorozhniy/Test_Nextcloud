import org.junit.jupiter.api.AfterEach;

import aquality.appium.mobile.application.AqualityServices;

public class BaseTest {

    @AfterEach
    public void afterEach(){
        AqualityServices.getApplication().getDriver().quit();
    }
}
