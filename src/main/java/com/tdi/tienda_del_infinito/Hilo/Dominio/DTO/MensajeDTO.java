package com.tdi.tienda_del_infinito.Hilo.Dominio.DTO;

import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import lombok.*;


/**
 * Clase MensajeDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
public class MensajeDTO {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    private int Id;

    /**
     * usuario tipo usuariovo
     */
    private UsuarioDTO autor;


    /**
     * fecha_creacion tipo Date
     */
    private String Fecha_creacion;

    /**
     * hilo tipo HiloVO
     */
    private HiloDTO hilo;

    /**
     * mensaje tipo String
     */
    private String mensaje;

    public MensajeDTO(UsuarioDTO autor, String fecha_creacion, HiloDTO hilo, String mensaje) {
        this.autor = autor;
        this.Fecha_creacion = fecha_creacion;
        this.hilo = hilo;
        this.mensaje = mensaje;
    }

}
