package com.tdi.tienda_del_infinito.Hilo.Aplicacion;

import com.tdi.tienda_del_infinito.Hilo.Aplicacion.Service.HiloService;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Builder.HiloVOBuilder;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.HiloDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.HiloMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Repository.HiloRepository;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.ProductoService;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.ProductoVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.Builder.TicketVOBuilder;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.TicketMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.ProductoRepository;
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
public class HiloIntegraUnitTestCase {

    @Autowired
    HiloService hiloService;

    @Autowired
    HiloRepository hiloRepo;

    @Autowired
    UsuarioRepository userRepo;

    @Test
    @Transactional
    public void ShouldCreateHiloNotExistTest() {

        HiloVO newhilo = hiloService.CrearHilo(buildHiloDto());

        Assert.assertNotNull("Devuelve nuevo Ticket", newhilo);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldCreateHiloExist_ThrowExceptionTest() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        HiloVO hilo = new HiloVOBuilder().build();
        hilo.setCreador(user);
        HiloVO hiloYaExistente = hiloRepo.save(hilo);

        HiloVO newhilo = hiloService.CrearHilo(HiloMapper.toDTO(hiloYaExistente));

    }


    private HiloDTO buildHiloDto() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        HiloVO hilo = new HiloVOBuilder().build();
        hilo.setCreador(user);
        return HiloMapper.toDTO(hilo);
    }


}
