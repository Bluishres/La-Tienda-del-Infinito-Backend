package com.tdi.tienda_del_infinito.Hilo.Dominio.Repository;

import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase interfaz MensajeRepository
 */
@Repository
public interface MensajeRepository extends JpaRepository<MensajeVO, Integer> {

    List<MensajeVO> findByHilo_Id(Integer id);

}
