package main;
import java.util.Scanner;

import dao.DaoUser;
import util.HibernateHelper;

public class Main
{
	
	public static void main(String[] args)
	{ 
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
			String userID = scanner.nextLine();
			
			System.out.print("senha:");
			String password = scanner.nextLine();
			
			validPassword = !schedulingSystem.login(userID, password);
		}while(!validPassword);
		
		String option;
		
		Boolean flag = true;
		while(flag)
		{
			System.out.println("\n>>> Escolha a opção");
			System.out.println("01 - Cria um novo usuario");
			
			if(schedulingSystem.hasUser())
			{
				System.out.println("02 - Editar um usuario");
				System.out.println("03 - Listar usuarios");
				//System.out.println("04 - Buscar um usuario");
				//System.out.println("05 - Remover um usuario");
			}
			
			//System.out.println("06 - Criar um medico");
			if(schedulingSystem.hasDoctor())
			{
				//System.out.println("07 - Listar medicos");
				//System.out.println("08 - Alterar medico");
				//System.out.println("09 - Buscar medicos");
				//System.out.println("10 - Remover medico");
				
				//--------------------
				
				//System.out.println("11 - Criar cronograma");
				//System.out.println("12 - Editar cronograma");
				//System.out.println("13 - Listar cronograma");
				//System.out.println("14 - Buscar cronograma");
				//System.out.println("15 - Remover cronograma");
			}
			
			//System.out.println("16 - Criar um Paciente");
			if(schedulingSystem.hasPatient())
			{
				//System.out.println("17 - Listar pacientes");
				//System.out.println("18 - Alterar pacientes");
				//System.out.println("19 - Buscar pacientes");
				//System.out.println("20 - Remover pacientes");
			}
			
			if(schedulingSystem.hasDoctor() && schedulingSystem.hasPatient())
			{
				//System.out.println("21 - Criar consulta");
				//System.out.println("22 - Listar consulta");
				//System.out.println("23 - Alterar consulta");
				//System.out.println("24 - Buscar consulta");
				//System.out.println("25 - Remover consulta");
			}
			
			System.out.println("0 - encerrra o sistema");
			System.out.print("Opcao escolhida:");
			option = scanner.nextLine();
			option = option.toUpperCase();
			
			switch (option)
			{
				
				//Cria um novo usuario
				case "1":
					System.out.println("Entre com os atributos do usuario");
					String[] attributesOfUser = new String[Attributes.values().length];
					for(int i = 0; i < Attributes.values().length; i++)
					{
						System.out.print(Attributes.values()[i].toString()+" : ");
						String attribute = scanner.nextLine();
						attributesOfUser[i] = attribute;
					}
					
					
					schedulingSystem.createUser(attributesOfUser);
					break;
			
				//Editar usuario		
				case "2":
					if(schedulingSystem.hasUser())
					{
						schedulingSystem.printListOfUsers();
						System.out.println("Escolha um usuario pelo indice:");
						Integer userIndex = Integer.valueOf(scanner.nextLine());
						
						User user = schedulingSystem.listOfUsers.get(userIndex);
						
						System.out.println("Escolha um atributo pelo indice");
						user.listAttributes();
						Integer attributeIndex = Integer.valueOf(scanner.nextLine());
						
						System.out.println("Digite o novo conteudo do atributo  escolhido");
						String attributeContent = scanner.nextLine();
						
						user.editAttribute(attributeIndex, attributeContent);
						
						System.out.println("Atributos do usuario apos a alteracao");
						user.listAttributes();
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
