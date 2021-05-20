package com.tdi.tienda_del_infinito.Producto.Dominio.Builder;

import com.tdi.tienda_del_infinito.Producto.Dominio.VO.ProductoVO;

public class ProductoVOMother {
    public static ProductoVO general() {
        return new ProductoVOBuilder().build();
    }
}
