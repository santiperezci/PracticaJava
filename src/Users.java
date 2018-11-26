
public class Users implements IUser{
	int numUsers;
	User [] nombreUsers;
	
	public Users () {
		nombreUsers=new User[180];
		nombreUsers[0]=new User("Pedro", "pedro@nebrija.com", "pedropassword");
		nombreUsers[1]=new User("John",	"john@nebrija.com", "johnpassword");
		nombreUsers[2]=new User("Alberto", "alberto@nebrija.com", "albertopassword");
		nombreUsers[3]=new User("Julio", "julio@nebrija.com", "juliopassword");

		numUsers=4;
	}
	
	@Override
	public boolean addUsuario(String name, String email, String password) {
		boolean added=false;
		User newUser;
		newUser=new User(name,email,password);
		try {
			nombreUsers[numUsers+1]=newUser;
			numUsers++;
			added=true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return added;
	}

   @Override
   public boolean verificar(User usuario) {
	boolean existe=false;
	for(int i=0;i<numUsers;i++) {
		if(usuario.name.equals(nombreUsers[i].name) && nombreUsers[i].email.equals(usuario.email) 
				&& nombreUsers[i].password.equals(usuario.password))  {
			
			existe=true;
			
			break;
		}
	}
	return existe;
   }
}

