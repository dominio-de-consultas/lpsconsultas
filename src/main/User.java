package main;

import java.util.Date;

public class User {
	private long pid;
	public String[] listOfAttributes;
	
	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	//----------Getter e Setter genericos----------
	Object getX(int attributeID)
	{
		return this.listOfAttributes[attributeID];
	}
	
	void setX(Integer attributeID, String x)
	{
		this.listOfAttributes[attributeID] = x;
	}
	//--------------------
	User(String[] attributesOfUser)
	{
		
		this.listOfAttributes = new String[Attributes.values().length];
		for(int i = 0; i < Attributes.values().length; i++)
		{
			this.listOfAttributes[i] = attributesOfUser[i];
		}
	}
	
	void editAttribute(Integer attributeID, String content)
	{
		this.listOfAttributes[attributeID] = content;
	}
		
	String getNome()
	{
		return this.listOfAttributes[Attributes.nome.ordinal()].toString();
	}
	
	void setNome(String nome)
	{
		this.listOfAttributes[Attributes.nome.ordinal()] = nome;
	}
	
	String getCPF()
	{
		return this.listOfAttributes[Attributes.CPF.ordinal()].toString();
		
	}
	void setCPF(String cpf)
	{
		this.listOfAttributes[Attributes.CPF.ordinal()] = cpf;		
	}
	String getEmail()
	{
		return this.listOfAttributes[Attributes.email.ordinal()].toString();
		
	}
	void setEmail(String email)
	{
		this.listOfAttributes[Attributes.email.ordinal()] = email;		
	}
	String getTelefone()
	{
		return this.listOfAttributes[Attributes.telefone.ordinal()].toString();
		
	}
	void setTelefone(String telefone)
	{
		this.listOfAttributes[Attributes.telefone.ordinal()] = telefone;		
	}
	String getSenha()
	{
		return this.listOfAttributes[Attributes.senha.ordinal()].toString();
		
	}
	void setSenha(String senha)
	{
		this.listOfAttributes[Attributes.senha.ordinal()] = senha;		
	}
	
	
	void listAttributes()
	{
		for(int i = 0; i < Attributes.values().length; i++)
		{
			System.out.println(i+" : "+Attributes.values()[i].toString()+" : "+this.listOfAttributes[i].toString());
		}
	}
	
	public void addSchedule(Doctor doctor, Date starterDate, Date finalDate, Boolean available)
	{
		if(verifySchedules(doctor, starterDate, finalDate))
		{
			Schedule schedule = new Schedule(starterDate, finalDate, available);
			doctor.listOfSchedules.add(schedule);
		}
		else
		{
			System.out.println("Já existem um cronograma neste horário");
		}
		
	}
	Boolean verifySchedules(Doctor doctor, Date starterDate, Date finalDate)
	{
		for(int i = 0 ; i < doctor.listOfSchedules.size(); i++)
		{
			Schedule actualSchedule = doctor.listOfSchedules.get(i);
			if
			(
				(starterDate.after(actualSchedule.starterDate) && starterDate.before(actualSchedule.finalDate))	
				||
				(finalDate.before(actualSchedule.finalDate) && finalDate.after(actualSchedule.starterDate))
				||
				(starterDate.before(actualSchedule.starterDate) && finalDate.after(actualSchedule.finalDate))
			)
			{
				return false;
			}
		}
			
		
		return true;
	}
}
