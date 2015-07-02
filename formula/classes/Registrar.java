/**
 * @(#)Registrar.java
 *
 *
 * @author Hernan Alonso Ortega
 * @version 1.00 2013/11/12
 */

//Librerias
import javax.swing.*;//@param "Swing" es la libreria de componentes gráficos*/
import java.util.*;//@Param "Util" es la libreria de utilidades, como fechas, horas, perifericos*/
import java.awt.event.*;//@Param "awt.event" Libreria para eventos del sistema(algo que se va a ejecutar)*/
import java.awt.*;//Libreria de acciones(algo que se ejecutar)*/


public class Registrar implements ActionListener
{
	//Declaración de Variables
	JFrame Ventana;

	MenuBar barra= new MenuBar();//@Param "MenuBar" Declaramos la Barra de menu e Instanciamos*/
	//@Param "new Menu" declaramos el menu de Opciones*/
	Menu archivo= new Menu("Archivo");
	Menu editar= new Menu ("Editar");
	Menu config= new Menu ("Configuración");
	Menu ayuda= new Menu ("Ayuda");
	Menu guardar= new Menu ("Guardar");
	Menu sonido= new Menu ("Sonido");
	Menu video= new Menu ("Video");

	JLabel JLopcsexo,JLcbcalendario,jlfondo;
	/**@param JLabel para crear el el calendario para el registro*/
	
	JButton jbcerrar;
	JButton jbentrar;//Este es el BOTON
	ImageIcon Fondo;//Imagen del fondo
	ImageIcon Botonentrar;
	ImageIcon BotonCerrar;
	JComboBox Jcbmenu;//@parm "ComboBox-Menu" Declaramos un Despregable*/
	String[] opcsexo={" ","Masculino","Femenino"};//Opciones para el ComboBox*/
	JComboBox Jcbcalendario;//Declaro ComboBox de Calendario

	public static void main(String[] args)
	{
		new Registrar();
	}

