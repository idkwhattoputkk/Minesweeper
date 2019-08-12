package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;

public class BuscaminaTest {

	private Buscaminas buscaminas;
	
	public void setupScenary1() {
		 Random r =new Random();
		 int randomize = r.nextInt(2);
		 if(randomize==0) {
			 randomize=1;
		 }
		 buscaminas = new Buscaminas(randomize);
		 buscaminas.inicializarCasillasLibres();
	}
	public void setupScenary2() {
		Random r =new Random();
		 int randomize = r.nextInt(3);
		 if(randomize>0) {
		 buscaminas = new Buscaminas(randomize);
		 }
	}
	@Test
	public void testInicializarCasillasLibre1() {
		setupScenary1();
		for(int i=0;i<buscaminas.darCasillas().length;i++) {
			for(int j=0;j<buscaminas.darCasillas()[i].length;j++) {
				assertTrue(!buscaminas.darCasillas()[i][j].esMina());
			}
		}
	}
	@Test
	public void testInicializarCasillasLibre2() {
		setupScenary1();
		for(int i=0;i<buscaminas.darCasillas().length;i++) {
			for(int j=0;j<buscaminas.darCasillas()[0].length;j++) {
				assertEquals(buscaminas.darCasillas()[i][j].mostrarValorCasilla(), "-");
				}
			}
		}
	@Test
	public void testInicializarCasillasLibre3() {
		setupScenary1();
		for(int i=0;i<buscaminas.darCasillas().length;i++) {
			for(int j=0;j<buscaminas.darCasillas()[0].length;j++) {
				assertFalse(buscaminas.darCasillas()[i][j].darSeleccionada());
				}
			}
		}
}
