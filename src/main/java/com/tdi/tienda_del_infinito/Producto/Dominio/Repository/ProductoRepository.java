package com.tdi.tienda_del_infinito.Producto.Dominio.Repository;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz ProductoRepository
 */
@Repository
public interface ProductoRepository extends JpaRepository<ProductoVO, Integer> {



}
