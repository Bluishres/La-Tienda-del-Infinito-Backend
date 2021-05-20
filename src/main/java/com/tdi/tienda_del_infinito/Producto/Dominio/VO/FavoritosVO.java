package com.tdi.tienda_del_infinito.Producto.Dominio.VO;

import com.tdi.tienda_del_infinito.Shared.Dominio.Audit.AuditableEntity;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase FavoritosVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "favoritos")
public class FavoritosVO extends AuditableEntity implements Serializable {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    /**
     * usuario tipo usuariovo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioVO usuario;


    /**
     * producto tipo productovo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private ProductoVO producto;

    public FavoritosVO(UsuarioVO usuario, ProductoVO producto) {
        this.usuario = usuario;
        this.producto = producto;
    }
}
