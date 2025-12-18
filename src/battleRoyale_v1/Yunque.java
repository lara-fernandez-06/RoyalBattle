package battleRoyale_v1;

public class Yunque extends Loot {

	public Yunque(String nombre, TipoLoot tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicar(Personaje p) {
	    p.getArma().setDmg(p.getArma().getDmg() + 5); //+5 de daño
	}

}

