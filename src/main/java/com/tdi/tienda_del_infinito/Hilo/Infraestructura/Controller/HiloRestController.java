package com.tdi.tienda_del_infinito.Hilo.Infraestructura.Controller;

import com.tdi.tienda_del_infinito.Hilo.Aplicacion.Service.HiloService;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.HiloDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.DTO.MensajeDTO;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.HiloMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.Mapper.MensajeMapper;
import com.tdi.tienda_del_infinito.Hilo.Dominio.VO.HiloVO;
import com.tdi.tienda_del_infinito.Shared.Infraestructura.Controller.Constant.EndpointUrls;
import com.tdi.tienda_del_infinito.Usuario.Aplicacion.Service.UsuarioService;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Clase controlador de Producto para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.Base + HiloRestController.Foro_RESOURCE)
@AllArgsConstructor
public class HiloRestController {

    public static final String Foro_RESOURCE = "/foro";

    @Autowired
    private final HiloService hiloService;

    @Autowired
    private final UsuarioService userService;

    @Transactional
    @RequestMapping(value = "/hilo", method = POST)
    public ResponseEntity<HiloDTO> crearHilo(@RequestParam int Id_Creador, @RequestParam String Titulo, @RequestParam String Fecha, @RequestBody String mensaje) {
        Optional<UsuarioVO> uservo = userService.ConsultarPerfilUsuario(Id_Creador);
        if (uservo != null) {
            HiloDTO dto = new HiloDTO(UsuarioMapper.toDTO(uservo.get()), Titulo, Fecha);
            dto = HiloMapper.toDTO(hiloService.CrearHilo(dto));
            uservo = userService.ConsultarPerfilUsuario(Id_Creador);
            Optional<HiloVO> hilovo = hiloService.Consultar_hilo(dto.getId());
            if (uservo != null || hilovo != null) {
                MensajeDTO msgdto = new MensajeDTO(UsuarioMapper.toDTO(uservo.get()), Fecha, HiloMapper.toDTO(hilovo.get()), mensaje);
                msgdto = MensajeMapper.toDTO(hiloService.EnviarMensaje(msgdto));
                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/hilo", method = GET)
    public ResponseEntity<List<HiloDTO>> getAllhilos() {
        return ResponseEntity.ok(hiloService.Consultar_hilos());
    }

    @Transactional
    @RequestMapping(value = "/hilo/get", method = GET)
    public ResponseEntity<HiloDTO> getById(@RequestParam int id) {
        Optional<HiloVO> hilovo = hiloService.Consultar_hilo(id);
        if (hilovo != null) {
            return new ResponseEntity<>(HiloMapper.toDTO(hilovo.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/hilo")
    public ResponseEntity<Boolean> deleteHilo(@PathVariable final int id) {
        return hiloService.Eliminar_hilo(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Transactional
    @RequestMapping(value = "/hilo/mensaje", method = POST)
    public ResponseEntity<MensajeDTO> enviarMensaje(@RequestParam int Id_Creador, @RequestParam String Fecha, @RequestParam int Id_Hilo, @RequestBody String mensaje) {
        Optional<UsuarioVO> uservo = userService.ConsultarPerfilUsuario(Id_Creador);
        Optional<HiloVO> hilovo = hiloService.Consultar_hilo(Id_Hilo);
        if (uservo != null || hilovo != null) {
            MensajeDTO dto = new MensajeDTO(UsuarioMapper.toDTO(uservo.get()), Fecha, HiloMapper.toDTO(hilovo.get()), mensaje);
            dto = MensajeMapper.toDTO(hiloService.EnviarMensaje(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/hilo/mensajes", method = GET)
    public ResponseEntity<List<MensajeDTO>> getAllmensajesbyhilo(@RequestParam int Id_Hilo) {
        return ResponseEntity.ok(hiloService.getMensajesbyHilo(Id_Hilo));
    }


    @DeleteMapping(value = "/hilo/mensaje")
    public ResponseEntity<Boolean> deleteMensaje(@PathVariable final int id) {
        return hiloService.Eliminar_mensaje(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


}
