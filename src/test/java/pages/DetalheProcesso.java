package pages;

import support.DriverQA;

public class DetalheProcesso extends BasePage  {

    public DetalheProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public Object getCode() {
        return driver.getText("codigo");
    }

    public String getNotice() {
        return driver.getText("notice");
    }

    public void clickBack() {
        driver.click(".ls-btn-primary-danger", "css");
    }

    public String getField(String field) {
        return driver.getText(field);
    }
}
