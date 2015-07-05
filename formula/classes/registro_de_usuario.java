/**
 * @(#)registro_de_usuario.java
 *
 *
 * @author Hernan Alonso Ortega
 * @version 1.00 2013/11/23
 */

//Bloque Libreria
import javax.swing.*;//@Param " Swing" es la libreria de componentes grÃ¡ficos*/
import java.util.*;//@Param "Util" es la libreria de utilidades, como fechas, horas, perifericos*/
import java.awt.event.*;//@param "event" libreria para eventos del sistema(algo que se va a ejecutar)*/
import java.awt.*;//Libreria de acciones(algo que se ejecuta)*/


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

public class registro_de_usuario implements ActionListener {

	JFrame Ventana;
	JLabel jlcorreo,jlusuario, jlcontraseña,jlfondo;//Estos son los LABEL
	JTextField jtusuario;//Estos son los TEXTBOX
	JPasswordField jpcontraseña;
	JTextField jtcorreo;
    JButton jbguardar;//@param  "JButton" parametro par crear botones*/
    JButton jbeliminar;
    JButton jbconsultar;
    JButton jbmodificar;
    ImageIcon Fondo;
	Mat mat;


	 //@param 	"Vector" parametro para buscar//
 	Vector DatosConsulta,NomColumnas;
 	JPanel VentanaBuscar;
 	JTable TablaBuscar;
 	DefaultTableModel ModeloDatos;
 	JScrollPane panelBarra;
 	///////

    public static void main(String[] args)
	{
		new registro_de_usuario();
	}

	//Este es el CONSTRUTOR
    public registro_de_usuario()
    {
    	//Construimos los elementos para la ventana de registro*/
    	//Nombre de la Variable JFrame
    	Ventana=new JFrame ("REGISTRAR");

       	jlusuario=new JLabel("NOMBRE DEL USUARIO");
       	jlcorreo=new JLabel("EMAIL");
       	jtcorreo=new JTextField("");
       	jlcorreo.setToolTipText("Digite aquÃ­ su Email");
       	jbguardar=new JButton ("GUARDAR");
       	jbeliminar=new JButton ("ELIMINAR");
       	jbconsultar=new JButton ("CONSULTAR");
       	jbmodificar=new JButton("MODIFICAR");
       	jtusuario=new JTextField("");
       	jtusuario.setToolTipText("**Digite aqui su nombre de usuario**");
       	jlcontraseña=new JLabel("ContraseÃ±a");
		jpcontraseña=new JPasswordField("");
       	jpcontraseña.setToolTipText("***DIGITE AQUI SU CLAVE DE 10 DIGITOS***");
       	Fondo=new ImageIcon("imagenes\\F1.jpg");//@param "ImageIcon" Poniendo imagen de Fondo*/
       	jlfondo=new JLabel(Fondo);

		//@Param "new JPanel" parametro para crear ventana de buscar y sus medidas*/
	VentanaBuscar = new JPanel();
	VentanaBuscar.setLayout(null);
	VentanaBuscar.reshape(430,30,300,250);
    
    //@param "new Vector" vector para las columnas para el registro de diferentes usuarios*/
  	NomColumnas = new Vector();
  	NomColumnas.add("Usuario");
  	NomColumnas.add("ContraseÃ±a");
  	NomColumnas.add("Email");



  	DatosConsulta = new Vector();
	//Modelo una tabla imaginaria
  	ModeloDatos = new DefaultTableModel(DatosConsulta,NomColumnas);
  	TablaBuscar = new JTable(ModeloDatos);


  	panelBarra = new JScrollPane(TablaBuscar);
  	panelBarra.reshape(1,1,300,250);

  	VentanaBuscar.add(panelBarra);
  	Ventana.add(VentanaBuscar);
		////



       	//Le damos ubicaciÃ³n a los elementos dentro de la ventana
    	//Se puede utilizar RESHAPE o SETBOUNDS
    	jlusuario.reshape(5,5,130,25); //Las medidas se componen de X,Y,ANCHO y LARGO
		jtusuario.reshape(140,5,130,25);
		jlcontraseña.reshape(5,40,130,25);
		jpcontraseña.reshape(140,40,130,25);
		jlcorreo.reshape(5,80,130,25);
		jtcorreo.reshape(140,80,130,25);
		jbguardar.reshape (10,200,90,25);
		jbeliminar.reshape(100,200,90,25);
		jbconsultar.reshape (190,200,110,25);
		jbmodificar.reshape(300,200,100,25);
		jlfondo.reshape(0,0,900,600);    //tamaÃ±o de fondo


		//Agregamos los elementos al JFrame
		Ventana.add(jlusuario);
		Ventana.add(jtusuario);
		Ventana.add(jlcontraseña);
		Ventana.add(jpcontraseña);
		Ventana.add(jlcorreo);
		Ventana.add(jtcorreo);
		Ventana.add(jbguardar);
		Ventana.add(jbeliminar);
		Ventana.add(jbconsultar);
		Ventana.add(jbmodificar);
		Ventana.add(jlfondo);

         //@Param "this" activamos los botones de la ventata*/
		jbguardar.addActionListener(this);
		jbeliminar.addActionListener(this);
		jbconsultar.addActionListener(this);
		jbmodificar.addActionListener(this);




		//@Param "resize" Comando para poner el tamaÃ±o de la ventana*/
		Ventana.resize(900,600);
		//@Param "setLocationRelativeTo" comando para centrar la Ventana*/
		Ventana.setLocationRelativeTo(null);
		//@Param "setResizable" comando para bloquear el tamaÃ±o de la ventana, lo deja fijo*/
		Ventana.setResizable(false);
		//Comando para saber que el diseÃ±ador de todo soy yo
		Ventana.setLayout(null);
		Ventana.getContentPane().setBackground(Color.white);
		Ventana.show();
		mat=new Mat();

    }





