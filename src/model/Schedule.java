package model;
import java.util.Date;

/**
 * Classe que se refere a um cronograma de um médico.
 * Ela possui informações como data de início e fim,
 * disponibilidade e identificador do médico(CRM {@link Doctor#getCRM()})
 * @author Eliton
 * @see Doctor
 */
public class Schedule implements Comparable<Schedule>
{
	/**
	 * Identificador do cronograma
	 */
	private Integer pid;
	/**
	 * Data de início do horário disponível de um médico.
	 */
	public Date starterDate;
	/**
	 * Data final do horário disponivel de um médico.
	 */
	public Date finalDate;
	/**
	 * Atributo que guarda a disponibilidade do cronograma.
	 */
	public Boolean available;
	/**
	 * Identificador do médico que o possui.
	 * @see Doctor
	 */
	public Integer crm;
	/**
	 * Identificador do paciente agendado para aquela data e hora.
	 * @see Doctor
	 */
	public String cpf;
	/**
	 * Identificador do usuário que agendou a consulta.
	 */
	public String cpfUser;
	/**
	 * @return Retorna o cpf do usuário que criou a consulta.
	 */
	public String getCpfUser() {
		return cpfUser;
	}

	/**
	 * @param cpfUser Configura o cpf do usuário que criou a consulta.
	 */
	public void setCpfUser(String cpfUser) {
		this.cpfUser = cpfUser;
	}

	/**
	 * 
	 * @return Retorna id do médico que o possui.(CRM)
	 */
	public Integer getCRM() {
		return crm;
	}

	/**
	 * Configura o médico ao qual pertence esse cronograma, com o CRM do médico.
	 * @param did
	 */
	public void setCRM(Integer did) {
		this.crm = did;
	}
	/**
	 * 
	 * @return Retorna id do médico que o possui.(CRM)
	 */
	public String getCPF() {
		return cpf;
	}

	/**
	 * Configura o médico ao qual pertence esse cronograma, com o CRM do médico.
	 * @param did
	 */
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o identificador do cronograma.
	 * @return
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * Configura o identificado do cronograma.
	 * @param pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * Retorna a data de início do cronograma.
	 * @return Retorna a data de início do cronograma.
	 */
	public Date getStarterDate() {
		return starterDate;
	}

	/**
	 * Configura a data de início do cronograma.
	 * @param starterDate
	 */
	public void setStarterDate(Date starterDate) {
		this.starterDate = starterDate;
	}

	/**
	 * 
	 * @return Retorna a data final do cronograma.
	 */
	public Date getFinalDate() {
		return finalDate;
	}

	/**
	 * Configura a data final do cronograma.
	 * @param finalDate
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	/**
	 * 
	 * @return Retorna a disponibilidade do cronograma.
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * Configura a disponibilidade do cronograma.
	 * @param available
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	/**
	 * Construtor para os atributos.
	 * @param starterDate
	 * @param finalDate
	 * @param available
	 * @param did
	 */
	public Schedule(Date starterDate, Date finalDate, Boolean available, Integer did)
	{
		this.starterDate = starterDate;
		this.finalDate = finalDate;
		this.available = available;
		this.crm = did;
	}
	
	/**
	 * Construtor que inicializa a disponibilidade com falso.
	 */
	public Schedule()
	{
		this.available = false;
	}
	

	/**
	 * Realiza a comparação entre dois cronogramas através da data inicial.
	 */
	@Override
	public int compareTo(Schedule o) {
		
		return this.starterDate.compareTo(o.starterDate);
	}
}