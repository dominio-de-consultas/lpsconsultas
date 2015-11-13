package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.DaoUser;
import util.HibernateHelper;

public class Main
{
	
	public static void main(String[] args) throws ParseException
	{ 
		String dateFormat = "dd/MM/yyyy";
		String dateAndHourFormat = "HH:mm dd/MM/yyyy";
		HibernateHelper helper = new HibernateHelper();
		SchedulingSystem schedulingSystem = new SchedulingSystem();
		Scanner scanner = new Scanner(System.in);
		DaoUser daoUser = new DaoUser();
		
		
		Boolean validPassword = false;
		do
		{
			System.out.println("Lista de usuários cadastrados:");
			schedulingSystem.printListOfUsers();
			
			System.out.println("\nLOGIN\n");
			
			System.out.print("CPF:");
			String userID = scanner.nextLine();
			
			System.out.print("senha:");
			String password = scanner.nextLine();
			
			validPassword = schedulingSystem.login(userID, password);
			if(!validPassword){
				System.out.println("Usuário não encontrado ou senha errada.");
			}
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
			
			System.out.println("06 - Criar um medico");
			if(schedulingSystem.hasDoctor())
			{
				System.out.println("07 - Listar medicos");
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
			
			System.out.println("16 - Criar um Paciente");
			if(schedulingSystem.hasPatient())
			{
				System.out.println("17 - Listar pacientes");
				//System.out.println("18 - Alterar pacientes");
				//System.out.println("19 - Buscar pacientes");
				//System.out.println("20 - Remover pacientes");
			}
			
			if(schedulingSystem.hasDoctor() && schedulingSystem.hasPatient())
			{
				System.out.println("21 - Criar consulta");
				System.out.println("22 - Listar consulta");
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
				//------------------------------------------------------------
				//Cria um novo usuario
				case "01":
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
				//------------------------------------------------------------
				//Editar usuario		
				case "02":
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
				//------------------------------------------------------------	
				// Listar usuarios	
				case "03":
					if(schedulingSystem.hasUser())
					{
						schedulingSystem.printListOfUsers();
					}
					
					else
					{
						System.out.println("Operação negada: É necessário criar um usuário");
					}
					break;
					
				//------------------------------------------------------------
				case "04":
					if(schedulingSystem.hasUser())
					{
						;
					}
					
					else
					{
						System.out.println("Operação negada: É necessário criar um usuário");
					}
					break;
				//------------------------------------------------------------
				//System.out.println("06 - Criar um medico");
				case "06":
					Doctor newDoctor = new Doctor();
					for(int i = 0; i < DoctorAttributes.values().length; i++)
					{
						System.out.println(DoctorAttributes.values()[i].toString()+": ");
						String aux = scanner.nextLine();
						if
						(
							i == DoctorAttributes.nome.ordinal()
							|| i == DoctorAttributes.CPF.ordinal()
							|| i == DoctorAttributes.especialidade.ordinal()
							|| i == DoctorAttributes.email.ordinal()
							|| i == DoctorAttributes.rua.ordinal()
							|| i == DoctorAttributes.CEP.ordinal()
							|| i == DoctorAttributes.bairro.ordinal()
							|| i == DoctorAttributes.municipio.ordinal()
							|| i == DoctorAttributes.estado.ordinal()
							|| i == DoctorAttributes.complemento.ordinal()
							|| i == DoctorAttributes.telefone.ordinal()
						)
						{
							newDoctor.listOfAttributes[i] = aux;
						}	
						else if(i == DoctorAttributes.dataDeNascimento.ordinal())
						{
							SimpleDateFormat dataFormat = new SimpleDateFormat (dateFormat);
							Date date = dataFormat.parse(aux);
							newDoctor.setDataDeNascimento(date);
						}
						else if(i == DoctorAttributes.numero.ordinal() || i == DoctorAttributes.CRM.ordinal())
						{
							newDoctor.listOfAttributes[i] = Integer.parseInt(aux);
						}
					}
					schedulingSystem.createDoctor(newDoctor);
					//schedulingSystem.listOfDoctors.add(newDoctor);
					
					break;
				//------------------------------------------------------------
				//System.out.println("07 - Listar medicos");
				case "07":
					schedulingSystem.printListOfDoctors();
					break;
				//------------------------------------------------------------
				//System.out.println("16 - Criar um Paciente");
				case "16":
					Patient newPatient = new Patient();
					
					
					for(int i = 0; i < PatientAttributes.values().length; i++)
					{
						System.out.println(PatientAttributes.values()[i].toString()+": ");
						String aux = scanner.nextLine();
						if
						(
							i == PatientAttributes.nome.ordinal()
							|| i == PatientAttributes.CPF.ordinal()
							|| i == PatientAttributes.rua.ordinal()
							|| i == PatientAttributes.CEP.ordinal()
							|| i == PatientAttributes.bairro.ordinal()
							|| i == PatientAttributes.municipio.ordinal()
							|| i == PatientAttributes.estado.ordinal()
							|| i == PatientAttributes.complemento.ordinal()
							|| i == PatientAttributes.telefone.ordinal()
							|| i == PatientAttributes.email.ordinal()
							|| i == PatientAttributes.tipoSanguineo.ordinal()
							|| i == PatientAttributes.alergias.ordinal()
							|| i == PatientAttributes.descricaoHistoricoFamiliar.ordinal()
						)
						{
							newPatient.listOfAttributes[i] = aux.toString();
						}
						else if(i == PatientAttributes.numero.ordinal())
						{
							newPatient.setNumero(Integer.parseInt(aux));
						}
						else if(i == PatientAttributes.doadorDeOrgaos.ordinal())
						{
							newPatient.setDoadorDeOrgaos(Boolean.parseBoolean(aux));
						}
						else if(i == PatientAttributes.dataDeNascimento.ordinal())
						{
							SimpleDateFormat dataFormat = new SimpleDateFormat (dateFormat);
							Date date = dataFormat.parse(aux);
							newPatient.setDataDeNascimento(date);
						}
					}
					schedulingSystem.listOfPatients.add(newPatient);
					break;
				//System.out.println("17 - Listar pacientes");
				case "17":
					schedulingSystem.printListOfPatients();
					break;
				
				
				//System.out.println("21 - Criar consulta");
				case "21":
					break;
				//System.out.println("22 - Listar consulta");
				case "22":
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
		helper.close();
			
	}
}
