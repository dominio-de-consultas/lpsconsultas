package main;

import java.util.ArrayList;
import java.util.Date;

public class Doctor
{
	private long pid;
	public ArrayList<Schedule> listOfSchedules;
	

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

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
			System.out.println("Já existem um cronograma neste horário");
		}
		
	}
	
	Boolean verifySchedules(Date starterDate, Date finalDate)
	{
		for(int i = 0 ; i < this.listOfSchedules.size(); i++)
		{
			Schedule actualSchedule = this.listOfSchedules.get(i);
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
