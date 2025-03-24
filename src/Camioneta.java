public class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta(String marca, String modelo, int anio, double precioPorDia, int capacidadCarga) {
        super(marca, modelo, anio, precioPorDia);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("camioneta - " + getMarca() + " " + getModelo() + " (" + getAnio() +
                "), carga: " + capacidadCarga + "kg, precio por día: $" + getPrecioPorDia());
    }
}
