package ru.yandex.acceptance.test.components;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class TabsComponent {

    public List<String> getTabNames() {
        return $$(".home-tabs__link")
                .shouldBe(CollectionCondition.sizeGreaterThan(0)).texts();
    }
}
