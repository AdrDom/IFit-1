package br.edu.ifpb.resteasyapp.entidade;

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
@Table(name = "tb_alimento")
@NamedQuery(name = "Alimento.getAll", query = "from Alimento")
public class Alimento {
	
	public Alimento(){
		
	}

	public Alimento(String nome, String calorias, String proteinas, String carboidratos, String gorduras) {
		super();
		this.nome = nome;
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.carboidratos = carboidratos;
		this.gorduras = gorduras;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alimento")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "calorias")
	private String calorias;
	
	@Column(name = "proteinas")
	private String proteinas;
	
	@Column(name = "carboidratos")
	private String carboidratos;
	
	@Column(name = "gorduras")
	private String gorduras;
	
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getCalorias() {
		return calorias;
	}

	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}
	
	@XmlElement
	public String getProteinas() {
		return proteinas;
	}

	public void setProteinas(String proteinas) {
		this.proteinas = proteinas;
	}
	
	@XmlElement
	public String getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(String carboidratos) {
		this.carboidratos = carboidratos;
	}
	
	@XmlElement
	public String getGorduras() {
		return gorduras;
	}

	public void setGorduras(String gorduras) {
		this.gorduras = gorduras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calorias == null) ? 0 : calorias.hashCode());
		result = prime * result + ((carboidratos == null) ? 0 : carboidratos.hashCode());
		result = prime * result + ((gorduras == null) ? 0 : gorduras.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((proteinas == null) ? 0 : proteinas.hashCode());
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
		Alimento other = (Alimento) obj;
		if (calorias == null) {
			if (other.calorias != null)
				return false;
		} else if (!calorias.equals(other.calorias))
			return false;
		if (carboidratos == null) {
			if (other.carboidratos != null)
				return false;
		} else if (!carboidratos.equals(other.carboidratos))
			return false;
		if (gorduras == null) {
			if (other.gorduras != null)
				return false;
		} else if (!gorduras.equals(other.gorduras))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (proteinas == null) {
			if (other.proteinas != null)
				return false;
		} else if (!proteinas.equals(other.proteinas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alimento [id=" + id + ", nome=" + nome + ", calorias=" + calorias + ", proteinas=" + proteinas
				+ ", carboidratos=" + carboidratos + ", gorduras=" + gorduras + "]";
	}
	
}
