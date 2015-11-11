package main;
public class User {
	public String[] attributesOfUser;
	
	
	User(String[] attributesOfUser)
	{
		
		this.attributesOfUser = new String[Attributes.values().length];
		for(int i = 0; i < Attributes.values().length; i++)
		{
			this.attributesOfUser[i] = attributesOfUser[i];
		}
	}
	
	void editAttribute(Integer attributeID, String content)
	{
		this.attributesOfUser[attributeID] = content;
	}
		
	String getName()
	{
		return this.attributesOfUser[Attributes.nome.ordinal()].toString();
		
	}
	
	void listAttributes()
	{
		for(int i = 0; i < Attributes.values().length; i++)
		{
			System.out.println(i+" : "+Attributes.values()[i].toString()+" : "+this.attributesOfUser[i].toString());
		}
	}
}
