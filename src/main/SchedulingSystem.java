package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.DaoUser;

public class SchedulingSystem
{
	DaoUser daoUser;
	//----------Attributes----------
	public List<User> listOfUser;
	
	//----------Constructor method----------
	SchedulingSystem()
	{
		this.listOfUser = new ArrayList<User>();
		
		/*
		String[] attributesOfDefaultUser = new String[Attributes.values().length];
		attributesOfDefaultUser[Attributes.nome.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.senha.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.CPF.ordinal()] = "000";
		attributesOfDefaultUser[Attributes.telefone.ordinal()] = "[vazio]";
		attributesOfDefaultUser[Attributes.email.ordinal()] = "[vazio]";
		*/
		User defaultUser = new User("admin",000,"",0,"","","","",0,"",new Date(),"","","",false,"",000,"admin");
		this.listOfUser.add(defaultUser);
	}
	
	Boolean login(int userID, String password)
	{
		for(int i = 0; i < this.listOfUser.size(); i++)
		{
			User user = this.listOfUser.get(i);
			if
			(
				user.getCpf() == userID
				&&
				user.getSenha() == password
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
	public void createUser(User user)
	{
		daoUser = new DaoUser();
		daoUser.insertUpdate(user);
		listOfUser.add(user);
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
			System.out.println(i+" : "+this.listOfUser.get(i).getNome());
		}
		System.out.println("\n");
	}
	
}
