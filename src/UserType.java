import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserType {
	
	private Integer id;
	private Integer numberOfAttributes;
	private Boolean[] listOfAttributes;
	private String nameOfType;
	
	public UserType(String nameOfType, Boolean[] listOfAttributes)
	{
		this.nameOfType = nameOfType;
		
		this.numberOfAttributes = Attributes.values().length;
		this.listOfAttributes = new Boolean[Attributes.values().length];
		for(int i = 0; i < Attributes.values().length; i++)
		{
			//System.out.println(listOfAttributes[i].toString());
			this.listOfAttributes[i] = listOfAttributes[i];
		}
		
	}
	
	User createUser()
	{
		//adicionar ao HashMap os atributos pertencentes a aquele tipo de usuario
		HashMap<Integer, Object> attributesOfUserType = new HashMap<Integer, Object>();
		for(int i = 0; i < this.numberOfAttributes; i++)
		{
			if(this.listOfAttributes[i] == true)
			{
				//dataDeNascimento
				if(i == Attributes.dataDeNascimento.ordinal())
				{
					//Data
					 Date date = new Date();
					 attributesOfUserType.put(i, date);
				}
				
				/*
					nome, CPF, senha, telefone, email,
					tipoSanguineo, alergias, historicoDoencasHereditarias,	
					especialidade, 
				 */
				else if(i >= Attributes.nome.ordinal() && i <= Attributes.especialidade.ordinal())
				{
					//string
					attributesOfUserType.put(i, "default");
				}
				else if(i >= Attributes.CRM.ordinal() && i <= Attributes.complemento.ordinal())
				{
					//Integer
					attributesOfUserType.put(i, 0);
				}
				
				else
				{
					//Boolean
					attributesOfUserType.put(i, false);
				}
				
			}
		}
		
		//depois de adicionar os atributos pertencentes ao tipo de usuario, devemos adicionar os metodos permitidos
		
		//criar User
		User user = new User(attributesOfUserType);
		return user;
	}
}
