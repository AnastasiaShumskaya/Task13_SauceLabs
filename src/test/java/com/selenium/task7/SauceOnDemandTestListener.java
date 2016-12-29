package com.selenium.task7;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import static com.codeborne.selenide.Selenide.screenshot;


/**
 * Created by AnastasiaShumskaya on 12/29/2016.
 */
public class SauceOnDemandTestListener implements ITestListener  {

    @Attachment(value = "Screenshot", type = "image/png")
    private static String captureScreenshot() {
        return screenshot("my_file_name");
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}