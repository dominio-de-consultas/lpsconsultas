package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{

	static Date dateAux;
	static String aux;
	static SimpleDateFormat dateAndHourFormat;
	static SimpleDateFormat dateFormat;
	static Scanner scanner;
	public static void main(String[] args)
	{ 
		dateFormat = new SimpleDateFormat (SchedulingSystem.dateString);
		dateAndHourFormat = new SimpleDateFormat(SchedulingSystem.dateAndHourString);
		scanner = new Scanner(System.in);

		SchedulingSystem schedulingSystem = new SchedulingSystem();
		
		Boolean validPassword = false;
		do
		{
			System.out.println("Lista de usuários cadastrados:");
			schedulingSystem.printListOfUsers();
			
			System.out.println("LOGIN");			
			System.out.print("CPF: ");
			String userID = scanner.nextLine();
			System.out.print("senha: ");
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
			panelOptions(schedulingSystem);
			option = scanner.nextLine();
			option = option.toUpperCase();
			
			switch (option)
			{
				//------------------------------------------------------------
				//Cria um novo usuario
				case "01":
					createUser(schedulingSystem);
					break;
				//------------------------------------------------------------
				//Editar usuario		
				case "02":
					editUser(schedulingSystem);
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
				//Buscar um usuario
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
					createDoctor(schedulingSystem);					
					break;
				//------------------------------------------------------------
				//System.out.println("07 - Listar medicos");
				case "07":
					schedulingSystem.printListOfDoctors();
					break;
				//------------------------------------------------------------
				//System.out.println("11 - Criar cronograma");
				case "11":
					insertSchedule(schedulingSystem);
					break;
				//------------------------------------------------------------
				//System.out.println("13 - Listar cronograma");
				case "13":
					break;	
					
				//------------------------------------------------------------
				//System.out.println("16 - Criar um Paciente");
	
				case "16":
					createPatient(schedulingSystem);
					break;
				
				//------------------------------------------------------------
				//System.out.println("17 - Listar paciente");
				case "17":
					schedulingSystem.printListOfPatients();
					break;
				//------------------------------------------------------------
				//0 - encerrra o sistema
				case "0":
					flag = false;
					break;
					
				default:
					System.out.println("Escolha uma opção válida.");
					break;
				
			}
			
		}
		scanner.close();
		schedulingSystem.closeHelper();
			
	}

	private static void createPatient(SchedulingSystem schedulingSystem) {
		// TODO Auto-generated method stub
		Patient newPatient = new Patient();
		
		
		for(int i = 0; i < PatientAttributes.values().length; i++)
		{
			System.out.println(PatientAttributes.values()[i].toString()+": ");
			aux = scanner.nextLine();
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
				try {
					dateAux = dateFormat.parse(aux);
					newPatient.setDataDeNascimento(dateAux);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					schedulingSystem.closeHelper();
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		schedulingSystem.listOfPatients.add(newPatient);		
	}

	private static void insertSchedule(SchedulingSystem schedulingSystem) {
		// TODO Auto-generated method stub
		System.out.println("\nEscolha um médico:");
		schedulingSystem.printListOfDoctors();
		aux = scanner.nextLine();
		Doctor doctor = schedulingSystem.listOfDoctors.get(Integer.parseInt(aux));
		Schedule newSchedule = new Schedule();
		
		System.out.println("Cronogramas existentes:");
		doctor.printListOfSchedules();
		
		
		
		System.out.println("Entre com a data inicial e hora inicial(Ex.: " + SchedulingSystem.dateAndHourString + ")");
		aux = scanner.nextLine();
		try {
			dateAux = dateAndHourFormat.parse(aux);
			newSchedule.setStarterDate(dateAux);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			schedulingSystem.closeHelper();
			e.printStackTrace();
			System.exit(1);
		}
			
		
		
		System.out.println("Entre com a data final:");
		aux = scanner.nextLine();
		
		try {
			dateAux = dateAndHourFormat.parse(aux);
			newSchedule.setFinalDate(dateAux);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			schedulingSystem.closeHelper();
			e.printStackTrace();
			System.exit(1);
		}
				
		doctor.listOfSchedules.add(newSchedule);
		
		
	}

	private static void createDoctor(SchedulingSystem schedulingSystem) {
		// TODO Auto-generated method stub
		Doctor newDoctor = new Doctor();
		for(int i = 0; i < DoctorAttributes.values().length; i++)
		{
			System.out.println(DoctorAttributes.values()[i].toString()+": ");
			aux = scanner.nextLine();
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
			
				try {
					dateAux = dateFormat.parse(aux);
					newDoctor.setDataDeNascimento(dateAux);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					schedulingSystem.closeHelper();
					e.printStackTrace();
					System.exit(1);
				}
			}
			else if(i == DoctorAttributes.numero.ordinal() || i == DoctorAttributes.CRM.ordinal())
			{
				newDoctor.listOfAttributes[i] = Integer.parseInt(aux);
			}
		}
		schedulingSystem.createDoctor(newDoctor);
		//schedulingSystem.listOfDoctors.add(newDoctor);
		
	}

	private static void editUser(SchedulingSystem schedulingSystem) {
		// TODO Auto-generated method stub
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
	}

	private static void createUser(SchedulingSystem schedulingSystem) {
		// TODO Auto-generated method stub
		System.out.println("Entre com os atributos do usuario");
		String[] attributesOfUser = new String[Attributes.values().length];
		for(int i = 0; i < Attributes.values().length; i++)
		{
			System.out.print(Attributes.values()[i].toString()+" : ");
			String attribute = scanner.nextLine();
			attributesOfUser[i] = attribute;
		}
							
		schedulingSystem.createUser(attributesOfUser);
		
	}

	private static void panelOptions(SchedulingSystem schedulingSystem) {
		// TODO Auto-generated method stub
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
			
			System.out.println("11 - Criar cronograma");
			//System.out.println("12 - Editar cronograma");
			System.out.println("13 - Listar cronograma");
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
			//System.out.println("21 - Criar consulta");
			//System.out.println("22 - Listar consulta");
			//System.out.println("23 - Alterar consulta");
			//System.out.println("24 - Buscar consulta");
			//System.out.println("25 - Remover consulta");
		}
		
		System.out.println("0 - encerrra o sistema");
		System.out.print("Opcao escolhida:");		
	}
}
