/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.femass.controleestagio.dao;

import br.edu.femass.controleestagio.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class AlunoDao {
    @PersistenceContext
    EntityManager em;
    
    public void Inserir(Aluno aluno){
        em.persist(aluno);
    }
    
    public void Alterar(Aluno aluno){
        em.merge(aluno);
    }
    
    public void Excluir(Aluno aluno){
        em.remove(em.merge(aluno));
    }    
    
    public List<Aluno> getClientes(String nome) {
        Query q = em.createQuery("select c from Aluno a where a.nome = :n");
        q.setParameter("n", nome);
        return q.getResultList();
    }
}
