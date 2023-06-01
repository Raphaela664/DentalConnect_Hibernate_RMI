/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implementation;

import java.rmi.RemoteException;
import java.util.List;
import model.Specialist;
import service.SpecialistService;
import dao.SpecialistDao;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author admin
 */
public class SpecialistImpl extends UnicastRemoteObject implements SpecialistService{
    public  SpecialistImpl() throws RemoteException{
        super();
    }
    public SpecialistDao dao = new SpecialistDao();
    @Override
    public List<Specialist> allSpecialists() throws RemoteException {
        return dao.allSpecialists();
    }
}
