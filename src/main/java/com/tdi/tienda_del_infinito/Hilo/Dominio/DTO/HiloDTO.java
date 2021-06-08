package com.tdi.tienda_del_infinito.Hilo.Dominio.DTO;

import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase HiloDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
public class HiloDTO {
    /**
     * id tipo int el cual es el Id en la base de datos
     */
    private int Id;

    /**
     * usuario tipo usuariovo
     */
    private UsuarioDTO creador;

    /**
     * titulo tipo String
     */
    private String titulo;

    /**
     * fecha_creacion tipo Date
     */
    private String Fecha_creacion;

    /**
     * lista_mensajes tipo List
     */
//    private List<MensajeDTO> lista_mensajes = new ArrayList<>();

    public HiloDTO(UsuarioDTO creador, String titulo, String fecha_creacion) {
        this.creador = creador;
        this.titulo = titulo;
        this.Fecha_creacion = fecha_creacion;
    }
}
