package main;

import java.util.Date;

/**
 * Classe cujos objetos referem-se aos dados do cadastro de um usuário cadastrado no sistema
 *
 */
public class User {
	/**Lista contendo os atributos do usuário*/
	public String[] listOfAttributes;
	
	/**
	 * Construtor de um objeto da classe User
	 */
	User(){
		this.listOfAttributes = new String[Attributes.values().length];
	}

	//----------Getter e Setter genericos----------
	/**
	 * Getter genérico, sendo necessário especificar o atributo no parâmetro de entrada
	 * @param attributeID Código do atributo de acordo com o enum UserAttributes
	 * @return Informação do atributo de código attributeID
	 */
	Object getX(int attributeID)
	{
		return this.listOfAttributes[attributeID];
	}
	/**
	 * setter genérico, sendo necessário especificar o atributo e o dado a ser adicionado 
	 * @param attributeID Código do atributo de acordo com o enum UserAttributes
	 * @param x dado a ser adicionado no atributo de código attributeID
	 */
	void setX(Integer attributeID, String x)
	{
		this.listOfAttributes[attributeID] = x;
	}
	//--------------------
	/**
	 * Construtor de um objeto da classe User que já inicializa os valores dos atributos do objeto com os valores corretos.
	 * @param attributesOfUser
	 */
	User(String[] attributesOfUser)
	{
		
		this.listOfAttributes = new String[Attributes.values().length];
		for(int i = 0; i < Attributes.values().length; i++)
		{
			this.listOfAttributes[i] = attributesOfUser[i];
		}
	}
	/**
	 * Método que altera o valor do atributo de valor attributeID com o valor content
	 * @param attributeID posição do atributo a ser editado no enum UserAttributes
	 * @param content valor a ser inserido
	 */
	void editAttribute(Integer attributeID, String content)
	{
		this.listOfAttributes[attributeID] = content;
	}
	
	/**
	 * getter para a variável nome
	 * @return
	 */
	String getNome()
	{
		return this.listOfAttributes[Attributes.nome.ordinal()].toString();
	}
	/**
	 * setter para a variável nome
	 * @return
	 */
	void setNome(String nome)
	{
		this.listOfAttributes[Attributes.nome.ordinal()] = nome;
	}
	/**
	 * getter para a variável CPF
	 * @return
	 */
	String getCPF()
	{
		return this.listOfAttributes[Attributes.CPF.ordinal()].toString();
		
	}
	/**
	 * setter para a variável CPF
	 * @return
	 */
	void setCPF(String cpf)
	{
		this.listOfAttributes[Attributes.CPF.ordinal()] = cpf;		
	}
	/**
	 * getter para a variável email
	 * @return
	 */
	String getEmail()
	{
		return this.listOfAttributes[Attributes.email.ordinal()].toString();
		
	}
	/**
	 * setter para a variável email
	 * @return
	 */
	void setEmail(String email)
	{
		this.listOfAttributes[Attributes.email.ordinal()] = email;		
	}
	/**
	 * getter para a variável telefone
	 * @return
	 */
	String getTelefone()
	{
		return this.listOfAttributes[Attributes.telefone.ordinal()].toString();
		
	}
	/**
	 * setter para a variável telefone
	 * @return
	 */
	void setTelefone(String telefone)
	{
		this.listOfAttributes[Attributes.telefone.ordinal()] = telefone;		
	}
	/**
	 * getter para a variável senha
	 * @return
	 */
	String getSenha()
	{
		return this.listOfAttributes[Attributes.senha.ordinal()].toString();
		
	}
	/**
	 * setter para a variável senha
	 * @return
	 */
	void setSenha(String senha)
	{
		this.listOfAttributes[Attributes.senha.ordinal()] = senha;		
	}
	
	/**
	 * Método que imprime os valores dos attributos do objeto instanciado
	 * @return
	 */
	void listAttributes()
	{
		for(int i = 0; i < Attributes.values().length; i++)
		{
			System.out.println(i+" : "+Attributes.values()[i].toString()+" : "+this.listOfAttributes[i].toString());
		}
	}
	/**
	 * Adiciona um cronograma ao médico especificado
	 * @param doctor
	 * @param starterDate
	 * @param finalDate
	 * @param available
	 */
	public void addSchedule(Doctor doctor, Date starterDate, Date finalDate, Boolean available)
	{
		if(verifySchedules(doctor, starterDate, finalDate))
		{
			Schedule schedule = new Schedule(starterDate, finalDate, available, doctor.getCRM());
			doctor.listOfSchedules.add(schedule);
		}
		else
		{
			System.out.println("Já existem um cronograma neste horário");
		}
		
	}
	/**
	 * Verifica se um certo cronograma pode ser criado
	 */
	Boolean verifySchedules(Doctor doctor, Date starterDate, Date finalDate)
	{
		for(Schedule s : doctor.listOfSchedules)
		{
			if
			(
				(starterDate.after(s.starterDate) && starterDate.before(s.finalDate))	
				||
				(finalDate.before(s.finalDate) && finalDate.after(s.starterDate))
				||
				(starterDate.before(s.starterDate) && finalDate.after(s.finalDate))
			)
			{
				return false;
			}
		}
			
		
		return true;
	}
}
