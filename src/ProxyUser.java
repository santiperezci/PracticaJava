
public class ProxyUser implements IUser{
	Users usuario1=new Users();

	@Override
	public boolean addUsuario(String name, String email, String password) {
		return usuario1.addUsuario(name, email, password);
	}

	@Override
	public boolean verificar(User usuario) {
		return usuario1.verificar(usuario);
		
	}
	

}
