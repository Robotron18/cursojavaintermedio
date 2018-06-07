

public class Alumno extends Persona{
	private int legajo;
	
	public Alumno(){
		
	}

	public Alumno(int legajo, String nombre, String apellido, Long dni) {
		super();
		super.setNombre(nombre);
		super.setApellido(apellido);
		super.setDni(dni);
		this.legajo = legajo;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		
		return "Alumno [legajo=" + legajo + "," + super.toString() + "]";
	}

	
	
	
	
	
}
