package main;
import java.util.ArrayList;
import java.util.List;

import dao.DaoDoctor;
import dao.DaoPatient;
import dao.DaoUser;

public class SchedulingSystem
{
	private DaoUser daoUser;
	private DaoDoctor daoDoctor;
	private DaoPatient daoPatient;
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
		
		daoUser = new DaoUser();
		daoDoctor = new DaoDoctor();
		daoPatient = new DaoPatient();
		this.listOfDoctors = daoDoctor.select();
		this.listOfUsers = daoUser.select();
		this.listOfPatients = daoPatient.select();		
		
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
				user.listOfAttributes[Attributes.CPF.ordinal()].equals(userID)
				&&
				user.listOfAttributes[Attributes.senha.ordinal()].equals(password)
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
		daoUser.insertUpdate(newUser);
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
	
	public User searchUser(String nome)
	{
		List<User> ls = daoUser.select();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getNome().equals(nome)){
				return ls.get(i);
			}
		return null;
	
	}
	public void printListOfUsers()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfUsers.size(); i++)
		{
			System.out.println(i+" : "+this.listOfUsers.get(i).getNome());
		}
		System.out.println("\n");
	}
	

	//----------Doctors methods----------
	public void createDoctor(Doctor doctor){
		daoDoctor.insertUpdate(doctor);
	}
	public void printListOfDoctors()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfDoctors.size(); i++)
		{
			System.out.println(i+" : "+this.listOfDoctors.get(i).getNome());
		}
		System.out.println("\n");
	}
	
	
	//----------Patientss methods----------
	public void printListOfPatients()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfPatients.size(); i++)
		{
			System.out.println(i+" : "+this.listOfPatients.get(i).getNome());
		}
		System.out.println("\n");
	}
	
}
