package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        //System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping //Anotacoes de PageableDefault são facultativos. Se o parâmetro existir na url, vale a url
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort={"nome"}) Pageable paginacao) {
        //return repository.findAll();
        //return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();
        //return repository.findAll(paginacao).map(DadosListagemMedico::new);
        return repository.findByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medicos = repository.getReferenceById(dados.id());
        medicos.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        //ESSA EXCLUSÃO É A REAL
        //repository.deleteById(id);

        //ESSA É A EXCLUSÃO LÓGICA
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
