package com.tdi.tienda_del_infinito.Hilo.Infraestructura;

import com.tdi.tienda_del_infinito.Hilo.Dominio.Builder.HiloVOBuilder;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Builder.MensajeVOBuilder;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
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
public class MensajeInfraUnitTestCase extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewMensajeTest() {
        //Arrange
        MensajeVO mensaje = createAndSaveNewMensaje();

        //Assert
        MensajeVO mensajeBd = em.find(MensajeVO.class, mensaje.getId());
        Assert.assertEquals(mensaje, mensajeBd);
    }

    @Test
    @Transactional
    public void ShouldEditMensajeTest() {
        //Arrange
        MensajeVO mensaje = createAndSaveNewMensaje();
        MensajeVO mensajeEdit = em.find(MensajeVO.class, mensaje.getId());
        mensajeEdit.setMensaje("mensaje");

        //Act
        em.persist(mensajeEdit);
        em.flush();
        em.clear();

        //Assert
        mensajeEdit = em.find(MensajeVO.class, mensaje.getId());
        Assert.assertEquals(mensajeEdit.getId(), mensaje.getId());
    }

    @Test
    @Transactional
    public void ShouldRemoveMensajeTest() {
        //Arrange
        MensajeVO mensajeDelete = em.find(MensajeVO.class, createAndSaveNewMensaje().getId());

        //Act
        em.remove(mensajeDelete);
        em.flush();
        em.clear();
        MensajeVO mensajeBd = em.find(MensajeVO.class, mensajeDelete.getId());

        //Assert
        Assert.assertNull(mensajeBd);
    }

    private MensajeVO createAndSaveNewMensaje() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        em.persist(user);
        HiloVO hilo = new HiloVOBuilder()
                .build();
        hilo.setCreador(user);
        em.persist(hilo);
        MensajeVO mensaje = new MensajeVOBuilder()
                .build();
        mensaje.setHilo(hilo);
        mensaje.setAutor(user);
        em.persist(mensaje);
        return mensaje;
    }


}
