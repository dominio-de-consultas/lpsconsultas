package main;

import java.util.Date;

/**
 * Classe cujos objetos referem-se aos dados do cadastro de um paciente cadastrado no sistema
 * @author Eliton
 *
 */
public class Patient
{
	/**
	 * Lista contendo todos os atributos de um paciente
	 */
	public Object[] listOfAttributes;
	
	/**
	 * Método genérico para obter um atributo do paciente, passando por argumento o id do atributo.
	 * @param attributeID Identificador do atributo solicitado.
	 * @return O atributo solicitado.
	 */
	Object getX(int attributeID)
	{
		return this.listOfAttributes[attributeID];
	}
	
	/**
	 * Método genérico para configurar um atributo do paciente, passando por argumento o id do atributo. 
	 * @param attributeID Identificador do atributo a ser configurado.
	 * @param x objeto que configura o atributo.
	 */
	void setX(int attributeID, Object x)
	{
		this.listOfAttributes[attributeID] = x;
	}
	
	/**
	 * getter para o atributo nome.
	 * @return
	 */
	String getNome()
	{
		return (String) this.listOfAttributes[PatientAttributes.nome.ordinal()];
	}
	
	/**
	 * setter para o atributo nome.
	 * @param nome
	 */
	void setNome(String nome)
	{
		this.listOfAttributes[PatientAttributes.nome.ordinal()] = nome;
	}
	
	/**
	 * getter para o atributo CPF. 
	 * @return
	 */
	String getCPF()
	{
		return (String) this.listOfAttributes[PatientAttributes.CPF.ordinal()];
	}
	
	/**
	 * setter para o atributo CPF
	 * @param CPF
	 */
	void setCPF(String CPF)
	{
		this.listOfAttributes[PatientAttributes.CPF.ordinal()] = CPF;
	}
	
	/**
	 * getter para o atributo rua
	 * @return
	 */
	String getRua()
	{
		return (String) this.listOfAttributes[PatientAttributes.rua.ordinal()];
	}
	
	/**
	 * setter para o atributo rua
	 * @param rua
	 */
	void setRua(String rua)
	{
		this.listOfAttributes[PatientAttributes.rua.ordinal()] = rua;
	}
	
	/**
	 * getter para o atributo CEP
	 * @return
	 */
	String getCEP()
	{
		return (String) this.listOfAttributes[PatientAttributes.CEP.ordinal()];
	}
	
	/**
	 * setter para o atributo 
	 * @param CEP
	 */
	void setCEP(String CEP)
	{
		this.listOfAttributes[PatientAttributes.CEP.ordinal()] = CEP;
	}

	/**
	 * getter para o atributo numero
	 * @return
	 */
	Integer getNumero()
	{
		return (Integer) this.listOfAttributes[PatientAttributes.numero.ordinal()];
	}
	
	/**
	 * setter para o atributo numero
	 * @param numero
	 */
	void setNumero(Integer numero)
	{
		this.listOfAttributes[PatientAttributes.numero.ordinal()] = numero;
	}
	
	/**
	 * getter para o atributo bairro
	 * @return
	 */
	String getBairro()
	{
		return (String) this.listOfAttributes[PatientAttributes.bairro.ordinal()];
	}
	
	/**
	 * setter para o atributo bairro
	 * @param bairro
	 */
	void setBairro(String bairro)
	{
		this.listOfAttributes[PatientAttributes.bairro.ordinal()] = bairro;
	}

	/**
	 * getter para o atributo municipio
	 * @return
	 */
	String getMunicipio()
	{
		return (String) this.listOfAttributes[PatientAttributes.municipio.ordinal()];
	}
	
	/**
	 * setter para o atributo municipio
	 * @param municipio
	 */
	void setMunicipio(String municipio)
	{
		this.listOfAttributes[PatientAttributes.municipio.ordinal()] = municipio;
	}
	
	/**
	 * getter para o atributo estado
	 * @return
	 */
	String getEstado()
	{
		return (String) this.listOfAttributes[PatientAttributes.estado.ordinal()];
	}
	
	/**
	 * setter para o atributo estado
	 * @param estado
	 */
	void setEstado(String estado)
	{
		this.listOfAttributes[PatientAttributes.estado.ordinal()] = estado;
	}
	
