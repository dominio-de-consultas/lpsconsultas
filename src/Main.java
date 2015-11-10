import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		SchedulingSystem schedulingSystem = new SchedulingSystem();
		
		Scanner scanner = new Scanner(System.in);
		
		String option;
		
		Boolean flag = true;
		while(flag)
		{
			System.out.println("Escolha a opção");
			System.out.println("1 - cria um novo tipo de usuario");
			System.out.println("2 - cria um novo usuario");
			System.out.println("0 - encerrra o sistema");
			System.out.print("Opcao escolhida:");
			option = scanner.nextLine();
			option = option.toUpperCase();
			
			switch (option)
			{
				//1 - cria um novo tipo de usuario
				case "1":
					Boolean[] listOfAttributes = new Boolean[Attributes.values().length];
							
					System.out.println("Entre com o nome do tipo de usuario:");
					String name = scanner.nextLine();
					
					
					System.out.println("Escolha quais atributos estarao no tipo de usuario(S/N)");
					Attributes[] aux = Attributes.values();
					for(int i = 0; i < Attributes.values().length ; i++)
					{
						System.out.println(aux[i].toString());
						String attributeOption = scanner.nextLine();
						attributeOption = attributeOption.toUpperCase();
						
						if(attributeOption == "S")
						{
							listOfAttributes[i] = true;
						}
						else
						{
							listOfAttributes[i] = false;
						}
					}
					// O CPF eh a chave
					listOfAttributes[Attributes.CPF.ordinal()] = true;
					
					schedulingSystem.createUserType(name, listOfAttributes);
					break;
					
				//2 - cria um novo usuario
				case "2":
					//User user = userType.createUser();
					;
					
				//0 - encerrra o sistema
				case "0":
					flag = false;
				default:
					break;
				
			}
			
		}
		scanner.close();

		
		
	}

}
