package main;

import java.util.Date;

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
	
	void setNumero(Integer numero)
	{
		this.listOfAttributes[PatientAttributes.numero.ordinal()] = numero;
	}
	//--------------------
	//----------bairro----------
	String getBairro()
	{
		return (String) this.listOfAttributes[PatientAttributes.bairro.ordinal()];
	}
	
	void setBairro(String bairro)
	{
		this.listOfAttributes[PatientAttributes.bairro.ordinal()] = bairro;
	}
	//--------------------
	//----------municipio----------
	String getMunicipio()
	{
		return (String) this.listOfAttributes[PatientAttributes.municipio.ordinal()];
	}
	
	void setMunicipio(String municipio)
	{
		this.listOfAttributes[PatientAttributes.municipio.ordinal()] = municipio;
	}
	//--------------------
	//----------estado----------
	String getEstado()
	{
		return (String) this.listOfAttributes[PatientAttributes.estado.ordinal()];
	}
	
	void setEstado(String estado)
	{
		this.listOfAttributes[PatientAttributes.estado.ordinal()] = estado;
	}
	//--------------------
	//----------complemento----------
	String getComplemento()
	{
		return (String) this.listOfAttributes[PatientAttributes.estado.ordinal()];
	}
	
	void setComplemento(String complemento)
	{
		this.listOfAttributes[PatientAttributes.complemento.ordinal()] = complemento;
	}
	//--------------------
	//----------telefone----------
	String getTelefone()
	{
		return (String) this.listOfAttributes[PatientAttributes.telefone.ordinal()];
	}
	
	void setTelefone(String telefone)
	{
		this.listOfAttributes[PatientAttributes.telefone.ordinal()] = telefone;
	}
	//--------------------
	//----------email----------
	String getEmail()
	{
		return (String) this.listOfAttributes[PatientAttributes.email.ordinal()];
	}
	
	void setEmail(String email)
	{
		this.listOfAttributes[PatientAttributes.email.ordinal()] = email;
	}
	//--------------------
	//----------dataDeNascimento----------
	Date getDataDeNascimento()
	{
		return (Date) this.listOfAttributes[PatientAttributes.dataDeNascimento.ordinal()];
	}
	
	void setDataDeNascimento(Date dataDeNascimento)
	{
		this.listOfAttributes[PatientAttributes.dataDeNascimento.ordinal()] = dataDeNascimento;
	}
	//--------------------
	//----------tipoSanguineo----------
	Date getTipoSanguineo()
	{
		return (Date) this.listOfAttributes[PatientAttributes.tipoSanguineo.ordinal()];
	}
	
	void setTipoSanguineo(String tipoSanguineo)
	{
		this.listOfAttributes[PatientAttributes.tipoSanguineo.ordinal()] = tipoSanguineo;
	}
	//--------------------
	//----------alergias----------
	String getAlergias()
	{
		return (String) this.listOfAttributes[PatientAttributes.alergias.ordinal()];
	}
	
	void setAlergias(String alergias)
	{
		this.listOfAttributes[PatientAttributes.alergias.ordinal()] = alergias;
	}
	//--------------------
	//----------descricaoHistoricoEscolar----------
	String getDescricaoHistoricoEscolar()
	{
		return (String) this.listOfAttributes[PatientAttributes.descricaoHistoricoEscolar.ordinal()];
	}
	
	void setDescricaoHistoricoEscolar(String descricaoHistoricoEscolar)
	{
		this.listOfAttributes[PatientAttributes.descricaoHistoricoEscolar.ordinal()] = descricaoHistoricoEscolar;
	}
	//--------------------
	//----------doadorDeOrgaos----------
	Boolean getDoadorDeOrgaos()
	{
		return (Boolean) this.listOfAttributes[PatientAttributes.doadorDeOrgaos.ordinal()];
	}
	
	void setDoadorDeOrgaos(Boolean doadorDeOrgaos)
	{
		this.listOfAttributes[PatientAttributes.doadorDeOrgaos.ordinal()] = doadorDeOrgaos;
	}
	//--------------------
	
	Patient()
	{
		this.listOfAttributes = new Object[PatientAttributes.values().length];
	}
	
}
