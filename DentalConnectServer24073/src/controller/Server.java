/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.Implementation.AppointmentsImpl;
import service.Implementation.SpecialistImpl;
import service.Implementation.UserImpl;

/**
 *
 * @author admin
 */
public class Server {

    public Server() {
    }
    
    public static void main(String[] args) {
        try{
            // set properties
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            // create registry
            Registry registry  = LocateRegistry.createRegistry(5000);
            registry.rebind("user", new UserImpl());
            registry.rebind("appointment", new AppointmentsImpl());
            registry.rebind("specialist", new SpecialistImpl());
            System.out.println("Server is running on port 5000");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
