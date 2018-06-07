
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PersonalNoDocente extends Persona  implements TiempoTrabajo {
	private LocalTime horadeingreso;
	private LocalTime horadeegreso;
	private int padron;
	
public PersonalNoDocente() {
	
}

public int getPadron() {
	return padron;
}
@Override
public String toString() {
	return "Profesor [padron=" + padron + ", " + super.toString() + "] y trabajo "+ new DecimalFormat("#.##").format(horasdetrabajo()) /*00horasdetrabajo()*/+" horas";
}
public LocalTime getHoradeingreso() {
	return horadeingreso;
}

public void setHoradeingreso(LocalTime horadeingreso) {
	this.horadeingreso = horadeingreso;
}

public LocalTime getHoradeegreso() {
	return horadeegreso;
}

public void setHoradeegreso(LocalTime horadeegreso) {
	this.horadeegreso = horadeegreso;
}

public void setPadron(int padron) {
	this.padron = padron;
}

public PersonalNoDocente(int padron, String nombre, String apellido, Long dni) {
	super();
	super.setNombre(nombre);
	super.setApellido(apellido);
	super.setDni(dni);
	this.padron = padron;
}

public void cargaHoras(LocalTime horadeingreso, LocalTime horadeegreso) {
	this.horadeingreso=horadeingreso;
	this.horadeegreso=horadeegreso;
}

@Override
public double horasdetrabajo() {
	Long l=new Long(ChronoUnit.MINUTES.between( horadeingreso, horadeegreso));
	
	return l.doubleValue()/60;
	
	
}
}
