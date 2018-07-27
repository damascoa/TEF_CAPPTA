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
public class TratarErros {

    private String mensagem;

    public TratarErros(int codigo) {
        switch (codigo) {
            case 1:
                mensagem = "Não autenticado/Alguma das informações fornecidas para autenticação não é válida";
                break;
            case 2:
                mensagem = "CapptaGpPlus está sendo inicializado";
                break;
            case 3:
                mensagem = "Formato da requisição recebida pelo CapptaGpPlus é inválido";
                break;
            case 4:
                mensagem = "Operação cancelada pelo operador";
                break;
            case 5:
                mensagem = "Pagamento não autorizado/pendente/não encontrado";
                break;
            case 6:
                mensagem = "Pagamento ou cancelamento negados pela rede adquirente ou falta de conexão com internet";
                break;
            case 7:
                mensagem = "Erro interno no CapptaGpPlus";
                break;
            case 8:
                mensagem = "Erro na comunicação entre o Checkout Cappta e o CapptaGpPlus";
                break;
            case 9:
                mensagem = "Ocorre quando qualquer operação é realizada sem que se tenha finalizado o último pagamento";
                break;
            case 10:
                mensagem = "Uma reimpressão ou cancelamento foi executada dentro de uma sessão multi-cartões";
                break;
            case 14:
                mensagem = "Valor digitado no pinpad é inválido.";
                break;
            case 15:
                mensagem = "Existem pagamentos pendentes de uma sessão de multiplos pagamentos não finalizada.";
                break;
            default:
                mensagem = "Motivo desconhecido";
                break;
        }

    }

    public String getMensagem() {
        return mensagem;
    }

}
