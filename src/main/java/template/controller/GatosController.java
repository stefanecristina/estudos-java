package template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import template.model.Gato;
import template.repository.GatoRepository;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/gatos", produces = { MediaType.APPLICATION_JSON_VALUE, })
public class GatosController {

  @Autowired
  private GatoRepository dao;

  @GetMapping
  public List<Gato> listar() {
    return this.dao.findAll();
  }

  @PostMapping
  public ResponseEntity<Gato> salvar(@RequestBody Gato gato) {
    try {
      return ResponseEntity.ok(this.dao.save(gato));
    }
    catch(DataIntegrityViolationException dive) {
      log.error("Ocorreu um erro ao salvar registro: {}", dive.getMessage());
    }
    catch (Exception e) {
      log.error("Deu outro erro: ", e);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping(value = "/{id}")
  public Gato buscar(@PathVariable Integer id) {
    return this.dao.getById(id);
  }

  @DeleteMapping(value = "/{id}")
  public Gato apagar(@PathVariable Integer id) {
    Gato gato = this.buscar(id);
    this.dao.delete(gato);
    return gato;
  }

}
