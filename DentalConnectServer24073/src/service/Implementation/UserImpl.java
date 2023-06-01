/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implementation;

import dao.UserDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Users;
import service.UserService;

/**
 *
 * @author admin
 */
public class UserImpl extends UnicastRemoteObject implements UserService{
    public  UserImpl() throws RemoteException {
        super();
    }
    public UserDao dao = new UserDao();
    @Override
    public String registerUser(Users user) throws RemoteException {
         return dao.registerUser(user);
    }

    @Override
    public List<Users> allUsers() throws RemoteException {
        return dao.allUsers();
    }

    @Override
    public Users getUserById(Users user) throws RemoteException {
       return dao.getUserById(user);
    }
    @Override
    public Users loginUser(Users user) throws RemoteException {
       return dao.loginUser(user);
    }
}
