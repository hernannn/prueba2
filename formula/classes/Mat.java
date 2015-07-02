/**
 * @(#)Mat.java
 *
 *
 * @author Hernan Alonso Ortega 
 * @version 1.00 2013/11/23
 */
/**
 *importar lbrerias
 * @param swing es la libreria para componentes graficos*/
 //@param util es la libreria que sirve como para la fecha, hora*/
 

import java.util.*;
import javax.swing.*;

public class Mat { //Este es el nombre de la clase*/


	public String[][] Registro;
	int InRegistro=0;

    public Mat() {

//@param "String" es el segistro de usuario*/
    		Registro = new String [100][3];
    }



      public void InsetarRegistro(String Usuario,String Contrasena,String Email){
    	int sw=0;

    	for (int i = 0; i<100; i++){
    		if(Usuario.equals(Registro[i][0])){
    			JOptionPane.showMessageDialog(null,"Usuario ya existente");//mensaje para cunado se esta registrando usuario ya exixtente*/
    			sw=1;
				break;
    		}
    	}
    	if(sw==0){
    		//@Param "InRegistro" parametro de registro de ususrios*/
	    	Registro[InRegistro][0]=Usuario;
	    	Registro[InRegistro][1]=Contrasena;
	    	Registro[InRegistro][2]=Email;

	    	InRegistro++;
    	}

    }



     public void EliminarRegistro(String Usuario){// comando si se decea eliminar un usuario*/
    	int i,sw=0;
    	for (i=0;i<100;i++){
    		if(Usuario.equals(Registro[i][0])){
    			sw=1;
    			for (int j = 0; j<3; j++) {
					Registro[i][j]=null;
				}
				break;
    		}
    	}

    	for (int n=i; n<100-1; n++){
    		for (int j = 0; j<2; j++){
    			Registro[n][j]=Registro[n+1][j];
    		}
    	}

    	if(sw==0){
    		//@param JOptionPane parametro cuando no se encuentra registro de usuario*/ 
    		JOptionPane.showMessageDialog(null,"No se encontro el Registro");
    	}


    }


     //* @param "public String" parametro para buscar registro de usuario*/
	 public String[] BuscarRegistro(String Usuario){
    	int i=0,sw=0;
    	String[] r;
    	r = new String [3];
    	for (i=0;i<100;i++){
    		if(Usuario.equals(Registro[i][0])){
				sw=1;
    			for (int j = 0; j<3 ; j++) {
					r[j]=Registro[i][j];
				}
    		}
    	}
    	if(sw==0){
    		//@Param "showMessageDialog" mensage informativo*/
    		JOptionPane.showMessageDialog(null,"No se encontro el Registro");
    		return null;
    	}
    	return r;
    }


//@param String parametro para modificar registro*/
 public void ModificarRegistro(String Usuario,String Contrasena,String Email){

	    for (int i = 0; i<100; i++){
    		if(Usuario.equals(Registro[i][0])){

	    		Registro[i][1]=Contrasena;



    		}
    	}


    }

    // @param "public String" parametro de consulta registro de usuario*
     public String[][] ConsultaRegistro(){
    	return Registro;
    }


}