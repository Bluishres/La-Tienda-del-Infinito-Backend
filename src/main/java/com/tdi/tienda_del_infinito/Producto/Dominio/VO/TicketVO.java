package com.tdi.tienda_del_infinito.Producto.Dominio.VO;

import com.tdi.tienda_del_infinito.Shared.Dominio.Audit.AuditableEntity;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase TicketVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "ticket")
public class TicketVO extends AuditableEntity implements Serializable {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    /**
     * fecha tipo String
     */
    @Column(length = 500)
    private String Fecha;

    /**
     * importe tipo Double
     */
    @Column(length = 500)
    private Double Importe;

    /**
     * unidades tipo Integer
     */
    @Column(length = 500)
    private int Unidades;

    /**
     * usuario tipo usuariovo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioVO usuario;


    /**
     * producto tipo productovo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private ProductoVO producto;

    public TicketVO(String fecha, Double importe, int unidades) {
        Fecha = fecha;
        Importe = importe;
        Unidades = unidades;
    }
}
