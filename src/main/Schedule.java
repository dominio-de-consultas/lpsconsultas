package main;
import java.util.Date;

public class Schedule
{
	private long pid;
	public Date starterDate;
	public Date finalDate;
	public Boolean available;
	
	public Schedule(Date starterDate, Date finalDate, Boolean available)
	{
		this.starterDate = starterDate;
		this.available = available;
	}
}