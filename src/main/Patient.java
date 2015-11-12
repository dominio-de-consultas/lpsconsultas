package main;

public class Patient
{
	public Object[] listOfAttributes;
	
	//----------Getter e Setter genericos----------
	Object getX(int attributeID)
	{
		return this.listOfAttributes[attributeID];
	}
	
	void setX(int attributeID, Object x)
	{
		this.listOfAttributes[attributeID] = x;
	}
	//--------------------
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
	//----------bairro----------
	Integer getBairro()
	{
		return (Integer) this.listOfAttributes[PatientAttributes.bairro.ordinal()];
	}
	
	void setBairro(String bairro)
	{
		this.listOfAttributes[PatientAttributes.bairro.ordinal()] = bairro;
	}
	//--------------------
	//----------municipio----------
	Integer getMunicipio()
	{
		return (Integer) this.listOfAttributes[PatientAttributes.municipio.ordinal()];
	}
	
	void setMunicipio(String municipio)
	{
		this.listOfAttributes[PatientAttributes.municipio.ordinal()] = municipio;
	}
	//--------------------
	Patient()
	{
		this.listOfAttributes = new Object[PatientAttributes.values().length];
	}
	
}
