package com.tdi.tienda_del_infinito.Hilo.Aplicacion;

import com.tdi.tienda_del_infinito.Hilo.Aplicacion.Service.HiloService;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Builder.HiloVOBuilder;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Builder.MensajeVOBuilder;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.HiloDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.MensajeDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.HiloMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.MensajeMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Repository.HiloRepository;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Repository.MensajeRepository;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.MensajeVO;
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

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class})
public class HiloIntegraUnitTestCase {

    @Autowired
    HiloService hiloService;

    @Autowired
    HiloRepository hiloRepo;

    @Autowired
    MensajeRepository mensajeRepo;

    @Autowired
    UsuarioRepository userRepo;

    @Test
    @Transactional
    public void ShouldCreateHiloNotExistTest() {

        HiloVO newhilo = hiloService.CrearHilo(buildHiloDto());

        Assert.assertNotNull("Devuelve nuevo hilo", newhilo);

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

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldRemoveHiloNotExist_ThrowExceptionTest() {

        hiloService.Eliminar_hilo(25);
    }

    @Test
    @Transactional
    public void ShouldRemoveHiloExistTest() {

        HiloVO hiloYaExistente = hiloService.CrearHilo(buildHiloDto());


        Assert.assertEquals(true, hiloService.Eliminar_hilo(hiloYaExistente.getId()));

    }

    @Test
    @Transactional
    public void ShouldReturnHiloExistTest() {

        HiloVO hiloYaExistente = hiloService.CrearHilo(buildHiloDto());

        Optional<HiloVO> hilodevuelto = hiloService.Consultar_hilo(hiloYaExistente.getId());

        Assert.assertNotNull(hilodevuelto);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldReturnHiloNotExist_ThrowExceptionTest() {


        HiloVO hiloYaExistente = new HiloVOBuilder().build();

        Optional<HiloVO> hilodevuelto = hiloService.Consultar_hilo(hiloYaExistente.getId());

    }

    @Test
    @Transactional
    public void ShouldCreateMensajeNotExistTest() {

        MensajeVO newmensaje = hiloService.EnviarMensaje(buildMensajeDto());

        Assert.assertNotNull("Devuelve nuevo Mensaje", newmensaje);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldCreateMensajeExist_ThrowExceptionTest() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        HiloVO hilo = new HiloVOBuilder().build();
        hilo.setCreador(user);
        hiloRepo.save(hilo);
        MensajeVO mensaje = new MensajeVOBuilder().build();
        mensaje.setHilo(hilo);
        mensaje.setAutor(user);
        MensajeVO mensajeYaExistente = mensajeRepo.save(mensaje);

        MensajeVO newmensaje = hiloService.EnviarMensaje(MensajeMapper.toDTO(mensajeYaExistente));

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldRemoveMensajeNotExist_ThrowExceptionTest() {

        hiloService.Eliminar_mensaje(25);
    }

    @Test
    @Transactional
    public void ShouldRemoveMensajeExistTest() {

        MensajeVO mensajeYaExistente = hiloService.EnviarMensaje(buildMensajeDto());


        Assert.assertEquals(true, hiloService.Eliminar_mensaje(mensajeYaExistente.getId()));

    }


    private HiloDTO buildHiloDto() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        HiloVO hilo = new HiloVOBuilder().build();
        hilo.setCreador(user);
        return HiloMapper.toDTO(hilo);
    }

    private MensajeDTO buildMensajeDto() {
        UsuarioVO user = new UsuarioVOBuilder()
                .build();
        userRepo.save(user);
        HiloVO hilo = new HiloVOBuilder().build();
        hilo.setCreador(user);
        hiloRepo.save(hilo);
        MensajeVO mensaje = new MensajeVOBuilder().build();
        mensaje.setHilo(hilo);
        mensaje.setAutor(user);
        return MensajeMapper.toDTO(mensaje);
    }


}
