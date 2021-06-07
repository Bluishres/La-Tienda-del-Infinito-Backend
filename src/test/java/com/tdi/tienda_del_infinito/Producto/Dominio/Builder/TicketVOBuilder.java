package com.tdi.tienda_del_infinito.Producto.Dominio.Builder;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@With
public class TicketVOBuilder {
    private String Fecha;
    private Double Importe;
    private int Unidades;

    public TicketVO build() {
        ObjectMother om = ObjectMother.getInstance();
        TicketVO mother = om.bear("TicketVO", TicketVO.class);

        return new TicketVO(
                Fecha != null ? Fecha : mother.getFecha().toString(),
                Importe != null ? Importe : mother.getImporte(),
                Unidades != 0 ? Unidades : mother.getUnidades()
        );
    }


}
