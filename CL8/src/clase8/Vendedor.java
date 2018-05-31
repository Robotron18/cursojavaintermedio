package clase8;

public class Vendedor extends Empleados {
	private int CantidadDeVentas;
	private int porcentajeComision;
	

	
	public Vendedor() {
		
	};
	
	public void setPorcentajeComision(int porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}
	
	public void setCantidadDeVentas(int cantidadDeVentas) {
		this.CantidadDeVentas = cantidadDeVentas;
		
	}

    @Override
	public int getSueldo() {
    	double totalextras= this.CantidadDeVentas*porcentajeComision/100;
	    int totalbasico=super.getSueldobasico();
	    return (int)(totalextras + totalbasico);
	}
}
