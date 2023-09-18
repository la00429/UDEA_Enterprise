package co.edu.udea.presentador;

import co.edu.udea.modelo.*;
import co.edu.udea.vista.Vista;

public class Presentador {

    private final String MENU = "1.Acceder a información de la empresa.\n" + "2.Acceder a información de empleados.\n" + "3.Acceder a movimientos de usuarios.\n" + "0.Salir.\n";
    private final String MENU_INTERNO = "1. Leer\n" + "2. Modificar\n" + "0.Volver.";
    private final String MENU_EMPRESA = "1.Crear empresa.\n" + "2.Leer y modificar el nombre de la empresa.\n" + "3.Leer y modificar la dirección de la empresa.\n" + "4.Leer y modificar el telefono de la empresa.\n" + "5.Leer y modificar el NIT de la empresa.\n" + "0.Volver a menu principal.\n";
    private final String MENU_EMPLEADO = "1.Crear empleado.\n" + "2.Leer y modificar el nombre del empleado.\n" + "3.Leer y modificar el correo del empleado.\n" + "4.Leer y modificar la empresa a la que pertenece un empleado.\n" + "5.Leer y modificar el rol de un empleado.\n" + "0.Volver a menu principal.\n";
    private final String MENU_MOVIMIENTO = "1.Crear movimiento.\n" + "2.Leer y modificar un monto de un movimiento.\n" + "3.Leer y modificar el concepto de un movimiento.\n" + "4.Leer y modificar el usuario que fue encargado de registrar el movimiento.\n" + "0.Volver a menu principal.\n";
    private Vista vista;
    private Empresa empresa;

    public Presentador() {
        this.vista = new Vista();
    }

    private int mostrarMenu(String menu) {
        int option = Integer.parseInt(vista.ingresoDatos(menu + "\n" + "Por favor, ingresa una opción:\n"));
        return option;
    }

    public void run() {
        int option = mostrarMenu(MENU);
        switch (option) {
            case 1:
                empresaInfo();
                break;
            case 2:
                empleadoInfo();
                break;
            case 3:
                movimientoInfo();
                break;
            case 0:
                System.exit(0);
                break;
        }
        do {
            run();
        } while (option != 4);
    }

    private void empresaInfo() {
        int option = mostrarMenu(MENU_EMPRESA);
        switch (option) {
            case 1:
                crearEmpresa();
                break;
            case 2:
                nombreEmpresa();
                break;
            case 3:
                direcionEmpresa();
                break;
            case 4:
                telefonoEmpresa();
                break;
            case 5:
                nitEmpresa();
                break;
            case 0:
                run();
                break;
        }
        do {
            empleadoInfo();
        } while (option != 6);

    }

    private void crearEmpresa() {
        String nombre = vista.ingresoDatos("Por favor ingresa un nombre para tu empresa.");
        String direccion = vista.ingresoDatos("Por favor ingresa una dirección para tu empresa.");
        Long telefono = Long.parseLong(vista.ingresoDatos("Por favor ingresa un numero de telefono de tu empresa."));
        Long nit = Long.parseLong(vista.ingresoDatos("Por favor ingresa el NIT de tu empresa."));
        Empresa empresa = new Empresa(nombre, direccion, telefono, nit);
        vista.mostrarMensaje("Esta es la empresa que creaste." + empresa.toString());

    }

