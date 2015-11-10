import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SchedulingSystem
{

	//----------Attributes----------
	public List<UserType> listOfUserType;
	public List<User> listOfUser;
	
	//----------Constructor methods----------
	SchedulingSystem()
	{
		this.listOfUserType = new ArrayList<UserType>();
		this.listOfUser = new ArrayList<User>();
	}
	
	Boolean hasUserType()
	{
		if(listOfUserType.size() != 0)
		{
			return true;
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
	
	//----------UserType methods----------
	public void createUserType(String name, Boolean[] listOfAttributes)
	{
		UserType userType = new UserType(name, listOfAttributes);
		listOfUserType.add(userType);
	}
	
	public void editUserType()
	{
		;
	}
	
	public void removeUserType()
	{
		;
	}
	
	public void searchUserType()
	{
		;
	}
	
	//----------User methods----------
	public void createUser()
	{
		;
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
	
	
}
