package main;
import java.util.Date;

public class Schedule implements Comparable<Schedule>
{
	private long pid;
	public Date starterDate;
	public Date finalDate;
	public Boolean available;
	public long did;
	
	
	public long getDid() {
		return did;
	}

	public void setDid(long did) {
		this.did = did;
	}

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

	
	public Schedule(Date starterDate, Date finalDate, Boolean available, long did)
	{
		this.starterDate = starterDate;
		this.finalDate = finalDate;
		this.available = available;
		this.did = did;
	}
	
	public Schedule()
	{
		this.available = false;
	}
	

	@Override
	public int compareTo(Schedule o) {
		// TODO Auto-generated method stub
		return this.starterDate.compareTo(o.starterDate);
	}
}