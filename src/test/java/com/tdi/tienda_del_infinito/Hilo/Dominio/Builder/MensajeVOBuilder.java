package com.tdi.tienda_del_infinito.Hilo.Dominio.Builder;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@With
public class MensajeVOBuilder {
    private Date Fecha_creacion;
    private String mensaje;

    public MensajeVO build() {
        ObjectMother om = ObjectMother.getInstance();
        MensajeVO mother = om.bear("MensajeVO", MensajeVO.class);

        return new MensajeVO(
                Fecha_creacion != null ? Fecha_creacion : mother.getFecha_creacion(),
                mensaje != null ? mensaje : mother.getMensaje()
        );
    }


}
