/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implementation;

import dao.AppointmentDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Appointments;
import service.AppointmentService;

/**
 *
 * @author admin
 */
public class AppointmentsImpl extends UnicastRemoteObject implements AppointmentService {
    public  AppointmentsImpl() throws RemoteException{
        super();
    }
    public AppointmentDao dao = new AppointmentDao();
     @Override
    public String registerAppointment(Appointments Appointment) throws RemoteException {
         return dao.registerAppointment(Appointment);
    }

    @Override
    public String updateAppointment(Appointments Appointment) throws RemoteException {
       return dao.updateAppointment(Appointment);
    }

    @Override
    public String deleteAppointment(Appointments Appointment) throws RemoteException {
       return dao.deleteAppointment(Appointment);
    }

    @Override
    public List<Appointments> allAppointments() throws RemoteException {
        return dao.allAppointments();
    }

    @Override
    public Appointments getAppointmentById(Appointments Appointment) throws RemoteException {
       return dao.getAppointmentById(Appointment);
    }
   @Override
    public List<Appointments> allPatientAppointments(Appointments Appointment) throws RemoteException {
       return dao.allPatientAppointments(Appointment);
    }
     @Override
    public List<Appointments> allDoctorAppointments(Appointments Appointment) throws RemoteException {
       return dao.allDoctorAppointments(Appointment);
    }
}
