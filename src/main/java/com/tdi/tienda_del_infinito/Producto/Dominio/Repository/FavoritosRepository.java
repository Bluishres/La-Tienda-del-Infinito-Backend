package com.tdi.tienda_del_infinito.Producto.Dominio.Repository;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz FavoritosRepository
 */
@Repository
public interface FavoritosRepository extends JpaRepository<FavoritosVO, Integer> {
}
