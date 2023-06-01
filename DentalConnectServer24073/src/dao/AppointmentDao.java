/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Appointments;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class AppointmentDao {
     public String registerAppointment(Appointments newAppointment){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(newAppointment);
        tr.commit();
        ss.close();
        
        return "Data saved successfully";
    }
    
     public String updateAppointment(Appointments newAppointment){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(newAppointment);
        tr.commit();
        ss.close();
        
        return "Data updated successfully";
    }
    public String deleteAppointment(Appointments newAppointment){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(newAppointment);
        tr.commit();
        ss.close();
        
        return "Data deleted successfully";
    }
    
     public  List<Appointments> allAppointments(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Appointments> AppointmentsList = ss.createQuery("select Appointment from Appointments Appointment").list();
        ss.close();
        return AppointmentsList;
    }
    public Appointments getAppointmentById(Appointments Appointment){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Appointments searchAppointment = (Appointments)ss.get(Appointments.class, Appointment.getAppId());
        ss.close();
        return searchAppointment;
    }
    public  List<Appointments> allPatientAppointments(Appointments Appointment){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Appointments> AppointmentsList = ss.createQuery("select PatientAppointment from Appointments PatientAppointment.patient_id="+Appointment.getPatient_id()).list();
        ss.close();
        return AppointmentsList;
    }
    public  List<Appointments> allDoctorAppointments(Appointments Appointment){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Appointments> AppointmentsList = ss.createQuery("select PatientAppointment from Appointments PatientAppointment.patient_id="+Appointment.getDoctor_id()).list();
        ss.close();
        return AppointmentsList;
    }
}
