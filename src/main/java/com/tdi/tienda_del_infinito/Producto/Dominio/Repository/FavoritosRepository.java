package com.tdi.tienda_del_infinito.Producto.Dominio.Repository;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase interfaz FavoritosRepository
 */
@Repository
public interface FavoritosRepository extends JpaRepository<FavoritosVO, Integer> {

    List<FavoritosVO> findByUsuario_Id(Integer usuario);
}
