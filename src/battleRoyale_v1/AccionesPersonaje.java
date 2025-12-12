package battleRoyale_v1;

public interface AccionesPersonaje {
	
	public void atacar(Personaje enemigo);
	public void quitarVida(int dmg);
	public boolean checkBuff();
	public void checkSurroundings(Tablero tablero);
	
}
