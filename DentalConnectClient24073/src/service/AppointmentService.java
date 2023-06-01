/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Appointments;
/**
 *
 * @author admin
 */
public interface AppointmentService extends Remote{
    public String registerAppointment(Appointments Appointment) throws RemoteException;
    public String updateAppointment(Appointments Appointment) throws RemoteException;
    public String deleteAppointment(Appointments Appointment) throws RemoteException;
    public List<Appointments> allAppointments() throws RemoteException;
    public Appointments getAppointmentById(Appointments Appointment) throws RemoteException;
    public List<Appointments> allPatientAppointments(Appointments Appointment) throws RemoteException;
    public List<Appointments> allDoctorAppointments(Appointments Appointment) throws RemoteException;

    public String UpdateAppointment(Appointments appointment);
}
