public class Localidad {

    private int asientosDisp;
    private int fondos;
    private int numero;
    private int precio;


    public Localidad() {
        asientosDisp = 20;
        fondos = 0;
        numero = 0;
        precio = 0;
    }

    public void setAsientos(int asientos) {
        this.asientosDisp = asientos;
    }

    public int getAsientos() {
        return asientosDisp;
    }

    public void setFondos(int fondos) {
        this.fondos = fondos;
    }

    public int getFondos() {
        return fondos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

}