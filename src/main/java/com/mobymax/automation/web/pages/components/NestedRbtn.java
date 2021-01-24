package com.mobymax.automation.web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.By;

import java.util.function.Function;

import static com.codeborne.selenide.Condition.*;

public class NestedRbtn {
    private final ElementsCollection parentItems;
    private final Function<SelenideElement, ElementsCollection> nestedItems;

    public NestedRbtn(ElementsCollection parentItems, Function<SelenideElement, ElementsCollection> nestedItems) {
        this.parentItems = parentItems;
        this.nestedItems = nestedItems;
    }

    public void select(String item, String option) {
        SelenideElement itemEl = parentItems.find(exactText(item)).should(visible).parent();
        if (!itemEl.has(cssClass("checked"))) {
            itemEl.click();
        }
        SelenideElement optionEl = nestedItems.apply(itemEl).find(exactText(option)).should(visible);
        if (!optionEl.is(cssClass("checked"))) {
            optionEl.click();
        }
    }
}
