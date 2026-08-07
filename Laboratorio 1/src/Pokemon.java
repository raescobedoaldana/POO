public class Pokemon {

    public static final int agua = 1;
    public static final int planta = 2;
    public static final int fuego = 4;
    public static final int electrico = 8;

    private String nombre;
    private int tipo;
    private int ataque;
    private int defensa;
    private boolean haPeleado;

    public Pokemon() {
        nombre = "";
        tipo = agua;
        ataque = 0;
        defensa = 0;
        haPeleado = false;
    }

    public Pokemon(String nombre, int tipo, int ataque, int defensa) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.haPeleado = false;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTipo(int newTipo) {
        tipo = newTipo;
    }

	public int getTipo() {
        return tipo;
    }

    public void setAtaque(int newAtaque) {
        ataque = newAtaque;
    }

	public int getAtaque() {
        return ataque;
    }

    public void setDefensa(int newDefensa) {
        defensa = newDefensa;
    }

	public int getDefensa() {
        return defensa;
    }

    public void setPeleado(boolean newPeleado) {
        haPeleado = newPeleado;
    }

    public boolean getPeleado() {
        return haPeleado;
    }
	
public String getNombreTipo() {

    switch (tipo) {

        case agua:
            return "Agua";

        case planta:
            return "Planta";

        case fuego:
            return "Fuego";

        case electrico:
            return "Eléctrico";

        default:
            return "Desconocido";
    }
}


}
