package steps;

import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import screens.SearchScreen;
import utils.StringUtils;

public class SearchScreenSteps {

    private final SearchScreen searchScreen;

    public SearchScreenSteps() {
        this.searchScreen = new SearchScreen();
    }

    public void checkDocumentPresent(String titleDocument) {
        searchScreen.state().waitForClickable(Duration.ofSeconds(7));
        List<String> titles = searchScreen.getTitleFromDocuments().stream()
                .map(StringUtils::extractTextBeforeDotOrColon)
                .collect(Collectors.toList());
        Assertions.assertTrue(titles.contains(titleDocument),
                String.format("The '%s' file must be present in the list of files.", titleDocument));
    }
}
