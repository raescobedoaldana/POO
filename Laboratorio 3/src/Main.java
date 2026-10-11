//SÍ, pedí ayuda con este código, que quede claro. No soy CAPAZ de escribir 800 líneas sin cometer errores
//Ahora, las ideas de diseño fueron mías
//Me esforce en leer cada línea (y sí, cada línea), revisar errores de lógica o alucinaciones de IA o cosas COMPLETAMENTE INNECESARIAS
//... o incluso cosas que solucionan el problema PERO no entiendo (como por ejemplo, un trims o algo así, que NO hemos visto)
//Sería incoherente para mí poder entender eso si no lo hemos visto
//Asi que, sí, pido ayuda, pero creo que puedo defender el código, puesto que surge de ideas mías de lógica y funcionamiento
//Al igual que son cosas que sí comprendo
//Asi que creo que he estado aprendiendo. Me cuesta, seh, pero he aprendido

//¿Por que comento esto? Por que querían comentarios (mentira, no solo por ello). Revisé y cuestioné este código. Si de veras hay dudas, preguntenme.
//Tambien quería ver si leen todos mis comentarios. Yo los seguiré haciendo. ASi que si estan leyendo esto, hola y gracias por leer.

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
		//Ingresos
        Scanner teclado = new Scanner(System.in);
		//Nuevo registro
        Registro registro = new Registro();


        // Carga default (y referencias nerd)
        registro.cargarTrabajo(new ImagenFija("I001", "Estudio Toby", "Running Sky",1.5f, true));
        registro.cargarTrabajo(new ImagenFija("I002", "Estudio Beta", "Dirtmouth", 2.0f, false));
        registro.cargarTrabajo(new Animacion("A001", "Estudio Fox", "Feature Presentation",9.5f, true, 610));
        registro.cargarTrabajo(new Animacion("A002", "Estudio Delta", "Black Knife",5.0f, false, 200));
        registro.cargarTrabajo(new AnimacionPostproduccion("P001", "Estudio EXOK", "Reach for the Summit",9.5f, true, 610, 1800.0f));
        registro.cargarTrabajo(new AnimacionPostproduccion("P002", "Estudio Rune", "FlowerMan", 6.0f, false, 250, 500.0f));
        registro.cargarTrabajo(new SimulacionFisica("S001", "Estudio TOTK", "Artefactos Zonan",3.5f, false, 20));
        registro.cargarTrabajo(new SimulacionFisica("S002", "Estudio Team", "Void",4.0f, false, 35));


        //Nodos iniciales
        registro.registrarNodo(new Nodo("N001", 20.0f, true));
        registro.registrarNodo(new Nodo("N002", 15.0f, false));
        registro.registrarNodo(new Nodo("N003", 30.0f, true));

        boolean continuar = true;
        while (continuar) {

            System.out.println("\nRENDERGT - MENU PRINCIPAL\n");
            System.out.println("1. Cotizar y registrar trabajo");
            System.out.println("2. Registrar nodo");
            System.out.println("3. Consultar trabajos");
            System.out.println("4. Consultar nodos");
            System.out.println("5. Crear lote");
            System.out.println("6. Asignar trabajo a lote");
            System.out.println("7. Retirar trabajo de lote");
            System.out.println("8. Iniciar lote");
            System.out.println("9. Registrar resultado");
            System.out.println("10. Consultar lotes");
            System.out.println("11. Reporte de trabajos");
            System.out.println("12. Reporte de ingresos");
            System.out.println("13. Reporte de lotes abiertos");
            System.out.println("14. Salir");


            int opcion = 0;
            boolean opcionValida = false;

            while (!opcionValida) {
				//try catches damdas y caballeros
                try {
                    System.out.print("Seleccione una opcion: ");
                    opcion = teclado.nextInt();
                    teclado.nextLine();

                    if (opcion >= 1 && opcion <= 14) {
                        opcionValida = true;
                    }
					//Agarra un número fuera del rango
                    else {
                        System.out.println(
                            "La opcion debe estar entre 1 y 14."
                        );
                    }

					//Se pasó de listo y coloco un símbolo no númerico
                } catch (InputMismatchException e) {

                    System.out.println("Entrada invalida. Ingrese un numero.");
                    teclado.nextLine();
                }
            }


            switch (opcion) {
                // Cotización de trabajo
                case 1: {
                    System.out.println("\nCOTIZAR TRABAJO\n");
                    System.out.println("1. Imagen fija");
                    System.out.println("2. Animacion");
                    System.out.println("3. Animacion postproduccion");
                    System.out.println("4. Simulacion fisica");

					//Submenú (Clase)
                    int tipo = 0;
                    boolean tipoValido = false;

                    while (!tipoValido) {
					//Otro try catacj
						try {
                            System.out.print("Seleccione el tipo: ");
                            tipo = teclado.nextInt();
                            teclado.nextLine();

							//Un número válido
                            if (tipo >= 1 && tipo <= 4) {
                                tipoValido = true;
                            }
                            else {
                                System.out.println(
                                    "Seleccione una opcion entre 1 y 4."
                                );
                            }

							//Escribió otra cosa que no es un número (que listillo)
                        } catch (InputMismatchException e) {
                            System.out.println(
                                "Entrada invalida. Ingrese un numero."
                            );
                            teclado.nextLine();
                        }
                    }

					//Como NO necesito aun la clase para los datos default, lo necesitaremos después, ahora aún no
                    String codigo = "";
                    boolean codigoValido = false;
                    while (!codigoValido) {
                        System.out.print("Codigo del trabajo: ");
                        codigo = teclado.nextLine();
						//No dejes un código vaçio
                        if (codigo.isEmpty()) {
                            System.out.println(
                                "El codigo no puede estar vacio."
                            );
                        }
						//Usa un código nuevo
                        else if (registro.buscarTrabajo(codigo) != null) {
                            System.out.println(
                                "Ya existe un trabajo con ese codigo."
                            );
                        }
                        else {
                            codigoValido = true;
                        }
                    }

                    System.out.print("Nombre del estudio: ");
                    String estudio = teclado.nextLine();
                    System.out.print("Nombre del proyecto: ");
                    String nombre = teclado.nextLine();

                    float horas = 0;
                    boolean horasValidas = false;
					
					//Ingrese horas
                    while (!horasValidas) {
						//try catch
                        try {
                            System.out.print("Horas estimadas: ");
                            horas = teclado.nextFloat();
                            teclado.nextLine();

							//horas positivas
                            if (horas <= 0) {
                                System.out.println(
                                    "Las horas deben ser mayores a cero."
                                );
                            }
							//Ahora si necesito el tipo, y las horas no pueden ser mayores a 2
                            else if (tipo == 1 && horas > 2) {
                                System.out.println(
                                    "Una imagen fija no puede superar 2 horas."
                                );
                            }
                            else {
                                horasValidas = true;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada invalida. Ingrese un numero.");
                            teclado.nextLine();
                        }
                    }


                    boolean diurno = false;
					//determinar Su horario
                    if (tipo != 4) {  //esto es por que si no es Simulacion Física, puede elegir horario
                        int opcionHorario = 0;
                        boolean horarioValido = false;
                        while (!horarioValido) {
							//try catch con menú nuevo
                            try {
                                System.out.println("1. Diurno");
                                System.out.println("2. Nocturno");
                                System.out.print("Seleccione horario: ");
                                opcionHorario = teclado.nextInt();
                                teclado.nextLine();

								//verificacion de horario
                                if (opcionHorario == 1 || opcionHorario == 2) {
                                    horarioValido = true;
                                }

                                else {
                                    System.out.println(
                                        "Seleccione 1 o 2."
                                    );
                                }

								//La susodicha excepción
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida.");
                                teclado.nextLine();
                            }
                        }

                        if (opcionHorario == 1) {
                            diurno = true;
                        }
                    }
                    else {
                        System.out.println("Las simulaciones fisicas son nocturnas."); //Por que sería una simulacion fisica
                    }


                    Trabajo nuevoTrabajo = null;
					//Ahora sí o sí necesito el tipo
                    switch (tipo) {
                        case 1:
                            nuevoTrabajo = new ImagenFija(codigo, estudio, nombre, horas, diurno);
                            break;

                        case 2: { 
							//Los nuevos atributos
                            int fotogramas = 0;
                            boolean fotogramasValidos = false;
							//nuevo verificador
                            while (!fotogramasValidos) {
								//Try catch
                                try {
                                    System.out.print("Cantidad de fotogramas: ");
                                    fotogramas = teclado.nextInt();
                                    teclado.nextLine();

									//Verificaciones de que sea positivo
                                    if (fotogramas > 0) {
                                        fotogramasValidos = true;
                                    }

                                    else {
                                        System.out.println("Los fotogramas deben ser positivos.");
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada invalida.");
                                    teclado.nextLine();
                                }
                            }

							//Si cumple todo, crea una animación
                            nuevoTrabajo = new Animacion(codigo, estudio, nombre, horas, diurno, fotogramas);
                            break;
                        }

						//Animación Postproducción
                        case 3: {
							//Atributos
                            int fotogramas = 0;
                            boolean fotogramasValidos = false;

                            while (!fotogramasValidos) {
								//Try catch		
                                try {
                                    System.out.print("Cantidad de fotogramas: ");
                                    fotogramas = teclado.nextInt();
                                    teclado.nextLine();

                                    if (fotogramas > 0) {
                                        fotogramasValidos = true;
                                    }
                                    else {
                                        System.out.println("Los fotogramas deben ser positivos.");
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada invalida.");
                                    teclado.nextLine();
                                }
                            }


                            float recursos = 0;
                            boolean recursosValidos = false;

							//lo mismo de antes (no comentaré, es lo mismo)
                            while (!recursosValidos) {

                                try {
                                    System.out.print("Valor de recursos licenciados: Q");
                                    recursos = teclado.nextFloat();
                                    teclado.nextLine();

                                    if (recursos > 0) {
                                        recursosValidos = true;
                                    }
                                    else {
                                        System.out.println("Ingrese un valor positivo.");
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada invalida.");
                                    teclado.nextLine();
                                }
                            }

                            nuevoTrabajo = new AnimacionPostproduccion(codigo, estudio, nombre, horas, diurno, fotogramas, recursos);
                            break;
                        }

                        case 4: {
							//ADivinen que hay que hacer? Lo MISMO
                            int resolucion = 0;
                            boolean resolucionValida = false;

                            while (!resolucionValida) {
                                try {
                                    System.out.print("Resolucion en millones de celdas (1-50): ");

                                    resolucion = teclado.nextInt();
                                    teclado.nextLine();

									//Si sí le hizo caso, registralo y valida
                                    if (resolucion >= 1 && resolucion <= 50) {
                                        resolucionValida = true;
                                    }
                                    else {
                                        System.out.println("La resolucion debe estar entre 1 y 50.");
                                    }
									//El inputMismatch exception
                                } catch (InputMismatchException e) {
                                    System.out.println(
                                        "Entrada invalida."
                                    );
                                    teclado.nextLine();
                                }
                            }

							//Si creó todo, use una simulación fisica
                            nuevoTrabajo = new SimulacionFisica(codigo, estudio, nombre,horas, false, resolucion);
                            break;
                        }
                    }


                    // Cotización. Esto todavía NO la registra
                    System.out.println("\nCOTIZACION\n");
                    System.out.println(nuevoTrabajo);

                    System.out.printf("Costo: Q%.2f%n", nuevoTrabajo.calcularCosto());
                    System.out.println("Tiempo de entrega: " + nuevoTrabajo.tiempoEntrega()+ " horas");

                    int confirmar = 0;
                    boolean confirmacionValida = false;

					//confirmacion para registrarla?
                    while (!confirmacionValida) {
                        try {
                            System.out.println("\n1. Aceptar");
                            System.out.println("2. Cancelar");
                            System.out.print("Seleccione una opcion: ");

                            confirmar = teclado.nextInt();
                            teclado.nextLine();

                            if (confirmar == 1 || confirmar == 2) {
                                confirmacionValida = true;
                            }
                            else {
                                System.out.println("Seleccione 1 o 2.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada invalida.");
                            teclado.nextLine();
                        }
                    }

					//Si confirmó registralo
                    if (confirmar == 1) {
                        if (registro.registrarTrabajo(nuevoTrabajo)) {
                            System.out.println("Trabajo registrado correctamente.");
                        }
						//Si no se pudo (por x o y motivo)
                        else {
                            System.out.println(
                                "No se pudo registrar el trabajo."
                            );
                        }

                    }
					//Escribó 2
                    else {
                        System.out.println("Cotizacion cancelada.");
                    }

                    break;
                }


                // Registrar nodo
                case 2: {

                    System.out.println("\nREGISTRAR NODO\n");

                    String codigoNodo = "";
                    boolean codigoValido = false;

					//Misma idea, cree un boolean en un while para que cuando se cumple salga del while
                    while (!codigoValido) {

						//Ingresos del codigo, pero solo validos
                        System.out.print("Codigo del nodo: ");
                        codigoNodo = teclado.nextLine();

						//No vacío
                        if (codigoNodo.isEmpty()) {
                            System.out.println("El codigo no puede estar vacio.");
                        }
						//Codigo igual
                        else if (registro.buscarNodo(codigoNodo) != null) {
                            System.out.println("Ya existe un nodo con ese codigo.");
                        }
                        else {
                            codigoValido = true;
                        }
                    }


                    float capacidad = 0;
                    boolean capacidadValida = false;

					//Debería ponerle un acrónimo
                    while (!capacidadValida) {

                        try {
                            System.out.print("Capacidad maxima de horas: ");
                            capacidad = teclado.nextFloat();
                            teclado.nextLine();

                            if (capacidad > 0) {
                                capacidadValida = true;
                            }
                            else {
                                System.out.println("La capacidad debe ser positiva y valida.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada invalida.");
                            teclado.nextLine();
                        }
                    }


                    int opcionGpu = 0;
                    boolean gpuValida = false;
					//Lo mismo pero con GPU
                    while (!gpuValida) {
                        try {
                            System.out.println("1. Sí tiene GPU");
                            System.out.println("2. No tiene GPU");
                            System.out.print("Seleccione una opcion: ");
                            opcionGpu = teclado.nextInt();
                            teclado.nextLine();

							//Si es un número valido
                            if (opcionGpu == 1 || opcionGpu == 2) {
                                gpuValida = true;
                            }
							//Un número invpalido
                            else {
                                System.out.println("Seleccione 1 o 2.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada invalida.");
                            teclado.nextLine();
                        }
                    }

                    boolean gpu = false;
					//Como GPU era un boolean, acá está el por que
                    if (opcionGpu == 1) {
                        gpu = true;
                    }

					//Crea un nuevo nodo
                    Nodo nuevoNodo = new Nodo(codigoNodo, capacidad, gpu);

					//Si se pudo registrar
                    if (registro.registrarNodo(nuevoNodo)) {
                        System.out.println("Nodo registrado correctamente.");
                    }
					//Si no
                    else {
                        System.out.println("No se pudo registrar el nodo.");
                    }
                    break;
                }


                // Trabajos
                case 3:
                    registro.mostrarTrabajos();
                    break;


                // Nodos
                case 4:
                    registro.mostrarNodos();
                    break;


                // Creación de Lotes
                case 5: {
                    System.out.println("\nCREAR LOTE\n");
                    System.out.print("Codigo del lote: ");
                    String codigoLote = teclado.nextLine();
                    System.out.print("Codigo del nodo: ");
                    String codigoNodo = teclado.nextLine();
                    Nodo nodo = registro.buscarNodo(codigoNodo);

					//Por que acá no hice todo lo de ifs y whiles y todo eso??? Por que está en crearLote

                    if (registro.crearLote(codigoLote, nodo)) {
                        System.out.println("Lote creado correctamente.");
                    }
                    else {
                        System.out.println("No se pudo crear el lote.");
                    }
                    break;
                }


                // asignar trabajo
                case 6: {
                    System.out.println("\nASIGNAR TRABAJO\n");
                    System.out.print("Codigo del lote: ");
                    String codigoLote = teclado.nextLine();
                    System.out.print("Codigo del trabajo: ");
                    String codigoTrabajo = teclado.nextLine();

                    if (registro.asignarTrabajo(
                            codigoLote, codigoTrabajo)) {

                        System.out.println(
                            "Trabajo asignado correctamente."
                        );
                    }
                    else {
                        System.out.println(
                            "No se pudo asignar el trabajo."
                        );
                    }

                    break;
                }


                // RETIRAR TRABAJO
                case 7: {
                    System.out.println("\nRETIRAR TRABAJO\n");
                    System.out.print("Codigo del lote: ");
                    String codigoLote = teclado.nextLine();
                    System.out.print("Codigo del trabajo: ");
                    String codigoTrabajo = teclado.nextLine();

					//Mismo principio, la logica ya está en el metodo
                    if (registro.retirarTrabajo(codigoLote, codigoTrabajo)) {
                        System.out.println("Trabajo retirado correctamente.");
                    }
                    else {
                        System.out.println("No se pudo retirar el trabajo.");
                    }
                    break;
                }


                // Inciación del Proceso de Iniciación del Lote de Aperture Science Labs
                case 8: {
                    System.out.println("\nINICIAR LOTE\n");
                    System.out.print("Codigo del lote: ");
                    String codigoLote = teclado.nextLine();

					//Las verificaciones ya están en el Lote
                    if (registro.iniciarLote(codigoLote)) {
                        System.out.println("Lote iniciado correctamente.");
                    }
                    else {
                        System.out.println("No se pudo iniciar el lote.");
                    }
                    break;
                }


                // Registro de resultados (después de iniciar un lote)
                case 9: {
                    System.out.println("\nREGISTRAR RESULTADO\n");
                    System.out.print("Codigo del lote: ");
                    String codigoLote = teclado.nextLine();
                    System.out.print("Codigo del trabajo: ");
                    String codigoTrabajo = teclado.nextLine();

                    int resultado = 0;
                    boolean resultadoValido = false;

                    while (!resultadoValido) {
                        try {
							//Un menú de resultado
							System.out.println("1. Completado");
                            System.out.println("2. Fallido");
                            System.out.print("Seleccione resultado: ");
                            resultado = teclado.nextInt();
                            teclado.nextLine();

							//Solo si ingreso 1 o 2
                            if (resultado == 1 || resultado == 2) {
                                resultadoValido = true;
                            }
							//Número que no es
                            else {
                                System.out.println("Seleccione 1 o 2.");
                            }

							//Errores
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada invalida.");
                            teclado.nextLine();
                        }
                    }

                    boolean completado = false;
                    if (resultado == 1) {
                        completado = true;
                    }

					//Si se completó, registraResultado para este así
                    if (registro.registrarResultado(codigoLote, codigoTrabajo, completado)) {
                        System.out.println("Resultado registrado correctamente.");
                    }
                    else {
                        System.out.println("No se pudo registrar el resultado.");
                    }

                    break;
                }


                // Consulte los lotes
                case 10:
                    registro.mostrarLotes();
                    break;

                // Reporte trabajos
                case 11:
                    registro.reporteTrabajos();
                    break;


                // Reporte de ingresos
                case 12:
                    registro.reporteIngresos();
                    break;


                // Reporte de lotes
                case 13:
                    registro.reporteLotesAbiertos();
                    break;


                // Salir
                case 14:
                    System.out.println("Saliendo de RenderGT...");
                    continuar = false;
                    break;
            }
        }

        teclado.close();
    }
}
