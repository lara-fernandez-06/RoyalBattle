package battleRoyale_v1;

public class PersonajeNotExistException extends Exception{
	
	public PersonajeNotExistException() {
		super("Este tipo de personaje no existe");
	}
}
