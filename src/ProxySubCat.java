
public class ProxySubCat implements IsubCat{
	subCategorys subCat=new subCategorys(null, null, null);

	@Override
	public void setNombresProductos(String idSubCat) {
		// TODO Auto-generated method stub
		subCat.setNombresProductos(idSubCat);
	}

	@Override
	public void listarProductos() {
		// TODO Auto-generated method stub
		subCat.listarProductos();
	}

}
