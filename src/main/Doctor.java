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
	
	
	
	
}
