package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getAllWhiskyFromYear(int year){

        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));

            results = cr.list();

        }catch(HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }


    @Transactional
    public List<Whisky> getAllWhiskiesFromRegion(String region) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "whisky");
            cr.add(Restrictions.eq("whisky.region", region));
            results = cr.list();
        }catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            //no matter what happens exception or not, do the following
            session.close();
        }
        return results;
    }
}
