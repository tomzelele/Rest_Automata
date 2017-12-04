package br.senac.tads4b.as.restfullp2.resource;

import java.util.HashMap;
import java.util.Map;
import br.senac.tads4b.as.restfullp2.model.Curso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoResource {

    private Map<Integer, Curso> cursos;

    public CursoResource() {
        cursos = new HashMap<>();

        Curso c1 = new Curso(1, "Tecnologia Analise e Desenvolvimento de sistema", "5 semestres");
        Curso c2 = new Curso(2, "Tecnologia em Banco de dados", "5 semestres");
        Curso c3 = new Curso(3, "Bacharelado Ciência da Computação", "10 semestres");

        cursos.put(1, c1);
        cursos.put(2, c2);
        cursos.put(3, c3);
    }

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public ResponseEntity<List<Curso>> listar() {
        return new ResponseEntity<>(new ArrayList<>(cursos.values()), HttpStatus.OK);
    }

    @RequestMapping(value = "/cursos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Curso> buscar(@PathVariable("id") Integer id) {

        Curso curso = cursos.get(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @RequestMapping(value = "/cursos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
        Curso curso = cursos.remove(id);

        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    /*
    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Produto> listar() {
      return service.listar(0, 100);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public Produto obter(@PathVariable("id") Long idProd) {
      return service.obter(idProd);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> salvar(@RequestBody Produto p) {
      if (p != null) {
        p.setDtCadastro(new Date());
        if (p.getIdCategorias() != null && !p.getIdCategorias().isEmpty()) {
          Set<Categoria> categorias = new LinkedHashSet<Categoria>();
          for (Integer i : p.getIdCategorias()) {
            Categoria c = categoriaService.obter(i);
            Set<Produto> produtos = new LinkedHashSet<Produto>();
            produtos.add(p);
            c.setProdutos(produtos);
            categorias.add(c);
          }
          p.setCategorias(categorias);
        }
        service.incluir(p);
        return new ResponseEntity<Produto>(HttpStatus.CREATED);
      }
      return new ResponseEntity<Produto>(HttpStatus.BAD_REQUEST);
    }
      */

}
