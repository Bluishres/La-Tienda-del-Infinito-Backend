package com.tdi.tienda_del_infinito.Producto.Infraestructura;

import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Shared.Config.ConfigurationPersistenceTest;
import com.tdi.tienda_del_infinito.Shared.UnitTestCase;
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
public class ProductoInfraUnitTestCase extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewProductTest() {
        //Arrange
        ProductoVO product = createAndSaveNewProduct();

        //Assert
        ProductoVO productBd = em.find(ProductoVO.class, product.getId());
        Assert.assertEquals(product, productBd);
    }

    @Test
    @Transactional
    public void ShouldEditUserTest() {
        //Arrange
        ProductoVO product = createAndSaveNewProduct();
        ProductoVO productEdit = em.find(ProductoVO.class, product.getId());
        productEdit.setNombre("Miguel");

        //Act
        em.persist(productEdit);
        em.flush();
        em.clear();

        //Assert
        productEdit = em.find(ProductoVO.class, product.getId());
        Assert.assertEquals(productEdit.getId(), product.getId());
    }

    @Test
    @Transactional
    public void ShouldRemoveUser() {
        //Arrange
        ProductoVO productDelete = em.find(ProductoVO.class, createAndSaveNewProduct().getId());

        //Act
        em.remove(productDelete);
        em.flush();
        em.clear();
        ProductoVO productBd = em.find(ProductoVO.class, productDelete.getId());

        //Assert
        Assert.assertNull(productBd);
    }


    private ProductoVO createAndSaveNewProduct() {
        ProductoVO product = new ProductoVOBuilder()
                .build();
        em.persist(product);
        return product;
    }

}
