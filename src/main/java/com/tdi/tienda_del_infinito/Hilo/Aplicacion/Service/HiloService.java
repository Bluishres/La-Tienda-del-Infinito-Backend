package com.tdi.tienda_del_infinito.Hilo.Aplicacion.Service;

import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.HiloDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.MensajeDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.HiloMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.MensajeMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Repository.HiloRepository;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Repository.MensajeRepository;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
import com.tdi.tienda_del_infinito.Shared.Err.EntityExist;
import com.tdi.tienda_del_infinito.Shared.Err.EntityNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Casos de uso de la Tienda
 */
@Service
public class HiloService {

    @Autowired
    private HiloRepository hiloRepository;

    @Autowired
    private MensajeRepository mensajeRepository;


    @Transactional
    public HiloVO CrearHilo(HiloDTO hilodto) {

        Optional<HiloVO> nbd = hiloRepository.findById(hilodto.getId());
        if (nbd.isPresent())
            throw new EntityExist(HiloVO.class.toString(), hilodto.getId());

        HiloVO hilo = HiloMapper.fromDTO(hilodto);
        return hiloRepository.save(hilo);
    }

    @Transactional
    public ArrayList<HiloDTO> Consultar_hilos() {
        List<HiloVO> nbd = hiloRepository.findAll();
        ArrayList<HiloDTO> nbdA = new ArrayList<>();
        for (int i = 0; i < nbd.size(); i++) {
            HiloDTO hilo = HiloMapper.toDTO(nbd.get(i));
            nbdA.add(hilo);
        }
        return nbdA;
    }

    @Transactional
    public Optional<HiloVO> Consultar_hilo(int id) {
        Optional<HiloVO> nbd = hiloRepository.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(HiloVO.class.toString(), id);
        }
        return nbd;
    }

    @Transactional
    public boolean Eliminar_hilo(int id) {
        Optional<HiloVO> nbd = hiloRepository.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(HiloVO.class.toString(), id);
        }
        hiloRepository.deleteById(id);
        return true;
    }

    @Transactional
    public MensajeVO EnviarMensaje(MensajeDTO mensajedto) {

        Optional<MensajeVO> nbd = mensajeRepository.findById(mensajedto.getId());
        if (nbd.isPresent())
            throw new EntityExist(HiloVO.class.toString(), mensajedto.getId());

        MensajeVO mensaje = MensajeMapper.fromDTO(mensajedto);
        return mensajeRepository.save(mensaje);
    }

    @Transactional
    public ArrayList<MensajeDTO> getMensajesbyHilo(Integer hilo) {
        ArrayList<MensajeDTO> nbdA = new ArrayList<>();
        List<MensajeVO> nbd = mensajeRepository.findByHilo_Id(hilo);
        if (nbd.isEmpty()) {
            throw new EntityNotExist(MensajeVO.class.toString(), hilo);
        } else {
            for (int i = 0; i < nbd.size(); i++) {
                MensajeDTO mensaje = MensajeMapper.toDTO(nbd.get(i));
                nbdA.add(mensaje);
            }
        }
        return nbdA;
    }

    @Transactional
    public boolean Eliminar_mensaje(int id) {
        Optional<MensajeVO> nbd = mensajeRepository.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(MensajeVO.class.toString(), id);
        }
        mensajeRepository.deleteById(id);
        return true;
    }

}
