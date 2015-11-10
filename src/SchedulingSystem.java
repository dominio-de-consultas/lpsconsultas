import java.util.HashMap;
import java.util.List;

public class SchedulingSystem
{

	public HashMap<Integer, UserType> listOfUserType;
	public HashMap<Integer, User> listOfUser;
	
	SchedulingSystem()
	{
		this.listOfUserType = new HashMap<Integer, UserType>();
		this.listOfUser = new HashMap<Integer, User>();
		
		
	}
	
	void createUserType(Integer ID, String name, Boolean[] listOfAttributes)
	{
		UserType userType = new UserType(name, listOfAttributes);
		listOfUserType.put(ID, userType);
	}
	
	
}
