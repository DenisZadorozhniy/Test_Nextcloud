package screens;

import org.openqa.selenium.By;

import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;

public class TextDocumentScreen extends Screen {

    private final ITextBox titleDocument;

    public TextDocumentScreen() {
        super(By.id("com.nextcloud.client:id/thumbnail"), "Text document screen");
        this.titleDocument = getElementFactory().getTextBox(By.id("com.nextcloud.client:id/filename"),"Title document");
    }

    public boolean isTextDocumentScreenDisplayed(){
       return state().isDisplayed();
    }

    public String getTitleDocumentText(){
        return titleDocument.getText();
    }
}
