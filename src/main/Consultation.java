package main;

public class Consultation
{
	private Integer ID;
	private Integer CRM;
	private Integer CPF;
	
	Consultation()
	{
		;
	}
	
	//----------ID----------
	Object getID()
	{
		return this.ID;
	}
	
	void setID(Integer ID)
	{
		this.ID = ID;
	}
	//--------------------
	//----------CRM----------
	Object getCRM()
	{
		return this.CRM;
	}
	
	void setCRM(Integer CRM)
	{
		this.CRM = CRM;
	}
	//--------------------
	//----------CPF----------
	Object getCPF()
	{
		return this.CPF;
	}
	
	void setCPF(Integer CPF)
	{
		this.CPF = CPF;
	}
	//--------------------
}
