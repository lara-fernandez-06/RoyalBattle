package battleRoyale_v1;

public final class ArmaNotExistException extends Exception{
	
	//Constructor
	public ArmaNotExistException() {
		super("Este tipo de arma no existe");
	}
}
