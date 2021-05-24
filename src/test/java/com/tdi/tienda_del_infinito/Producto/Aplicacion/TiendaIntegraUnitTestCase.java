package com.tdi.tienda_del_infinito.Producto.Aplicacion;

import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.ProductoService;
import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.TiendaService;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.TicketVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.FavoritosDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.ProductoDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.FavoritosMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.ProductoMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.TicketMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.FavoritosRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.ProductoRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.TicketRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Shared.Config.ConfigurationPersistenceTest;
import com.tdi.tienda_del_infinito.Shared.Err.EntityExist;
import com.tdi.tienda_del_infinito.Shared.Err.EntityNotExist;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Builder.UsuarioVOBuilder;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Repository.UsuarioRepository;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class})
public class TiendaIntegraUnitTestCase {

    @Autowired
    TiendaService tiendaService;

    @Autowired
    TicketRepository ticketRepo;

    @Autowired
    FavoritosRepository favoritosRepo;

    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    ProductoRepository productRepo;


    @Test
    @Transactional
    public void ShouldBuyTicketNotExistTest() {

        TicketVO newticket = tiendaService.Comprar_Producto(buildTicketDto());

        Assert.assertNotNull("Devuelve nuevo Ticket", newticket);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldBuyTicketExist_ThrowExceptionTest() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        ProductoVO product = new ProductoVOBuilder()
                .build();
        productRepo.save(product);
        TicketVO ticket = new TicketVOBuilder().build();
        ticket.setProducto(product);
        ticket.setUsuario(user);
        TicketVO ticketYaExistente = ticketRepo.save(ticket);

        TicketVO newticket = tiendaService.Comprar_Producto(TicketMapper.toDTO(ticketYaExistente));

    }

    @Test
    @Transactional
    public void ShouldAddFavoritosNotExistTest() {

        FavoritosVO newfavoritos = tiendaService.Añadir_Favorito(buildFavoritosDto());

        Assert.assertNotNull("Devuelve nuevo Favorito", newfavoritos);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldAddFavoritosExist_ThrowExceptionTest() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        ProductoVO product = new ProductoVOBuilder()
                .build();
        productRepo.save(product);
        FavoritosVO favorito = new FavoritosVO(user, product);
        FavoritosVO favoritoYaExistente = favoritosRepo.save(favorito);

        FavoritosVO newfavorito = tiendaService.Añadir_Favorito(FavoritosMapper.toDTO(favoritoYaExistente));

    }



    private TicketDTO buildTicketDto() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        ProductoVO product = new ProductoVOBuilder()
                .build();
        productRepo.save(product);
        TicketVO ticket = new TicketVOBuilder().build();
        ticket.setProducto(product);
        ticket.setUsuario(user);
        return TicketMapper.toDTO(ticket);
    }

    private FavoritosDTO buildFavoritosDto() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        ProductoVO product = new ProductoVOBuilder()
                .build();
        productRepo.save(product);
        FavoritosVO favoritos = new FavoritosVO(user, product);
        return FavoritosMapper.toDTO(favoritos);
    }

}
