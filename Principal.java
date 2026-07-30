//import java.util.Random; 
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);

    Tomorrowland festival = new Tomorrowland();
    Comprador novo = new Comprador();

    int opcion;

    do {

        System.out.println("\n********** TOMORROWLAND **********");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        opcion = teclado.nextInt();
        teclado.nextLine();

        switch(opcion){

            case 1:

            novo = new Comprador();

            System.out.print("Nombre: ");
                novo.setNombre(teclado.nextLine());

            System.out.print("Correo electrónico: ");
                novo.setEmail(teclado.nextLine());

            System.out.print("Cantidad de boletos: ");
                novo.setCantBoletos(teclado.nextInt());

            System.out.print("Presupuesto: ");
                novo.setPresupuesto(teclado.nextInt());

            teclado.nextLine();

                novo.setTicket();

                System.out.println("Ticket generado: " + novo.getTicket());

                break;

    case 2:
    if(novo.getCantBoletos() == 0){
        System.out.println("Debe registrar un comprador primero.");
        break;
    }

    if(festival.validarTicket(novo)){

        System.out.println("Su ticket es válido");

        int localidad = festival.asignarLocalidad();

        System.out.println("Localidad asignada: " + localidad);

        festival.venderBoletos(novo, localidad);

    }
    else{

        System.out.println("El tícket no es ganador");

    }

    break;

    case 3:

    System.out.println(festival.sumaDisp());

        break;

    case 4:

        System.out.print("Ingrese la localidad [1, 5 o 10]: ");
        int numero = teclado.nextInt();
        teclado.nextLine();

        System.out.println(festival.dispLocal(numero));

        break;

        case 5:

            System.out.println(festival.sumaFondos());

            break;

        case 6:

        System.out.println("El programa ha finalizado.");

        break;

        default:

        System.out.println("Opción inválida.");

            }

        } while(opcion != 6);

    }

}