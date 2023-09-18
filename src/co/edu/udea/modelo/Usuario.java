package co.edu.udea.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<MovimientoDinero>movimientos;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario() {
        this.movimientos = new ArrayList<MovimientoDinero>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<MovimientoDinero> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }

    public MovimientoDinero buscarMovimiento( String concepto){
        MovimientoDinero movimientoDinero = new MovimientoDinero();
        for (MovimientoDinero movimientoEncontrado:movimientos) {
            if (movimientos.contains(movimientoDinero.getConceptoMovimiento().equals(concepto))){
                movimientoDinero = movimientoEncontrado;
            }
        }
        return movimientoDinero;
    }
}
