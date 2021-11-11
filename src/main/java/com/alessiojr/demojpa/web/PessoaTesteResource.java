package com.alessiojr.demojpa.web;

import com.alessiojr.demojpa.domain.Pessoa;
import com.alessiojr.demojpa.service.PessoaService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@Api(tags = "Recursos de Teste para pessoa")
public class PessoaTesteResource {
    private final Logger log = LoggerFactory.getLogger(PessoaTesteResource.class);

    private final PessoaService pessoaService;

    public PessoaTesteResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(path = "/pessoas/criar/{name}")
    public String helloApp(@PathVariable String name) {
        Pessoa p = new Pessoa();
        p.setNome(name);
        pessoaService.save(p);
        return  "criou";
    }

    @GetMapping(path = "/pessoas/listar/{id}")
    public Pessoa helloApp(@PathVariable Long id) {
        return  pessoaService.findOne(id).get();
    }


}
