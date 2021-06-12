package com.tdi.tienda_del_infinito.Hilo.Dominio.VO;

import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.*;

import javax.persistence.*;

/**
 * Clase MensajeVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "mensaje")
public class MensajeVO {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * usuario tipo usuariovo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioVO autor;

    /**
     * fecha_creacion tipo Date
     */
    @Column
    private String fecha_creacion;

    /**
     * fecha_creacion tipo Date
     */
    @Column
    private String mensaje;

    /**
     * hilo tipo HiloVO
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hilo_id")
    private HiloVO hilo;

    public MensajeVO(String fecha_creacion, String mensaje) {
        this.fecha_creacion = fecha_creacion;
        this.mensaje = mensaje;
    }
}
