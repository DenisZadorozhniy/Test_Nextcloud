package steps;

import org.junit.jupiter.api.Assertions;

import screens.TextDocumentScreen;
import utils.StringUtils;

public class TextDocumentScreenSteps {
    private final TextDocumentScreen textDocumentScreen;

    public TextDocumentScreenSteps() {
        this.textDocumentScreen = new TextDocumentScreen();
    }

    public void compareTitleDocument(String titleDocument) {
        if (textDocumentScreen.isTextDocumentScreenDisplayed()) {
            Assertions.assertEquals(StringUtils.extractTextBeforeDotOrColon(textDocumentScreen.getTitleDocumentText()), titleDocument, "Titles must be the equal");
        }
    }
}
