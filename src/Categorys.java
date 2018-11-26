
public class Categorys {
	int numCategorias;
	Category [ ] nombresCategorias;
	public Categorys() {
		
		nombresCategorias =new Category[] {new Category("Sports","Spo"),new Category("Electronics","Elec"),
				new Category("Videogames","Vid"),new Category("Garden","Gar")};
		nombresCategorias[0].setNombresSubCategorias(new String[]{"Football", "Basketball", "Hockey"});
		
		nombresCategorias[1].setNombresSubCategorias(new String[] {"Informatic", "TV and audio", "Smartphones"});
		
		nombresCategorias[2].setNombresSubCategorias(new String[] {"Consoles", "Games", "Accesories"});
		
		nombresCategorias[3].setNombresSubCategorias(new String[] {"Barbecues", "Decks and fences", "Swimming pools"});
		
		numCategorias=4;
	}
	public subCategorys encontrarSubCategoria(String idSubCat) {
		subCategorys sc=null;
		for(int i=0; i<numCategorias;i++) {
			for(int j=0;j<nombresCategorias[i].numSubCategorys;j++) {
				if(idSubCat.equals(nombresCategorias[i].nombresSubCategorys[j].getIdCat())) {
				sc= nombresCategorias[i].nombresSubCategorys[j];
				}
			}
		}
		return sc;
	}
	public void listar() {
		for(int i=0; i<numCategorias-1;i++) {
			
		nombresCategorias[i].getNombreCat();
		for(int j=0;j<nombresCategorias[i].numSubCategorys-1;j++) {
				System.out.println(nombresCategorias[i].nombresSubCategorys[j].getNombreSubCat());
			}
		}	
	}
}
