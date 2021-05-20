package com.tdi.tienda_del_infinito.Producto.Aplicacion;

import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.ProductoService;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.ProductoDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.ProductoMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.ProductoRepository;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Shared.Config.ConfigurationPersistenceTest;
import com.tdi.tienda_del_infinito.Shared.Err.EntityExist;
import com.tdi.tienda_del_infinito.Shared.Err.EntityNotExist;
import com.tdi.tienda_del_infinito.Usuario.Aplicacion.Service.UsuarioService;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Builder.UsuarioVOBuilder;
import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Repository.UsuarioRepository;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class})
public class ProductoIntegraTestCase {

    @Autowired
    ProductoService productService;

    @Autowired
    ProductoRepository productRepo;

    @Test
    @Transactional
    public void ShouldRegisterProductoNotExistTest() {

        ProductoVO newproducto = productService.Registro_De_Producto(buildProductoDto());


        Assert.assertNotNull("Devuelve nuevo Producto", newproducto);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldRegisterProductoExist_ThrowExceptionTest() {


        ProductoVO productoYaExistente = productRepo.save(new ProductoVOBuilder().build());

        ProductoVO newproducto = productService.Registro_De_Producto(ProductoMapper.toDTO(productoYaExistente));

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldRemoveProductoNotExist_ThrowExceptionTest() {

        productService.Eliminar_Producto(25);
    }

    @Test
    @Transactional
    public void ShouldRemoveProductoExistTest() {

        ProductoVO productoYaExistente = productService.Registro_De_Producto(ProductoMapper.toDTO(new ProductoVOBuilder().build()));


        Assert.assertEquals(true, productService.Eliminar_Producto(productoYaExistente.getId()));

    }

    @Test
    @Transactional
    public void ShouldReturnProductoExistTest() {

        ProductoVO productoYaExistente = productService.Registro_De_Producto(ProductoMapper.toDTO(new ProductoVOBuilder().build()));

        Optional<ProductoVO> Productodevuelto = productService.ConsultarProducto(productoYaExistente.getId());

        Assert.assertNotNull(Productodevuelto);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldReturnProductoNotExist_ThrowExceptionTest() {


        ProductoVO productoYaExistente = new ProductoVOBuilder().build();

        Optional<ProductoVO> Productodevuelto = productService.ConsultarProducto(productoYaExistente.getId());

    }

    @Test
    @Transactional
    public void ShouldEditProductoExistTest() {

        ProductoVO Productosineditar = productService.Registro_De_Producto(ProductoMapper.toDTO(new ProductoVOBuilder().build()));

        Optional<ProductoVO> Productoaeditar = productService.ConsultarProducto(Productosineditar.getId());

        Productoaeditar.get().setNombre("Aaaaaaaa");

        ProductoVO productodb = productService.Modificar_Producto(ProductoMapper.toDTO(Productoaeditar.get()));

        Assert.assertEquals(Productoaeditar.get(), productodb);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldEditProductoNotExist_ThrowExceptionTest() {


        ProductoVO Productosineditar = new ProductoVOBuilder().build();

        ProductoVO Productoaeditar = Productosineditar;

        Productoaeditar.setNombre("Miguel");

        ProductoVO productodb = productService.Modificar_Producto(ProductoMapper.toDTO(Productoaeditar));


    }

    private ProductoDTO buildProductoDto() {
        return ProductoMapper.toDTO(new ProductoVOBuilder().build());
    }


}
