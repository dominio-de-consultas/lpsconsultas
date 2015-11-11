package main;
import java.util.ArrayList;
import java.util.Date;

public class Doctor
{

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
			System.out.println("Já existem um cronograma neste horário");
		}
		
	}
	
	Boolean verifySchedules(Date starterDate, Date finalDate)
	{
		for(int i = 0 ; i < this.listOfSchedules.size(); i++)
		{
			Schedule actualSchedule = this.listOfSchedules.get(i);
			if(true)
			{
				;
			}
			
		}
		return true;
	}
}
