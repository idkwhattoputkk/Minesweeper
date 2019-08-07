/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package modelo;

import java.util.Random;

public class Buscaminas {


	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel principiante
	 */
	public static final int FILAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel intermedio
	 */
	public static final int FILAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel experto
	 */
	public static final int FILAS_EXPERTO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel principiante
	 */
	public static final int COLUMNAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel intermedio
	 */
	public static final int COLUMNAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel experto
	 */
	public static final int COLUMNAS_EXPERTO = 30;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel principiante
	 */
	public static final int PRINCIPIANTE = 1;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel intermedio
	 */
	public static final int  INTERMEDIO = 2;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel experto
	 */
	public static final int EXPERTO = 3;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel principiante
	 */
	public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel 
	 */
	public static final int CANTIDAD_MINAS_ = 40;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel experto
	 */
	public static final int CANTIDAD_MINAS_EXPERTO = 99;

	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------

	/**
	 * Relacion que tiene la matriz de casillas
	 */
	private Casilla[][] casillas;

	/**
	 * Atributo que representa el nivel del juego <Solo puede tomar valores PRINCIPIANTE, , EXPERTO>
	 */
	private int nivel;

	/**
	 * Atributo que tiene la cantidad de minas en el tablero
	 */
	private int cantidadMinas;

