package com.tdi.tienda_del_infinito.Usuario.Dominio.Repository;

import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO, Integer> {

}
