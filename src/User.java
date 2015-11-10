
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class User {
	private HashMap<Integer, Object> attributesOfUser;
	
	
	User(HashMap<Integer, Object> attributesOfUserType)
	{
		Set<Integer> key = attributesOfUserType.keySet();
		for(int i = 0; i < key.size(); i++)
		{
			Object aux = attributesOfUserType.get(key[i]);
			this.attributesOfUser.put(key, aux);
		}
	}
	
	void editAttribute(Integer attributeID, Object content)
	{
		;
	}
}
