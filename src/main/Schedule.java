package main;
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
	private long pid;
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
	public long did;
	
	/**
	 * 
	 * @return Retorna id do médico que o possui.(CRM)
	 */
	public long getDid() {
		return did;
	}

	/**
	 * Configura o médico ao qual pertence esse cronograma, com o CRM do médico.
	 * @param did
	 */
	public void setDid(long did) {
		this.did = did;
	}

	/**
	 * Retorna o identificador do cronograma.
	 * @return
	 */
	public long getPid() {
		return pid;
	}

	/**
	 * Configura o identificado do cronograma.
	 * @param pid
	 */
	public void setPid(long pid) {
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
	public Schedule(Date starterDate, Date finalDate, Boolean available, long did)
	{
		this.starterDate = starterDate;
		this.finalDate = finalDate;
		this.available = available;
		this.did = did;
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
		// TODO Auto-generated method stub
		return this.starterDate.compareTo(o.starterDate);
	}
}