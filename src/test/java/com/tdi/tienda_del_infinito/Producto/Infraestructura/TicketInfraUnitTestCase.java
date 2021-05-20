package com.tdi.tienda_del_infinito.Producto.Infraestructura;

import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.TicketVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.TicketVO;
import com.tdi.tienda_del_infinito.Shared.Config.ConfigurationPersistenceTest;
import com.tdi.tienda_del_infinito.Shared.UnitTestCase;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Builder.UsuarioVOBuilder;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class})
public class TicketInfraUnitTestCase extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewTicketTest() {
        //Arrange
        TicketVO ticket = createAndSaveNewTicket();

        //Assert
        TicketVO ticketBd = em.find(TicketVO.class, ticket.getId());
        Assert.assertEquals(ticket, ticketBd);
    }

    @Test
    @Transactional
    public void ShouldEditTicketTest() {
        //Arrange
        TicketVO ticket = createAndSaveNewTicket();
        TicketVO ticketEdit = em.find(TicketVO.class, ticket.getId());
        ticketEdit.setUnidades(2);

        //Act
        em.persist(ticketEdit);
        em.flush();
        em.clear();

        //Assert
        ticketEdit = em.find(TicketVO.class, ticket.getId());
        Assert.assertEquals(ticketEdit.getId(), ticket.getId());
    }

    @Test
    @Transactional
    public void ShouldRemoveTicketTest() {
        //Arrange
        TicketVO ticketDelete = em.find(TicketVO.class, createAndSaveNewTicket().getId());

        //Act
        em.remove(ticketDelete);
        em.flush();
        em.clear();
        TicketVO ticketBd = em.find(TicketVO.class, ticketDelete.getId());

        //Assert
        Assert.assertNull(ticketBd);
    }

    private TicketVO createAndSaveNewTicket() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        em.persist(user);
        ProductoVO product = new ProductoVOBuilder()
                .build();
        em.persist(product);
        TicketVO ticket = new TicketVOBuilder()
                .build();
        ticket.setProducto(product);
        ticket.setUsuario(user);
        em.persist(ticket);
        return ticket;
    }

}
