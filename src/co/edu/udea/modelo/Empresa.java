package co.edu.udea.modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String direccion;
    private long telefono;
    private long nit;

    private List<Empleado> empleados;
    private List<Usuario> usuarios;

    public Empresa(String nombre, String direccion, long telefono, long nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    public Empresa() {
        this.empleados = new ArrayList<Empleado>();
        this.usuarios = new ArrayList<Usuario>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Empleado buscarEmpleado(String nombre){
        Empleado empleado = new Empleado();
        for (Empleado empleadoEncontrado:empleados) {
            if (empleados.contains(empleado.getNombre().equals(nombre))){
                empleado = empleadoEncontrado;
            }
        }
        return empleado;
    }
    public Usuario buscarUsuario( String nombre){
        Usuario usuario = new Usuario();
        for (Usuario usuarioEncontrado:usuarios) {
            if (usuarios.contains(usuario.getNombre().equals(nombre))){
                usuario = usuarioEncontrado;
            }
        }
        return usuario;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", nit=" + nit +
                ", empleados=" + empleados +
                ", usuarios=" + usuarios +
                '}';
    }
}
