/**
 * @(#)Login.java
 *
 *
 * @author Hernan Alonso Ortega jaramillo
 * @version 1.00 2013/11/9
 */


//Bloque Libreria
import javax.swing.*;//@param "Swing" es la libreria de componentes gráficos*/
import java.util.*;//@param "Util" es la libreria de utilidades, como fechas, horas, perifericos
import java.awt.event.*;//@param awt.event Libreria para eventos del sistema(algo que se va a ejecutar)
import java.awt.*;//@param "awt" libreria de acciones(algo que se ejecutar)


public class Login implements ActionListener
{
	//Declaración de Variables
	JFrame Ventana;
	JLabel jlusuario, jlcontraseña,jlfondo;//Estos son los "LABEL" para crear los botenes de creacion de usuario*/
	JTextField jtusuario;//Estos son los TEXTBOX
	JPasswordField jpcontraseña;
    
    JButton jbiniciar;//@Param "JButton" Este es la variable para crear botnes*/
    JButton jbcerrar;
    ImageIcon Fondo;


	MenuBar barra= new MenuBar();//@Param "MenuBar" declaramos la Barra de menu e Instanciamos
	//Declaramos el menu de Opciones
	Menu archivo= new Menu("Archivo");
	Menu editar= new Menu ("Editar");
	Menu config= new Menu ("Configuración");
	Menu ayuda= new Menu ("Ayuda");
	Menu guardar= new Menu ("Guardar");
	Menu sonido= new Menu ("Sonido");
	Menu video= new Menu ("Video");

	public static void main(String[] args)
	{
		new Login();
	}

	//Este es el CONSTRUTOR
    public Login()
    {
    	//Construimos los elementos
    	//@Param  "JFrame" nombre de la Variable para la ventana de inicio de sesión*/ 
    	Ventana=new JFrame ("Inicio de sesión");

        //@Param "new JLabel" colocamos el texto para pedir el nombre de usuario en la ventana*/
       	jlusuario=new JLabel("Nombre de usuario");
       	//@Param "new JButton" colocamos los botones de iniciar y cancelar en la ventana de inicio*/
       	jbiniciar=new JButton ("Iniciar");
       	jbcerrar=new JButton ("Cancelar");
       	jtusuario=new JTextField("");
       	jtusuario.setToolTipText("Digite aquí su nombre de usuario");//@Param "setToolTipText" con este parametro creamos el cuadro de dialogo para el nombre de usuario */
       	jlcontraseña=new JLabel("Contraseña");//Se crea el cuadro de la contaceña*/
		jpcontraseña=new JPasswordField("");
       	jpcontraseña.setToolTipText("Digite aquí su clave de 10 digitos");
       	Fondo=new ImageIcon("imagenes\\j1.jpg");//@Param "new ImageIcon" Poniendo imagen de Fondo pa la ventana*/
       	jlfondo=new JLabel(Fondo);





    	//Le damos ubicación a los elementos dentro de la ventana*/
    	//Se puede utilizar RESHAPE o SETBOUNDS*/
    	jlusuario.reshape(5,5,130,25); //Las medidas se componen de X,Y,ANCHO y LARGO*/
		jtusuario.reshape(140,5,130,25);
		jlcontraseña.reshape(5,40,130,25);
		jpcontraseña.reshape(140,40,130,25);
		jbiniciar.reshape (90,90,100,25);
		jbcerrar.reshape(200,90,100,25);
		jlfondo.reshape(100,0,300,210);    //Tamaño de fondo*/





		//Agregamos los elementos al JFrame*/
		Ventana.add(jlusuario);
		Ventana.add(jtusuario);
		Ventana.add(jlcontraseña);
		Ventana.add(jpcontraseña);
		Ventana.add(jbiniciar);
		Ventana.add(jbcerrar);
		Ventana.add(jlfondo);


		//@Param "this" Poner a escuchar acciones a los botones*/
		jbiniciar.addActionListener(this);
		jbcerrar.addActionListener(this);






    	//@Param "resize" comando para colocar el tamaño de la ventana*/
		Ventana.resize(450,250);
		//@Param "setLocationRelativeTo" comando para centrar la Ventana*/
		Ventana.setLocationRelativeTo(null);
		//@param "setResizable" comando para bloquear el tamaño de la ventana, lo deja fijo*/
		Ventana.setResizable(false);
		//@Param "setLayout" comando para saber que el diseñador de todo soy yo*/
		Ventana.setLayout(null);
		Ventana.getContentPane().setBackground(Color.white);
		//@Param "getContentPane" mestra la Ventana*/
		Ventana.show();
    }
    //@Param "actionPerformed" funcionalidad del boton*/
    public void actionPerformed(ActionEvent b)
    {
    	if(b.getSource()==jbiniciar)
    	{
    		//JOptionPane.showMessageDialog(null,"WELCOME") ;//Mensaje de Información
    		//JOptionPane.showMessageDialog(null,"ERROR","PRECAUTION",JOptionPane.ERROR_MESSAGE);//Mensaje de error, tiene mansaje de error y otro con el nombre de la ventana
    		//JOptionPane.showMessageDialog(null,"ESTUPIDO!!!!!!!!!","PRECAUTION",JOptionPane.WARNING_MESSAGE);

    		//@Param 	"String" Operacion Login*/
    		String usuario, contrasena;
    		usuario=jtusuario.getText();
    		contrasena=jpcontraseña.getText();

    		if (usuario.equals("hernan")&&/*Este simbolo significa Y*/ contrasena.equals("123")||/*Este simbolo significa O*/usuario.equals("Juanpablo")&& contrasena.equals("456"))
    		{
    			//@Param "showMessageDialog" Mensaje de Información o biemvenida*/
    			JOptionPane.showMessageDialog(null,"BIENVENIDO "+ usuario) ;
    			new Registrar();
    			Ventana.dispose();//Esta propiedad esconde la Ventana.
    		}
    		else
    		{
    			//@Param "showMessageDialog" Este parametro nos saca el mensaje de error, tiene mensaje de error y otro con el nombre de la ventana*/
    			JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecto","Advertencia!",JOptionPane.ERROR_MESSAGE);
    		}
    	}


    	if(b.getSource()==jbcerrar)//@Param "if" significa que si no resuta una cosa  entoces que haga otra.
    	
    	{
          //Param "showConfirmDialog" mensaje de informaciòn*/

    	int opc=	JOptionPane.showConfirmDialog(null,"¿Desea Salir?");
    	if(opc==JOptionPane.YES_OPTION)
    	{
    		System.exit(0);
    	}

    	}


    }


}
