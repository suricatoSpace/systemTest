package pages;

import support.DriverQA;

public class ListaProcesso extends BasePage  {
    public ListaProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }


    public void clickNewProcess() {
        driver.click("btn-novo");
    }

    public void clickEditProcess(String code) {
        String elem = "btn-edit_" + code.trim();
        driver.click(elem);
    }

    public void clickShow(String code) {
        String elem = "btn-show_" + code.trim();
        driver.click(elem);
    }

    public void clickDelete(String code) {
        String elem = "btn-delete_" + code.trim();
        driver.click(elem);
    }

    public void deleteConfirm() {
        driver.ChooseOkOnNextConfirmation();;
    }

    public boolean existDeleteButton(String code) throws InterruptedException {
        String elem = "btn-delete_" + code.trim();
        Thread.sleep(5000);
        return driver.getDriver().getPageSource().contains(elem);
    }
}
