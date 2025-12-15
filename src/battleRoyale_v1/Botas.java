package battleRoyale_v1;

public class Botas extends Loot {

	public Botas(String nombre, TipoLoot tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void aplicar(Personaje p) {
       p.setPasos(p.getPasos() + 1); //aumenta los pasos en 15
    }

}
