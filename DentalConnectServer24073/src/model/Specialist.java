/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author admin
 */
@Entity
public class Specialist implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctor_id;
    private String doctor_name;

    public Specialist() {
    }

    public Specialist(int doctor_id, String doctor_name) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
    }

    public Specialist(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }
    
}
