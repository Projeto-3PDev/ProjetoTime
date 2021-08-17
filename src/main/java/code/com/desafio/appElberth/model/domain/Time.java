package code.com.desafio.appElberth.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int anoFundacao;
	private float valor; 
	private String siglaNacao;
	private boolean clubeEmpresa;
	
	public Time() {
		this.setValor(999);
		this.setSiglaNacao("BR");
		this.setClubeEmpresa(false);
	}
	
	public Time(String nome, int anoFundacao) {
		this();
		this.nome = nome;
		this.anoFundacao = anoFundacao;
	}
	
	@Override
	public String toString() {
		return "Sou "+nome+" fundado em " + anoFundacao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoFundacao() {
		return anoFundacao;
	}
	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getSiglaNacao() {
		return siglaNacao;
	}
	public void setSiglaNacao(String siglaNacao) {
		this.siglaNacao = siglaNacao;
	}
	public boolean isClubeEmpresa() {
		return clubeEmpresa;
	}
	public void setClubeEmpresa(boolean clubeEmpresa) {
		this.clubeEmpresa = clubeEmpresa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}