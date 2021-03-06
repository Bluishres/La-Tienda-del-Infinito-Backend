package com.tdi.tienda_del_infinito.Usuario.Infraestructura.Controller;

import com.tdi.tienda_del_infinito.Shared.Infraestructura.Controller.Constant.EndpointUrls;
import com.tdi.tienda_del_infinito.Usuario.Aplicacion.Service.UsuarioService;
import com.tdi.tienda_del_infinito.Usuario.Dominio.DTO.UsuarioDTO;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador de Usuario para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.Base + UsuarioRestController.USER_RESOURCE)
@AllArgsConstructor
public class UsuarioRestController {

    public static final String USER_RESOURCE = "/user";
    @Autowired
    private final UsuarioService userService;

    /**
     * Método que registra un usuario
     *
     * @param dto
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<UsuarioDTO> register(@RequestBody UsuarioDTO dto) {
        dto = UsuarioMapper.toDTO(userService.Registro_De_Usuario(dto));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Método que obtiene una lista de todos los usuarios
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping(EndpointUrls.GetAll)
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(userService.Consultar_Usuarios());
    }

    /**
     * Método que obtiene un usuario por su id
     *
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return userService.ConsultarPerfilUsuario(id)
                    .map(user -> UsuarioMapper.toDTO(user))
                    .map(userdto -> new ResponseEntity(userdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que obtiene un usuario por su nick
     *
     * @param nick
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping(EndpointUrls.GetByNick)
    public ResponseEntity getByNick(@PathVariable final String nick) {
        try {
            return userService.ConsultarPerfilUsuarioByNick(nick)
                    .map(user -> UsuarioMapper.toDTO(user))
                    .map(userdto -> new ResponseEntity(userdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que obtiene un usuario por su email
     *
     * @param email
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping(EndpointUrls.GetByEmail)
    public ResponseEntity getByEmail(@PathVariable final String email) {
        try {
            return userService.ConsultarPerfilUsuarioByEmail(email)
                    .map(user -> UsuarioMapper.toDTO(user))
                    .map(userdto -> new ResponseEntity(userdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que actualiza los datos de un usuario
     *
     * @param usuarioDTO
     * @return
     */
    @CrossOrigin(origins = "*")
    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity(userService.Modificar_Usuario(usuarioDTO), HttpStatus.CREATED);
    }

    /**
     * Método que elimina un usuario el cual se obtiene por su id
     *
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return userService.Eliminar_Usuario(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