	//CONSTRUTOR
    public Registrar()
    {
    	//Construimos los elementos
    	//Nombre de la Variable JFrame
    	Ventana=new JFrame ("FORMULA 1");

    	Ventana.setMenuBar(barra);//Seleccionamos la Barra de Menu

    	barra.add(archivo);//@Param  "barra.add" agregamos los menu a la barra*/
    	barra.add(editar);//Agregamos los menu a la barra
    	barra.add(config);//Agregamos los menu a la barra
    	barra.add(ayuda);//Agregamos los menu a la barra

    	archivo.add("Nuevo");//Agregamos la opción al menu archivo
    	archivo.add("Abrir");//Agregamos la opción al menu archivo

    	archivo.addSeparator();//Agregamos un SEPARADOR a las opciones del arhivo

    	archivo.add(guardar);//@Param "add" agregamos la opción guardar*/
    	guardar.add("Guardar");//Agregamos submenu a la opción guardar
    	guardar.add("Guardar como...");//Agregamos submenu a la opción guardar
    	guardar.add("Guardar Todo");//Agregamos submenu a la opción guardar

    	archivo.addSeparator();//Agregamos un SEPARADOR a las opciones del guardar

    	archivo.add("Salir");

    	editar.add("Cortar");//Agregamos la opción al menu editar*/
    	editar.add("Copiar");//Agregamos la opción al menu editar*/
    	editar.add("Pegar");//Agregamos la opción al menu editar*/

    	ayuda.add("Información");
    	ayuda.add("Acerca de...");

        //@Param "config.add" Agregamos la obsión al menu configuraciones, sonido, video*/
    	config.add(sonido);
    	config.add("Controles");
    	config.add(video);
    	config.add("Opciones");
    	sonido.add("Volumen");
    	sonido.add("Ecualizador");
    	video.add("Resolución");
    	video.add("Brillo");
    	video.add("Contraste");


       	JLopcsexo=new JLabel("GENERO");
        //@Poniendo Boton con imagen
       	Botonentrar=new ImageIcon("imagenes\\INGRE.JPG");
       	jbentrar=new JButton (Botonentrar);
        BotonCerrar=new ImageIcon("Imagenes\\CANCEL.JPG");
       	jbcerrar=new JButton (BotonCerrar);
        
        
       	JLopcsexo.setToolTipText("elija su genero");
       	JLcbcalendario=new JLabel("FECHA DE NACIMIENTO");//colocando calendario para fechas*/
       	

		JLcbcalendario.setToolTipText("elija su fecha de nacimiento");

       	Jcbmenu=new JComboBox(opcsexo);//Construimos el ComboBox menu desplegable de obsiones*/
       	Jcbcalendario=new DateComboBox();
       	Fondo=new ImageIcon("imagenes\\f1.png");//Poniendo imagen de Fondo
       	jlfondo=new JLabel(Fondo);

		/*Jcbmenu.addItem(" ");//Esta es una forma de agregar Item*Item
		Jcbmenu.addItem("Masculino");
		Jcbmenu.addItem("Femenino");*/




    	//@Param "reshape" Le damos ubicación a los elementos dentro de la Ventana*/
    	//Se puede utilizar RESHAPE o SETBOUNDS
    	JLopcsexo.reshape(5,5,130,25); //Las medidas se componen de X,Y,ANCHO y LARGO
		Jcbmenu.reshape(150,5,130,25);//Tamaño de ComboBox
		JLcbcalendario.reshape(5,40,130,25);
		Jcbcalendario.reshape(150,40,130,25);
		jbentrar.reshape (170,100,40,40);
		jbcerrar.reshape (230,100,40,40);
		jlfondo.reshape(0,0,500,200);//Tamaño del fondo




		//Agregamos los elementos al JFrame
		Ventana.add(JLopcsexo);
		Ventana.add(JLopcsexo);
		Ventana.add(JLcbcalendario);
		Ventana.add(JLcbcalendario);
		Ventana.add(jbentrar);
		Ventana.add(jbcerrar);
		Ventana.add(Jcbmenu);//Le damos vida en la Ventana
		Ventana.add(Jcbcalendario);
		Ventana.add(jlfondo);

		//Poner a escuchar acciones a los botones
		jbentrar.addActionListener(this);//Realiza la Accion de Clic
		jbcerrar.addActionListener(this);//Realiza la Accion de Clic



    	//Comando para poner el tamaño de la ventana
		Ventana.resize(400,200);
		//Comando para centrar la Ventana
		Ventana.setLocationRelativeTo(null);
		//Comando para bloquear el tamaño de la ventana, lo deja fijo
		Ventana.setResizable(false);
		//Comando para saber que el diseñador de todo soy yo
		Ventana.setLayout(null);
		Ventana.getContentPane().setBackground(Color.white);


//Muestra la Ventana
		Ventana.show();
    }


    //Funcionalidad del boton
    public void actionPerformed(ActionEvent b)
    {
    	if(b.getSource()==jbentrar)
    	{
    		//JOptionPane.showMessageDialog(null,"WELCOME") ;//Mensaje de Información
    		//JOptionPane.showMessageDialog(null,"ERROR","PRECAUTION",JOptionPane.ERROR_MESSAGE);//Mensaje de error, tiene mansaje de error y otro con el nombre de la ventana
    		JOptionPane.showMessageDialog(null,"POR FAVOR DIGITE LAS OPCIONES QUE SE SOLICITA","PRECAUTION",JOptionPane.WARNING_MESSAGE);


    	}

    	if(b.getSource()==jbcerrar)
    	{
    		JOptionPane.showConfirmDialog(null,"DESEA CERRAR SESION");
    		//System.exit(0);//Esta cierra la Compilación
    		new Login();//Esta me devuelve a la pagina principal
    	}


    }


}