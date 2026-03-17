package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

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
}
