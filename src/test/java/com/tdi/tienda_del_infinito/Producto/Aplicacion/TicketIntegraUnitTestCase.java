package com.tdi.tienda_del_infinito.Producto.Aplicacion;

import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.ProductoService;
import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.TiendaService;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.TicketVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.ProductoDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.ProductoMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.TicketMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.ProductoRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.TicketRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Shared.Config.ConfigurationPersistenceTest;
import com.tdi.tienda_del_infinito.Shared.Err.EntityExist;
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
public class TicketIntegraUnitTestCase {

    @Autowired
    TiendaService tiendaService;

    @Autowired
    TicketRepository ticketRepo;

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

}
