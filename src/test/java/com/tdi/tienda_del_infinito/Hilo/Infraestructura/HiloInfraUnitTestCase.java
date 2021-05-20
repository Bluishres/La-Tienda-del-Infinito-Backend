package com.tdi.tienda_del_infinito.Hilo.Infraestructura;

import com.tdi.tienda_del_infinito.Hilo.Dominio.Builder.HiloVOBuilder;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
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
public class HiloInfraUnitTestCase extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewHiloTest() {
        //Arrange
        HiloVO hilo = createAndSaveNewHilo();

        //Assert
        HiloVO hiloBd = em.find(HiloVO.class, hilo.getId());
        Assert.assertEquals(hilo, hiloBd);
    }

    @Test
    @Transactional
    public void ShouldEditHiloTest() {
        //Arrange
        HiloVO hilo = createAndSaveNewHilo();
        HiloVO hiloEdit = em.find(HiloVO.class, hilo.getId());
        hiloEdit.setTitulo("HILO 1");

        //Act
        em.persist(hiloEdit);
        em.flush();
        em.clear();

        //Assert
        hiloEdit = em.find(HiloVO.class, hilo.getId());
        Assert.assertEquals(hiloEdit.getId(), hilo.getId());
    }

    @Test
    @Transactional
    public void ShouldRemoveHiloTest() {
        //Arrange
        HiloVO hiloDelete = em.find(HiloVO.class, createAndSaveNewHilo().getId());

        //Act
        em.remove(hiloDelete);
        em.flush();
        em.clear();
        HiloVO hiloBd = em.find(HiloVO.class, hiloDelete.getId());

        //Assert
        Assert.assertNull(hiloBd);
    }

    private HiloVO createAndSaveNewHilo() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        em.persist(user);
        HiloVO hilo = new HiloVOBuilder()
                .build();
        hilo.setCreador(user);
        em.persist(hilo);
        return hilo;
    }

}
