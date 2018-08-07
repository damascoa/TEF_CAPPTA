/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.cappta.services.enums;

/**
 *
 * @author Renato
 */
public enum TipoVia {
    TIPO_VIA_TODAS(1),
    TIPO_VIA_CLIENTE(2),
    TIPO_VIA_LOJA(3);

    private Integer codigo;

    private TipoVia(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
