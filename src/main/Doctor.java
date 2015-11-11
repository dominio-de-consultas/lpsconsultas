package main;

import java.util.ArrayList;
import java.util.Date;

public class Doctor
{
	private Object[] listOfAttributes;
		
	
	public ArrayList<Schedule> listOfSchedules;
	

	public long getCRM() {
		return (long) this.listOfAttributes[DoctorAttributes.CRM.ordinal()];
	}

	public void setCRM(long CRM) {
		this.listOfAttributes[DoctorAttributes.CRM.ordinal()] = CRM;
	}

	public Doctor(Object[] listOfAttributes)
	{
		this.listOfSchedules = new ArrayList<Schedule>();
		
		this.listOfAttributes = new Object[DoctorAttributes.values().length];
		for(int i = 0; i < DoctorAttributes.values().length; i++)
		{
			this.listOfAttributes[i] = listOfAttributes[i];
		}
	}
	
	
	
	
}
