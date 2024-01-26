package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "Vasco da Gama!!!! \n \n Me encontre: https://linktr.ee/yagoavial";
    }

    /**
     * Toda nova funcionalidade sempre deve ter:
     * Controller, para mapear a requisição da nova funcionalidade;
     * DTOs, que representam os dados que chegam e saem da API;
     * Entidade JPA;
     * Repository, para isolar o acesso ao banco de dados;
     * Migration, para fazer as alterações no banco de dados.
     * Regras de negócio
     */

}
