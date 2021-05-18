package com.tdi.tienda_del_infinito.Producto.Dominio.DTO;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.*;

import javax.persistence.*;

/**
 * Clase FavoritosDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
public class FavoritosDTO {
    /**
     * id tipo int
     */
    private int Id;

    /**
     * usuario tipo usuariovo
     */
    private UsuarioVO Usuario;


    /**
     * producto tipo productovo
     */
    private ProductoVO Producto;
}
