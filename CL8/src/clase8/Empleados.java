package clase8;

import java.time.LocalDate;

public class Empleados {
   private String nombre;
   private String apellido;
   private int sueldobasico;
   private LocalDate fechadenacimiento;

   public Empleados(){
	   
   };
   
public Empleados(String nombre, String apellido, int sueldobasico) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.sueldobasico = sueldobasico;
}

public int getSueldo() {
	return sueldobasico;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public void setfechadenacimiento(LocalDate fechadenacimiento) {
	this.fechadenacimiento=fechadenacimiento;
}

public LocalDate getFechadenacimiento() {
	return fechadenacimiento;
}

public void setFechadenacimiento(LocalDate fechadenacimiento) {
	this.fechadenacimiento = fechadenacimiento;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getSueldobasico() {
	return sueldobasico;
}

public void setSueldobasico(int sueldobasico) {
	this.sueldobasico = sueldobasico;
}
   
}
