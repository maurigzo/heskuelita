
package com.capgemini.heskuelita.test;

import com.capgemini.heskuelita.entity.Account;
import com.capgemini.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.*;

public class HibernateTest {


    private static SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger (HibernateTest.class);


    public HibernateTest () {

        super ();
    }


    @BeforeAll
    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }
    @AfterAll
    public static void destroy () {

        sessionFactory.close ();
    }


    @Test
    @DisplayName ("Create New Records")
    public void m1 () {


        // Get a session.
        Session session = null;
        Transaction tx = null;
        try {

            logger.info("Getting a session...");
            session = sessionFactory.openSession ();
            tx = session.beginTransaction ();

            // Set the data to save.
            logger.info("Creating values to insert...");
            Account[] values = new Account[]{

                   new Account ("Homer Simpson", "Test", "email")
            };

            // Save the data.
            for (Account e : values) {

                logger.info (String.format ("Saving value %s", e.getUser_name ()));
                session.save(e);
                logger.info (String.format ("Value %s saved!", e.getUser_name ()));
            }
            tx.commit ();
            Assertions.assertTrue (values[0].getId () > 0, String.format ("Problems creating the new user %s", values[0].getUser_name ()));

        } catch (Exception ex) {

            logger.error (ex.getMessage ());
            tx.rollback ();
            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test.");

        } finally { session.close (); }
    }

    @Test
    @DisplayName ("Finding all users")
    public void m2 () {

        Session session = null;
        List<Account> users;

        try {

            logger.info ("Executing select all users.");
            logger.info("Getting a session...");
            session = sessionFactory.openSession ();

            users = (List)session.createCriteria (Account.class).list ();

            logger.info ("Print all users info.");
            users.forEach ( e -> logger.info (e.getUser_name ()));

            Assertions.assertFalse (users.isEmpty (), "There are not users found!!!");

        } catch (Exception e) {

            logger.error (e.getMessage ());
            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test.");

        } finally { session.close(); }
    }

    @Test
    @DisplayName ("Update all users")
    public void m3 () {

        final Session session;
        Transaction tx = null;
        List<Account> users;

        try {

            logger.info ("Updating all users.");
            logger.info("Getting a session...");
            session = sessionFactory.openSession ();
            tx = session.beginTransaction ();

            users = (List)session.createCriteria (Account.class).list ();

            logger.info ("Print all users info.");
            users.forEach (e -> {

                logger.info (String.format ("Updating %s ", e.getUser_name ()));
                e.setUser_name (e.getUser_name ().toUpperCase ());
                session.save (e);
            });
            tx.commit ();

            Assertions.assertFalse (users.isEmpty (), "There are not users found!!!");

        } catch (Exception e) {

            logger.error (e.getMessage ());
            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test.");
        }
    }

    @Test
    @DisplayName ("Delete all users")
    public void m4 () {

        final Session session;
        Transaction tx;
        List<Account> values;

        try {

            logger.debug ("Delete all users.");
            session = sessionFactory.openSession ();
            tx = session.beginTransaction ();
            values = (List)session.createQuery ("From Account").list ();

            Assertions.assertFalse (values.isEmpty (), "There are not users found!!!");

            values.forEach (e -> session.delete (e));
            tx.commit ();

            values = (List)session.createQuery("From Account").list ();
            Assertions.assertTrue (values.isEmpty (), "There are users found!!!");

        } catch (Exception e) {

            logger.error (e.getMessage ());
            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test.");
        }
    }


}