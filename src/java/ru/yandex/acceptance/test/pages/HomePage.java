package ru.yandex.acceptance.test.pages;

import ru.yandex.acceptance.test.components.SearchComponent;
import ru.yandex.acceptance.test.components.TabsComponent;

public class HomePage {

    private SearchComponent searchComponent;
    private TabsComponent tabsComponent;

    public SearchComponent getSearchBar() {
        if (searchComponent == null) {
            searchComponent = new SearchComponent();
        }
        return searchComponent;
    }

    public TabsComponent getTabs() {
        if (tabsComponent == null) {
            tabsComponent = new TabsComponent();
        }
        return tabsComponent;
    }
}
