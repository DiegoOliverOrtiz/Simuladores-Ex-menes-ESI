public class Pregunta {
	private String cuestion;
	private char solucion;
	private String cuestion1;
	private String cuestion2;
	private String cuestion3;
	private String cuestion4;
    private int indiceSeleccionado = -1; // -1 significa que no se ha seleccionado nada
    private boolean respondidaCorrectamente = false;
	
	public Pregunta(String cuestion, String cuestion1, String cuestion2, String cuestion3, String cuestion4, String solucion) {
		this.cuestion = cuestion;
		this.cuestion1 = cuestion1.trim();
		this.cuestion2 = cuestion2.trim();
		this.cuestion3 = cuestion3.trim();
		this.cuestion4 = cuestion4.trim();
		solucion=solucion.trim();
		this.solucion = solucion.charAt(solucion.length()-1);
		
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

	public char getSolucion() {
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

    
	@Override
	public String toString() {
		return "Pregunta [cuestion=" + cuestion + ", solucion=" + solucion + ", cuestion1=" + cuestion1 + ", cuestion2="
				+ cuestion2 + ", cuestion3=" + cuestion3 + ", cuestion4=" + cuestion4+ "]";
	}
    
    
}
