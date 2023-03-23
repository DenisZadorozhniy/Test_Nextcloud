package utils;

import org.openqa.selenium.Alert;

import aquality.appium.mobile.application.AqualityServices;

public class AlertManager {
    private static Alert alert = AqualityServices.getApplication().getDriver().switchTo().alert();

    public static void dismissAlert() {
        alert.dismiss();
    }

    public static void acceptAlert(){
        alert.accept();
    }
}
