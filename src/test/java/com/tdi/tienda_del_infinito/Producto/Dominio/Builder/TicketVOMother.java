package com.tdi.tienda_del_infinito.Producto.Dominio.Builder;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;

public class TicketVOMother {
    public static TicketVO general() {
        return new TicketVOBuilder().build();
    }
}
