package com.tdi.tienda_del_infinito.Usuario.Dominio.VO;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Shared.Dominio.Audit.AuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase UsuarioVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@With
@Entity(name = "usuario")
public class UsuarioVO extends AuditableEntity implements Serializable {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nombre tipo String
     */
    @Column(unique = true, nullable = false)
    private String Nick;

    /**
     * password tipo String
     */
    @Column(length = 30, nullable = false)
    private String Password;

    /**
     * email tipo String
     */
    @Column(length = 50, nullable = false)
    private String Email;

    /**
     * nombre tipo String
     */
    @Column(length = 50, nullable = false)
    private String Nombre;

    /**
     * apellidos tipo String
     */
    @Column(length = 50, nullable = false)
    private String Apellidos;

    /**
     * nacionalidad tipo String
     */
    @Column(length = 50, nullable = false)
    private String Nacionalidad;

    /**
     * fecha_nacimiento tipo Date
     */
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date Fecha_Nacimiento;

    /**
     * direccion tipo String
     */
    @Column(length = 50, nullable = false)
    private String Direccion;

    /**
     * isAdmin tipo boolean
     */
    @Column(length = 50, nullable = false)
    private boolean isAdmin;

    /**
     * foto_perfil tipo String
     */
    @Column(length = 150, nullable = false)
    private String Foto_Perfil;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HiloVO> hilos = new ArrayList<>();

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MensajeVO> mensajes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FavoritosVO> lista_deseados = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TicketVO> tickets = new ArrayList<>();


}
