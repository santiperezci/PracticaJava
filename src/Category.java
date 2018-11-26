
public class Category {
	private String idCat,nombreCategory;
	subCategorys [] nombresSubCategorys;
	int numSubCategorys;
	public Category() {
		numSubCategorys=0;
	}
	
	public Category(String nombre, String id) {
		nombreCategory=nombre;
		idCat=id;
		numSubCategorys=0;
	}
	
	public String getNombreCat() {
		return nombreCategory;
	}
	
	public String getIdCat() {
		return idCat;
	}
	
	public void setNombresSubCategorias(String [] nombresSCat) {
		nombresSubCategorys=new subCategorys[nombresSCat.length];
		numSubCategorys=nombresSCat.length;
		for (int i=0; i<nombresSCat.length;i++) {
			try {
				nombresSubCategorys[i]=new subCategorys(nombresSCat[i], nombreCategory.substring(0, 4) +Integer.toString(i), nombreCategory) ;
				if(i==0) {
					System.out.println(nombresSubCategorys[i].getIdCat()+ nombresSubCategorys[i].getNombrePadre().toUpperCase());
				}
				System.out.println(nombresSubCategorys[i].getNombreSubCat()+ " "+ nombresSubCategorys[i].getIdCat());
				nombresSubCategorys[i].setNombresProductos(nombresSubCategorys[i].getIdCat());
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	
	}
}
