package com.tdi.tienda_del_infinito.Usuario.Infraestructura.Persistence;

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
public class UsuarioInfraUnitTestCase extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewUserTest() {
        //Arrange
        UsuarioVO user = createAndSaveNewUser();

        //Assert
        UsuarioVO userBd = em.find(UsuarioVO.class, user.getId());
        Assert.assertEquals(user, userBd);
    }

    @Test
    @Transactional
    public void ShouldEditUserTest() {
        //Arrange
        UsuarioVO user = createAndSaveNewUser();
        UsuarioVO userEdit = em.find(UsuarioVO.class, user.getId());
        userEdit.setNombre("Miguel");

        //Act
        em.persist(userEdit);
        em.flush();
        em.clear();

        //Assert
        userEdit = em.find(UsuarioVO.class, user.getId());
        Assert.assertEquals(userEdit.getId(), user.getId());
    }

    @Test
    @Transactional
    public void ShouldRemoveUser() {
        //Arrange
        UsuarioVO userDelete = em.find(UsuarioVO.class, createAndSaveNewUser().getId());

        //Act
        em.remove(userDelete);
        em.flush();
        em.clear();
        UsuarioVO userBd = em.find(UsuarioVO.class, userDelete.getId());

        //Assert
        Assert.assertNull(userBd);
    }

    private UsuarioVO createAndSaveNewUser() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        em.persist(user);
        return user;
    }

}
