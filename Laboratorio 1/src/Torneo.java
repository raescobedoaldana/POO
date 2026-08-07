import java.util.Random;

public class Torneo {

    private Jugador entrenador;
    private Jugador cpu;
    private Random random;

    public Torneo(Jugador entrenador, Jugador cpu) {
        this.entrenador = entrenador;
        this.cpu = cpu;
        random = new Random();
    }

//Generación random de la CPU
    public void calcularEstadisticas() {

        for (int i = 1; i <= 3; i++) {

            String nombre = "";
            int tipo;
            int ataque;
            int defensa;

            switch (i) {

                case 1:
                    nombre = "Alpha";
                    break;

                case 2:
                    nombre = "Beta";
                    break;

                case 3:
                    nombre = "Gamma";
                    break;
            }

            int opcion = random.nextInt(4) + 1;

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

                default:
                    tipo = Pokemon.electrico;
                    break;
            }

            ataque = random.nextInt(21) + 40;
            defensa = random.nextInt(21) + 40;

            Pokemon pokemonCPU = new Pokemon(nombre, tipo, ataque, defensa);

            cpu.asignarPokemon(i, pokemonCPU);

            System.out.println(nombre);
            System.out.println("Tipo: " + pokemonCPU.getNombreTipo());
            System.out.println("Ataque: " + ataque);
            System.out.println("Defensa: " + defensa);
            System.out.println();
        }
    }

    public boolean calcularProbabilidad(int probabilidad) {

        int fallo = 100 - probabilidad;
        int numero = random.nextInt(100) + 1;

        System.out.println("Probabilidad: " + probabilidad + "%");
        System.out.println("Número generado: " + numero);

        if (numero <= fallo) {

            System.out.println("El movimiento falló.");
            return false;
        }

        System.out.println("El movimiento fue exitoso.");
        return true;
    }

//Sistema de daño de las peleas Pokémon
    public int calcularDano(Pokemon atacante, Pokemon defensor, int movimiento) {

        int ataque = atacante.getAtaque();
        int defensa = defensor.getDefensa();

//Sistema de Movimientos (Sigo muy orgulloso de este sistema)
        switch (atacante.getTipo()) {

            case Pokemon.agua:

                switch (movimiento) {

                    case 1:
                        ataque += 8;
                        defensa += 5;
                        break;

                    case 2:
                        ataque += 15;
                        break;

                    case 3:
                        ataque += 10;
                        defensa += 10;
                        break;
                }

                break;

            case Pokemon.planta:

                switch (movimiento) {

                    case 1:
                        ataque += 10;
                        break;

                    case 2:
                        ataque += 20;
                        break;

                    case 3:
                        ataque += 5;
                        defensa += 10;
                        break;
                }

                break;

            case Pokemon.fuego:

                switch (movimiento) {

                    case 1:
                        ataque += 12;
                        break;

                    case 2:
                        ataque += 20;
                        break;

                    case 3:
                        ataque += 30;
                        break;
                }

                break;

            case Pokemon.electrico:

                switch (movimiento) {

                    case 1:
                        ataque += 12;
                        break;

                    case 2:
                        ataque += 18;
                        break;

                    case 3:
                        ataque += 5;
                        defensa += 12;
                        break;
                }

                break;
        }

        // Efectividad de tipos (Sigo super orgulloso de esto :D )
        int diferencia = atacante.getTipo() - defensor.getTipo();

        switch (diferencia) {

            // Los efectivos
            case 7:
            case 2:
            case 1:
            case -3:
                ataque += 20;
                break;

            // Los débiles
            case 3:
            case -2:
            case -1:
            case -7:
                ataque -= 10;
                break;

            // Neutrales
            case 6:
            case 4:
            case 0:
            case -4:
            case -6:
                break;
        }

        int dano = ataque - defensa;	

        if (dano < 1) {
            dano = 1;
        }

        return dano;
    }

    public void compararAtaque(int danoEntrenador, int danoCPU) {

        if (danoEntrenador > danoCPU) {

            entrenador.setPuntaje(entrenador.getPuntaje() + 1);
            System.out.println("¡El ENTRENADOR gana la ronda!");

        }

        else if (danoCPU > danoEntrenador) {

            cpu.setPuntaje(cpu.getPuntaje() + 1);
            System.out.println("¡La CPU gana la ronda!");

        }

        else {

            System.out.println("¡Empate!");

        }
    }

}