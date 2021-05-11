package com.tdi.tienda_del_infinito.Producto.Dominio;

import com.tdi.tienda_del_infinito.Usuario.Dominio.UsuarioVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase ProductoVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "Producto")
public class ProductoVO {

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
    private Date Fecha_creacion;

/*    *//**
     * idusuario tipo int
     *//*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", foreignKey = @ForeignKey(name = "USUARIO_ID_FK"))
    private UsuarioVO id_usuarios;*/

    /**
     * descripcion tipo String
     */
    @Column(length = 500)
    private String descripcion;
}
