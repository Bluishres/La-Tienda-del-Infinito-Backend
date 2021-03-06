package com.tdi.tienda_del_infinito.Producto.Dominio.Builder;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@With
public class ProductoVOBuilder {
    private String Nombre;
    private String Precio;
    private int Stock_disponible;
    private String Fecha_creacion;
    private String descripcion;
    private String imagen;

    public ProductoVO build() {
        ObjectMother om = ObjectMother.getInstance();
        ProductoVO mother = om.bear("ProductoVO", ProductoVO.class);

        return new ProductoVO(
                Nombre != null ? Nombre : mother.getNombre(),
                Precio != null ? Precio : mother.getPrecio(),
                Stock_disponible != 0 ? Stock_disponible : mother.getStock_disponible(),
                Fecha_creacion != null ? Fecha_creacion : mother.getFecha_creacion(),
                descripcion != null ? descripcion : mother.getDescripcion(),
                imagen = "https://i.blogs.es/8e8f64/lo-de-que-comprar-una-casa-es-la-mejor-inversion-hay-generaciones-que-ya-no-lo-ven-ni-de-lejos---1/450_1000.jpg"
        );


    }


}