	/**
	 * getter para o atributo complemento
	 * @return
	 */
	String getComplemento()
	{
		return (String) this.listOfAttributes[PatientAttributes.estado.ordinal()];
	}
	
	/**
	 * setter para o atributo complemento
	 * @param complemento
	 */
	void setComplemento(String complemento)
	{
		this.listOfAttributes[PatientAttributes.complemento.ordinal()] = complemento;
	}
	
	/**
	 * getter para o atributo telefone
	 * @return
	 */
	String getTelefone()
	{
		return (String) this.listOfAttributes[PatientAttributes.telefone.ordinal()];
	}
	
	/**
	 * setter para o atributo telefone
	 * @param telefone
	 */
	void setTelefone(String telefone)
	{
		this.listOfAttributes[PatientAttributes.telefone.ordinal()] = telefone;
	}
	
	/**
	 * getter para o atributo email
	 * @return
	 */
	String getEmail()
	{
		return (String) this.listOfAttributes[PatientAttributes.email.ordinal()];
	}
	
	/**
	 * setter para o atributo email
	 * @param email
	 */
	void setEmail(String email)
	{
		this.listOfAttributes[PatientAttributes.email.ordinal()] = email;
	}

	/**
	 * getter para o atributo dataDeNascimento
	 * @return
	 */
	Date getDataDeNascimento()
	{
		return (Date) this.listOfAttributes[PatientAttributes.dataDeNascimento.ordinal()];
	}
	
	/**
	 * setter para o atributo dataDeNascimento
	 * @param dataDeNascimento
	 */
	void setDataDeNascimento(Date dataDeNascimento)
	{
		this.listOfAttributes[PatientAttributes.dataDeNascimento.ordinal()] = dataDeNascimento;
	}
	
	/**
	 * getter para o atributo tipoSanguineo
	 * @return
	 */
	String getTipoSanguineo()
	{
		return (String) this.listOfAttributes[PatientAttributes.tipoSanguineo.ordinal()];
	}
	
	/**
	 * setter para o atributo tipoSanguineo
	 * @param tipoSanguineo
	 */
	void setTipoSanguineo(String tipoSanguineo)
	{
		this.listOfAttributes[PatientAttributes.tipoSanguineo.ordinal()] = tipoSanguineo;
	}
	
	/**
	 * getter para o atributo alergias
	 * @return
	 */
	String getAlergias()
	{
		return (String) this.listOfAttributes[PatientAttributes.alergias.ordinal()];
	}
	
	/**
	 * setter para o atributo alergias
	 * @param alergias
	 */
	void setAlergias(String alergias)
	{
		this.listOfAttributes[PatientAttributes.alergias.ordinal()] = alergias;
	}
	
	/**
	 * getter para o atributo descricaoHistoricoFamiliar
	 * @return
	 */
	String getDescricaoHistoricoFamiliar()
	{
		return (String) this.listOfAttributes[PatientAttributes.descricaoHistoricoFamiliar.ordinal()];
	}
	
	/**
	 * setter para o atributo descricaoHistoricoEscolar
	 * @param descricaoHistoricoEscolar
	 */
	void setDescricaoHistoricoFamiliar(String descricaoHistoricoEscolar)
	{
		this.listOfAttributes[PatientAttributes.descricaoHistoricoFamiliar.ordinal()] = descricaoHistoricoEscolar;
	}
	
	/**
	 * getter para o atributo doadorDeOrgaos
	 * @return
	 */
	Boolean getDoadorDeOrgaos()
	{
		return (Boolean) this.listOfAttributes[PatientAttributes.doadorDeOrgaos.ordinal()];
	}
	
	/**
	 * setter para o atributo doadoDeOrgaos
	 * @param doadorDeOrgaos
	 */
	void setDoadorDeOrgaos(Boolean doadorDeOrgaos)
	{
		this.listOfAttributes[PatientAttributes.doadorDeOrgaos.ordinal()] = doadorDeOrgaos;
	}
	
	/**
	 * Construtor que inicializa a lista de atributos do paciente. 
	 */
	Patient()
	{
		this.listOfAttributes = new Object[PatientAttributes.values().length];
	}
	
}
