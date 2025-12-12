package battleRoyale_v1;

public abstract class Arma {
	
	//Atributos
	private TipoArma tipoArma;
	private int dmg;
	//private int checkingCOSITAS;
	private int rango;
	private int attackChance;
	public int id;
	
	//Constructor
	public Arma(TipoArma tipoArma, int dmg, int rango) {
		this.tipoArma = tipoArma;
		this.dmg = dmg;
		this.rango = rango;
		this.attackChance = 0;
		this.id = tipoArma.getId();
	}
	
	//toString
	@Override
	public String toString() {
		return this.tipoArma.toString();
	}
	
	//Getters y Setters
	public int getDmg() {
		return dmg;
	}
}
