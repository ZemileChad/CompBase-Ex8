/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 *
 * @author user
 */
public class StudentTable {
        
    public static void insertStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(std);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, std.getId());
        fromDb.setName(std.getName());
        fromDb.setGpa(std.getGpa());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static Student findStudentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student std = em.find(Student.class, id);
        em.close();
        return std;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Student> stdList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return stdList;
    }
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> stdList = (List<Student>) query.getResultList();
        em.close();
        return stdList;
    }
    public static void removeStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, std.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
    
    
}
