package main;

import java.util.ArrayList;
import java.util.Date;

public class Doctor
{
	private long pid;
	public ArrayList<Schedule> listOfSchedules;
	
	public Doctor()
	{
		this.listOfSchedules = new ArrayList<Schedule>();
	}
	
	public void addSchedule(Date starterDate, Date finalDate, Boolean available)
	{
		if(verifySchedules(starterDate, finalDate))
		{
			Schedule schedule = new Schedule(starterDate, finalDate, available);
			listOfSchedules.add(schedule);
		}
		else
		{
			System.out.println("JÃ¡ existem um cronograma neste horÃ¡rio");
		}
		
	}
	
	Boolean verifySchedules(Date starterDate, Date finalDate)
	{
		for(int i = 0 ; i < this.listOfSchedules.size(); i++)
		{
			Schedule actualSchedule = this.listOfSchedules.get(i);
			if(true)
			{
				if
				(
					(starterDate.after(actualSchedule.starterDate) && starterDate.before(actualSchedule.finalDate))	
					||
					(finalDate.before(actualSchedule.finalDate) && finalDate.after(actualSchedule.starterDate))
				)
				{
					return false;
				}
			}
			
		}
		return true;
	}
}
