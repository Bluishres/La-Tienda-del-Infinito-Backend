package com.tdi.tienda_del_infinito.Producto.Dominio.DTO;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase ProductoDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
public class ProductoDTO {

    /**
     * id tipo int
     */
    private int Id;

    /**
     * nombre tipo String
     */
    private String Nombre;

    /**
     * precio tipo String
     */
    private String Precio;

    /**
     * stock tipo Integer
     */
    private int Stock_disponible;

    /**
     * fecha tipo Date
     */
    private Date Fecha_creacion;

    /*    *//**
     * idusuario tipo int
     *//*
    private UsuarioVO id_usuarios;*/

    /**
     * descripcion tipo String
     */
    private String descripcion;
}
