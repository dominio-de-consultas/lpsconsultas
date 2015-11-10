
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class User {
	private HashMap<Integer, Object> attributesOfUserType;
	
	
	User(HashMap<Integer, Object> attributesOfUserType)
	{
		Collection<Object> attributes = attributesOfUserType.values();
		Object[] a = attributes.toArray();
		
		/*
		for(Object i:a)
		
		{
			System.out.println(i.toString());
		}
		*/
	}
	
	void editAttribute(Integer attributeID, Object content)
	{
		;
	}
}
