package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    // camp pentru EntityManager (pt interactiunea cu baza de date)
    private EntityManager entityManager;

    //injectarea EntityManager prin constructor (recomandat pt testabilitate si modularitate)
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implementarea metodei save pt salvarea unui obiect Student in baza de date
    @Override
    @Transactional
    public void save(Student theStudent) {
        //ca sa salvez studentul in baza de date
        entityManager.persist(theStudent);
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll () {
        //create query
        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student", Student.class);

        //returnam query results
        return  theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //creare query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //setarea parametrilor pentru query
        theQuery.setParameter("theData", theLastName);

        //returnarea rezultatelor query
        return theQuery.getResultList();


        //return List.of();

    }

}
