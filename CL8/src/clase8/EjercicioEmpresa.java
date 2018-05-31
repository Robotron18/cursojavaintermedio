package clase8;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjercicioEmpresa {
	
	final static int PROGRAMADOR=0;
	final static int VENDEDOR=1;
	final static int CANCELAR=2;
	
	public static void main(String[] args) {
		
		ArrayList <Empleados> lista= new ArrayList<Empleados>();
		
		cargaempleados(lista);
		calculosueldos(lista);
		
	}
	
	public static void cargaempleados(ArrayList<Empleados> Empleados) {
		Object[] options = {"Programador",
                "Vendedor",
                "Cancelar"};
		int opcion;
		Programador progprovisorio;
		Vendedor venprovisorio;
		opcion=JOptionPane.showOptionDialog(null, "Elegi que tipo de empleado ingresar", "Lalala", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
				//0 es programador
				//1 es vendedor
				//4 es cancelar
		while(opcion!=CANCELAR) {
			if(opcion==PROGRAMADOR) {
				progprovisorio=new Programador();
				cargagenerica(progprovisorio);
				progprovisorio.setHorasExtras(retornaNumero( "Ingrese la cantidad de horas extra"));
				progprovisorio.setBonoPorHoraExtra(retornaNumero( "Ingrese el bono por hora extra"));
				Empleados.add(progprovisorio);
			    }
			if(opcion==VENDEDOR) {
		        venprovisorio= new Vendedor();
		        cargagenerica(venprovisorio);			
		        venprovisorio.setCantidadDeVentas(retornaNumero( "Ingrese el monto total de ventas"));
		        venprovisorio.setPorcentajeComision(retornaNumero( "Ingrese el porcentaje de comision por ventas"));
				Empleados.add(venprovisorio);
				}
			JOptionPane.showMessageDialog(null, "Entrada agregada!");
			opcion=JOptionPane.showOptionDialog(null, "Elegi que tipo de empleado ingresar", "Lalala", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		}
		
	}
	
	
	public static void calculosueldos(ArrayList<Empleados> Empleados) {
		int totalsueldos=0;
		int sueldomenor=0;
		int posicionmenorsueldo=0;
		Empleados varLocal;
		sueldomenor= Empleados.get(posicionmenorsueldo).getSueldo();
		
		if(JOptionPane.showConfirmDialog(null, "Desea mostrar la lista completa?", null, 0)==0) {
			for(int i=0; i<Empleados.size();i++)/*Empleados varLocal:Empleados)/**/ {
				varLocal=Empleados.get(i);
				System.out.println("El sueldo que corresponde a "+ varLocal.getNombre()+" "+varLocal.getApellido()+" es: "+varLocal.getSueldo()
				                  +". Su fecha de nacimiento es "+varLocal.getFechadenacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
									+". Su edad es de "+ChronoUnit.YEARS.between( varLocal.getFechadenacimiento(), LocalDate.now())+" Años");
                totalsueldos=totalsueldos+varLocal.getSueldo();
                if(varLocal.getSueldo()<sueldomenor) {
                	sueldomenor=varLocal.getSueldo();
                	posicionmenorsueldo=i;
                }
			}
			System.out.println("El monto total de sueldos es de: "+ totalsueldos);
			varLocal=Empleados.get(posicionmenorsueldo);
			System.out.println("El sueldo menor es de: "+sueldomenor+" y corresponde a: " + varLocal.getNombre()+" "+varLocal.getApellido());
		}
	}
	
	
	public static void cargagenerica(Empleados coso) {
		
		
		LocalDate fechaprovisoria;
		coso.setNombre(JOptionPane.showInputDialog( "Ingrese el nombre"));
		coso.setApellido(JOptionPane.showInputDialog( "Ingrese el apellido"));
		
		while(true){
			try{
				fechaprovisoria=LocalDate.parse(JOptionPane.showInputDialog( "Ingrese la fecha de nacimiento dd/MM/YYYY"), DateTimeFormatter.ofPattern("dd/MM/yyyy") );

			    break;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "pone bien la fecha! dd/MM/YYYY", "ta todo mal", JOptionPane.WARNING_MESSAGE, null);				
			}
		}
		coso.setfechadenacimiento(fechaprovisoria);
		coso.setSueldobasico(retornaNumero("Ingrese el sueldo basico"));
		
	}
	
	public static int retornaNumero(String Texto) {
		int numero;
		while(true){
			try{
				numero=(Integer.parseInt(JOptionPane.showInputDialog( Texto)));
			    break;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "pone solo numeros", "ta todo mal", JOptionPane.WARNING_MESSAGE, null);				
			}
		}
		return numero;
	}
}
