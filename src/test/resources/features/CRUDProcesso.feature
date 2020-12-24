#language: pt
@wip
Funcionalidade: CRUD do Cadastro de Processo

  Contexto:
    Dado que o usuário encontra na página inicial
    E e que o usuário clica no Menu Processo
    E o usuário clica no botão novo Processo
    E o usuário informar "processo_vara" com o valor "Nova Mamoré"
    E o usuário informar "processo_numero_processo" com o valor "8452147"
    E o usuário informar "processo_natureza" com o valor "Civil"
    E o usuário informar "processo_partes" com o valor "Pedro Alcolumbre Junior x José Aparecido"
    E o usuário informar "processo_urgente" com o valor "sim"
    E o usuário informar "processo_arbitramento_s" com o valor "não"
    E o usuário informar "processo_assistente_social" com o valor "Patrícia Mendonça"
    E o usuário informar "processo_data_entrada" com o valor "01/12/2020"
    E o usuário informar "processo_data_saida" com o valor "15/12/2020"
    E o usuário informar "processo_data_agendamento" com o valor "10/06/2020"
    E o usuário informar "processo_status" com o valor "Concluído"
    E o usuário informar "processo_observacao" com o valor "Acordo entre as partes"

  Cenário: Adicionar um novo porcesso. - POST
    Quando o usuário clicar no botão salvar
    Então o usuário deve ver ver a mensagem "Processo foi criado com sucesso."

  Cenário: Editar um novo processo. - UPDATE
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    E o usuário clicar no botão editar do usuário cadastrado
    E o usuário informa o campo do "processo_vara" com o valor "São José dos Campos" na tela de edição
    Quando o usuário clicar no botão salvar na tela de edição
    Então o usuário deve ver o valor "São José dos Campos" no campo "vara"

  Cenário: Consultar um novo Processo. - GET
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    Quando o usuário clica no botão consultar do processo cadastrado
    Então o usuário deve ver o valor "Nova Mamoré" no campo "vara"
    E o usuário deve ver o valor "8452147" no campo "numero"
    E o usuário deve ver o valor "Civil" no campo "natureza"
    E o usuário deve ver o valor "Pedro Alcolumbre Junior x José Aparecido" no campo "partes"
    E o usuário deve ver o valor "S" no campo "urgente"
    E o usuário deve ver o valor "N" no campo "arbitramento"
    E o usuário deve ver o valor "Patrícia Mendonça" no campo "as_social"
    E o usuário deve ver o valor "2020-12-01" no campo "dt_entrada"
    E o usuário deve ver o valor "2020-12-15" no campo "dt_saida"
    E o usuário deve ver o valor "2020-06-10" no campo "dt_agendamento"
    E o usuário deve ver o valor "Concluído" no campo "status"
    E o usuário deve ver o valor "Acordo entre as partes" no campo "observacao"

  Cenário: Deletar um usuário. - DELETE
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    Quando o usuário clicar no botão apagar do processo cadastrado
    E o usuário confirmar a exclusão
    Então o botão apagar não deve mais existir para o usuário cadastrado

  Esquema do Cenario: Editar um novo processo. - UPDATE - <processo_vara> e <processo_natureza>
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    E o usuário clicar no botão editar do usuário cadastrado
    E o usuário informa o campo do "processo_vara" com o valor "<processo_vara>" na tela de edição
    E o usuário informa o campo do "processo_natureza" com o valor "<processo_natureza>" na tela de edição
    Quando o usuário clicar no botão salvar na tela de edição
    Então o usuário deve ver o valor "<processo_vara>" no campo "vara"
    E o usuário deve ver o valor "<processo_natureza>" no campo "natureza"

    Exemplos:
      | processo_vara | processo_natureza |
      | São critovão  | Criminal          |
      | Maranhão      | Familiar          |