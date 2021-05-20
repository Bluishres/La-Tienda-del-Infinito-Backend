package com.tdi.tienda_del_infinito.Hilo.Dominio.Builder;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;

public class MensajeVOMother {
    public static MensajeVO general() {
        return new MensajeVOBuilder().build();
    }
}
