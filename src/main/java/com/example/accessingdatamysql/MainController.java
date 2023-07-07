package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/curso") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private CursoRepository userRepository;

  @PostMapping(path="/nuevo") // Map ONLY POST Requests
  public @ResponseBody String addNewCurso (@RequestParam String nombre
      , @RequestParam Integer creditos) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Curso n = new Curso();
    n.setName(nombre);
    n.setCredito(creditos);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/listar")
  public @ResponseBody Iterable<Curso> getAllCursos() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

  @DeleteMapping(path="/eliminar") // Map ONLY POST Requests
  public @ResponseBody String editCurso (@RequestParam Integer id) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Curso n = new Curso();
    n.setId(id);
    userRepository.delete(n);
    return "Delete";
  }
}