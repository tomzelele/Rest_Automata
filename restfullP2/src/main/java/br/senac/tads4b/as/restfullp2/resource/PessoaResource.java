package br.senac.tads4b.as.restfullp2.resource;

import br.senac.tads4b.as.restfullp2.model.Pessoa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResource {
    private Map<Integer, Pessoa> pessoas;

    public PessoaResource() {
        pessoas = new HashMap<Integer, Pessoa>();

        Pessoa c1 = new Pessoa(1, "307", "Pegeout");
        Pessoa c2 = new Pessoa(2, "Doblô", "FIAT");
        Pessoa c3 = new Pessoa(3, "Weekend", "Palio");

        pessoas.put(1, c1);
        pessoas.put(2, c2);
        pessoas.put(3, c3);
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> listar() {
        return new ResponseEntity<List<Pessoa>>(new ArrayList<Pessoa>(pessoas.values()), HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> buscar(@PathVariable("id") Integer id) {
        Pessoa p = pessoas.get(id);
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pessoa>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
        Pessoa curso = pessoas.remove(id);

        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    
}
