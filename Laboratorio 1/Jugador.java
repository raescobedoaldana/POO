public class Jugador {

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private int puntaje;

    public Jugador() {
        pokemon1 = new Pokemon();
        pokemon2 = new Pokemon();
        pokemon3 = new Pokemon();
        puntaje = 0;
    }

    public void setPuntaje(int newPuntaje) {
        puntaje = newPuntaje;
    }

	public Pokemon getPokemon1() {
    return pokemon1;
}

public Pokemon getPokemon2() {
    return pokemon2;
}

public Pokemon getPokemon3() {
    return pokemon3;
}

    public int getPuntaje() {
        return puntaje;
    }

    public Pokemon seleccionarPokemon(int opcion) {

        switch (opcion) {

            case 1:
                if (pokemon1.getPeleado() == false) {
                    pokemon1.setPeleado(true);
                    return pokemon1;
                }
                break;

            case 2:
                if (pokemon2.getPeleado() == false) {
                    pokemon2.setPeleado(true);
                    return pokemon2;
                }
                break;

            case 3:
                if (pokemon3.getPeleado() == false) {
                    pokemon3.setPeleado(true);
                    return pokemon3;
                }
                break;
        }

        return null;
    }

    public int seleccionarMovimiento(int opcion) {
        return opcion;
    }

    public void reiniciarEquipo() {
        pokemon1.setPeleado(false);
        pokemon2.setPeleado(false);
        pokemon3.setPeleado(false);
    }

	public void asignarPokemon(int posicion, Pokemon pokemon) {

    switch (posicion) {

        case 1:
            pokemon1 = pokemon;
            break;

        case 2:
            pokemon2 = pokemon;
            break;

        case 3:
            pokemon3 = pokemon;
            break;

        default:
            System.out.println("Posición inválida.");
            break;
    }
}

}