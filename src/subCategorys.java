import java.io.File;

public class subCategorys implements IsubCat{
	String idSubCat,nombreSubCategoria, nombrePadre;
	String [] nombresProductos;
	public Product []  Productos;
	int numProductos=0;
	public subCategorys(String nombre, String id, String father) {
		
		nombreSubCategoria=nombre;
		idSubCat=id;
		nombrePadre=father;
	}
	
	public String getNombreSubCat() {
		return nombreSubCategoria;
	}
	
	public String getIdCat() {
		return idSubCat;
	}
	
	public String getNombrePadre() {
		return nombrePadre;
	}
	
	public void setIdCat(String id) {
		idSubCat=id;
	}
	
	@SuppressWarnings("unused")
	public void setNombresProductos(String idSubCat) {
		try {
		String path = new File(".").getCanonicalPath()+ "\\products\\" +idSubCat;
		File dir = new File(path );
		String[] ficheros = dir.list();
		int numFicheros=ficheros.length;
		if (ficheros == null) {
			  System.out.println("File not found.");
		}
		
		else { 
			  for (int i=0;i<numFicheros;i++) {
			    numProductos++;
			    Productos[i]=new Product(path+ "\\" +ficheros[i],nombrePadre,nombreSubCategoria);
			   
			  }
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listarProductos() {
		System.out.println("Products: ");
		System.out.println("Products number: " + numProductos);
		System.out.println(idSubCat);
		for(int i=0;i<numProductos;i++) {
			System.out.println(Productos[i].nombreProduct);
			System.out.println(Productos[i].precio);
			System.out.println(Productos[i].valoracion);
		}
	}
}
