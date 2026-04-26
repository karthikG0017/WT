package com.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestHibernate {

    public static void main(String[] args) {

        // 1) Build SessionFactory
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        // ---------- INSERT ----------
        Session s1 = sf.openSession();
        Transaction t1 = s1.beginTransaction();

        Book b = new Book();
        b.setTitle("C++");
        b.setAuthor("Bjarne");
        b.setPrice(600);

        s1.save(b);

        t1.commit();
        s1.close();

        System.out.println("Inserted!");

        // ---------- READ ----------
        Session s2 = sf.openSession();

        List<Book> list = s2.createQuery("from Book", Book.class).list();

        System.out.println("Books in DB:");
        for (Book x : list) {
            System.out.println(x.getId() + " " + x.getTitle() + " " + x.getPrice());
        }

        s2.close();

        // ---------- UPDATE ----------
        Session s3 = sf.openSession();
        Transaction t3 = s3.beginTransaction();

        Book b2 = s3.get(Book.class, 1); // change ID if needed
        if (b2 != null) {
            b2.setPrice(999);
            s3.update(b2);
            System.out.println("Updated!");
        } else {
            System.out.println("Book with id=1 not found");
        }

        t3.commit();
        s3.close();

        // ---------- DELETE ----------
        Session s4 = sf.openSession();
        Transaction t4 = s4.beginTransaction();

        Book b3 = s4.get(Book.class, 1); // change ID if needed
        if (b3 != null) {
            s4.delete(b3);
            System.out.println("Deleted!");
        } else {
            System.out.println("Book with id=1 not found");
        }

        t4.commit();
        s4.close();

        // Close factory
        sf.close();
    }
}