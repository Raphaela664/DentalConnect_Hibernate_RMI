/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Appointments;
import model.Specialist;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class SpecialistDao {
    
    public  List<Specialist> allSpecialists(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Specialist> SpecialistList = ss.createQuery("select special from Specialist special").list();
        ss.close();
        return SpecialistList;
    }
}
