/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.femass.controleestagio.dao;

import br.edu.femass.controleestagio.model.Aluno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class AlunoDao {

    @PersistenceContext
    EntityManager em;

    public void inserir(Aluno aluno) {
        em.persist(aluno);
    }

    public void alterar(Aluno aluno) {
        em.merge(aluno);
    }

    public void excluir(Aluno aluno) {
        em.remove(em.merge(aluno));
    }

    public List<Aluno> getAlunos() {
        Query q = em.createQuery("select a from Aluno a order by a.nome");
        return q.getResultList();
    }
    public List<String> getListaAlunos() {
        Query q = em.createQuery("select a.nome from Aluno a order by a.nome");
       return q.getResultList(); 
    }

    public List<Aluno> getAlunos(String nome) {
        Query q = em.createQuery("select a from Aluno a where a.nome = :n");
        q.setParameter("n", nome);
        return q.getResultList();
    }
    
    public Aluno getAlunoByString(String nome) {
        Query q = em.createQuery("select a from Aluno a where a.nome = :n");
        q.setParameter("n", nome);
        return (Aluno) q.getSingleResult();
    }
    
    public Aluno getAlunoByMatricula(String matricula)
    {
        Query q = em.createQuery("select a from  Aluno a where a.matricula = :m");
        q.setParameter("m", matricula);
        return (Aluno) q.getSingleResult();
    }
}
