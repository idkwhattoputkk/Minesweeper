package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;

public class BuscaminaTest {

	private Buscaminas buscaminas;
	
	public void setupScenary1() {
		Buscaminas buscaminas = new Buscaminas(1);
		
	}
	public void setupScenary2() {
		Buscaminas buscaminas = new Buscaminas(2);
	}
	public void setupScenary3() {
		Buscaminas buscaminas = new Buscaminas(3);
	}

}
