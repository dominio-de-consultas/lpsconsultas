package main;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.DaoDoctor;
import dao.DaoPatient;
import dao.DaoUser;
import util.HibernateHelper;

/** @class SchedulingSystem
 * 
 * @author Eliton
 *
 */
public class SchedulingSystem
{
	/** Cria conexão com o banco de dados*/
	private HibernateHelper helper;
	/** referência para a classe que gerencia o relacionamento entre objetos da classe User e o BD*/
	private DaoUser daoUser;
	/** referência para a classe que gerencia o relacionamento entre objetos da classe Doctor e o BD*/
	private DaoDoctor daoDoctor;
	/** referência para a classe que gerencia o relacionamento entre objetos da classe Patient e o BD*/
	private DaoPatient daoPatient;
	//----------Attributes----------
	/** Lista de usuários*/
	public List<User> listOfUsers;
	/** Lista de médicos*/
	public List<Doctor> listOfDoctors;
	/** Lista de pacientes*/
	public List<Patient> listOfPatients;

	static SimpleDateFormat dateAndHourFormat;
	static SimpleDateFormat dateFormat;
	static String dateString = "dd/MM/yyyy";
	static String dateAndHourString = "dd/MM/yyyy HH:mm";
	
	//----------Constructor method----------
	/** construtor de um objeto da classe SchedulingSystem*/
	SchedulingSystem()
	{
		this.helper = new HibernateHelper();
		this.listOfDoctors = new ArrayList<Doctor>();
		this.listOfPatients = new ArrayList<Patient>();
		this.listOfUsers = new ArrayList<User>();
		
		daoUser = new DaoUser();
		daoDoctor = new DaoDoctor();
		daoPatient = new DaoPatient();
		this.listOfDoctors = daoDoctor.select();
		this.listOfUsers = daoUser.select();
		this.listOfPatients = daoPatient.select();	
		
		for(Doctor d : this.listOfDoctors)
			d.updateListOfSchedules();
		
		String[] attributesOfDefaultUser = new String[Attributes.values().length];
		attributesOfDefaultUser[Attributes.nome.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.senha.ordinal()] = "admin";
		attributesOfDefaultUser[Attributes.CPF.ordinal()] = "000";
		attributesOfDefaultUser[Attributes.telefone.ordinal()] = "[vazio]";
		attributesOfDefaultUser[Attributes.email.ordinal()] = "[vazio]";
		
		User defaultUser = new User(attributesOfDefaultUser);
		this.listOfUsers.add(defaultUser);

		dateFormat = new SimpleDateFormat (SchedulingSystem.dateString);
		dateAndHourFormat = new SimpleDateFormat(SchedulingSystem.dateAndHourString);
	}
	
	/**
	 * Método que realiza a verificação do login
	 * @param userID código valor único que se refere a um certo usuário (O CPF no nosso caso)
	 * @param password senha do usuário
	 */
	Boolean login(String userID, String password)
	{
		for(int i = 0; i < this.listOfUsers.size(); i++)
		{
			User user = this.listOfUsers.get(i);
			if
			(
				user.listOfAttributes[Attributes.CPF.ordinal()].equals(userID)
				&&
				user.listOfAttributes[Attributes.senha.ordinal()].equals(password)
			)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**Método que verifica se já existe um usuário cadastrado no sistema*/
	Boolean hasUser()
	{
		return ! this.listOfUsers.isEmpty();
	}
	/**Método que verifica se já existe um médico cadastrado no sistema*/
	Boolean hasDoctor()
	{
		return ! this.listOfDoctors.isEmpty();
		
	}
	/**Método que verifica se já existe um paciente cadastrado no sistema*/
	Boolean hasPatient()
	{
		return ! this.listOfPatients.isEmpty();
	}
	
	//----------User methods----------
	/**Método que cria um usuário e o adiciona no sistema
	 * @param attributesOfUser Atributos referentes ao usuário que será adicionado
	 */
	public void createUser(String[] attributesOfUser)
	{
		User newUser = new User(attributesOfUser);
		daoUser.insertUpdate(newUser);
		listOfUsers.add(newUser);
	}
	
	public void editUser()
	{
		;
	}
	
	public void removeUser()
	{
		;
	}
	
	/**
	 * Busca por usuário no sistema à partir do seu nome
	 * @param nome Nome a ser buscado no sistema
	 * @return Usuário cujo nome é igual ao buscado ou Null
	 */
	public User searchUserByName(String nome)
	{
		List<User> ls = daoUser.select();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getNome().equals(nome)){
				return ls.get(i);
			}
		return null;
	
	}
	/**
	 * Imprime no terminal uma lista contendo todos os usuários cadastrados no sistema
	 */
	public void printListOfUsers()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfUsers.size(); i++)
		{
			System.out.println(i+" : "+this.listOfUsers.get(i).getNome());
		}
		System.out.println("\n");
	}
	

	//----------Doctors methods----------
	/**
	 * Método que insere um médico no BD
	 * @param doctor médico a ser inserido no BD
	 */
	public void createOrUpdateDoctor(Doctor doctor){
		daoDoctor.insertUpdate(doctor);
	}
	/**
	 * Método que insere um paciente no BD
	 * 
	 */
	public void createOrUpdatePatient(Patient patient){
		daoPatient.insertUpdate(patient);
	}
	
	/**
	 * Método que configura uma consulta no BD, através do doutor passado por parâmetro 
	 * recuperando seu cronograma, do paciente que participará da consulta e do identificador 
	 * do cronograma.
	 * @param doctor
	 * @param patient
	 * @param idSchedule
	 * @return Retorna true para sucesso na configuração de uma consulta e false para o contrário.
	 * @see {@link Doctor}, {@link Patient}, {@link Schedule}
	 */
	public Boolean createConsultation(Doctor doctor, Patient patient, Integer idSchedule){
		for(Schedule s : doctor.listOfSchedules)
			if(s.getPid().equals(idSchedule)){
				if(s.getAvailable()){
					s.setAvailable(false);
					s.setCPF(patient.getCPF());
					doctor.saveOrUpdateSchedule(s);
					return true;
				}
			}
		return false;
	}
	/**
	 * Imprime no terminal uma lista contendo todos os médicos cadastrados no sistema
	 */
	public void printListOfDoctors()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfDoctors.size(); i++)
		{
			System.out.println(i+" : "+this.listOfDoctors.get(i).getNome());
		}
		System.out.println("\n");
	}
	
	
	//----------Patientss methods----------
	/**
	 * Imprime no terminal uma lista contendo todos os pacientes cadastrados no sistema
	 */
	public void printListOfPatients()
	{
		System.out.println("\n");
		for(int i = 0; i < this.listOfPatients.size(); i++)
		{
			System.out.println(i+" : "+this.listOfPatients.get(i).getNome());
		}
		System.out.println("\n");
	}
	
	/**
	 * Método para fechar a conexão com o BD
	 * @see {@link HibernateHelper}
	 */
	public void closeHelper(){
		this.helper.close();
	}
	
}
