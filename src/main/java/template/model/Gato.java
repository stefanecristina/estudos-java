package template.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity @Table(name = "gato")
@Accessors(chain = true)
@Getter @Setter
public class Gato {

  @Id
  @GeneratedValue
  @Column(name = "id")
	private Integer id;

  @Column(name = "nome", nullable = false)
	private String nome;

  @Column(name = "raca")
	private String raca;

  @Column(name = "cor")
	private String cor;

  @Column(name = "origem")
  private String origem;
	}
