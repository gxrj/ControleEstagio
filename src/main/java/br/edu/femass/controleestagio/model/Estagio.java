/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.femass.controleestagio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dumas
 */
@Entity
public class Estagio implements Serializable{

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private boolean categoriaObrigatoria;
    private Aluno alunoEstagio;
    private Orientador orientadorEstagio;
    private LocalDate dataInicioEstagio;
    private LocalDate datafimEstagio;
    private Status statusDoEstagio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCategoriaObrigatoria() {
        return categoriaObrigatoria;
    }

    public void setCategoriaObrigatoria(boolean categoriaObrigatoria) {
        this.categoriaObrigatoria = categoriaObrigatoria;
    }
    
    public Aluno getAlunoEstagio() {
        return alunoEstagio;
    }

    public void setAlunoEstagio(Aluno alunoEstagio) {
        this.alunoEstagio = alunoEstagio;
    }

    public Orientador getOrientadorEstagio() {
        return orientadorEstagio;
    }

    public void setOrientadorEstagio(Orientador orientadorEstagio) {
        this.orientadorEstagio = orientadorEstagio;
    }

    public LocalDate getDataInicioEstagio() {
        return dataInicioEstagio;
    }

    public void setDataInicioEstagio(LocalDate dataInicioEstagio) {
        this.dataInicioEstagio = dataInicioEstagio;
    }

    public LocalDate getDatafimEstagio() {
        return datafimEstagio;
    }

    public void setDatafimEstagio(LocalDate datafimEstagio) {
        this.datafimEstagio = datafimEstagio;
    }

    public Status getStatusDoEstagio() {
        return statusDoEstagio;
    }

    public void setStatusDoEstagio(Status statusDoEstagio) {
        this.statusDoEstagio = statusDoEstagio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Estagio)) {
            return false;
        }
        Estagio other = (Estagio) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id;
    }
    
    
}
