/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;


/**
 *
 * @author admin
 */
public class UserDao {
    public String registerUser(Users newUser){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(newUser);
        tr.commit();
        ss.close();
        
        return "Data saved successfully";
    }
    
    public  List<Users> allUsers(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Users> usersList = ss.createQuery("select user from Users user").list();
        ss.close();
        return usersList;
    }
    public Users getUserById(Users user){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Users searchUser = (Users)ss.get(Users.class, user.getId());
        ss.close();
        return searchUser;
    }
    public Users loginUser(Users user) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Users logUser = null;

    try {
        transaction = session.beginTransaction();

        String hql = "FROM Users u WHERE u.email = :email AND u.password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("email", user.getEmail());
        query.setParameter("password", user.getPassword());

        logUser = (Users) query.uniqueResult();

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        // Handle or log the exception
    } finally {
        session.close();
    }

    return logUser;
}   
    
    
}
