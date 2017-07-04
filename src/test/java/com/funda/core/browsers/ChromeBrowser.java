package com.funda.core.browsers;

import com.funda.core.driver.FundaWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeBrowser extends BrowserAbstract {

    static String CHROMEDRIVER_PATH_FORMAT = "Drivers/Chrome/%s";
    static String CHROMEDRIVER_PATH_MAC = String.format(CHROMEDRIVER_PATH_FORMAT, "macos/chromedriver");
    static String CHROMEDRIVER_PATH_LINUX = String.format(CHROMEDRIVER_PATH_FORMAT, "linux64/chromedriver");
    static String CHROMEDRIVER_PATH_WINDOWS = String.format(CHROMEDRIVER_PATH_FORMAT, "win32/chromedriver.exe");

    private ChromeOptions chromeOptions = new ChromeOptions();


    private File getDriverFile() {
        String chromeBinaryPath = "";
        String osName = System.getProperty("os.name").toUpperCase();

        if (osName.contains("WINDOWS")) {
            chromeBinaryPath = CHROMEDRIVER_PATH_WINDOWS;
        } else if (osName.contains("MAC")) {
            chromeBinaryPath = CHROMEDRIVER_PATH_MAC;
        } else if (osName.contains("LINUX")) {
            chromeBinaryPath = CHROMEDRIVER_PATH_LINUX;
        }

        File chromedriver = new File(ClassLoader.getSystemResource(chromeBinaryPath).getPath());
        chromedriver.setExecutable(true);

        return chromedriver;
    }

    @Override
    public void setOptions() {
        System.setProperty("webdriver.chrome.driver", getDriverFile().getPath());

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("process-per-site");
        chromeOptions.addArguments("dns-prefetch-disable");
        chromeOptions.addArguments("--kiosk");
    }

    @Override
    public FundaWebDriver create() {
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new FundaWebDriver(new ChromeDriver(caps));
    }
}
