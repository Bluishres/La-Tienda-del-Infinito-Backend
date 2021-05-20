package com.tdi.tienda_del_infinito.Hilo.Dominio.VO;

import com.tdi.tienda_del_infinito.Shared.Dominio.Audit.AuditableEntity;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase HiloVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "hilo")
public class HiloVO extends AuditableEntity implements Serializable {

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
    private UsuarioVO creador;

    /**
     * titulo tipo String
     */
    @Column
    private String titulo;


    /**
     * fecha_creacion tipo Date
     */
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date fecha_creacion;


    /**
     * lista_mensajes tipo List
     */
    @OneToMany(mappedBy = "hilo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MensajeVO> lista_mensajes = new ArrayList<>();

    public HiloVO(String titulo, Date fecha_creacion) {
        this.titulo = titulo;
        this.fecha_creacion = fecha_creacion;
    }
}
