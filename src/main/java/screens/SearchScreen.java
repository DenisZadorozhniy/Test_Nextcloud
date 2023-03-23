package screens;

import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;

public class SearchScreen extends Screen {

    private final List<ITextBox> elementsInRecycler;

    public SearchScreen() {
        super(By.id("com.nextcloud.client:id/unified_search_item_layout"), "Search screen");
        this.elementsInRecycler = getElementFactory().findElements(By.xpath("//*" +
                "[contains(@resource-id,'com.nextcloud.client:id/title')]"),ITextBox.class);
    }

    public List<String> getTitleFromDocuments() {
        return elementsInRecycler.stream()
                .map(ITextBox::getText)
                .collect(Collectors.toList());
    }
}
