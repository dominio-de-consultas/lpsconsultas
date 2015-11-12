package main;

import java.util.Date;

public class User {
	private int id;
	private String nome;
	private int cpf;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	private int telefone;
	private String email;
	private Date dataDeNascimento;
	private String tipoSanguineo;
	private String alergias;
	private String descricaoHistoricoFamiliar;
	private boolean doadorDeOrgaos;
	private String especialidades;
	private int crm;
	private String senha;

	public User(String nome, int cpf, String rua, int numero, String bairro, String cidade, String estado,
			String complemento, int telefone, String email, Date dataDeNascimento, String tipoSanguineo,
			String alergias, String descricaoHistoricoFamiliar, boolean doadorDeOrgaos, String especialidades, int crm,
			String senha) {
		super();
		this.setNome(nome);
		this.cpf = cpf;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.telefone = telefone;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.tipoSanguineo = tipoSanguineo;
		this.alergias = alergias;
		this.descricaoHistoricoFamiliar = descricaoHistoricoFamiliar;
		this.doadorDeOrgaos = doadorDeOrgaos;
		this.especialidades = especialidades;
		this.crm = crm;
		this.senha = senha;
	}

	public User() {

	}

	public User(String[] attributesOfUser) {
		this.nome = attributesOfUser[Attributes.nome.ordinal()];
		this.cpf = Integer.parseInt(attributesOfUser[Attributes.CPF.ordinal()]);
		this.email = attributesOfUser[Attributes.email.ordinal()];
		this.senha = attributesOfUser[Attributes.senha.ordinal()];
		this.telefone = Integer.parseInt(attributesOfUser[Attributes.telefone.ordinal()]);

	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getDescricaoHistoricoFamiliar() {
		return descricaoHistoricoFamiliar;
	}

	public void setDescricaoHistoricoFamiliar(String descricaoHistoricoFamiliar) {
		this.descricaoHistoricoFamiliar = descricaoHistoricoFamiliar;
	}

	public boolean isDoadorDeOrgaos() {
		return doadorDeOrgaos;
	}

	public void setDoadorDeOrgaos(boolean doadorDeOrgaos) {
		this.doadorDeOrgaos = doadorDeOrgaos;
	}

	public String getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void addSchedule(Doctor doctor, Date starterDate, Date finalDate, Boolean available) {
		if (verifySchedules(doctor, starterDate, finalDate)) {
			Schedule schedule = new Schedule(starterDate, finalDate, available);
			doctor.listOfSchedules.add(schedule);
		} else {
			System.out.println("Já existem um cronograma neste horário");
		}

	}

	Boolean verifySchedules(Doctor doctor, Date starterDate, Date finalDate) {
		for (int i = 0; i < doctor.listOfSchedules.size(); i++) {
			Schedule actualSchedule = doctor.listOfSchedules.get(i);
			if ((starterDate.after(actualSchedule.starterDate) && starterDate.before(actualSchedule.finalDate))
					|| (finalDate.before(actualSchedule.finalDate) && finalDate.after(actualSchedule.starterDate))
					|| (starterDate.before(actualSchedule.starterDate) && finalDate.after(actualSchedule.finalDate))) {
				return false;
			}
		}

		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
