package screens.forms;

import org.openqa.selenium.By;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import utils.SwipeUtils;

public class MoreMenuForm extends Screen {

    private final IButton deleteButton;

    public MoreMenuForm() {
        super(By.id("com.nextcloud.client:id/file_actions_list"), "More menu form");
        this.deleteButton = getElementFactory().getButton(By.xpath("//android.widget.LinearLayout[9]"),"Delete button");
    }

    public void clickDeleteButton(){
        if (deleteButton.state().isDisplayed()){
            SwipeUtils.makeSwipe(deleteButton,SwipeDirection.DOWN);
        }
        deleteButton.click();
    }
}
