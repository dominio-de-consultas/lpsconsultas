package main;

import java.util.Date;
import java.util.TreeSet;

public class Doctor {
	public Object[] listOfAttributes;

	TreeSet<Schedule> listOfSchedules = new TreeSet<Schedule>();
	// ----------Getter e Setter genericos----------
	Object getX(int attributeID) {
		return this.listOfAttributes[attributeID];
	}

	void setX(int attributeID, Object x) {
		this.listOfAttributes[attributeID] = x;
	}
	// --------------------

	public Integer getCRM() {
		return (Integer) this.listOfAttributes[DoctorAttributes.CRM.ordinal()];
	}

	public void setCRM(Integer CRM) {
		this.listOfAttributes[DoctorAttributes.CRM.ordinal()] = CRM;
	}

	public String getNome() {
		return (String) this.listOfAttributes[DoctorAttributes.nome.ordinal()];
	}

	public void setNome(String nome) {
		this.listOfAttributes[DoctorAttributes.nome.ordinal()] = nome;
	}

	public String getCPF() {
		return (String) this.listOfAttributes[DoctorAttributes.CPF.ordinal()];
	}

	public void setCPF(String cpf) {
		this.listOfAttributes[DoctorAttributes.CPF.ordinal()] = cpf;
	}

	public Date getDataDeNascimento() {
		return (Date) this.listOfAttributes[DoctorAttributes.dataDeNascimento.ordinal()];
	}

	public void setDataDeNascimento(Date data) {
		this.listOfAttributes[DoctorAttributes.dataDeNascimento.ordinal()] = data;
	}

	public String getEspecialidade() {
		return (String) this.listOfAttributes[DoctorAttributes.especialidade.ordinal()];
	}

	public void setEspecialidade(String especialidade) {
		this.listOfAttributes[DoctorAttributes.especialidade.ordinal()] = especialidade;
	}

	public String getEmail() {
		return (String) this.listOfAttributes[DoctorAttributes.email.ordinal()];
	}

	public void setEmail(String email) {
		this.listOfAttributes[DoctorAttributes.email.ordinal()] = email;
	}

	public String getRua() {
		return (String) this.listOfAttributes[DoctorAttributes.rua.ordinal()];
	}

	public void setRua(String rua) {
		this.listOfAttributes[DoctorAttributes.rua.ordinal()] = rua;
	}

	public String getCEP() {
		return (String) this.listOfAttributes[DoctorAttributes.CEP.ordinal()];
	}

	public void setCEP(String cep) {
		this.listOfAttributes[DoctorAttributes.CEP.ordinal()] = cep;
	}
	public void setNumero(int numero) {
		this.listOfAttributes[DoctorAttributes.numero.ordinal()] = numero;
	}

	public Integer getNumero() {
		return (Integer) this.listOfAttributes[DoctorAttributes.numero.ordinal()];
	}

	public void setBairro(String bairro) {
		this.listOfAttributes[DoctorAttributes.bairro.ordinal()] = bairro;
	}

	public String getBairro() {
		return (String) this.listOfAttributes[DoctorAttributes.bairro.ordinal()];
	}

	public void setMunicipio(String municipio) {
		this.listOfAttributes[DoctorAttributes.municipio.ordinal()] = municipio;
	}

	public String getMunicipio() {
		return (String) this.listOfAttributes[DoctorAttributes.municipio.ordinal()];
	}

	public void setEstado(String estado) {
		this.listOfAttributes[DoctorAttributes.estado.ordinal()] = estado;
	}

	public String getEstado() {
		return (String) this.listOfAttributes[DoctorAttributes.estado.ordinal()];
	}

	public void setComplemento(String complemento) {
		this.listOfAttributes[DoctorAttributes.complemento.ordinal()] = complemento;
	}

	public String getComplemento() {
		return (String) this.listOfAttributes[DoctorAttributes.complemento.ordinal()]; 
	}

	public void setTelefone(String telefone) {
		this.listOfAttributes[DoctorAttributes.telefone.ordinal()] = telefone;
	}

	public String getTelefone() {
		return (String) this.listOfAttributes[DoctorAttributes.telefone.ordinal()];
	}

	public Doctor() {
		this.listOfSchedules = new TreeSet<Schedule>();
		this.listOfAttributes = new Object[DoctorAttributes.values().length];
	}
	public void printListOfSchedules() {
		System.out.println("\nCRONOGRAMA\n");

		for (Schedule s: this.listOfSchedules) {
			

			System.out.println("\nID: " + s.getPid());
			System.out.println("Início: " + s.starterDate.toString());
			System.out.println("Término: " + s.finalDate.toString());
			System.out.println("Disponibilidade: " + s.available.toString());
		}
	}

}
