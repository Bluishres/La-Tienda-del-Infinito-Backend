package com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper;

import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.MensajeDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class MensajeMapper {

    /**
     * Conversor de MensajeVO a MensajeDTO
     *
     * @param vo
     * @return
     */
    public static MensajeDTO toDTO(MensajeVO vo) {
        return new MensajeDTO()
                .withId(vo.getId())
                .withAutor(UsuarioMapper.toDTO(vo.getAutor()))
                .withFecha_creacion(vo.getFecha_creacion())
                .withHilo(HiloMapper.toDTO(vo.getHilo()))
                .withMensaje(vo.getMensaje());
    }

    /**
     * Conversor de MensajeDTO a MensajeVO
     *
     * @param dto
     * @return
     */
    public static MensajeVO fromDTO(MensajeDTO dto) {
        return new MensajeVO()
                .withId(dto.getId())
                .withAutor(UsuarioMapper.fromDTO(dto.getAutor()))
                .withFecha_creacion(dto.getFecha_creacion())
                .withHilo(HiloMapper.fromDTO(dto.getHilo()))
                .withMensaje(dto.getMensaje());
    }


}
