package main;
import java.util.Date;

public class Schedule
{
	private long pid;
	public Date starterDate;
	public Date finalDate;
	public Boolean available;
	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Date getStarterDate() {
		return starterDate;
	}

	public void setStarterDate(Date starterDate) {
		this.starterDate = starterDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Schedule(Date starterDate, Date finalDate, Boolean available)
	{
		this.starterDate = starterDate;
		this.available = available;
	}
	
	public Schedule()
	{
		;
	}
}