    public void actionPerformed(ActionEvent ev)
    {


    	if(ev.getSource()==jbguardar)
    	{

    		if(jtusuario.getText().equals("")){
   				JOptionPane.showMessageDialog(null,"Usuario requerido");//mensaje informativo*/
   			}
   			else{
   			this.guardar();
   			this.Consultar();

   			}

    	}


    		if(ev.getSource()==jbeliminar)

	    	{
	    		//@Param this funciones de botones de la ventana registro de usuario*/
	    		this.Eliminar();
	    		this.Consultar();
	    		this.Nuevo();
	    	}



	    	if(ev.getSource()==jbconsultar)

	    	{
	    		this.Buscar();
	    	}



	    	if(ev.getSource()==jbmodificar)
	    	{
	    		this.GuardarCambios();
	    		this.Consultar();
	    		this.Nuevo();
	    	}




    }





	void Buscar(){
   		String[] r;
   		r = new String[3];
   		r = mat.BuscarRegistro(JOptionPane.showInputDialog("Ingrese Usuario")); //Mensaje informativo*/
   		if(r!=null){
   			jtusuario.setText(r[0]);
   			jpcontraseña.setText(r[1]);
   			jtcorreo.setText(r[2]);



   		}
   	}


    void guardar(){
   		try{
	   		String Usuario = jtusuario.getText();
	   		String Contrasena= jpcontraseña.getText();
	   		String Email=jtcorreo.getText();


	   		mat.InsetarRegistro(Usuario,Contrasena,Email);
	   		this.Nuevo();

   		}catch(Exception e){
   			System.out.println("Error al listar los datos"+e.getMessage());
   		}


   	}

    void Nuevo()
    {
    	jtusuario.setText("");
    	jpcontraseña.setText("");
    	jtcorreo.setText("");
    }


//Parametro para modificar datos de ususrio*/
	void GuardarCambios()//Modificar
	{

			String Usuario = jtusuario.getText();
	   		String Contrasena= jpcontraseña.getText();
	   		String Email=jtcorreo.getText();

	   		mat.ModificarRegistro(Usuario,Contrasena,Email);



	}
//@param para consultar datos de usuario*/
    void Consultar(){
    	try {
    			String[][] Regi;
    			Regi = new String[100][3];
    			Regi=mat.ConsultaRegistro();
    			//@param "removeAllElements" remueve los elementos existentes de la matriz*/
 				DatosConsulta.removeAllElements();
    			for (int i = 0; i<100; i++){

    					Vector fila = new Vector();
    					fila.add(Regi[i][0]);
    					fila.add(Regi[i][1]);
    					fila.add(Regi[i][2]);

    					DatosConsulta.add(fila);


    			}

			ModeloDatos.setDataVector(DatosConsulta,NomColumnas);
			ModeloDatos.fireTableStructureChanged();

		}
		catch(Exception ex){
			System.out.print(ex);
		}
   	}

//@Param "JOptionPane" elimina el usuario que se desee*/
   	void Eliminar(){
   		mat.EliminarRegistro(JOptionPane.showInputDialog("Ingrese el Usuario a eliminar"));
   	}




    }

