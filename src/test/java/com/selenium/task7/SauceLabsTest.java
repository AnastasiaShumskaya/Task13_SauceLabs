package com.selenium.task7;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

@Listeners({SauceOnDemandTestListener.class})
public class SauceLabsTest  extends SauceTestBase{

    private static final String TEST_URL = "http://www.google.by/";
    private static final String TITLE = "Google";

    @DataProvider(name = "browsers")
    public static Object[][] setData() {
        return new Object[][]{
                new Object[]{"edge", "14.14393", "Windows 10"},
                new Object[]{"firefox", "39.0", "Windows 8.1"},
                new Object[]{"chrome",  "40.0", "Linux"},
        };
    }
    @Test(dataProvider = "browsers")
    public void firstTest(String browser, String version, String os) throws MalformedURLException {

        WebDriver driver = createDriver(browser, version, os);
        driver.get(TEST_URL);
        Assert.assertTrue(driver.getTitle().contains(TITLE), "Incorrect page!");
        driver.close();
    }
}
