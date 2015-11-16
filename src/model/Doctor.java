package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import dao.DaoSchedule;

/**
 * Classe cujos objetos referem-se aos dados do cadastro de um médico cadastrado no sistema
 */
public class Doctor {
	/**
	 * Lista contendo todos os atributos de um médico
	 */
	public Object[] listOfAttributes;

	/**
	 * Conjunto contendo todos os cronogramas de um médicos de forma ordenada
	 */
	TreeSet<Schedule> listOfSchedules = new TreeSet<Schedule>();
	/** referência para a classe que gerencia o relacionamento entre objetos da classe Schedule e o BD*/
	DaoSchedule daoSchedule;
	/**
	 * Construtor para objetos da classe Doctor
	 */
	public Doctor() {
		this.listOfSchedules = new TreeSet<Schedule>();
		this.listOfAttributes = new Object[DoctorAttributes.values().length];
		daoSchedule = new DaoSchedule();
	}
	/**
	 * Atualiza a lista de cronogramas do médico com o que existe no banco de dados.
	 */
	public void updateListOfSchedules(){
		List<Schedule> list = new ArrayList<Schedule>();
		list = daoSchedule.select();
		int i = 0;
		for(Schedule s : list)
		{
			if(s.getCRM() != this.getCRM())
				list.remove(i);
			i++;
		}
		if(list != null)
			this.listOfSchedules = new TreeSet<Schedule>(list);
	}
	
	/**
	 * Insere um cronograma no banco de dados e em seguida atualiza a lista de cronogramas
	 * chamando o método {@link Doctor#updateListOfSchedules()}.
	 * Para isso ele usa a classe {@link DaoSchedule} e método {@link DaoSchedule#insertUpdate(Schedule)}.
	 * @param schedule Um cronograma que será salvo no banco de dados 
	 */
	public void saveOrUpdateSchedule(Schedule schedule){
		daoSchedule.insertUpdate(schedule);
		updateListOfSchedules();
	}
	
	// ----------Getter e Setter genericos----------
	/**
	 * Getter genérico, sendo necessário especificar o atributo no parâmetro de entrada
	 * @param attributeID Código do atributo de acordo com o enum DoctorAttributes
	 * @return Informação do atributo de código attributeID
	 */
	Object getX(int attributeID) {
		return this.listOfAttributes[attributeID];
	}
	
	public void printDoctor(){
		for(int i = 0; i < DoctorAttributes.values().length; i++) 
			System.out.println(DoctorAttributes.values()[i].toString() +": " + this.getX(i));			
	}

	/**
	 * setter genérico, sendo necessário especificar o atributo e o dado a ser adicionado 
	 * @param attributeID Código do atributo de acordo com o enum DoctorAttributes
	 * @param x dado a ser adicionado no atributo de código attributeID
	 */
	void setX(int attributeID, Object x) {
		this.listOfAttributes[attributeID] = x;
	}
	// --------------------
	/**
	 * getter para o atributo CRM
	 * @return
	 */
	public Integer getCRM() {
		return (Integer) this.listOfAttributes[DoctorAttributes.CRM.ordinal()];
	}
	// --------------------
	/**
	 * setter para o atributo CRM
	 * @return
	 */
	public void setCRM(Integer CRM) {
		this.listOfAttributes[DoctorAttributes.CRM.ordinal()] = CRM;
	}
	/**
	 * getter para o atributo nome
	 * @return
	 */
	public String getNome() {
		return (String) this.listOfAttributes[DoctorAttributes.nome.ordinal()];
	}
	/**
	 * setter para o atributo nome
	 * @return
	 */
	public void setNome(String nome) {
		this.listOfAttributes[DoctorAttributes.nome.ordinal()] = nome;
	}
	/**
	 * getter para o atributo CPF
	 * @return
	 */
	public String getCPF() {
		return (String) this.listOfAttributes[DoctorAttributes.CPF.ordinal()];
	}
	/**
	 * setter para o atributo CPF
	 * @return
	 */
	public void setCPF(String cpf) {
		this.listOfAttributes[DoctorAttributes.CPF.ordinal()] = cpf;
	}
	/**
	 * getter para o atributo DataDeNascimento
	 * @return
	 */
	public Date getDataDeNascimento() {
		return (Date) this.listOfAttributes[DoctorAttributes.dataDeNascimento.ordinal()];
	}
	/**
	 * setter para o atributo DataDeNascimento
	 * @return
	 */
	public void setDataDeNascimento(Date data) {
		this.listOfAttributes[DoctorAttributes.dataDeNascimento.ordinal()] = data;
	}
	/**
	 * getter para o atributo especialidade
	 * @return
	 */
	public String getEspecialidade() {
		return (String) this.listOfAttributes[DoctorAttributes.especialidade.ordinal()];
	}
	/**
	 * setter para o atributo especialidade
	 * @return
	 */
	public void setEspecialidade(String especialidade) {
		this.listOfAttributes[DoctorAttributes.especialidade.ordinal()] = especialidade;
	}

	/**
	 * getter para o atributo email
	 * @return
	 */
	public String getEmail() {
		return (String) this.listOfAttributes[DoctorAttributes.email.ordinal()];
	}
	/**
	 * setter para o atributo email
	 * @return
	 */
	public void setEmail(String email) {
		this.listOfAttributes[DoctorAttributes.email.ordinal()] = email;
	}

