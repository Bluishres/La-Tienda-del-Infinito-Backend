package com.tdi.tienda_del_infinito.Usuario.Dominio.Builder;

import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;

public class UsuarioVOMother {
    public static UsuarioVO general() {
        return new UsuarioVOBuilder().build();
    }
}