	/**
	 * Atributo que representa si el usuario perdio al abrir una mina
	 */
	private boolean perdio;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructo de la clase Buscaminas
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		inicializarPartida();

	}


	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a partir del nivel elegido por el usuario
	 */
	private void inicializarPartida() {

		if(nivel == PRINCIPIANTE) {
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			cantidadMinas = CANTIDAD_MINAS_PRINCIPANTE;
		}
		else if (nivel==INTERMEDIO) {
			casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
			cantidadMinas = CANTIDAD_MINAS_;
		}
		else if(nivel==EXPERTO) {
			casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
			cantidadMinas = CANTIDAD_MINAS_EXPERTO;
		}
		inicializarCasillasLibres();
		generarMinas();
		

	}


	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {
		for(int i=0;i<casillas.length;i++) {
			for(int j=0;j<casillas[i].length;j++) {
				Casilla c = new Casilla(50);
				casillas[i][j]=c;
			}
		}

	}


	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una casillas
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int i, int j) {
		int flag=0;
		if(nivel==PRINCIPIANTE) {
			if(!casillas[i][j].esMina()) {
				if(i!=0 && j!=0 && i!=FILAS_PRINCIPIANTE-1 && j!= COLUMNAS_PRINCIPIANTE-1) {
					if(casillas[i][j-1].esMina())
						flag++;
					if(casillas[i-1][j-1].esMina())
						flag++;
					if(casillas[i+1][j-1].esMina()) 
						flag++;
					if(casillas[i][j+1].esMina())
						flag++;
					if(casillas[i+1][j+1].esMina())
						flag++;
					if(casillas[i-1][j+1].esMina())
						flag++;
					if(casillas[i+1][j].esMina())
						flag++;
					if(casillas[i-1][j].esMina())
						flag++;
					}
				}
			if(flag==0) {
				flag=1;
			}
		}else if(nivel==INTERMEDIO) {
			if(!casillas[i][j].esMina()) {
				if(i!=0 && j!=0 && i!=FILAS_INTERMEDIO-1 && j!= COLUMNAS_INTERMEDIO-1) {
					if(casillas[i][j-1].esMina())
						flag++;
					if(casillas[i-1][j-1].esMina())
						flag++;
					if(casillas[i+1][j-1].esMina()) 
						flag++;
					if(casillas[i][j+1].esMina())
						flag++;
					if(casillas[i+1][j+1].esMina())
						flag++;
					if(casillas[i-1][j+1].esMina())
						flag++;
					if(casillas[i+1][j].esMina())
						flag++;
					if(casillas[i-1][j].esMina())
						flag++;
				}
				if(flag==0) {
					flag=1;
				}
		}
		}else if (nivel == EXPERTO){
			if(!casillas[i][j].esMina()) {
				if(i!=0 && j!=0 && i!=FILAS_EXPERTO-1 && j!= COLUMNAS_EXPERTO-1) {
					if(casillas[i][j-1].esMina())
						flag++;
					if(casillas[i-1][j-1].esMina())
						flag++;
					if(casillas[i+1][j-1].esMina()) 
						flag++;
					if(casillas[i][j+1].esMina())
						flag++;
					if(casillas[i+1][j+1].esMina())
						flag++;
					if(casillas[i-1][j+1].esMina())
						flag++;
					if(casillas[i+1][j].esMina())
						flag++;
					if(casillas[i-1][j].esMina())
						flag++;
				}
				if(flag==0) {
					flag=1;
				}
		}
		}
		return flag++;
	}
	
	/**
	 * M�todo que se encarga de generar aleatoriomente las minas
	 */
	public void generarMinas() {
		int minesPlaced = 0;
	    Random random = new Random();
	    
		if(nivel==PRINCIPIANTE) {
		    while(minesPlaced < cantidadMinas) {
		      int x = random.nextInt(FILAS_PRINCIPIANTE);
		      int y = random.nextInt(COLUMNAS_PRINCIPIANTE);
		      Casilla ca = new Casilla(100);
		      if(casillas[y][x].esMina()!=true){
		        casillas[y][x]=ca;
		        minesPlaced ++;
		    }
		    }
		}else if(nivel==INTERMEDIO) {
		    while(minesPlaced < cantidadMinas) {
		      int x = random.nextInt(COLUMNAS_INTERMEDIO);
		      int y = random.nextInt(FILAS_INTERMEDIO);
		      Casilla ca = new Casilla(100);
		      if(casillas[y][x].esMina()!=true){
		        casillas[y][x]=ca;
		        minesPlaced ++;
		      }
		    }
		}else if(nivel==EXPERTO){
		    while(minesPlaced < cantidadMinas) {
		      int x = random.nextInt(COLUMNAS_EXPERTO);
		      int y = random.nextInt(FILAS_EXPERTO);
		      Casilla ca = new Casilla(100);
		      if(!casillas[y][x].esMina()){
		        casillas[y][x]=ca;
		        minesPlaced ++;
		      }
		    }
		}
		
	}


	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en pantalla
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {

		String minesweeper  =" ";
		String num=" ";
		for(int h=0;h<casillas.length;h++)
		{
			if(h<10)
			{
				minesweeper+=" "+h+" ";
			}
			else
			{
				minesweeper+=h+" ";
			}
			for(int k=0;k<casillas[h].length;k++)
			{
			casillas[h][k].modificarValor(cantidadMinasAlrededor(h,k));
			minesweeper+=(" "+casillas[h][k].mostrarValorCasilla()+" ");
			}
			minesweeper+="\n";
			minesweeper+=" ";
		}
		num+="  ";
		boolean flag = false;
		for(int i=0;i<casillas.length && flag==false ;i++)
		{
			for(int j=0;j<casillas[i].length;j++) {
			if(j<11)
			{
				num+=" "+j+" ";
			}
			else
			{
				num+= j+" ";
			}
		}
			flag=true;
		}
		num+="\n"+"  ";
		num += " "+" \n"+ minesweeper;
		return num;
	}


	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {

		for(int i=0;i<casillas.length;i++) {
			for(int j=0;j<casillas[i].length;j++) {
				casillas[i][j].destapar();
			}
		}

	}

	/**
	 * Metodo dar del atributo casillas
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas(){
		return casillas;
	}


	/**
	 * Este metodo se encargaa de abrir una casilla
	 * Si se abre una casilla de tipo Mina, se marca que el jugador perdio el juego.
	 * @param i - la fila donde esta la casilla 
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int i, int j) {
		boolean flag = false;
		if(casillas[i][j].darValor()==100) {
			casillas[i][j].destapar();
			perdio = true;
			flag= true;
		}else if(casillas[i][j]==null) {
			flag=false;
		}else {
			casillas[i][j].destapar();
			flag=true;
		}
		return flag;
	}


	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		//TODO
		return true;
	}


	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo valor sea Mayor que 0
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber casillas posibles para dar una pista, retorna el mensaje no hay pistas para dar
	 */
	public String darPista() {
		String nhull="";
		boolean stop=false;
		for (int i=0;i<casillas.length;i++) {
			for(int j=0;j<casillas[i].length;j++) {
				if(!casillas[i][j].esMina() && casillas[i][j].darSeleccionada()!=true && stop==false) {
					casillas[i][j].destapar();
					nhull=" "+ casillas[i][j].darValor()+" "+"La fila es: "+i+" la columna es: "+j+" ";
					stop=true;
				}else {
					nhull="no hay pistas para dar";
			}
			}
		}
		return nhull;
	}
	
	/***
	 * Metodo dar del atributo perdio
	 * @return boolean el atributo
	 */
	public boolean darPerdio(){
		return perdio;
	}

}