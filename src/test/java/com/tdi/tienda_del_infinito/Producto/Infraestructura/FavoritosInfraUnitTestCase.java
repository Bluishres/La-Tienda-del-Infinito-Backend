package com.tdi.tienda_del_infinito.Producto.Infraestructura;

import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.FavoritosVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
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
public class FavoritosInfraUnitTestCase extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewFavoritosTest() {
        //Arrange
        FavoritosVO favoritos = createAndSaveNewFavoritos();

        //Assert
        FavoritosVO favoritosBd = em.find(FavoritosVO.class, favoritos.getId());
        Assert.assertEquals(favoritos, favoritosBd);
    }

    @Test
    @Transactional
    public void ShouldRemoveFavoritosTest() {
        //Arrange
        FavoritosVO favoritosDelete = em.find(FavoritosVO.class, createAndSaveNewFavoritos().getId());

        //Act
        em.remove(favoritosDelete);
        em.flush();
        em.clear();
        FavoritosVO favoritosBd = em.find(FavoritosVO.class, favoritosDelete.getId());

        //Assert
        Assert.assertNull(favoritosBd);
    }

    private FavoritosVO createAndSaveNewFavoritos() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        em.persist(user);
        ProductoVO product = new ProductoVOBuilder()
                .build();
        em.persist(product);
        FavoritosVO favoritos = new FavoritosVO(user, product);
        em.persist(favoritos);
        return favoritos;
    }

}
