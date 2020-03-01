package ru.yandex.acceptance.test.dataproviders.main;

import org.testng.annotations.DataProvider;

public class HomePageDataProvider {

    @DataProvider(name = "GDS_01")
    private Object[][] dp1() {
        return new Object[][]{
                {"погода", "погода спб .* °C"},
                {"Липецк", "липецк"},
                {"Лото", "лоток для кошек"},
        };
    }
}
