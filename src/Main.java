
public class Main
{

	public static void main(String[] args)
	{
		//Boolean[] listOfAttributes = new Boolean[Attributes.values().length];
		Boolean[] listOfAttributes = 
		{
			//Data - dataDeNascimento
			true,
			
			// String - nome
			false,
			
			//String - CPF
			false,
			
			// String - senha
			false,
			
			// String - telefone
			false,
			
			// String - email
			false,
			
			// String -tipoSanguineo
			false,
			
			// String - alergias
			false,
			
			// String - historicoDoencasHereditarias
			false,
			
			// String - especialidade
			false,
			
			// Integer - bairro
			false,
						
			// Integer - municipio
			false,
			
			// Integer - estado
			false,
			
			//Complemento
			false,
			
			// Integer - CRM
			false,
			
			// Integer - CEP
			false,
			
			// Integer - rua
			false,
			
			// Integer - numero
			false,
			
			// Boolean - casoDoadorDeOrgaos
			false,			
		
		};
		
		SchedulingSystem schedulingSystem = new SchedulingSystem();
		
		schedulingSystem.createUserType(0, "tipo1", listOfAttributes);
		
		UserType userType = schedulingSystem.listOfUserType.get(0);
		
		User user = userType.createUser();
		
		schedulingSystem.listOfUser.put(0, user);
		
	}

}
