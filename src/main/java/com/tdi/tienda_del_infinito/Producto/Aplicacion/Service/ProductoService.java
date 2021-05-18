package com.tdi.tienda_del_infinito.Producto.Aplicacion.Service;

import com.tdi.tienda_del_infinito.Producto.Dominio.DTO.ProductoDTO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Mapper.ProductoMapper;
import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import com.tdi.tienda_del_infinito.Producto.Dominio.Repository.ProductoRepository;
import com.tdi.tienda_del_infinito.Shared.Err.EntityExist;
import com.tdi.tienda_del_infinito.Shared.Err.EntityNotExist;
import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Casos de uso de la entidad producto
 */
@Service
public class ProductoService {

    /**
     * productoRepo tipo productoRepository
     */
    @Autowired
    ProductoRepository productoRepo;

    /**
     * Método para dar de alta un nuevo producto. Tambien se convierte un productodto a ProductoVO
     *
     * @param productodto
     * @return productoRepo.save(producto)
     */
    @Transactional
    public ProductoVO Registro_De_Producto(ProductoDTO productodto) {

        Optional<ProductoVO> nbd = productoRepo.findById(productodto.getId());
        if (nbd.isPresent())
            throw new EntityExist(ProductoVO.class.toString(), productodto.getId());

        ProductoVO producto = ProductoMapper.fromDTO(productodto);
        return productoRepo.save(producto);
    }

    /**
     * Método para devolver la lista de productos.
     *
     * @return ArrayList<ProductoVO>
     */
    @Transactional
    public ArrayList<ProductoDTO> Consultar_Productos() {
        List<ProductoVO> nbd = productoRepo.findAll();
        ArrayList<ProductoDTO> nbdA = new ArrayList<>();
        for (int i = 0; i < nbd.size(); i++) {
            ProductoDTO producto = ProductoMapper.toDTO(nbd.get(i));
            nbdA.add(producto);
        }
        return nbdA;
    }

    /**
     * Método para consultar un producto en función a la id que se le pase
     *
     * @param id
     * @return productoRepo.findOne(id)
     */
    public Optional<ProductoVO> ConsultarProducto(int id) {
        Optional<ProductoVO> nbd = productoRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), id);
        }
        return nbd;
    }

    /**
     * Método para modificar un producto en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un productodto a ProductoVO
     *
     * @param productodto
     */
    @Transactional
    public ProductoVO Modificar_Producto(ProductoDTO productodto) {
        Optional<ProductoVO> nbd = productoRepo.findById(productodto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(ProductoVO.class.toString(), productodto.getId());
        }
        ProductoVO udpusuario = ProductoMapper.fromDTO(productodto);
        return productoRepo.save(udpusuario);
    }

    /**
     * Método para eliminar un producto
     *
     * @param id
     */
    @Transactional
    public boolean Eliminar_Producto(int id) {
        Optional<ProductoVO> nbd = productoRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(ProductoVO.class.toString(), id);
        }
        productoRepo.deleteById(id);
        return true;
    }
    
}
