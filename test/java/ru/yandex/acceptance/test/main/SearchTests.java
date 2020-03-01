package ru.yandex.acceptance.test.main;

import com.codeborne.selenide.testng.TextReport;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.acceptance.test.BaseTest;
import ru.yandex.acceptance.test.dataproviders.main.HomePageDataProvider;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Listeners({TextReport.class})
public class SearchTests extends BaseTest {

    @Test(dataProvider = "GDS_01",
            dataProviderClass = HomePageDataProvider.class,
            description = "User can get the first dropdown suggestion on the search bar.")
    public void GDS_01(String searchText, String expectedValue) {
        List<String> actualList = homePage.getSearchBar()
                .setText(searchText)
                .getDropdownOptions();

        assertThat("The search dropdown options are not found.",
                actualList.size(), greaterThan(0));
        assertThat("The first dropdown option does not begin with the expected one.",
                actualList.get(0), matchesPattern(expectedValue));
    }

    @Test(description = "User can see 'Картинки' tab on the second position.")
    public void GDS_02() {
        List<String> actualList = homePage.getTabs().getTabNames();

        assertThat("The first dropdown option does not begin with the expected one.",
                actualList.get(1), is("Картинки"));
    }
}
