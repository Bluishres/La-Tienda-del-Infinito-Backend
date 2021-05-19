package com.tdi.tienda_del_infinito.Producto.Dominio.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * lista_usuarios_deseados tipo List
     */
    private List<FavoritosDTO> lista_usuarios_deseados = new ArrayList<>();

    /**
     * lista_usuarios_deseados tipo List
     */
    private List<TicketDTO> tickets = new ArrayList<>();

    /**
     * descripcion tipo String
     */
    private String descripcion;
}
