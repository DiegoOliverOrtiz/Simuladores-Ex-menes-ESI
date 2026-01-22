package testsSSOO;

import java.util.ArrayList;
import java.util.Collections;

public class Pregunta {
	private String cuestion;
	private String solucion;
	private String cuestion1;
	private String cuestion2;
	private String cuestion3;
	private String cuestion4;
	private String cuestion5;
    private int indiceSeleccionado = -1; // -1 significa que no se ha seleccionado nada
    private boolean respondidaCorrectamente = false;
	
	public Pregunta(String cuestion, String solucion, String cuestion1, String cuestion2, String cuestion3, String cuestion4, String cuestion5) {
		this.cuestion = cuestion;
		this.solucion = solucion.trim();
		this.cuestion1 = cuestion1.trim();
		this.cuestion2 = cuestion2.trim();
		this.cuestion3 = cuestion3.trim();
		this.cuestion4 = cuestion4.trim();
		this.cuestion5 = cuestion5.trim();
	}
	
	// Getters y setters para los nuevos atributos
    public int getIndiceSeleccionado() {
        return indiceSeleccionado;
    }

    public void setIndiceSeleccionado(int indiceSeleccionado) {
        this.indiceSeleccionado = indiceSeleccionado;
    }

    public boolean isRespondidaCorrectamente() {
        return respondidaCorrectamente;
    }

    public void setRespondidaCorrectamente(boolean respondidaCorrectamente) {
        this.respondidaCorrectamente = respondidaCorrectamente;
    }
    
	public String getCuestion() {
		return cuestion;
	}

	public String getSolucion() {
		return solucion;
	}

	public String getCuestion1() {
		return cuestion1;
	}

	public String getCuestion2() {
		return cuestion2;
	}

	public String getCuestion3() {
		return cuestion3;
	}

	public String getCuestion4() {
		return cuestion4;
	}

	public String getCuestion5() {
		return cuestion5;
	}
	
    public void reorganizar() {
    	if(cuestion5.equals("-")) {
    		// Crear una lista con las opciones
    		ArrayList<String> opciones = new ArrayList<>();
    		opciones.add(cuestion1);
    		opciones.add(cuestion2);
    		opciones.add(cuestion3);
    		opciones.add(cuestion4);
    		
    		// Reorganizar las opciones de forma aleatoria
    		Collections.shuffle(opciones);

    		// Actualizar los atributos con el nuevo orden
    		cuestion1 = opciones.get(0);
    		cuestion2 = opciones.get(1);
    		cuestion3 = opciones.get(2);
    		cuestion4 = opciones.get(3);
    	}
    	
    	else {
    		// Crear una lista con las opciones
    		ArrayList<String> opciones = new ArrayList<>();
    		opciones.add(cuestion1);
    		opciones.add(cuestion2);
    		opciones.add(cuestion3);
    		opciones.add(cuestion4);
    		opciones.add(cuestion5);

    		// Reorganizar las opciones de forma aleatoria
    		Collections.shuffle(opciones);

    		// Actualizar los atributos con el nuevo orden
    		cuestion1 = opciones.get(0);
    		cuestion2 = opciones.get(1);
    		cuestion3 = opciones.get(2);
    		cuestion4 = opciones.get(3);
    		cuestion5 = opciones.get(4);
    	}
    }
    
	@Override
	public String toString() {
		return "Pregunta [cuestion=" + cuestion + ", solucion=" + solucion + ", cuestion1=" + cuestion1 + ", cuestion2="
				+ cuestion2 + ", cuestion3=" + cuestion3 + ", cuestion4=" + cuestion4 + ", cuestion5=" + cuestion5
				+ "]";
	}
    
    
}
