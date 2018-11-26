import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Amazon {
		static User usuario1;
		static Users usuarios1;
		static boolean usuarioRegistrado;
		static Categorys amazon;
		
	@SuppressWarnings("resource")
	public static void main (String[] arg){
		usuarioRegistrado=false;
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad1"));
		usuarios1=new Users();
		
		if(usuarios1.verificar(usuario1)==false) {
			System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad2"));
			registrarUsuario();
		}
		
		amazon=new Categorys();
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad3"));
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad4"));
		
		Scanner entradaEscaner = new Scanner (System.in);
		String subCat=entradaEscaner.nextLine ();
		subCategorys sc= amazon.encontrarSubCategoria(subCat);
		sc.listarProductos();
		menu();
	}
	
	public static boolean comprarProducto() {
		boolean productoComprado=false;
		
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad5"));
		Scanner entradaEscaner = new Scanner (System.in);
		String comprado=entradaEscaner.nextLine ();
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad6"));
		
		productoComprado=true;
		return productoComprado;
	}
	
	public static void registrarUsuario() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad7"));
		String usuario = "";
        usuario = entradaEscaner.nextLine ();
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad8"));
		String email = "";
        email = entradaEscaner.nextLine ();
        System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad9"));
        String contraseña = "";
        contraseña = entradaEscaner.nextLine ();
        escribirPropiedades(usuario, email, contraseña);
	}
	
	public static void escribirPropiedades(String usuario, String email, String contraseña) {
		 Properties properties = new Properties();
		 properties.setProperty("username", usuario);
		 properties.setProperty("email", email);
		 properties.setProperty("password", contraseña);
		 
		 try {
			 properties.store(new FileWriter("Config"),"");
			 boolean añadido=usuarios1.addUsuario(usuario, email, contraseña);
			 if(añadido==true) {
				 usuarioRegistrado=true;
				 System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad10"));
				 System.out.println(email);
			     System.out.println(usuario);
			     System.out.println("*******");
			 }
			 else {
				 System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad11"));
			 }
		 }
		 catch(IOException ex1) {
			 System.out.println(ex1.getMessage());
		 }
	}
	
	public static void leerPropiedades() {
		try(FileReader reader =  new FileReader("Config")) {
	        Properties properties = new Properties();
	        properties.load(reader);
	        String email = properties.getProperty("email");
	        String username = properties.getProperty("username");
	        String password = properties.getProperty("password");
	        if(email!=null && username!=null && password!=null) {
	        	usuario1=new User(username, email, password);
	        }
	        
	       }catch (Exception e) {;
	       e.printStackTrace();
	       }
	}
	
	public static void listar() {
		amazon.listar();
	}
	
	public static void menu() {
		System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad12"));
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion=Integer.valueOf(entradaEscaner.nextLine());
		switch(opcion) {
		case 1:
			comprarProducto();
			break;
		case 2:
			listar();
			System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad13"));
			String subCat=entradaEscaner.nextLine ();
			subCategorys sc= amazon.encontrarSubCategoria(subCat);
			sc.listarProductos();
			menu();
			break;
		default:
			System.out.println(ResourceBundle.getBundle("Etiquetas").getString("etq_trad14"));
			menu();
		}
	}
}
