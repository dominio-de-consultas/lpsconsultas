package main;
import java.util.List;
import java.util.Scanner;

import dao.DaoUser;
import util.HibernateHelper;

public class Main
{
	public static void main(String[] args)
	{
		HibernateHelper helper = new HibernateHelper();
		SchedulingSystem schedulingSystem = new SchedulingSystem();
		Scanner scanner = new Scanner(System.in);
		//DaoUser daoUser = new DaoUser();
		
		
		Boolean validPassword = false;
		do
		{
			
			/*
			List<User> listaUser = daoUser.select();
			for(User i : listaUser)
				System.out.println(i.getPid());	
			*/
			System.out.println("\nLOGIN\n");
			
			System.out.print("CPF:");
			int userID = Integer.parseInt(scanner.nextLine());
			
			System.out.print("senha:");
			String password = scanner.nextLine();
			
			validPassword = !schedulingSystem.login(userID, password);
		}while(!validPassword);
		
		String option;
		
		Boolean flag = true;
		while(flag)
		{
			System.out.println("\n>>> Escolha a opção");
			System.out.println("1 - Cria um novo usuario");
			
			if(schedulingSystem.hasUser())
			{
				System.out.println("2 - Editar um usuario");
				System.out.println("3 - Listar usuarios");
				//System.out.println("4 - Buscar um usuario");
				//System.out.println("3 - Remover um usuario");
			}
			
			
			
			System.out.println("0 - encerrra o sistema");
			System.out.print("Opcao escolhida:");
			option = scanner.nextLine();
			option = option.toUpperCase();
			
			switch (option)
			{
				
				//2 - Cria um novo usuario
				case "1":
					System.out.println("Entre com os atributos do usuario");
					String[] attributesOfUser = new String[Attributes.values().length];
					for(int i = 0; i < Attributes.values().length; i++)
					{
						System.out.print(Attributes.values()[i].toString()+" : ");
						String attribute = scanner.nextLine();
						attributesOfUser[i] = attribute;
					}
					
					
					schedulingSystem.createUser(new User(attributesOfUser));
					break;
			
				//Editar usuario		
				case "2":
					if(schedulingSystem.hasUser())
					{
						schedulingSystem.printListOfUsers();
						System.out.println("Escolha um usuario pelo indice:");
						Integer userIndex = Integer.valueOf(scanner.nextLine());
						
						User user = schedulingSystem.listOfUser.get(userIndex);
						/*
						System.out.println("Escolha um atributo pelo indice");
						user.listAttributes();
						Integer attributeIndex = Integer.valueOf(scanner.nextLine());
						
						System.out.println("Digite o novo conteudo do atributo  escolhido");
						String attributeContent = scanner.nextLine();
						
						user.editAttribute(attributeIndex, attributeContent);
						
						System.out.println("Atributos do usuario apos a alteracao");
						user.listAttributes();
						*/
					}
					
					else
					{
						System.out.println("Operação negada: É necessário criar um usuário");
					}
					break;
					
				// Listar usuarios	
				case "3":
					if(schedulingSystem.hasUser())
					{
						schedulingSystem.printListOfUsers();
					}
					
					else
					{
						System.out.println("Operação negada: É necessário criar um usuário");
					}
					break;
					
				//
				case "4":
					if(schedulingSystem.hasUser())
					{
						;
					}
					
					else
					{
						System.out.println("Operação negada: É necessário criar um usuário");
					}
					break;
					
				//0 - encerrra o sistema
				case "0":
					flag = false;
					break;
					
				default:
					break;
				
			}
			
		}
		scanner.close();

		
		
	}
	
	

}
