


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class BaseDatosEscuelas {
	final static int ALUMNO=0;
	final static int PROFESOR=1;
	final static int PND=2;
	final static int CANCELAR=3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] options = {"Alumno",
							"Profesor",
							"Personal no Docente",
							"Cancelar"};
		
		
		ArrayList <Persona> lista= new ArrayList<Persona>();
		
		int opcion;
		Alumno alumnoprovisorio;
		Profesor profesorprovisorio;
		PersonalNoDocente pndprovisorio;
		

		opcion=JOptionPane.showOptionDialog(null, "Desea ingresar un Profesor,pnd o un alumno?", "Lalala", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
		
		while(opcion!=CANCELAR) {
			if(opcion==ALUMNO) {
				alumnoprovisorio= new Alumno();
				cargagenerica(alumnoprovisorio);
				alumnoprovisorio.setLegajo(retornaNumero("ingresa el numero de Legajo"));
				lista.add(alumnoprovisorio);
				JOptionPane.showMessageDialog(null, "Entrada agregada!");
				
				}

			if(opcion==PROFESOR) {
				profesorprovisorio= new Profesor();
				cargagenerica(profesorprovisorio);
				profesorprovisorio.setPadron(retornaNumero("ingresa el numero de Padron"));
				profesorprovisorio.setHoradeingreso(retornahora("pone la hora de ingreso,  en formato HH:MM"));
				profesorprovisorio.setHoradeegreso(retornahora("pone la hora de egreso,  en formato HH:MM"));
				lista.add(profesorprovisorio);
				JOptionPane.showMessageDialog(null, "Entrada agregada!");
			}
			
			if(opcion==PND) {
				pndprovisorio= new PersonalNoDocente();
				cargagenerica(pndprovisorio);
				pndprovisorio.setPadron(retornaNumero("ingresa el numero de Padron"));
				pndprovisorio.setHoradeingreso(retornahora("pone la hora de ingreso,  en formato HH:MM"));
				pndprovisorio.setHoradeegreso(retornahora("pone la hora de egreso,  en formato HH:MM"));
				lista.add(pndprovisorio);
				JOptionPane.showMessageDialog(null, "Entrada agregada!");
			}
						
			opcion=JOptionPane.showOptionDialog(null, "Desea ingresar un Profesor, pnd o un alumno?", "Lalala", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
		}
		
		if(JOptionPane.showConfirmDialog(null, "Desea mostrar la lista completa?", null, 0)==0) {
			for(int i=0; i<lista.size();i++) {
				System.out.println(lista.get(i).toString());			
			}
	}
	}

public static void cargagenerica(Persona coso) {
		coso.setNombre(JOptionPane.showInputDialog( "Ingrese el nombre"));
		coso.setApellido(JOptionPane.showInputDialog( "Ingrese el apellido"));
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
	
public static LocalTime retornahora(String Texto) {
		LocalTime hora;
		while(true){
			try{
				hora=(LocalTime.parse(JOptionPane.showInputDialog(Texto),DateTimeFormatter.ofPattern("HH:mm")));
			    break;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "pone solo en formato HH:MM", "ta todo mal", JOptionPane.WARNING_MESSAGE, null);				
			}
		}
		return hora;
}
	
	
	
}
