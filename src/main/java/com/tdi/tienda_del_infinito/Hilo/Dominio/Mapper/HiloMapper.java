package com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper;

import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.HiloDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class HiloMapper {
    /**
     * Conversor de HiloVO a HiloDTO
     *
     * @param vo
     * @return
     */
    public static HiloDTO toDTO(HiloVO vo) {
        return new HiloDTO()
                .withId(vo.getId())
                .withCreador(UsuarioMapper.toDTO(vo.getCreador()))
                .withFecha_creacion(vo.getFecha_creacion())
                .withTitulo(vo.getTitulo());
    }

    /**
     * Conversor de HiloDTO a HiloVO
     *
     * @param dto
     * @return
     */
    public static HiloVO fromDTO(HiloDTO dto) {
        return new HiloVO()
                .withId(dto.getId())
                .withCreador(UsuarioMapper.fromDTO(dto.getCreador()))
                .withFecha_creacion(dto.getFecha_creacion())
                .withTitulo(dto.getTitulo());
    }

}
