import org.junit.jupiter.api.Test;

import configuration.Configuration;
import steps.FileEditingScreenSteps;
import steps.MainScreenSteps;
import steps.SearchScreenSteps;
import steps.TextDocumentScreenSteps;
import utils.StringUtils;

public class NextCloudTest extends BaseTest {

    private final MainScreenSteps mainScreenSteps;
    private final TextDocumentScreenSteps textDocumentScreenSteps;
    private final FileEditingScreenSteps fileEditingScreenSteps;
    private final SearchScreenSteps searchScreenSteps;

    public NextCloudTest() {
        this.mainScreenSteps = new MainScreenSteps();
        this.textDocumentScreenSteps = new TextDocumentScreenSteps();
        this.fileEditingScreenSteps = new FileEditingScreenSteps();
        this.searchScreenSteps = new SearchScreenSteps();
    }

    @Test
    public void firstTest() {
        String randomTitle = StringUtils.generateRandomWord(8);
        String randomText = StringUtils.generateRandomWord(12);

        mainScreenSteps.clickCancelInAlert();

        mainScreenSteps.clickAddButton();
        mainScreenSteps.clickCreateTextDocumentButton();

        mainScreenSteps.addTitleDocument(randomTitle);
        mainScreenSteps.clickCreateDocument();
        textDocumentScreenSteps.compareTitleDocument(randomTitle);
        fileEditingScreenSteps.checkFileEditingScreenDisplayed();

        fileEditingScreenSteps.writeText(randomText);
        fileEditingScreenSteps.clickCloseButton();
        mainScreenSteps.isDocumentPresent(randomTitle);

        mainScreenSteps.clickOverflowMenu(randomTitle);
        mainScreenSteps.deleteDocument();
    }

    @Test
    public void secondTest(){
        String randomTitle = StringUtils.generateRandomWord(8);
        String randomText = StringUtils.generateRandomWord(12);

        mainScreenSteps.clickCancelInAlert();

        mainScreenSteps.clickAddButton();
        mainScreenSteps.clickCreateTextDocumentButton();

        mainScreenSteps.addTitleDocument(randomTitle);
        mainScreenSteps.clickCreateDocument();
        textDocumentScreenSteps.compareTitleDocument(randomTitle);
        fileEditingScreenSteps.checkFileEditingScreenDisplayed();

        fileEditingScreenSteps.writeText(randomText);
        fileEditingScreenSteps.clickCloseButton();
        mainScreenSteps.isDocumentPresent(randomTitle);

        mainScreenSteps.clickOverflowMenu(randomTitle);
        mainScreenSteps.deleteDocument();
        mainScreenSteps.isDocumentAbsent(randomTitle);

        mainScreenSteps.updateScreen();
        mainScreenSteps.isDocumentAbsent(randomTitle);
    }

    @Test
    public void thirdTest(){
        String titleFile = Configuration.getProperties("titleFile");
        String description = Configuration.getProperties("description");

        mainScreenSteps.clickCancelInAlert();
        mainScreenSteps.isDocumentPresent(titleFile);

        mainScreenSteps.clickFile(titleFile);
        fileEditingScreenSteps.checkTextInEditText(description);
        fileEditingScreenSteps.clickCloseButton();
    }

    @Test
    public void fourthTest(){
        String titleFile = Configuration.getProperties("titleFile");

        mainScreenSteps.clickCancelInAlert();
        mainScreenSteps.isDocumentPresent(titleFile);

        mainScreenSteps.searchDocument(titleFile);
        searchScreenSteps.checkDocumentPresent(titleFile);
    }
}
