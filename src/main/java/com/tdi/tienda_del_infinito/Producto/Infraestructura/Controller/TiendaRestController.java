package com.tdi.tienda_del_infinito.Producto.Infraestructura.Controller;

import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.ProductoService;
import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.TiendaService;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.FavoritosDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.TicketDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.FavoritosMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.ProductoMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.TicketMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Shared.Infraestructura.Controller.Constant.EndpointUrls;
import com.tdi.tienda_del_infinito.Usuario.Aplicacion.Service.UsuarioService;
import com.tdi.tienda_del_infinito.Usuario.Dominio.Mapper.UsuarioMapper;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Clase controlador de Producto para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.Base + TiendaRestController.Shop_RESOURCE)
@AllArgsConstructor
public class TiendaRestController {

    public static final String Shop_RESOURCE = "/shop";
    @Autowired
    private final TiendaService tiendaService;
    @Autowired
    private final ProductoService productService;
    @Autowired
    private final UsuarioService userService;

    /**
     * @param Fecha
     * @param Importe
     * @param Unidades
     * @param Id_Usuario
     * @param Id_Producto
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buy", method = POST)
    public ResponseEntity<TicketDTO> comprar(@RequestParam String Fecha, @RequestParam Double Importe, @RequestParam int Unidades, @RequestParam int Id_Usuario, @RequestParam int Id_Producto) {
        Optional<UsuarioVO> uservo = userService.ConsultarPerfilUsuario(Id_Usuario);
        Optional<ProductoVO> productvo = productService.ConsultarProducto(Id_Producto);
        if (uservo != null || productvo != null) {
            TicketDTO dto = new TicketDTO(Fecha, Importe, Unidades, UsuarioMapper.toDTO(uservo.get()), ProductoMapper.toDTO(productvo.get()));
            dto = TicketMapper.toDTO(tiendaService.Comprar_Producto(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buy", method = GET)
    public ResponseEntity<List<TicketDTO>> ticketsAll() {
        return ResponseEntity.ok(tiendaService.Consultar_tickets());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buy/{user}", method = GET)
    public ResponseEntity<List<TicketDTO>> ticketsAllbyuser(@RequestParam int Id_Usuario) {
        return ResponseEntity.ok(tiendaService.Consultar_ticketsbyUser(Id_Usuario));
    }

    /**
     * Método que elimina un ticket el cual se obtiene por su id
     *
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return tiendaService.Eliminar_Ticket(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    /**
     * @param id_Usuario
     * @param id_Producto
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/fav", method = POST)
    public ResponseEntity<FavoritosDTO> favorito(@RequestParam int id_Usuario, @RequestParam int id_Producto) {
        Optional<UsuarioVO> uservo = userService.ConsultarPerfilUsuario(id_Usuario);
        Optional<ProductoVO> productvo = productService.ConsultarProducto(id_Producto);
        if (uservo != null || productvo != null) {
            FavoritosDTO dto = new FavoritosDTO(UsuarioMapper.toDTO(uservo.get()), ProductoMapper.toDTO(productvo.get()));
            dto = FavoritosMapper.toDTO(tiendaService.Añadir_Favorito(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/fav", method = GET)
    public ResponseEntity<List<FavoritosDTO>> favoritosAll() {
        return ResponseEntity.ok(tiendaService.Consultar_favoritos());
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/fav/{user}", method = GET)
    public ResponseEntity<List<FavoritosDTO>> favoritosAllbyuser(@RequestParam Integer Id_Usuario) {
        return ResponseEntity.ok(tiendaService.Consultar_favoritosbyUser(Id_Usuario));
    }


}
