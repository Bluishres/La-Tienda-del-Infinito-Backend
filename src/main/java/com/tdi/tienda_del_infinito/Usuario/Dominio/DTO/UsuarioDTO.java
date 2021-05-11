package com.tdi.tienda_del_infinito.Usuario.Dominio.DTO;

import com.tdi.tienda_del_infinito.Producto.Dominio.ProductoVO;
import com.tdi.tienda_del_infinito.Shared.Aplicacion.Dto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
     * fecha_nacimiento tipo Date
     */
    private Date Fecha_Nacimiento;

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

/*    @OneToMany(mappedBy = "Creador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HiloVO> hilos = new ArrayList<>();

    private List<ProductoVO> lista_deseados = new ArrayList<>();

    private List<ProductoDTO> Historial_Compra = new ArrayList<>();*/

}
