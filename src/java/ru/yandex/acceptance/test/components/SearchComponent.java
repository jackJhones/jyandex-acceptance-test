package ru.yandex.acceptance.test.components;

import com.codeborne.selenide.CollectionCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class SearchComponent {

    public SearchComponent setText(String text) {
        $(".input__control.input__input").sendKeys(text);
        return this;
    }

    public List<String> getDropdownOptions() {
        try {
            return $$(".popup__content .suggest2-item")
                    .shouldBe(CollectionCondition.sizeGreaterThan(0)).texts()
                    .stream()
                    .map(e -> e.replaceAll("\\n", " "))
                    .collect(Collectors.toList());
        } catch (IllegalStateException e) {
            /* dropdown options are not present */
            return new ArrayList<>();
        }
    }
}
