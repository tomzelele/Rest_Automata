package br.senac.tads4b.as.restfullp2.resource;

import br.senac.tads4b.as.restfullp2.model.Carro;
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
public class CarroResource {
    private Map<Integer, Carro> carros;

    public CarroResource() {
        carros = new HashMap<Integer, Carro>();

        Carro c1 = new Carro(1, "307", "Pegeout");
        Carro c2 = new Carro(2, "Doblô", "FIAT");
        Carro c3 = new Carro(3, "Weekend", "Palio");

        carros.put(1, c1);
        carros.put(2, c2);
        carros.put(3, c3);
    }

    @RequestMapping(value = "/carros", method = RequestMethod.GET)
    public ResponseEntity<List<Carro>> listar() {
        return new ResponseEntity<List<Carro>>(new ArrayList<Carro>(carros.values()), HttpStatus.OK);
    }

    @RequestMapping(value = "/carros/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carro> buscar(@PathVariable("id") Integer id) {

        Carro car = carros.get(id);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Carro>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/carros/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
        Carro curso = carros.remove(id);

        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    
}
