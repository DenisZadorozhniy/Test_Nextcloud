package screens;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import screens.forms.AddFileForm;
import screens.forms.DeletionWarningForm;
import screens.forms.MoreMenuForm;
import utils.StringUtils;

public class MainScreen extends Screen {

    private final IButton addFileButton;
    private final ILabel search;
    private final ILabel inputSearch;
    private final List<ITextBox> titleElementsInRecycler;
    private final List<ITextBox> elementsInRecycler;
    private final ILabel document;

    private final AddFileForm addFileForm;
    private final MoreMenuForm moreMenuForm;
    private final DeletionWarningForm deletionWarningForm;

    public MainScreen() {
        super(By.id("com.nextcloud.client:id/list_root"), "Main Screen");
        this.addFileButton = getElementFactory().getButton(By.id("com.nextcloud.client:id/fab_main"), "Add file button");
        this.search = getElementFactory().getLabel(By.id("com.nextcloud.client:id/search_text"), "Search");
        this.inputSearch = getElementFactory().getLabel(By.id("com.nextcloud.client:id/search_src_text"), "Input Search");
        this.titleElementsInRecycler = getElementFactory().findElements(By.xpath("//*[@resource-id='com.nextcloud.client:id/Filename']"), ITextBox.class);
        this.elementsInRecycler = getElementFactory().findElements(By.xpath("//*[@resource-id='com.nextcloud.client:id/Filename']"), ITextBox.class);
        this.document = getElementFactory().getLabel(By.xpath("//androidx.recyclerview." +
                "widget.RecyclerView//android.widget.LinearLayout[%s]"), "Document");

        this.addFileForm = new AddFileForm();
        this.moreMenuForm = new MoreMenuForm();
        this.deletionWarningForm = new DeletionWarningForm();
    }

    private ILabel getParticularDocumentLabel(int position) {
        return getElementFactory().getLabel(By.xpath("//androidx.recyclerview." +
                "widget.RecyclerView//android.widget.LinearLayout[" + position + "]"), "Document");
    }

    private IButton getMoreMenuButton(Integer number) {
        return getElementFactory().getButton(By.xpath("(//android.widget.ImageView[@content-desc=\"More menu\"])[" + number + "]"), "More menu");
    }

    public AddFileForm getAddFileForm() {
        return addFileForm;
    }

    public MoreMenuForm getMoreMenuForm() {
        return moreMenuForm;
    }

    public DeletionWarningForm getDeletionWarningForm() {
        return deletionWarningForm;
    }

    public void clickAddFileButton() {
        addFileButton.click();
    }

    public By getFilenameLocator(String titleDocument) {
         AtomicReference<ITextBox> doc = new AtomicReference<>(null);
        elementsInRecycler.stream()
                .filter(el -> StringUtils.extractTextBeforeDotOrColon(el.getText()).equals(titleDocument))
                .findFirst()
                .ifPresent(doc::set);
        return doc.get().getLocator();
    }

    public void clickOnParticularDocument(Integer position) {
        getParticularDocumentLabel(position).click();
    }

    public List<String> getTitleFromDocuments() {
        List<String> titlesList = new ArrayList<>();
        if (!titleElementsInRecycler.isEmpty()) {
            titleElementsInRecycler.forEach(element -> {
                String text = element.getText();
                titlesList.add(text);
            });
        }
        return titlesList;
    }

    public void clickMoreMenu(Integer number) {
        getMoreMenuButton(number).click();
    }

    public void writeTextToSearch(String text) {
        search.click();
        inputSearch.sendKeys(text);
    }

    public void startSearch() {
        inputSearch.sendKeys(Keys.ENTER);
    }
}
