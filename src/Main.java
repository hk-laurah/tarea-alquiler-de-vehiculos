import java.util.*;

public class Main {
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("menu de alquiler de vehiculos");
            System.out.println("1. registrar nuevo vehiculo");
            System.out.println("2. registrar nuevo cliente");
            System.out.println("3. realizar alquiler");
            System.out.println("4. mostrar vehiculos disponibles");
            System.out.println("5. registrar devolucion de vehículo");
            System.out.println("6. salir");
            System.out.print("selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarVehiculo();
                case 2 -> registrarCliente();
                case 3 -> realizarAlquiler();
                case 4 -> mostrarVehiculosDisponibles();
                case 5 -> devolverVehiculo();
                case 6 -> System.out.println("gracias por usar el sistema");
                default -> System.out.println("opcion invalida.");
            }
        } while (opcion != 6);
    }

    private static void registrarVehiculo() {
        System.out.print("¿que tipo de vehículo quiere registrar? (1. automovil 2. camioneta): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Año: ");
        int anio = sc.nextInt();
        System.out.print("Precio por día: ");
        double precio = sc.nextDouble();

        if (tipo == 1) {
            System.out.print("numero de puertas: ");
            int puertas = sc.nextInt();
            vehiculos.add(new Auto(marca, modelo, anio, precio, puertas));
        } else if (tipo == 2) {
            System.out.print("capacidad de carga (kg): ");
            int carga = sc.nextInt();
            vehiculos.add(new Camioneta(marca, modelo, anio, precio, carga));
        } else {
            System.out.println("tipo no valido.");
        }

        System.out.println("vehículo registrado con éxito.");
    }

    private static void registrarCliente() {
        System.out.print("nombre: ");
        String nombre = sc.nextLine();
        System.out.print("cedula: ");
        String cedula = sc.nextLine();
        System.out.print("licencia de conducir: ");
        String licencia = sc.nextLine();

        clientes.add(new Cliente(nombre, cedula, licencia));
        System.out.println("cliente registrado con éxito.");
    }

    private static void realizarAlquiler() {
        mostrarVehiculosDisponibles();
        System.out.print("seleccione el índice del vehículo a alquilar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 0 || index >= vehiculos.size() || !vehiculos.get(index).isDisponible()) {
            System.out.println("vehiculo no valido o no disponible.");
            return;
        }

        System.out.print("nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        Cliente cliente = buscarCliente(nombreCliente);

        if (cliente == null) {
            System.out.println("cliente no encontrado. registralo primero.");
            return;
        }

        System.out.print("cantidad de días a alquilar: ");
        int dias = sc.nextInt();

        Vehiculo v = vehiculos.get(index);
        double total = v.getPrecioPorDia() * dias;
        if (dias > 7) {
            total *= 0.9;
        }

        v.setDisponible(false);
        System.out.println("alquiler registrado. Costo total: $" + total);
    }

    private static Cliente buscarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    private static void mostrarVehiculosDisponibles() {
        System.out.println("vehiculos disponibles");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            if (v.isDisponible()) {
                System.out.print("[" + i + "] ");
                v.mostrarInfo();
            }
        }
    }

    private static void devolverVehiculo() {
        System.out.println("vehiculos disponibles");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            if (!v.isDisponible()) {
                System.out.print("[" + i + "] ");
                v.mostrarInfo();
            }
        }

        System.out.print("Seleccione el índice del vehículo a devolver: ");
        int index = sc.nextInt();

        if (index < 0 || index >= vehiculos.size() || vehiculos.get(index).isDisponible()) {
            System.out.println("indice invalido o el vehículo ya está disponible.");
            return;
        }

        vehiculos.get(index).setDisponible(true);
        System.out.println("vehículo marcado como disponible nuevamente.");
    }
}
