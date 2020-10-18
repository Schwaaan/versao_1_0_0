package com.teste.teste.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Nation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "nome")
    private String name;
    @Column(name = "sigla")
    private String sigle;
    @Column(name = "gentilico")
    private String gentilico;

    public Nation() {
    }

    public Nation(Integer id, boolean deleted, String name, String sigle, String gentilico) {
        this.id = id;
        this.deleted = deleted;
        this.name = name;
        this.sigle = sigle;
        this.gentilico = gentilico;
    }
}
