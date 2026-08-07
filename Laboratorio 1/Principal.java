// Madre santísima, esto tomó mucho, y digo muuuucho Google, Reddit y GPT para que funcione. 
//Pero funciona y es bellísimo. Si estas leyendo esto, es mi mensaje de alegría.
//Si tienen dudas, estoy 100% seguro que lo puedo defender, pero me tomó como 2 días seguidos hacer.
//No esperen un código así de elaborado siempre, pero quería aprovechar los días extra que tenía.
import java.util.Scanner;
import java.util.Random;
public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        Jugador entrenador = new Jugador();
        Jugador cpu = new Jugador();

        Torneo torneo = new Torneo(entrenador, cpu);

        for (int i = 1; i <= 3; i++) {

            System.out.println("\n**************************");
            System.out.println("Creación del Pokémon " + i);
            System.out.println("**************************");

            String nombre;
            int tipo = 0;
            int ataque;
            int defensa;

            System.out.print("Nombre: ");
            nombre = teclado.next();

            System.out.println("\nSeleccione el tipo del Pokémon:");
            System.out.println("1. Agua");
            System.out.println("2. Planta");
            System.out.println("3. Fuego");
            System.out.println("4. Eléctrico");

            int opcion = teclado.nextInt();

            while (opcion < 1 || opcion > 4) {

                System.out.println("Tipo inválido.");
                System.out.print("Ingrese nuevamente: ");
                opcion = teclado.nextInt();

            }

            switch (opcion) {

                case 1:
                    tipo = Pokemon.agua;
                    break;

                case 2:
                    tipo = Pokemon.planta;
                    break;

                case 3:
                    tipo = Pokemon.fuego;
                    break;

                case 4:
                    tipo = Pokemon.electrico;
                    break;

            }


            System.out.print("\nAtaque (30 - 50): ");
            ataque = teclado.nextInt();

            while (ataque < 30 || ataque > 50) {

                System.out.println("Ataque inválido.");
                System.out.print("Ingrese nuevamente: ");
                ataque = teclado.nextInt();

            }


            System.out.print("\nDefensa (30 - 50): ");
            defensa = teclado.nextInt();

            while (defensa < 30 || defensa > 50) {

                System.out.println("Defensa inválida.");
                System.out.print("Ingrese nuevamente: ");
                defensa = teclado.nextInt();

            }

            Pokemon pokemon = new Pokemon(
                    nombre,
                    tipo,
                    ataque,
                    defensa);

            entrenador.asignarPokemon(i, pokemon);

            System.out.println("\n***** Pokémon creado *****");
            System.out.println("Nombre: " + nombre);
            System.out.println("Tipo: " + pokemon.getNombreTipo());
            System.out.println("Ataque: " + ataque);
            System.out.println("Defensa: " + defensa);
            System.out.println("****************************");
        }

// Toca generar a la CPU (Revisar torneo)

        torneo.calcularEstadisticas();

