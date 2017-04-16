package br.edu.ifpb.resteasyapp.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tb_refeicao")
@NamedQuery(name = "Refeicao.getAll", query = "from Refeicao")
public class Refeicao {
	
	public Refeicao(){
		
	}
	
	public Refeicao(String suco, String carne, String graos, String fruta, String complemento, Date dia) {
		super();
		this.suco = suco;
		this.carne = carne;
		this.graos = graos;
		this.fruta = fruta;
		this.complemento = complemento;
		this.dia = dia;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_refeicao")
	private int id;
	
	@Column(name = "suco")
	private String suco;
	
	@Column(name = "carne")
	private String carne;
	
	@Column(name = "graos")
	private String graos;
	
	@Column(name = "fruta")
	private String fruta;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "dia")
	private Date dia = new Date();

	@XmlElement
	public String getFruta() {
		return fruta;
	}

	public void setFruta(String fruta) {
		this.fruta = fruta;
	}

	@XmlElement
	public String getCompletmento() {
		return complemento;
	}

	public void setCompletmento(String completmento) {
		this.complemento = completmento;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getSuco() {
		return suco;
	}

	public void setSuco(String suco) {
		this.suco = suco;
	}
	
	@XmlElement
	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}
	
	@XmlElement
	public String getGraos() {
		return graos;
	}

	public void setGraos(String graos) {
		this.graos = graos;
	}
	
	@XmlElement
	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carne == null) ? 0 : carne.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((fruta == null) ? 0 : fruta.hashCode());
		result = prime * result + ((graos == null) ? 0 : graos.hashCode());
		result = prime * result + id;
		result = prime * result + ((suco == null) ? 0 : suco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		if (carne == null) {
			if (other.carne != null)
				return false;
		} else if (!carne.equals(other.carne))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (fruta == null) {
			if (other.fruta != null)
				return false;
		} else if (!fruta.equals(other.fruta))
			return false;
		if (graos == null) {
			if (other.graos != null)
				return false;
		} else if (!graos.equals(other.graos))
			return false;
		if (id != other.id)
			return false;
		if (suco == null) {
			if (other.suco != null)
				return false;
		} else if (!suco.equals(other.suco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Refeicao [id=" + id + ", suco=" + suco + ", carne=" + carne + ", graos=" + graos + ", fruta=" + fruta
				+ ", completmento=" + complemento + ", dia=" + dia + "]";
	}
	
}
