import java.util.Random;
public class Tomorrowland {

    // Atributos
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;

public Tomorrowland(){

    localidad1 = new Localidad();
    localidad5 = new Localidad();
    localidad10 = new Localidad();

    localidad1.setNumero(1);
    localidad1.setPrecio(100);

    localidad5.setNumero(5);
    localidad5.setPrecio(500);

    localidad10.setNumero(10);
    localidad10.setPrecio(1000);

}

public boolean validarTicket(Comprador e){
    Random aleatorio = new Random();

    int a = aleatorio.nextInt(15000) + 1;
    int b = aleatorio.nextInt(15000) + 1;

    int menor = Math.min(a, b);
    int mayor = Math.max(a, b);

    int ticket = e.getTicket();

    return ticket >= menor && ticket <= mayor;
}

public int asignarLocalidad(){
    Random aleatorio = new Random();
    int local = aleatorio.nextInt(3) + 1;
    switch(local){
        case 1:
            return 1;
        case 2:
            return 5;
        case 3:
            return 10;
    }
    return local;
}

public void venderBoletos(Comprador a, int num){

    Localidad local;

    switch(num){

        case 1:
            local = localidad1;
            break;

        case 5:
            local = localidad5;
            break;

        case 10:
            local = localidad10;
            break;

        default:
            System.out.println("Error al seleccionar la localidad.");
            return;
    }

    if(local.getAsientos() == 0){
        System.out.println("La localidad está llena.");
        return;
    }

    int boletosVenta = a.getCantBoletos();

    if(boletosVenta > local.getAsientos()){
        boletosVenta = local.getAsientos();
        System.out.println("Hay " + boletosVenta + " boletos disponibles.");
    }

    int costo = boletosVenta * local.getPrecio();

    if(costo > a.getPresupuesto()){
        System.out.println("El presupuesto no es suficiente para realizar la compra.");
        return;
    }

    local.setAsientos(local.getAsientos() - boletosVenta);

    local.setFondos(local.getFondos() + costo);

    System.out.println("\nCompra realizada exitosamente.");
    System.out.println("Localidad asignada: " + local.getNumero());
    System.out.println("Boletos comprados: " + boletosVenta);
    System.out.println("Total pagado: $" + costo);
}

public String sumaDisp(){

    String estado = "";

    estado =
    "Localidad 1\n" +
    "Vendidos: " + (20 - localidad1.getAsientos()) +
    "\nDisponibles: " + localidad1.getAsientos() +

    "\n\nLocalidad 5\n" +
    "Vendidos: " + (20 - localidad5.getAsientos()) +
    "\nDisponibles: " + localidad5.getAsientos() +

    "\n\nLocalidad 10\n" +
    "Vendidos: " + (20 - localidad10.getAsientos()) +
    "\nDisponibles: " + localidad10.getAsientos();

    return estado;
}

public String dispLocal(int numero){

    switch(numero){

        case 1:
            return "Localidad 1 \nDisponibles: "
                    + localidad1.getAsientos();

        case 5:
            return "Localidad 5 \nDisponibles: "
                    + localidad5.getAsientos();

        case 10:
            return "Localidad 10 \nDisponibles: "
                    + localidad10.getAsientos();

        default:
            return "Localidad inválida.";

    }

}

public String sumaFondos(){

    int total =
    localidad1.getFondos() +
    localidad5.getFondos() +
    localidad10.getFondos();

    return "Fondos Localidad 1: $" + localidad1.getFondos()
    + "\nFondos Localidad 5: $" + localidad5.getFondos()
    + "\nFondos Localidad 10: $" + localidad10.getFondos()
    + "\n\nTotal generado: $" + total;

}

}