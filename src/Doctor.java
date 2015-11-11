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
		Schedule schedule = new Schedule(starterDate, finalDate, available);
		listOfSchedules.add(schedule);
	}
}
