import java.util.Random;
public class Comprador {
    //Atributos
    private String nombre;
    private String email;
    private int cantBoletos;
    private int ticket;
    private int presupuesto;

    //métodos
    public Comprador(){
        nombre = "Cliente";
        email = "ejemplo@uvg.edu.gt";
        cantBoletos = 0;
        ticket = 1;
        presupuesto = 0;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setCantBoletos(int cantBoletos){
        this.cantBoletos = cantBoletos;
    }
    public int getCantBoletos(){
        return cantBoletos;

}


public void setTicket(){
    Random aleatorio = new Random();
    int numero = aleatorio.nextInt(15000) + 1;
    this.ticket = numero;

}

public int getTicket(){
    return ticket;
}

public void setPresupuesto(int presupuesto){
    this.presupuesto = presupuesto;
}

public int getPresupuesto(){
    return presupuesto;
}

}