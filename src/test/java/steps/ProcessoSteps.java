package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class ProcessoSteps  extends BaseSteps {

    private HomePage homePage = new HomePage(driver);
    private MenuAgapitoSofware menuAgapitoSofware = new MenuAgapitoSofware(driver);
    private ListaProcesso listaProcesso = new ListaProcesso(driver);
    private NovoProcesso novoProcesso = new NovoProcesso(driver);
    private DetalheProcesso detalheProcesso = new DetalheProcesso(driver);
    private EditaProcesso editaProcesso = new EditaProcesso(driver);

    @Dado("^que o usuário encontra na página inicial$")
    public void queOUsuárioEncontraNaPáginaInicial() {
        homePage.open();
    }

    @E("^e que o usuário clica no Menu Processo$")
    public void eQueOUsuarioClicaNoMenuProcesso() {
        menuAgapitoSofware.clickProcessos();
    }

    @E("^o usuário clica no botão novo Processo$")
    public void oUsuarioClicaNoBotaoNovoProcesso() {
        listaProcesso.clickNewProcess();
    }

    @E("^o usuário informar \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void oUsuarioInformarComOValor(String field, String value) {
        novoProcesso.fillField(field, value);
    }

    @Quando("^o usuário clicar no botão salvar$")
    public void oUsuarioClicarNoBotaoSalvar() {
        novoProcesso.clickSave();
        novoProcesso.setCode(detalheProcesso.getCode().toString());
    }

    @Então("^o usuário deve ver ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveVerVerAMensagem(String message) {
        Assert.assertEquals(message, detalheProcesso.getNotice());
    }

    @E("^o usuário clicar no botão voltar$")
    public void oUsuarioClicarNoBotaoVoltar() {
        detalheProcesso.clickBack();
    }

    @E("^o usuário clicar no botão editar do usuário cadastrado$")
    public void oUsuarioClicarNoBotaoEditarDoUsuarioCadastrado() throws InterruptedException {
        Thread.sleep(3000);
        listaProcesso.clickEditProcess(novoProcesso.getCode());
    }

    @E("^o usuário informa o campo do \"([^\"]*)\" com o valor \"([^\"]*)\" na tela de edição$")
    public void oUsuarioInformaOCampoDoComOValorNaTelaDeEdicao(String field, String value) {
        editaProcesso.fillField(field, value);
    }

    @Quando("^o usuário clica no botão salvar na tela de edição$")
    public void oUsuarioClicaNoBotaoSalvarNaTelaDeEdicao() {
        editaProcesso.clickSave();
    }

    @Então("^o usuário deve ver o valor \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void oUsuarioDeveVerOValorNoCampo(String value, String field) {
        Assert.assertEquals(value, detalheProcesso.getField(field));
    }

    @Quando("^o usuário clica no botão consultar do processo cadastrado$")
    public void oUsuarioClicaNoBotãoConsultarDoProcessoCadastrado() {
        listaProcesso.clickShow(novoProcesso.getCode());
    }

    @Quando("^o usuário clicar no botão apagar do processo cadastrado$")
    public void oUsuarioClicarNoBotaoApagarDoProcessoCadastrado() {
        listaProcesso.clickDelete(novoProcesso.getCode());
    }

    @E("^o usuário confirmar a exclusão$")
    public void oUsuarioConfirmarAExclusao() {
        listaProcesso.deleteConfirm();
    }

    @Então("^o botão apagar não deve mais existir para o usuário cadastrado$")
    public void oBotaoApagarNaoDeveMaisExistirParaOUsuarioCadastrado() throws InterruptedException {
        Assert.assertFalse(listaProcesso.existDeleteButton(novoProcesso.getCode()));
    }

    @Quando("^o usuário clicar no botão salvar na tela de edição$")
    public void oUsuarioClicarNoBotaoSalvarNaTelaDeEdicao() {
        editaProcesso.clickSave();
    }
}
