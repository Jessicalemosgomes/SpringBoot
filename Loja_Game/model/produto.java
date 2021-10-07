package br.org.generation.minhaLojaDeGames.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_produto")
public class produto {

			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@Size(min = 3, max = 100)
			@NotNull
			private String produto;
			
			@NotNull
			private int estoqueproduto = 0;
			
			@NotNull
			private float preco = 0;
			
			@Temporal(TemporalType.TIMESTAMP)
			private Date data = new java.sql.Date(System.currentTimeMillis());

			@ManyToOne
			@JsonIgnoreProperties("listaproduto")
			private categoria categoria;
			
			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getproduto() {
				return produto;
			}

			public void setproduto(String produto) {
				this.produto = produto;
			}

			public double getpreco() {
				return preco;
			}

			public void setpreco(float preco) {
				this.preco = (@NotNull float) preco;
			}

			public int getEstoqueproduto() {
				return estoqueproduto;
			}

			public void setEstoqueproduto(int estoqueProduto) {
				this.estoqueproduto = estoqueProduto;
			}

			public Date getData() {
				return data;
			}

			public void setData(Date data) {
				this.data = data;
			}

			public categoria getcategoria() {
				return categoria;
			}

			public void setCategoria(categoria categoria) {
				this.categoria = categoria;
			}

}
