package com.tdi.tienda_del_infinito.Producto.Dominio.Mapper;

import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.FavoritosDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class FavoritosMapper {

    /**
     * Conversor de FavoritosVO a FavoritosDTO
     *
     * @param vo
     * @return
     */
    public static FavoritosDTO toDTO(FavoritosVO vo) {
        return new FavoritosDTO()
                .withId(vo.getId())
                .withProducto(ProductoMapper.toDTO(vo.getProducto()))
                .withUsuario(UsuarioMapper.toDTO(vo.getUsuario()));
    }

    /**
     * Conversor de FavoritosDTO a FavoritosVO
     *
     * @param dto
     * @return
     */
    public static FavoritosVO fromDTO(FavoritosDTO dto) {
        return new FavoritosVO()
                .withId(dto.getId())
                .withProducto(ProductoMapper.fromDTO(dto.getProducto()))
                .withUsuario(UsuarioMapper.fromDTO(dto.getUsuario()));
    }
}
