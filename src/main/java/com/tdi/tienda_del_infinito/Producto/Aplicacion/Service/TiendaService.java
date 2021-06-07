package com.tdi.tienda_del_infinito.Producto.Aplicacion.Service;

import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.FavoritosDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.FavoritosMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.TicketMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.FavoritosRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.TicketRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Shared.Err.EntityExist;
import com.tdi.tienda_del_infinito.Shared.Err.EntityNotExist;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
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
public class TiendaService {

    /**
     * favoritosRepo tipo FavoritosRepository
     */
    @Autowired
    private FavoritosRepository favoritosRepo;

    /**
     * ticketRepo tipo TicketRepository
     */
    @Autowired
    private TicketRepository ticketRepo;


    @Transactional
    public TicketVO Comprar_Producto(TicketDTO ticketdto) {

        Optional<TicketVO> nbd = ticketRepo.findById(ticketdto.getId());
        if (nbd.isPresent())
            throw new EntityExist(TicketVO.class.toString(), ticketdto.getId());

        TicketVO ticket = TicketMapper.fromDTO(ticketdto);
        return ticketRepo.save(ticket);
    }

    @Transactional
    public ArrayList<TicketDTO> Consultar_tickets() {
        List<TicketVO> nbd = ticketRepo.findAll();
        ArrayList<TicketDTO> nbdA = new ArrayList<>();
        for (int i = 0; i < nbd.size(); i++) {
            TicketDTO ticket = TicketMapper.toDTO(nbd.get(i));
            nbdA.add(ticket);
        }
        return nbdA;
    }

    /**
     * Método para eliminar un ticket
     *
     * @param id
     */
    @Transactional
    public boolean Eliminar_Ticket(int id) {
        Optional<TicketVO> nbd = ticketRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(TicketVO.class.toString(), id);
        }
        ticketRepo.deleteById(id);
        return true;
    }

    @Transactional
    public ArrayList<TicketDTO> Consultar_ticketsbyUser(Integer user) {
        ArrayList<TicketDTO> nbdA = new ArrayList<>();
        List<TicketVO> nbd = ticketRepo.findByUsuario_Id(user);
        if (nbd.isEmpty()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), user);
        } else {
            for (int i = 0; i < nbd.size(); i++) {
                TicketDTO ticket = TicketMapper.toDTO(nbd.get(i));
                nbdA.add(ticket);
            }
        }
        return nbdA;
    }


    @Transactional
    public FavoritosVO Añadir_Favorito(FavoritosDTO favoritosdto) {

        Optional<FavoritosVO> nbd = favoritosRepo.findById(favoritosdto.getId());
        if (nbd.isPresent())
            throw new EntityExist(FavoritosVO.class.toString(), favoritosdto.getId());

        FavoritosVO favorito = FavoritosMapper.fromDTO(favoritosdto);
        return favoritosRepo.save(favorito);
    }

    @Transactional
    public ArrayList<FavoritosDTO> Consultar_favoritos() {
        List<FavoritosVO> nbd = favoritosRepo.findAll();
        ArrayList<FavoritosDTO> nbdA = new ArrayList<>();
        for (int i = 0; i < nbd.size(); i++) {
            FavoritosDTO favorito = FavoritosMapper.toDTO(nbd.get(i));
            nbdA.add(favorito);
        }
        return nbdA;
    }

    @Transactional
    public ArrayList<FavoritosDTO> Consultar_favoritosbyUser(Integer user) {
        ArrayList<FavoritosDTO> nbdA = new ArrayList<>();
        List<FavoritosVO> nbd = favoritosRepo.findByUsuario_Id(user);
        if (nbd.isEmpty()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), user);
        } else {
            for (int i = 0; i < nbd.size(); i++) {
                FavoritosDTO ticket = FavoritosMapper.toDTO(nbd.get(i));
                nbdA.add(ticket);
            }
        }
        return nbdA;
    }


}
