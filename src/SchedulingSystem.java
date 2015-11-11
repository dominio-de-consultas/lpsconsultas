import java.util.ArrayList;
import java.util.List;

public class SchedulingSystem
{

	//----------Attributes----------
	public List<User> listOfUser;
	
	//----------Constructor method----------
	SchedulingSystem()
	{
		this.listOfUser = new ArrayList<User>();
		
		String[] attributesOfDefaultUser = new String[Attributes.values().length];
		attributesOfDefaultUser[Attributes.nome.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.senha.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.CPF.ordinal()] = "000";
		attributesOfDefaultUser[Attributes.telefone.ordinal()] = "[vazio]";
		attributesOfDefaultUser[Attributes.email.ordinal()] = "[vazio]";
		
		User defaultUser = new User(attributesOfDefaultUser);
		this.listOfUser.add(defaultUser);
	}
	
	Boolean login(String userID, String password)
	{
		for(int i = 0; i < this.listOfUser.size(); i++)
		{
			User user = this.listOfUser.get(i);
			if
			(
				user.attributesOfUser[Attributes.CPF.ordinal()] == userID
				&&
				user.attributesOfUser[Attributes.senha.ordinal()] == password
			)
			{
				return true;
			}
		}
		
		return false;
	}
	
	Boolean hasUser()
	{
		if(listOfUser.size() != 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	//----------User methods----------
	public void createUser(String[] attributesOfUser)
	{
		User newUser = new User(attributesOfUser);
		listOfUser.add(newUser);
	}

	public void editUser()
	{
		;
	}
	
	public void removeUser()
	{
		;
	}
	
	public void searchUser()
	{
		;
	}
	
	public void printListOfUsers()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfUser.size(); i++)
		{
			System.out.println(i+" : "+this.listOfUser.get(i).getName());
		}
		System.out.println("\n");
	}
	
}
