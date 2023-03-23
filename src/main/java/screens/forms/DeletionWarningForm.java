package screens.forms;

import org.openqa.selenium.By;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;

public class DeletionWarningForm extends Screen {

    private final IButton deleteButton;

    public DeletionWarningForm() {
        super(By.id("com.nextcloud.client:id/parentPanel"), "Deletion waring form");
        this.deleteButton = getElementFactory().getButton(By.id("android:id/button1"),"Delete button");
    }

    public void clickDelete(){
        deleteButton.click();
    }
}
