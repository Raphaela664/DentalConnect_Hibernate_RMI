/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Appointments implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer AppId;
    private Users patient_id;
    private Date date_of_birth;
    private String gender;
    private Specialist doctor_id;
    private String appointment_time;
    private String appointment_date;

    public Appointments() {
    }

    public Appointments(Integer AppId) {
        this.AppId = AppId;
    }

    public Appointments(Integer AppId, Users patient_id, Date date_of_birth, String gender, Specialist doctor_id, String appointment_time, String appointment_date) {
        this.AppId = AppId;
        this.patient_id = patient_id;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.doctor_id = doctor_id;
        this.appointment_time = appointment_time;
        this.appointment_date = appointment_date;
    }

    public Integer getAppId() {
        return AppId;
    }

    public void setAppId(Integer AppId) {
        this.AppId = AppId;
    }

    public Users getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Users patient_id) {
        this.patient_id = patient_id;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Specialist getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Specialist doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    
    
}
