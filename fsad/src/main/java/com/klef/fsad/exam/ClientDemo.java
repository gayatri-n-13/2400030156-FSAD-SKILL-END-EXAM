package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Movie m1 = new Movie("Pushpa", "Released", "2021-12-17", "Hyderabad");
        session.save(m1);

        Movie m2 = new Movie("RRR", "Released", "2022-03-25", "Delhi");
        session.save(m2);

        System.out.println("Records Inserted Successfully");

        tx.commit();
    
        session.beginTransaction();

        String hql = "update Movie set name=?1, status=?2 where id=?3";
        Query query = session.createQuery(hql);

        query.setParameter(1, "Pushpa 2");
        query.setParameter(2, "Upcoming");
        query.setParameter(3, 1);

        int result = query.executeUpdate();

        System.out.println(result + " Record Updated");

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}