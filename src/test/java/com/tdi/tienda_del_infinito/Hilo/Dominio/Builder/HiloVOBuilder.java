package com.tdi.tienda_del_infinito.Hilo.Dominio.Builder;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@With
public class HiloVOBuilder {
    private String titulo;
    private String Fecha_creacion;

    public HiloVO build() {
        ObjectMother om = ObjectMother.getInstance();
        HiloVO mother = om.bear("HiloVO", HiloVO.class);

        return new HiloVO(
                titulo != null ? titulo : mother.getTitulo(),
                Fecha_creacion != null ? Fecha_creacion : mother.getFecha_creacion()
        );
    }
}
