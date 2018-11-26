import java.io.FileReader;
import java.util.Properties;

public class Product {

		String nombreProduct;
		String category;
		String subCategory;
		float valoracion, precio;
		
		public Product(String nombreProd, String category, String subCategory) {
			
			try(FileReader reader =  new FileReader(nombreProd)) {
				
		        Properties properties = new Properties();
		        properties.load(reader);
		        
		        this.category=category;
		        this.subCategory=subCategory;
		        
		        nombreProduct = properties.getProperty("productname");
		        precio =Float.valueOf( properties.getProperty("price"));
		        valoracion = Float.valueOf(properties.getProperty("stars"));
		        
		        reader.close();
		        
		       }catch (Exception e) {
		    	   System.out.println(e.getMessage());
		       }
			

			}
}
