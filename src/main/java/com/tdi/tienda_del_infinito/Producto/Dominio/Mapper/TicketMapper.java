package com.tdi.tienda_del_infinito.Producto.Dominio.Mapper;

import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class TicketMapper {

    /**
     * Conversor de TicketVO a TicketDTO
     *
     * @param vo
     * @return
     */
    public static TicketDTO toDTO(TicketVO vo) {
        return new TicketDTO()
                .withId(vo.getId())
                .withFecha(vo.getFecha())
                .withImporte(vo.getImporte())
                .withProducto(ProductoMapper.toDTO(vo.getProducto()))
                .withUnidades(vo.getUnidades())
                .withUsuario(UsuarioMapper.toDTO(vo.getUsuario()));
    }

    /**
     * Conversor de TicketDTO a TicketVO
     *
     * @param dto
     * @return
     */
    public static TicketVO fromDTO(TicketDTO dto) {
        return new TicketVO()
                .withId(dto.getId())
                .withFecha(dto.getFecha())
                .withImporte(dto.getImporte())
                .withProducto(ProductoMapper.fromDTO(dto.getProducto()))
                .withUnidades(dto.getUnidades())
                .withUsuario(UsuarioMapper.fromDTO(dto.getUsuario()));
    }

}
