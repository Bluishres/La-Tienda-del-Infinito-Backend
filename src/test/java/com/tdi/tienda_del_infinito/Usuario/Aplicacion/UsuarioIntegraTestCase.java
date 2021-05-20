package com.tdi.tienda_del_infinito.Usuario.Aplicacion;

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
public class UsuarioIntegraTestCase {

    @Autowired
    UsuarioService userService;

    @Autowired
    UsuarioRepository userRepo;

    @Test
    @Transactional
    public void ShouldRegisterUsuarioNotExistTest() {

        UsuarioVO newuser = userService.Registro_De_Usuario(buildUsuarioDto());


        Assert.assertNotNull("Devuelve nuevo Cliente", newuser);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldRegisterUsuarioExist_ThrowExceptionTest() {


        UsuarioVO usuarioYaExistente = userRepo.save(new UsuarioVOBuilder().build());

        UsuarioVO newuser = userService.Registro_De_Usuario(UsuarioMapper.toDTO(usuarioYaExistente));

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldRemoveUsuarioNotExist_ThrowExceptionTest() {

        userService.Eliminar_Usuario(25);
    }

    @Test
    @Transactional
    public void ShouldRemoveUsuarioExistTest() {

        UsuarioVO usuarioYaExistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));


        Assert.assertEquals(true, userService.Eliminar_Usuario(usuarioYaExistente.getId()));

    }

    @Test
    @Transactional
    public void ShouldReturnUsuarioExistTest() {

        UsuarioVO Usuarioyaexistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        Optional<UsuarioVO> Usuariodevuelto = userService.ConsultarPerfilUsuario(Usuarioyaexistente.getId());

        Assert.assertNotNull(Usuariodevuelto);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldReturnUsuarioNotExist_ThrowExceptionTest() {


        UsuarioVO Usuarioyaexistente = new UsuarioVOBuilder().build();

        Optional<UsuarioVO> Usuariodevuelto = userService.ConsultarPerfilUsuario(Usuarioyaexistente.getId());

    }

    @Test
    @Transactional
    public void ShouldEditUsuarioExistTest() {

        UsuarioVO Usuariosineditar = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        Optional<UsuarioVO> Usuarioaeditar = userService.ConsultarPerfilUsuario(Usuariosineditar.getId());

        Usuarioaeditar.get().setNombre("Aaaaaaaa");

        UsuarioVO usuariodb = userService.Modificar_Usuario(UsuarioMapper.toDTO(Usuarioaeditar.get()));

        Assert.assertEquals(Usuarioaeditar.get(), usuariodb);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldEditUsuarioNotExist_ThrowExceptionTest() {


        UsuarioVO Usuariosineditar = new UsuarioVOBuilder().build();

        UsuarioVO Usuarioaeditar = Usuariosineditar;

        Usuarioaeditar.setNombre("Miguel");

        UsuarioVO usuariodb = userService.Modificar_Usuario(UsuarioMapper.toDTO(Usuarioaeditar));


    }


    private UsuarioDTO buildUsuarioDto() {
        return UsuarioMapper.toDTO(new UsuarioVOBuilder().build());
    }

}
