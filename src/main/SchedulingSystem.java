package main;
import java.util.ArrayList;
import java.util.List;

import dao.DaoUser;

public class SchedulingSystem
{
	DaoUser daoUser;
	//----------Attributes----------
	public List<User> listOfUsers;
	public List<Doctor> listOfDoctors;
	public List<Patient> listOfPatients;
	
	//----------Constructor method----------
	SchedulingSystem()
	{
		this.listOfDoctors = new ArrayList<Doctor>();
		this.listOfPatients = new ArrayList<Patient>();
		
		this.listOfUsers = new ArrayList<User>();
		
		
		String[] attributesOfDefaultUser = new String[Attributes.values().length];
		attributesOfDefaultUser[Attributes.nome.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.senha.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.CPF.ordinal()] = "000";
		attributesOfDefaultUser[Attributes.telefone.ordinal()] = "[vazio]";
		attributesOfDefaultUser[Attributes.email.ordinal()] = "[vazio]";
		
		User defaultUser = new User(attributesOfDefaultUser);
		this.listOfUsers.add(defaultUser);
	}
	
	Boolean login(String userID, String password)
	{
		for(int i = 0; i < this.listOfUsers.size(); i++)
		{
			User user = this.listOfUsers.get(i);
			if
			(
				user.listOfAttributes[Attributes.CPF.ordinal()] == userID
				&&
				user.listOfAttributes[Attributes.senha.ordinal()] == password
			)
			{
				return true;
			}
		}
		
		return false;
	}
	
	Boolean hasUser()
	{
		return ! this.listOfUsers.isEmpty();
	}
	
	Boolean hasDoctor()
	{
		return ! this.listOfDoctors.isEmpty();
		
	}
	
	Boolean hasPatient()
	{
		return ! this.listOfPatients.isEmpty();
	}
	
	
	//----------User methods----------
	public void createUser(String[] attributesOfUser)
	{
		User newUser = new User(attributesOfUser);
		//daoUser = new DaoUser();
		//daoUser.insertUpdate(newUser);
		listOfUsers.add(newUser);
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
		for(int i = 0; i < this.listOfUsers.size(); i++)
		{
			System.out.println(i+" : "+this.listOfUsers.get(i).getName());
		}
		System.out.println("\n");
	}
	
}
