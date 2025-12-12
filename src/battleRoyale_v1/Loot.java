package battleRoyale_v1;

public abstract class Loot {

    protected String nombreLoot;
    protected TipoLoot tipoLoot;

    public Loot(String nombre, TipoLoot tipo) {
        this.nombreLoot = nombre;
        this.tipoLoot = tipo;
    }

    public String getNombre() {
        return nombreLoot;
    }

    public TipoLoot getTipo() {
        return tipoLoot;
    }

    // Método que se aplicará al personaje al recoger el loot
    public abstract void aplicar(Personaje p);
}
