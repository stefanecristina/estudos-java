package template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import template.model.Gato;

public interface GatoRepository extends JpaRepository<Gato, Integer> {

}
