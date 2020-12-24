package pages;

import support.DriverQA;

public class MenuAgapitoSofware extends BasePage  {

    public MenuAgapitoSofware(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clickProcessos() {
        driver.click("processos");
    }
}
