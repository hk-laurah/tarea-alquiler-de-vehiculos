public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double precioPorDia;
    private boolean disponible;

    public Vehiculo(String marca, String modelo, int anio, double precioPorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioPorDia = precioPorDia;
        this.disponible = true;
    }

    public abstract void mostrarInfo();

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

