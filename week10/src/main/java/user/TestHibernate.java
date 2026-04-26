package com.user;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        System.out.println("Hibernate Connected!");

        s.close();
    }
}