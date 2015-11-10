import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		SchedulingSystem schedulingSystem = new SchedulingSystem();
		
		Scanner scanner = new Scanner(System.in);
		
		String option;
		System.out.println("Escolha a opção (IUT / IU)");
		option = scanner.nextLine();
		switch (option)
		{
		case "IUT":
			Boolean[] listOfAttributes = new Boolean[Attributes.values().length];
					
			System.out.println("Entre com o nome do tipo de usuario:");
			String name = scanner.nextLine();
			
			
			System.out.println("Escolha quais atributos estarao no tipo de usuario(S/N)");
			Attributes[] aux = Attributes.values();
			for(int i = 0; i < Attributes.values().length ; i++)
			{
				System.out.println(aux[i].toString());
				String attributeOption = scanner.nextLine();
				if(attributeOption == "S")
				{
					listOfAttributes[i] = true;
				}
				else
				{
					listOfAttributes[i] = false;
				}
			}
			schedulingSystem.createUserType(name, listOfAttributes);
			break;

		case "IU":
			//User user = userType.createUser();
			;
		case "END":
			scanner.close();
		default:
			break;
		}
		
		
	}

}
