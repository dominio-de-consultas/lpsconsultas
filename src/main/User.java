package main;

import java.util.Date;

public class User {
	private long pid;
	public String[] attributesOfUser;
	
	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

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
