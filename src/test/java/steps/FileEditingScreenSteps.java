package steps;

import org.junit.jupiter.api.Assertions;

import screens.FileEditingScreen;
import utils.StringUtils;

public class FileEditingScreenSteps {
    private final FileEditingScreen fileEditingScreen;

    public FileEditingScreenSteps() {
        this.fileEditingScreen = new FileEditingScreen();
    }

    public void checkFileEditingScreenDisplayed() {
        fileEditingScreen.state().waitForDisplayed();
        Assertions.assertTrue(fileEditingScreen.isFileEditingScreenDisplayed(),
                "File editing screen should be displayed");
    }

    public void writeText(String text) {
        fileEditingScreen.addTextInDirectEditor(text);
    }

    public void clickCloseButton() {
        fileEditingScreen.clickCloseBtn();
    }

    public void checkTextInEditText(String text) {
        Assertions.assertEquals(StringUtils.removeTrailingSpaces(fileEditingScreen.getTextFromDirectEditor()), text,
                "Values must be equal");
    }
}
