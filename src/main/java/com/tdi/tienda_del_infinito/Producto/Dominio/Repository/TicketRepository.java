package com.tdi.tienda_del_infinito.Producto.Dominio.Repository;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz TicketRepository
 */
@Repository
public interface TicketRepository extends JpaRepository<TicketVO, Integer> {
}
