/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.femass.controleestagio.gui;

import br.edu.femass.controleestagio.dao.AlunoDao;
import br.edu.femass.controleestagio.model.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author dumas
 */
@Named(value = "guiAluno")
@SessionScoped
public class GuiAluno implements Serializable {

    private List<Aluno> alunos;
    private Aluno aluno;
    private Boolean alterado;

    @EJB
    AlunoDao alunoDao;

    public GuiAluno() {
    }

    public String iniciar() {
        alunos = alunoDao.getAlunos();
        return "FrmLstAluno";
    }

    public String incluir() {
        aluno = new Aluno();
        alterado = false;
        return "FrmCadAluno";
    }

    public String alterar(Aluno a) {
        aluno = a;
        alterado = true;
        return "FrmCadAluno";
    }

    public String excluir(Aluno a) {
        alunoDao.excluir(a);
        alunos = alunoDao.getAlunos();
        return null;
    }

    public String gravar() {
        if (alterado) {
            alunoDao.alterar(getAluno());
        } else {
            alunoDao.inserir(getAluno());
        }
        return iniciar();
    }

    /**
     * @return the alunos
     */
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
