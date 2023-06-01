/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Specialist;
/**
 *
 * @author admin
 */
public interface SpecialistService extends Remote {
    public List<Specialist> allSpecialists() throws RemoteException;
  
}
