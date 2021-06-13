package com.tdi.tienda_del_infinito.Producto.Dominio.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tdi.tienda_del_infinito.Shared.Dominio.Audit.AuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Clase ProductoVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@With
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
     * Imagen tipo String
     */
    @Column
    private String Imagen;

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

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FavoritosVO> lista_usuarios_deseados;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketVO> tickets;

    /**
     * descripcion tipo String
     */
    @Column(length = 500)
    private String descripcion;

    public ProductoVO(String nombre, String precio, int stock_disponible, String fecha_creacion, String descripcion, String imagen) {
        Nombre = nombre;
        Precio = precio;
        Stock_disponible = stock_disponible;
        Fecha_creacion = fecha_creacion;
        this.descripcion = descripcion;
        Imagen = imagen;
    }

}
