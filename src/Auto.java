public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String marca, String modelo, int anio, double precioPorDia, int numeroPuertas) {
        super(marca, modelo, anio, precioPorDia);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("auto - " + getMarca() + " " + getModelo() + " (" + getAnio() +
                "), puertas: " + numeroPuertas + ", precio por día: $" + getPrecioPorDia());
    }
}
