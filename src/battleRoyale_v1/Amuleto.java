package battleRoyale_v1;

public class Amuleto extends Loot {

	public Amuleto(String nombre, TipoLoot tipo) {
		super(nombre, tipo);
	}

	@Override
	public void aplicar(Personaje p) {
	    p.getArma().setRango(p.getArma().getRango() + 1); //+1 en rango
	}

}
