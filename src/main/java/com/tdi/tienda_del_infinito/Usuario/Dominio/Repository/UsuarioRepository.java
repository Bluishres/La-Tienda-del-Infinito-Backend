package com.tdi.tienda_del_infinito.Usuario.Dominio.Repository;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Clase interfaz UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO, Integer> {

    Optional<UsuarioVO> findByEmail(String Email);
    Optional<UsuarioVO> findByNick(String Nick);

}
