package org.gochev.repository;

import org.gochev.entity.Submission;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gochev on 10/6/15.
 */

@Stateless
public class SubmissionRepository {

    @PersistenceContext
    private EntityManager em;

    public Submission save(Submission submission){
        em.persist(submission);
        return submission;
    }
}