	/**
	 * getter para o atributo rua
	 * @return
	 */
	public String getRua() {
		return (String) this.listOfAttributes[DoctorAttributes.rua.ordinal()];
	}
	/**
	 * setter para o atributo rua
	 * @return
	 */
	public void setRua(String rua) {
		this.listOfAttributes[DoctorAttributes.rua.ordinal()] = rua;
	}
	/**
	 * getter para o atributo CEP
	 * @return
	 */
	public String getCEP() {
		return (String) this.listOfAttributes[DoctorAttributes.CEP.ordinal()];
	}
	/**
	 * setter para o atributo CEP
	 * @return
	 */
	public void setCEP(String cep) {
		this.listOfAttributes[DoctorAttributes.CEP.ordinal()] = cep;
	}
	
	/**
	 * getter para o atributo número
	 * @return
	 */
	public Integer getNumero() {
		return (Integer) this.listOfAttributes[DoctorAttributes.numero.ordinal()];
	}
	/**
	 * setter para o atributo número
	 * @return
	 */
	public void setNumero(int numero) {
		this.listOfAttributes[DoctorAttributes.numero.ordinal()] = numero;
	}

	/**
	 * setter para o atributo bairro
	 * @return
	 */
	public void setBairro(String bairro) {
		this.listOfAttributes[DoctorAttributes.bairro.ordinal()] = bairro;
	}
	/**
	 * getter para o atributo bairro
	 * @return
	 */
	public String getBairro() {
		return (String) this.listOfAttributes[DoctorAttributes.bairro.ordinal()];
	}
	/**
	 * setter para o atributo municipio
	 * @return
	 */
	public void setMunicipio(String municipio) {
		this.listOfAttributes[DoctorAttributes.municipio.ordinal()] = municipio;
	}

	/**
	 * getter para o atributo municipio
	 * @return
	 */
	public String getMunicipio() {
		return (String) this.listOfAttributes[DoctorAttributes.municipio.ordinal()];
	}
	/**
	 * setter para o atributo estado
	 * @return
	 */
	public void setEstado(String estado) {
		this.listOfAttributes[DoctorAttributes.estado.ordinal()] = estado;
	}

	/**
	 * getter para o atributo estado
	 * @return
	 */
	public String getEstado() {
		return (String) this.listOfAttributes[DoctorAttributes.estado.ordinal()];
	}
	/**
	 * setter para o atributo complemento
	 * @return
	 */
	public void setComplemento(String complemento) {
		this.listOfAttributes[DoctorAttributes.complemento.ordinal()] = complemento;
	}
	
	/**
	 * getter para o atributo complemento
	 * @return
	 */
	public String getComplemento() {
		return (String) this.listOfAttributes[DoctorAttributes.complemento.ordinal()]; 
	}
	/**
	 * setter para o atributo telefone
	 * @return
	 */
	public void setTelefone(String telefone) {
		this.listOfAttributes[DoctorAttributes.telefone.ordinal()] = telefone;
	}
	/**
	 * getter para o atributo telefone
	 * @return
	 */
	public String getTelefone() {
		return (String) this.listOfAttributes[DoctorAttributes.telefone.ordinal()];
	}

	/**
	 * Metodo que lista todos o cronograma do médico em questão.
	 *
	 */
	public void printListOfSchedules() {
		System.out.println("\nCRONOGRAMA DE "+ getNome() + "\n");

		for (Schedule s: this.listOfSchedules) {		

			System.out.println("\nID: " + s.getPid());
			System.out.println("Início: " + s.starterDate.toString());
			System.out.println("Término: " + s.finalDate.toString());
			System.out.println("Disponibilidade: " + s.available.toString());
			System.out.println("Marcado por(CPF): " + s.cpfUser);
			System.out.println("Pertence ao médico(CRM): " + s.getCRM());
			System.out.println("Para o paciente: "+ s.getCPF());
		}
	}
	
	/**
	 * Metodo que lista todos o cronograma do médico em questão.
	 *
	 */
	public void printListOfConsultation() {
		System.out.println("\nConsultas de "+ getNome() + "\n");

		for (Schedule s: this.listOfSchedules) {		
			if(!s.getAvailable())
			{
				System.out.println("\nID: " + s.getPid());
				System.out.println("Início: " + s.starterDate.toString());
				System.out.println("Término: " + s.finalDate.toString());
				System.out.println("Disponibilidade: " + s.available.toString());
				System.out.println("Marcado por(CPF): " + s.cpfUser);
				System.out.println("Pertence ao médico(CRM): " + s.getCRM());
				System.out.println("Para o paciente: "+ s.getCPF());
			}
		}
	}
	/**
	 * Metodo que lista todos o cronograma de horários disponíveis do médico em questão.
	 *
	 */
	public void printListOfAvailableSchedules() {
		System.out.println("\nCRONOGRAMA DE "+ getNome() + "\n");

		for (Schedule s: this.listOfSchedules) {		
			if(s.available == true)
			{
				System.out.println("\nID: " + s.getPid());
				System.out.println("Início: " + s.starterDate.toString());
				System.out.println("Término: " + s.finalDate.toString());
				System.out.println("Disponibilidade: " + s.available.toString());
			}
			
		}
	}
	

}
