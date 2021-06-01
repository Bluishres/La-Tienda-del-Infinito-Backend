package com.tdi.tienda_del_infinito.Usuario.Dominio.Builder;

import com.tdi.tienda_del_infinito.Usuario.Dominio.VO.UsuarioVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;


@AllArgsConstructor
@NoArgsConstructor
@With
public class UsuarioVOBuilder {
    private String Nick;
    private String Password;
    private String Email;
    private String Nombre;
    private String Apellidos;
    private String Nacionalidad;
    private String Fecha_Nacimiento;
    private String Direccion;
    private boolean isAdmin;
    private String Foto_Perfil;

    public UsuarioVO build() {
        ObjectMother om = ObjectMother.getInstance();
        UsuarioVO mother = om.bear("UsuarioVO", UsuarioVO.class);

        return new UsuarioVO(
                Nick != null ? Nick : mother.getNick(),
                Password != null ? Password : mother.getPassword(),
                Email != null ? Email : mother.getEmail(),
                Nombre != null ? Nombre : mother.getNombre(),
                Apellidos != null ? Apellidos : mother.getApellidos(),
                Nacionalidad != null ? Nacionalidad : mother.getNacionalidad(),
                Fecha_Nacimiento != null ? Fecha_Nacimiento : mother.getFecha_Nacimiento(),
                Direccion != null ? Direccion : mother.getDireccion(),
                isAdmin = false,
                Foto_Perfil != null ? Foto_Perfil : mother.getFoto_Perfil()
        );
    }


}
