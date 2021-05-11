package com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper;

import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.UsuarioVO;

public class UsuarioMapper {

    /**
     * Conversor de UsuarioVO a UsuarioDTO
     * @param vo
     * @return
     */
    public static UsuarioDTO toDTO(UsuarioVO vo) {
        return new UsuarioDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withPassword(vo.getPassword())
                .withEmail(vo.getEmail())
                .withFecha_Nacimiento(vo.getFecha_Nacimiento())
                .withNick(vo.getNick())
                .withAdmin(vo.isAdmin())
                .withApellidos(vo.getApellidos())
                .withDireccion(vo.getDireccion())
                .withFoto_Perfil(vo.getFoto_Perfil())
                .withNacionalidad(vo.getNacionalidad());
    }

    /**
     * Conversor de UsuarioDTO a UsuarioVO
     * @param dto
     * @return
     */
    public static UsuarioVO fromDTO(UsuarioDTO dto) {
        return new UsuarioVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withPassword(dto.getPassword())
                .withEmail(dto.getEmail())
                .withFecha_Nacimiento(dto.getFecha_Nacimiento())
                .withNick(dto.getNick())
                .withAdmin(dto.isAdmin())
                .withApellidos(dto.getApellidos())
                .withDireccion(dto.getDireccion())
                .withFoto_Perfil(dto.getFoto_Perfil())
                .withNacionalidad(dto.getNacionalidad());
    }
}
