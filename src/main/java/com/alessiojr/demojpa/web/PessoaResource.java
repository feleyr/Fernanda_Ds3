package com.alessiojr.demojpa.web;

import com.alessiojr.demojpa.domain.Pessoa;
import com.alessiojr.demojpa.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
    private final Logger log = LoggerFactory.getLogger(PessoaResource.class);

    private final PessoaRepository pessoaRepository;

    public PessoaResource(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping(path = "/criar/{name}")
    public String helloApp(@PathVariable String name) {
        Pessoa p = new Pessoa();
        p.setNome(name);
        pessoaRepository.save(p);
        return  "criou";
    }

    @GetMapping(path = "/listar/{id}")
    public Pessoa helloApp(@PathVariable Long id) {
        return  pessoaRepository.findById(id).get();
    }
}
