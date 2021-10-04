package br.org.generation.farmacia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_categotia")
public class categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max = 100, message = "Preencha o campo com até 100 caracteres")
	private String medicamentos;
	
	@NotNull
	@Size(min = 3, max = 100, message = "Preencha o campo com até 100 caracteres")
	private String cosmeticos;
	
	@NotNull
	@Size(min = 3, max = 100, message = "Preencha o campo com até 100 caracteres")
	private String vitaminas_suplementos;
	
	@NotNull
	@Size(min = 3, max = 100, message = "Preencha o campo com até 100 caracteres")
	private String ortopedia_e_acessorios;

	@OneToMany(mappedBy = "categoria")
	@JsonIgnoreProperties("categoria")
	private List<produto> produto;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getCosmeticos() {
		return cosmeticos;
	}

	public void setCosmeticos(String cosmeticos) {
		this.cosmeticos = cosmeticos;
	}

	public String getVitaminas_suplementos() {
		return vitaminas_suplementos;
	}

	public void setVitaminas_suplementos(String vitaminas_suplementos) {
		this.vitaminas_suplementos = vitaminas_suplementos;
	}

	public String getOrtopedia_e_acessorios() {
		return ortopedia_e_acessorios;
	}

	public void setOrtopedia_e_acessorios(String ortopedia_e_acessorios) {
		this.ortopedia_e_acessorios = ortopedia_e_acessorios;
	}
	
}
