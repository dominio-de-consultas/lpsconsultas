package main;

import java.util.ArrayList;

public class Doctor
{
	private Object[] listOfAttributes;
		
	
	public ArrayList<Schedule> listOfSchedules;
	//----------Getter e Setter generico----------
	Object getX(int attributeID)
	{
		return this.listOfAttributes[attributeID];
	}
	
	void setX(int attributeID, Object x)
	{
		this.listOfAttributes[attributeID] = x;
	}
	//--------------------

	public long getCRM() {
		return (long) this.listOfAttributes[DoctorAttributes.CRM.ordinal()];
	}

	public void setCRM(long CRM) {
		this.listOfAttributes[DoctorAttributes.CRM.ordinal()] = CRM;
	}
	
	public Doctor()
	{
		this.listOfSchedules = new ArrayList<Schedule>();
		this.listOfAttributes = new Object[DoctorAttributes.values().length];
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
	
	public void listSchedules()
	{
		System.out.println("\nCRONOGRAMA\n");
		
		for(int i = 0; i < this.listOfSchedules.size(); i++)
		{
			Schedule schedule = this.listOfSchedules.get(i);
			
			System.out.println("\nID: "+schedule.getPid());
			System.out.println("Início: "+schedule.starterDate.toString());
			System.out.println("Término: "+schedule.finalDate.toString());
			System.out.println("Disponibilidade: "+schedule.available.toString());
		}
	}
	
	
	
	
}
