package com.tdi.tienda_del_infinito.Hilo.Dominio.Repository;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz HiloRepository
 */
@Repository
public interface HiloRepository extends JpaRepository<HiloVO, Integer> {


}
