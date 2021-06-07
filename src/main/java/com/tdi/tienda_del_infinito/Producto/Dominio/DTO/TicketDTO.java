package com.tdi.tienda_del_infinito.Producto.Dominio.DTO;

import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import lombok.*;


/**
 * Clase TicketDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
public class TicketDTO {
    /**
     * id tipo int
     */
    private int Id;

    /**
     * fecha tipo String
     */
    private String Fecha;

    /**
     * importe tipo Double
     */
    private Double Importe;

    /**
     * unidades tipo Integer
     */
    private int Unidades;

    /**
     * usuario tipo usuariovo
     */
    private UsuarioDTO Usuario;


    /**
     * producto tipo productovo
     */
    private ProductoDTO Producto;

    public TicketDTO(String fecha, Double importe, int unidades, UsuarioDTO usuario, ProductoDTO producto) {
        Fecha = fecha;
        Importe = importe;
        Unidades = unidades;
        Usuario = usuario;
        Producto = producto;
    }
}
