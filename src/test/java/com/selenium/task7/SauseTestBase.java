package com.selenium.task7;

/**
 * Created by AnastasiaShumskaya on 12/29/2016.
 */

 import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners({SauceOnDemandTestListener.class})
class SauceTestBase implements SauceOnDemandSessionIdProvider {

    private static final String LOGIN = "kanapuska";
    private static final String ACCESS_KEY = "1e5855e2-accd-4e0f-a8e9-e20c3eb36fcd";

    protected ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    protected ThreadLocal<String> sessionId = new ThreadLocal<String>();

    protected WebDriver createDriver(String browser, String version, String os) throws MalformedURLException {

        if (browser == "edge")
        {
            DesiredCapabilities caps = DesiredCapabilities.edge();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "14.14393");
            webDriver.set(new RemoteWebDriver(
                    new URL("https://" + LOGIN + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub"),
                    caps));
            sessionId.set(((RemoteWebDriver) getWebDriver()).getSessionId().toString());
            return webDriver.get();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", version);
        capabilities.setCapability("platform", os);
        webDriver.set(new RemoteWebDriver(
                new URL("https://" + LOGIN + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub"),
                capabilities));
        sessionId.set(((RemoteWebDriver) getWebDriver()).getSessionId().toString());
        return webDriver.get();
    }



    public WebDriver getWebDriver() {
        System.out.println("WebDriver" + webDriver.get());
        return webDriver.get();
    }

    public String getSessionId() {
        return sessionId.get();
    }
}


