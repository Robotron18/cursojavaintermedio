package clase8;

public class Programador extends Empleados{
private int bonoPorHoraExtra;
private int horasExtras;


public Programador() {
	
}

public int getBonoPorHoraExtra() {
	return bonoPorHoraExtra;
}

public void setBonoPorHoraExtra(int bonoPorHoraExtra) {
	this.bonoPorHoraExtra = bonoPorHoraExtra;
}

public void setHorasExtras(int horasExtras) {
	this.horasExtras = horasExtras;
	
}

@Override
public int getSueldo() {
	  int totalextras= bonoPorHoraExtra*this.horasExtras;
      int totalbasico=super.getSueldobasico();
      return totalextras + totalbasico;
      
}


}
