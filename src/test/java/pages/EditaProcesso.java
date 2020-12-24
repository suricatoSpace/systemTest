package pages;

import support.DriverQA;

public class EditaProcesso extends BasePage  {

    public EditaProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void fillField(String field, String value) {
        driver.waitElement(field);
        switch (field){
            case "processo_vara" :
            case "processo_numero_processo" :
            case "processo_natureza" :
            case "processo_partes" :
            case "processo_assistente_social" :
            case "processo_data_entrada" :
            case "processo_data_saida" :
            case "processo_data_agendamento" :
            case "processo_status" :
            case "processo_observacao" :
                preencherInput(field,value); break;
            case "processo_urgente" : preencherUrgente(value); break;
            case "processo_arbitramento_s" : preencherArbitramento(value); break;
        }
    }

    private void preencherArbitramento(String value) {
        if (value.toLowerCase().equals("sim")){
            driver.click("processo_arbitramento_s");
        }
        else{
            driver.click("#processo_arbitramento_n","css");
        }
    }

    private void preencherUrgente(String value) {
        driver.selectByText(value, "processo_urgente");
    }

    private void preencherInput(String field, String value) {
        driver.sendKeys(value, field);
    }


    public void clickSave() {
        driver.click("btn-save");
    }
}
