package com.tdi.tienda_del_infinito.Hilo.Dominio.Builder;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;

public class HiloVOMother {
    public static HiloVO general() {
        return new HiloVOBuilder().build();
    }

}
