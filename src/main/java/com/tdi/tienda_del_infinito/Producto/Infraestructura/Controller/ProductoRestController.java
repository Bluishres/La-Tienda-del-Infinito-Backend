package com.tdi.tienda_del_infinito.Producto.Infraestructura.Controller;

import com.tdi.tienda_del_infinito.Producto.Aplicacion.Service.ProductoService;
import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.ProductoDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.ProductoMapper;
import com.tdi.tienda_del_infinito.Shared.Infraestructura.Controller.Constant.EndpointUrls;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador de Producto para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.Base + com.tdi.tienda_del_infinito.Producto.Infraestructura.Controller.ProductoRestController.Product_RESOURCE)
@AllArgsConstructor
public class ProductoRestController {

    @Autowired
    private final ProductoService productService;

    public static final String Product_RESOURCE = "/product";

    /**
     * Método que registra un producto
     *
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<ProductoDTO> register(@RequestBody ProductoDTO dto) {
        dto = ProductoMapper.toDTO(productService.Registro_De_Producto(dto));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Método que obtiene una lista de todos los usuarios
     *
     * @return
     */
    @GetMapping(EndpointUrls.GetAll)
    public ResponseEntity<List<ProductoDTO>> getAll() {
        return ResponseEntity.ok(productService.Consultar_Productos());
    }

    /**
     * Método que obtiene un producto por su id
     *
     * @param id
     * @return
     */
    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return productService.ConsultarProducto(id)
                    .map(product -> ProductoMapper.toDTO(product))
                    .map(productdto -> new ResponseEntity(productdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que actualiza los datos de un producto
     *
     * @param ProductoDTO
     * @return
     */
    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<ProductoDTO> update(@RequestBody ProductoDTO ProductoDTO) {
        return new ResponseEntity(productService.Modificar_Producto(ProductoDTO), HttpStatus.CREATED);
    }

    /**
     * Método que elimina un producto el cual se obtiene por su id
     *
     * @param id
     * @return
     */
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return productService.Eliminar_Producto(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
