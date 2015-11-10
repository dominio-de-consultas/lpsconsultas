
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private HashMap<Integer, Object> attributesOfUser;
	
	
	User(HashMap<Integer, Object> attributesOfUserType)
	{
		
		Set<Integer> key = attributesOfUserType.keySet();
		Integer[] attributesArray = (Integer[]) key.toArray();
		for(int i = 0; i < key.size(); i++)
		{
			
			Object aux = attributesOfUserType.get(attributesArray[i]);
			this.attributesOfUser.put(attributesArray[i], aux);
		}
		
	}
	
	void editAttribute(Integer attributeID, Object content)
	{
		;
	}
}
