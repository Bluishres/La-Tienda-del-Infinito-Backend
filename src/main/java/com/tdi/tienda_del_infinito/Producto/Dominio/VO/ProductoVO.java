package com.tdi.tienda_del_infinito.Producto.Dominio.VO;

import com.tdi.tienda_del_infinito.Shared.Dominio.Audit.AuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase ProductoVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "producto")
public class ProductoVO extends AuditableEntity implements Serializable {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    /**
     * nombre tipo String
     */
    @Column(length = 500)
    private String Nombre;

    /**
     * precio tipo String
     */
    @Column(length = 500)
    private String Precio;

    /**
     * stock tipo Integer
     */
    @Column(length = 500)
    private int Stock_disponible;

    /**
     * fecha tipo Date
     */
    @Column(length = 500)
    private String Fecha_creacion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FavoritosVO> lista_usuarios_deseados;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TicketVO> tickets;

    /**
     * descripcion tipo String
     */
    @Column(length = 500)
    private String descripcion;

    public ProductoVO(String nombre, String precio, int stock_disponible, String fecha_creacion, String descripcion) {
        Nombre = nombre;
        Precio = precio;
        Stock_disponible = stock_disponible;
        Fecha_creacion = fecha_creacion;
        this.descripcion = descripcion;
    }
}