    private void nombreEmpresa() {
        int option = mostrarMenu(MENU_INTERNO);
        switch (option) {
            case 1:
                vista.mostrarMensaje("Este el nombre de la empresa: " + empresa.getNombre());
                break;
            case 2:
                vista.mostrarMensaje("Esta opción te permite cambiar el nombre de la empresa: " + empresa.getNombre());
                empresa.setNombre(vista.ingresoDatos("Por favor ingresa un nuevo nombre para tu empresa."));
                vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.getNombre());
                break;
            case 0:
                empresaInfo();
                break;
        }
        do {
            nombreEmpresa();
        } while (option != 3);
    }

    private void direcionEmpresa() {
        int option = mostrarMenu(MENU_INTERNO);
        switch (option) {
            case 1:
                vista.mostrarMensaje("Esta la dirección  de la empresa: " + empresa.getDireccion());
                break;
            case 2:
                vista.mostrarMensaje("Esta opción te permite cambiar la dirección de la empresa: " + empresa.getDireccion());
                empresa.setDireccion(vista.ingresoDatos("Por favor ingresa una nueva dirección para tu empresa."));
                vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.getDireccion());
                break;
            case 0:
                empresaInfo();
                break;
        }
        do {
            direcionEmpresa();
        } while (option != 3);

    }

    private void telefonoEmpresa() {
        int option = mostrarMenu(MENU_INTERNO);
        switch (option) {
            case 1:
                vista.mostrarMensaje("Este es el telefono de la empresa: " + empresa.getTelefono());
                break;
            case 2:
                vista.mostrarMensaje("Esta opción te permite cambiar el telefono de la empresa: " + empresa.getTelefono());
                empresa.setTelefono(Long.parseLong(vista.ingresoDatos("Por favor ingresa un numero de telefono de tu empresa.")));
                vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.getTelefono());
                break;
            case 0:
                empresaInfo();
                break;
        }
        do {
            telefonoEmpresa();
        } while (option != 3);

    }

    private void nitEmpresa() {
        int option = mostrarMenu(MENU_INTERNO);
        switch (option) {
            case 1:
                vista.mostrarMensaje("Este es el NIT de la empresa: " + empresa.getNit());
                break;
            case 2:
                vista.mostrarMensaje("Esta opción te permite cambiar el NIT de la empresa: " + empresa.getNit());
                empresa.setNit(Long.parseLong(vista.ingresoDatos("Por favor ingresa el NIT de tu empresa.")));
                vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.getNit());
                break;
            case 0:
                empresaInfo();
                break;
        }
        do {
            nitEmpresa();
        } while (option != 3);

    }

    private void empleadoInfo() {
        int option = mostrarMenu(MENU_EMPLEADO);
        switch (option) {
            case 1:
                crearEmpleado();
                break;
            case 2:
                nombreEmpleado();
                break;
            case 3:
                correoEmpleado();
                break;
            case 4:
                empresaEmpleado();
                break;
            case 5:
                rolEmpleado();
                break;
            case 0:
                empresaInfo();
                break;
        }
        do {
            empleadoInfo();
        } while (option != 6);
    }

    private void crearEmpleado() {
        String nombre = vista.ingresoDatos("Por favor ingresa el nombre del empleado: ");
        String correo = vista.ingresoDatos("Por favor, ingresa el correo del empleado: ");
        String empresaNombre = vista.ingresoDatos("Por favor, ingresa el nombre de la empresa a la que pertenece el empleado: ");
        String rol = vista.ingresoDatos("Por favor, ingresa el rol del empleado");
        Empleado empleado = new Empleado(nombre, correo, empresaNombre, rol);
        empresa.agregarEmpleado(empleado);
        vista.mostrarMensaje("Este es el empleado que agregaste.\n" + empresa.buscarEmpleado(nombre));
    }

    private void nombreEmpleado() {
        if (!empresa.getEmpleados().isEmpty()) {
            vista.mostrarMensaje("Estos son los empleados de esta empresa:\n" + empresa.getEmpleados());
            String nombreEmpleado = vista.ingresoDatos("¿De qué empleado desear saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Este el nombre del empleado: " + empresa.buscarEmpleado(nombreEmpleado).getNombre());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar el nombre del empleado: " + empresa.buscarEmpleado(nombreEmpleado).getNombre());
                    String nombreEmpleadoNuevo = vista.ingresoDatos("Por favor ingresa un nuevo nombre para tu empleado.");
                    empresa.buscarEmpleado(nombreEmpleado).setNombre(nombreEmpleadoNuevo);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarEmpleado(nombreEmpleadoNuevo).getNombre());
                    break;
                case 0:
                    empleadoInfo();
                    break;
            }
            do {
                nombreEmpleado();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay empleados. Puedes crear uno");
            empleadoInfo();
        }
    }

    private void correoEmpleado() {
        if (!empresa.getEmpleados().isEmpty()) {
            vista.mostrarMensaje("Estos son los empleados de esta empresa:\n" + empresa.getEmpleados());
            String nombreEmpleado = vista.ingresoDatos("¿De qué empleado desear saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Este el correo del empleado: " + empresa.buscarEmpleado(nombreEmpleado).getCorreo());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar el correo del empleado: " + empresa.buscarEmpleado(nombreEmpleado).getCorreo());
                    String correoEmpleadoNuevo = vista.ingresoDatos("Por favor ingresa un nuevo correo para tu empleado.");
                    empresa.buscarEmpleado(nombreEmpleado).setCorreo(correoEmpleadoNuevo);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarEmpleado(nombreEmpleado).getCorreo());
                    break;
                case 0:
                    empleadoInfo();
                    break;
            }
            do {
                correoEmpleado();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay empleados. Puedes crear uno");
            empleadoInfo();
        }
    }

    private void empresaEmpleado() {
        if (!empresa.getEmpleados().isEmpty()) {
            vista.mostrarMensaje("Estos son los empleados de esta empresa:\n" + empresa.getEmpleados());
            String nombreEmpleado = vista.ingresoDatos("¿De qué empleado desear saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Esta es la empresa a la que pertenece el empleado: " + empresa.buscarEmpleado(nombreEmpleado).getEmpresa());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar la empresa a la que pertenece el empleado " + empresa.buscarEmpleado(nombreEmpleado).getEmpresa());
                    String empresaEmpleadoNuevo = vista.ingresoDatos("Por favor ingresa un nuevo nombre de la empresa de tu empleado.");
                    empresa.buscarEmpleado(nombreEmpleado).setEmpresa(empresaEmpleadoNuevo);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarEmpleado(nombreEmpleado).getEmpresa());
                    break;
                case 0:
                    empleadoInfo();
                    break;
            }
            do {
                empresaEmpleado();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay empleados. Puedes crear uno");
            empleadoInfo();
        }
    }

    private void rolEmpleado() {
        if (!empresa.getEmpleados().isEmpty()) {
            vista.mostrarMensaje("Estos son los empleados de esta empresa:\n" + empresa.getEmpleados());
            String nombreEmpleado = vista.ingresoDatos("¿De qué empleado desear saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Este es el rol el empleado: " + empresa.buscarEmpleado(nombreEmpleado).getRol());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar la empresa a la que pertenece el empleado " + empresa.buscarEmpleado(nombreEmpleado).getRol());
                    String rolEmpleadoNuevo = vista.ingresoDatos("Por favor ingresa un nuevo nombre de la empresa de tu empleado.");
                    empresa.buscarEmpleado(nombreEmpleado).setRol(rolEmpleadoNuevo);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarEmpleado(nombreEmpleado).getRol());
                    break;
                case 0:
                    empleadoInfo();
                    break;
            }
            do {
                rolEmpleado();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay empleados. Puedes crear uno");
            empleadoInfo();
        }
    }

    private void movimientoInfo() {
        int option = mostrarMenu(MENU_MOVIMIENTO);
        switch (option) {
            case 1:
                crearMovimiento();
                break;
            case 2:
                montoMovimiento();
                break;
            case 3:
                conceptoMovimiento();
                break;
            case 4:
                usuarioMovimiento();
                break;
            case 0:
                run();
                break;
        }
        do {
            empleadoInfo();
        } while (option != 5);
    }

    private void crearMovimiento() {
        double montoMovimiento = Double.parseDouble(vista.ingresoDatos("Por favor, ingresa el monto del movimiento."));
        String conceptoMovimiento = vista.ingresoDatos("Por favor, ingresa el concepto del movimiento.");
        Usuario titular = new Usuario(vista.ingresoDatos("Por favor, ingresa el nombre del titular: "));
        MovimientoDinero movimientoDinero = new MovimientoDinero(montoMovimiento, conceptoMovimiento, titular);
        vista.mostrarMensaje(movimientoDinero.toString());
    }

    private void montoMovimiento() {
        if (!empresa.getUsuarios().isEmpty()) {
            vista.mostrarMensaje("Estos son los usuarios de esta empresa:\n" + empresa.getUsuarios());
            String nombreUsuario = vista.ingresoDatos("¿De qué usuario desea saber información?");
            vista.mostrarMensaje("Estos son los movimiento del usuario: " + empresa.buscarUsuario(nombreUsuario).getMovimientos());
            String movimiento = vista.ingresoDatos("¿De qué movimiento desea saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Este es el monto del movimiento: " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getMontoMovimiento());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar el monto del movimiento " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getMontoMovimiento());
                    Double montoNuevoMovimiento = Double.parseDouble(vista.ingresoDatos("Por favor ingresa un nuevo monto para el movimiento."));
                    empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).setMontoMovimiento(montoNuevoMovimiento);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getMontoMovimiento());
                    break;
                case 0:
                    movimientoInfo();
                    break;
            }
            do {
                montoMovimiento();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay usuarios.");
            movimientoInfo();
        }
    }

    private void conceptoMovimiento() {
        if (!empresa.getUsuarios().isEmpty()) {
            vista.mostrarMensaje("Estos son los usuarios de esta empresa:\n" + empresa.getUsuarios());
            String nombreUsuario = vista.ingresoDatos("¿De qué usuario desea saber información?");
            vista.mostrarMensaje("Estos son los movimiento del usuario: " + empresa.buscarUsuario(nombreUsuario).getMovimientos());
            String movimiento = vista.ingresoDatos("¿De qué movimiento desea saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Este es el concepto del movimiento: " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getConceptoMovimiento());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar el concepto del movimiento " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getConceptoMovimiento());
                    String conceptoNuevoMovimiento = vista.ingresoDatos("Por favor ingresa un nuevo concepto para el movimiento.");
                    empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).setConceptoMovimiento(conceptoNuevoMovimiento);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getConceptoMovimiento());
                    break;
                case 0:
                    movimientoInfo();
                    break;
            }
            do {
                conceptoMovimiento();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay usuarios.");
            movimientoInfo();
        }
    }

    private void usuarioMovimiento() {
        if (!empresa.getUsuarios().isEmpty()) {
            vista.mostrarMensaje("Estos son los usuarios de esta empresa:\n" + empresa.getUsuarios());
            String nombreUsuario = vista.ingresoDatos("¿De qué usuario desea saber información?");
            vista.mostrarMensaje("Estos son los movimiento del usuario: " + empresa.buscarUsuario(nombreUsuario).getMovimientos());
            String movimiento = vista.ingresoDatos("¿De qué movimiento desea saber información?");
            int option = mostrarMenu(MENU_INTERNO);
            switch (option) {
                case 1:
                    vista.mostrarMensaje("Este es el usuario asociado al movimiento: " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getTitular().getNombre());
                    break;
                case 2:
                    vista.mostrarMensaje("Esta opción te permite cambiar el usuario del movimiento " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getTitular().getNombre());
                    Usuario usuarioNuevoMovimiento = new Usuario();
                    usuarioNuevoMovimiento.setNombre(vista.ingresoDatos("Por favor ingresa un nuevo usuario para el movimiento."));
                    empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).setTitular(usuarioNuevoMovimiento);
                    vista.mostrarMensaje("Cambios realizados con éxito: " + empresa.buscarUsuario(nombreUsuario).buscarMovimiento(movimiento).getTitular());
                    break;
                case 0:
                    movimientoInfo();
                    break;
            }
            do {
                usuarioMovimiento();
            } while (option != 3);
        } else {
            vista.mostrarMensaje("No hay usuarios.");
            movimientoInfo();
        }
    }
}
