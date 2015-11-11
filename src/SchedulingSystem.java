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