// Peleas pokémon!

        for (int ronda = 1; ronda <= 4; ronda++) {

            System.out.println("\n**************************");
            System.out.println("RONDA " + ronda);
            System.out.println("**************************");

            if (ronda == 4) {

                entrenador.reiniciarEquipo();
                cpu.reiniciarEquipo();

            }

//Seleccione su pokémon

            Pokemon pokemonEntrenador = null;

            while (pokemonEntrenador == null) {

                System.out.println("\nSeleccione un Pokémon:");

                System.out.println("1. " + entrenador.getPokemon1().getNombre());
                System.out.println("2. " + entrenador.getPokemon2().getNombre());
                System.out.println("3. " + entrenador.getPokemon3().getNombre());

                int opcionPokemon = teclado.nextInt();

                pokemonEntrenador =
                        entrenador.seleccionarPokemon(opcionPokemon);

                if (pokemonEntrenador == null) {

                    System.out.println("Ese Pokémon ya participó en una ronda.");

                }

            }


            Pokemon pokemonCPU = null;

            while (pokemonCPU == null) {

                int opcionCPU = random.nextInt(3) + 1;

                pokemonCPU =
                        cpu.seleccionarPokemon(opcionCPU);

            }

            System.out.println("\n**************************");
            System.out.println("ENTRENADOR envía a "
                    + pokemonEntrenador.getNombre());
            System.out.println("Tipo: "
                    + pokemonEntrenador.getNombreTipo());

            System.out.println();

            System.out.println("CPU envía a "
                    + pokemonCPU.getNombre());
            System.out.println("Tipo: "
                    + pokemonCPU.getNombreTipo());
            System.out.println("**************************");

//¡Es tu turno, ENTRENADOR!

System.out.println("\n**************************");
System.out.println("Turno del ENTRENADOR");
System.out.println("**************************");

int movimientoEntrenador = 0;
int probabilidadEntrenador = 0;

switch (pokemonEntrenador.getTipo()) {

    case Pokemon.agua:

        System.out.println("1. Burbuja");
        System.out.println("   Lanza una lluvia de burbujas contra el rival.");
        System.out.println("   Ataque: +8");
        System.out.println("   Defensa: +5");
        System.out.println("   Probabilidad: 100%\n");

        System.out.println("2. Pistola Agua");
        System.out.println("   Dispara un potente chorro de agua.");
        System.out.println("   Ataque: +15");
        System.out.println("   Defensa: +0");
        System.out.println("   Probabilidad: 90%\n");

        System.out.println("3. Tenaza");
        System.out.println("   Atrapa al rival con unas fuertes tenazas.");
        System.out.println("   Ataque: +10");
        System.out.println("   Defensa: +10");
        System.out.println("   Probabilidad: 85%\n");

        movimientoEntrenador = teclado.nextInt();

        while (movimientoEntrenador < 1 || movimientoEntrenador > 3) {

            System.out.println("Movimiento inválido.");
            movimientoEntrenador = teclado.nextInt();

        }

        switch (movimientoEntrenador) {

            case 1:
                probabilidadEntrenador = 100;
                break;

            case 2:
                probabilidadEntrenador = 90;
                break;

            case 3:
                probabilidadEntrenador = 85;
                break;

        }

        break;

    case Pokemon.planta:

    System.out.println("1. Látigo Cepa");
    System.out.println("   Golpea al rival con resistentes cepas.");
    System.out.println("   Ataque: +10");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 95%\n");

    System.out.println("2. Hojas Navaja");
    System.out.println("   Lanza una ráfaga de hojas afiladas.");
    System.out.println("   Ataque: +20");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 75%\n");

    System.out.println("3. Absorber");
    System.out.println("   Absorbe energía para fortalecerse.");
    System.out.println("   Ataque: +5");
    System.out.println("   Defensa: +10");
    System.out.println("   Probabilidad: 90%\n");

    movimientoEntrenador = teclado.nextInt();

    while (movimientoEntrenador < 1 || movimientoEntrenador > 3) {

        System.out.println("Movimiento inválido.");
        movimientoEntrenador = teclado.nextInt();

    }

    switch (movimientoEntrenador) {

        case 1:
            probabilidadEntrenador = 95;
            break;

        case 2:
            probabilidadEntrenador = 75;
            break;

        case 3:
            probabilidadEntrenador = 90;
            break;

    }

    break;

case Pokemon.fuego:

    System.out.println("1. Brasas");
    System.out.println("   Dispara pequeñas brasas.");
    System.out.println("   Ataque: +12");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 90%\n");

    System.out.println("2. Lanzallamas");
    System.out.println("   Lanza una intensa llamarada.");
    System.out.println("   Ataque: +20");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 75%\n");

    System.out.println("3. Llamarada");
    System.out.println("   Desata una enorme explosión de fuego.");
    System.out.println("   Ataque: +30");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 60%\n");

    movimientoEntrenador = teclado.nextInt();

    while (movimientoEntrenador < 1 || movimientoEntrenador > 3) {

        System.out.println("Movimiento inválido.");
        movimientoEntrenador = teclado.nextInt();

    }

    switch (movimientoEntrenador) {

        case 1:
            probabilidadEntrenador = 90;
            break;

        case 2:
            probabilidadEntrenador = 75;
            break;

        case 3:
            probabilidadEntrenador = 60;
            break;

    }

    break;

case Pokemon.electrico:

    System.out.println("1. Impactrueno");
    System.out.println("   Lanza una descarga eléctrica.");
    System.out.println("   Ataque: +12");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 95%\n");

    System.out.println("2. Rayo");
    System.out.println("   Descarga una potente corriente eléctrica.");
    System.out.println("   Ataque: +18");
    System.out.println("   Defensa: +0");
    System.out.println("   Probabilidad: 90%\n");

    System.out.println("3. Onda Trueno");
    System.out.println("   Una onda eléctrica debilita al rival.");
    System.out.println("   Ataque: +5");
    System.out.println("   Defensa: +12");
    System.out.println("   Probabilidad: 95%\n");

    movimientoEntrenador = teclado.nextInt();

    while (movimientoEntrenador < 1 || movimientoEntrenador > 3) {

        System.out.println("Movimiento inválido.");
        movimientoEntrenador = teclado.nextInt();

    }

    switch (movimientoEntrenador) {

        case 1:
            probabilidadEntrenador = 95;
            break;

        case 2:
            probabilidadEntrenador = 90;
            break;

        case 3:
            probabilidadEntrenador = 95;
            break;

    }

    break;

}

// ¡Turno del Rival (CPU). Ojalá esto sirva.

int movimientoCPU = random.nextInt(3) + 1;
int probabilidadCPU = 0;

System.out.println("\n**************************");
System.out.println("Turno de " + pokemonCPU.getNombre());
System.out.println("**************************");

switch (pokemonCPU.getTipo()) {

    case Pokemon.agua:

        switch (movimientoCPU) {

            case 1:
                System.out.println(pokemonCPU.getNombre() + " usa Burbuja.");
                probabilidadCPU = 100;
                break;

            case 2:
                System.out.println(pokemonCPU.getNombre() + " usa Pistola Agua.");
                probabilidadCPU = 90;
                break;

            case 3:
                System.out.println(pokemonCPU.getNombre() + " usa Tenaza.");
                probabilidadCPU = 85;
                break;

        }

        break;

    case Pokemon.planta:

        switch (movimientoCPU) {

            case 1:
                System.out.println(pokemonCPU.getNombre() + " usa Látigo Cepa.");
                probabilidadCPU = 95;
                break;

            case 2:
                System.out.println(pokemonCPU.getNombre() + " usa Hojas Navaja.");
                probabilidadCPU = 75;
                break;

            case 3:
                System.out.println(pokemonCPU.getNombre() + " usa Absorber.");
                probabilidadCPU = 90;
                break;

        }

        break;

    case Pokemon.fuego:

        switch (movimientoCPU) {

            case 1:
                System.out.println(pokemonCPU.getNombre() + " usa Brasas.");
                probabilidadCPU = 90;
                break;

            case 2:
                System.out.println(pokemonCPU.getNombre() + " usa Lanzallamas.");
                probabilidadCPU = 75;
                break;

            case 3:
                System.out.println(pokemonCPU.getNombre() + " usa Llamarada.");
                probabilidadCPU = 60;
                break;

        }

        break;

    case Pokemon.electrico:

        switch (movimientoCPU) {

            case 1:
                System.out.println(pokemonCPU.getNombre() + " usa Impactrueno.");
                probabilidadCPU = 95;
                break;

            case 2:
                System.out.println(pokemonCPU.getNombre() + " usa Rayo.");
                probabilidadCPU = 90;
                break;

            case 3:
                System.out.println(pokemonCPU.getNombre() + " usa Onda Trueno.");
                probabilidadCPU = 95;
                break;

        }

        break;
}

int danoEntrenador = 0;
int danoCPU = 0;

System.out.println("\nRealizando cálculos...");

if (torneo.calcularProbabilidad(probabilidadEntrenador)) {

    danoEntrenador = torneo.calcularDano(
            pokemonEntrenador,
            pokemonCPU,
            movimientoEntrenador);

}

if (torneo.calcularProbabilidad(probabilidadCPU)) {

    danoCPU = torneo.calcularDano(
            pokemonCPU,
            pokemonEntrenador,
            movimientoCPU);

}

torneo.compararAtaque(
        danoEntrenador,
        danoCPU);

System.out.println("\n**************************");
System.out.println("Resultado de la ronda");
System.out.println("**************************");

System.out.println("Daño del ENTRENADOR: "
        + danoEntrenador);

System.out.println("Daño de la CPU: "
        + danoCPU);

System.out.println();

System.out.println("Marcador");

System.out.println("ENTRENADOR: "
        + entrenador.getPuntaje());

System.out.println("CPU: "
        + cpu.getPuntaje());

} 

System.out.println("\n**************************");
System.out.println("      RESULTADO FINAL");
System.out.println("**************************");

System.out.println("ENTRENADOR: "
        + entrenador.getPuntaje());

System.out.println("CPU: "
        + cpu.getPuntaje());

System.out.println();

if (entrenador.getPuntaje() > cpu.getPuntaje()) {

    System.out.println("¡El ENTRENADOR gana el torneo!");

}

else if (cpu.getPuntaje() > entrenador.getPuntaje()) {

    System.out.println("¡La CPU gana el torneo!");

}

else {

    System.out.println("¡El torneo terminó en empate!");

}

teclado.close();

}
}
