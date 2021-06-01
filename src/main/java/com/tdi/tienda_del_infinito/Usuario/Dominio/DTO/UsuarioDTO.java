package com.tdi.tienda_del_infinito.Usuario.Dominio.DTO;

import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.HiloDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.MensajeDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.FavoritosDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Shared.Aplicacion.Dto;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase UsuarioDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class UsuarioDTO implements Dto, Serializable {
    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String Nick;

    /**
     * password tipo String
     */
    private String Password;

    /**
     * email tipo String
     */
    private String Email;

    /**
     * nombre tipo String
     */
    private String Nombre;

    /**
     * apellidos tipo String
     */
    private String Apellidos;

    /**
     * nacionalidad tipo String
     */
    private String Nacionalidad;

    /**
     * fecha_nacimiento tipo String
     */
    private String Fecha_Nacimiento;

    /**
     * direccion tipo String
     */
    private String Direccion;

    /**
     * isAdmin tipo boolean
     */
    private boolean isAdmin;

    /**
     * foto_perfil tipo String
     */
    private String Foto_Perfil;

    private List<HiloDTO> hilos = new ArrayList<>();

    private List<MensajeDTO> mensajes = new ArrayList<>();

    private List<FavoritosDTO> lista_deseados = new ArrayList<>();

    private List<TicketDTO> tickets = new ArrayList<>();

}
