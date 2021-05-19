package com.tdi.tienda_del_infinito.Producto.Dominio.DTO;

import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import lombok.*;

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
    private UsuarioDTO Usuario;


    /**
     * producto tipo productovo
     */
    private ProductoDTO Producto;

    public FavoritosDTO(UsuarioDTO usuario, ProductoDTO producto) {
        Usuario = usuario;
        Producto = producto;
    }
}
