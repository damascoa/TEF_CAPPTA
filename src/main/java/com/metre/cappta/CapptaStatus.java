/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.cappta;

/**
 *
 * @author Renato
 */
public enum CapptaStatus {
    SUCESSO("0", "Sucesso"),
    NAO_AUTENTICADO("1", "Não autenticado/Alguma das informações fornecidas para autenticação não é válida"),
    INICIANDO_CAPPTAGPPLUS("2", "CapptaGpPlus está sendo inicializado"),
    ERRO_INTERNO_CAPPTAGPPLUS("7", "Erro interno no CapptaGpPlus"),
    ERRO_COMUNICACAO("8", "Erro na comunicação entre a CappAPI e o CapptaGpPlus"),
    OP_REALIZADA_SEM_FINALIZAR_ULTIMO_PAGAMENTO("9", "Ocorre quando qualquer operação é realizada sem que se tenha finalizado o último pagamento"),
    IMPRESSAO_CANCELAMENTO_EXECUTADA_MULTI_CARTOES("10", "Uma reimpressão ou cancelamento foi executada dentro de uma sessão multi-cartões"),
    VALOR_INVALIDO("14", "Valor digitado no pinpad é inválido.");

    private CapptaStatus(String codigo, String Mensagem) {
        this.codigo = codigo;
        this.Mensagem = Mensagem;
    }

    private String codigo;
    private String Mensagem;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public String valueByCodigo(String codigo) {
        String saida = "Não reconhecido";
        for (CapptaStatus cs : CapptaStatus.values()) {
            if (codigo.equals(cs.getCodigo())) {
                saida = cs.getMensagem();
                break;
            }
        }
        return saida;
    }

}
