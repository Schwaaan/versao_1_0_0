package com.teste.teste.controllers;

import com.teste.teste.domain.Nation;
import com.teste.teste.domain.dto.ResponseDTO;
import com.teste.teste.domain.dto.TextDTO;
import com.teste.teste.repository.NationRepository;
import com.teste.teste.service.TokenService;
import com.teste.teste.utils.Assert;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class NationController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private NationRepository nationRepository;

    @GetMapping("/v1/pais/listar")
    public List<Nation> getNations(HttpServletRequest request) {
        tokenService.validateToken(request); // usar webSecurity?
        return nationRepository.findAll();
    }

    @PostMapping("/v1/pais/salvar")
    public Nation updateNation(HttpServletRequest request, @RequestBody Nation nation) {
        tokenService.validateTokenAndIsAdmin(request);
        if (nation.getId() != 0) {
            Nation nationUpdate = Assert.found(nationRepository.findOneById(nation.getId()), "Pais nao encontrado");
            nationUpdate.setName(nation.getName());
            nationUpdate.setSigle(nation.getSigle());
            nationUpdate.setGentilico(nation.getGentilico());
            return nationRepository.save(nationUpdate);
        }
        return nationRepository.save(nation);
    }

    @GetMapping("/v1/pais/pesquisar")
    public List<Nation> getPaisByName(@RequestBody TextDTO textDTO, HttpServletRequest request) {
        tokenService.validateTokenAndIsAdmin(request);
        return nationRepository.findAllByNameContains(textDTO.getTexto());
    }

    @GetMapping("/v1/pais/excluir/{id}")
    public ResponseDTO deletePaisById(HttpServletRequest request, @PathVariable("id") Integer id) {
        tokenService.validateTokenAndIsAdmin(request);
        Optional<Nation> nation = nationRepository.findOneByIdAndDeletedIsFalse(id);
        if (nation.isPresent()) {
            nation.get().setDeleted(true);
            nationRepository.save(nation.get());
            return new ResponseDTO("True");
        }
        return new ResponseDTO("False");
    }

}
