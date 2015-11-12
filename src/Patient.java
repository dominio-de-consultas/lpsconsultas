
public class Patient
{
	public Object[] listOfAttributes;
	
	//----------Nome----------
	String getNome()
	{
		return (String) this.listOfAttributes[PatientAttributes.nome.ordinal()];
	}
	
	void setNome(String nome)
	{
		this.listOfAttributes[PatientAttributes.nome.ordinal()] = nome;
	}
	//--------------------
	
	
	//----------CPF----------
	String getCPF()
	{
		return (String) this.listOfAttributes[PatientAttributes.CPF.ordinal()];
	}
	
	void setCPF(String CPF)
	{
		this.listOfAttributes[PatientAttributes.CPF.ordinal()] = CPF;
	}
	//--------------------
	
	//----------rua----------
	String getRua()
	{
		return (String) this.listOfAttributes[PatientAttributes.rua.ordinal()];
	}
	
	void setRua(String rua)
	{
		this.listOfAttributes[PatientAttributes.rua.ordinal()] = rua;
	}
	//--------------------
	
	//----------CEP----------
	String getCEP()
	{
		return (String) this.listOfAttributes[PatientAttributes.CEP.ordinal()];
	}
	
	void setCEP(String CEP)
	{
		this.listOfAttributes[PatientAttributes.CEP.ordinal()] = CEP;
	}
	//--------------------
	//----------numero----------
	Integer getNumero()
	{
		return (Integer) this.listOfAttributes[PatientAttributes.numero.ordinal()];
	}
	
	void setNumero(String numero)
	{
		this.listOfAttributes[PatientAttributes.numero.ordinal()] = numero;
	}
	//--------------------
	Patient()
	{
		this.listOfAttributes = new Object[PatientAttributes.values().length];
	}
	
}
