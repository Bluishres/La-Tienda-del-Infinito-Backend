package com.tdi.tienda_del_infinito.Producto.Dominio.Mapper;

import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.ProductoDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class ProductoMapper {

    /**
     * Conversor de EventoVO a EventoDTO
     * @param vo
     * @return
     */
    public static ProductoDTO toDTO(ProductoVO vo) {
        return new ProductoDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withFecha_creacion(vo.getFecha_creacion())
                .withPrecio(vo.getPrecio())
                .withStock_disponible(vo.getStock_disponible())
                .withDescripcion(vo.getDescripcion());
    }

    /**
     * Conversor de EventoDTO a EventoVO
     * @param dto
     * @return
     */
    public static ProductoVO fromDTO(ProductoDTO dto) {
        return new ProductoVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withFecha_creacion(dto.getFecha_creacion())
                .withPrecio(dto.getPrecio())
                .withStock_disponible(dto.getStock_disponible())
                .withDescripcion(dto.getDescripcion());
    }
}
