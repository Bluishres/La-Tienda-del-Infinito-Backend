package com.tdi.tienda_del_infinito.Producto.Dominio.DTO;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
     * fecha tipo Date
     */
    private Date Fecha;

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
    private UsuarioVO Usuario;


    /**
     * producto tipo productovo
     */
    private ProductoVO Producto;
}
