package battleRoyale_v1;

public abstract class Arma {
	
	//Atributos
	private TipoArma tipoArma;
	private int dmg;
	//private int checkingCOSITAS;
	private int rango;
	private int attackChance;
	
	//Constructor
	public Arma(TipoArma tipoArma, int dmg, int rango) {
		this.tipoArma = tipoArma;
		this.dmg = dmg;
		this.rango = rango;
		this.attackChance = 0;
	}
}
