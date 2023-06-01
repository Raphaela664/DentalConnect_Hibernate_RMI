/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Users;

/**
 *
 * @author admin
 */
public interface UserService extends Remote{
    public String registerUser(Users user) throws RemoteException;
    public List<Users> allUsers() throws RemoteException;
    public Users getUserById(Users user) throws RemoteException;
    public Users loginUser(Users user) throws RemoteException;
}
