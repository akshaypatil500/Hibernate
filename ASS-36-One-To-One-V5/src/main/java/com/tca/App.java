package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.Car;
import com.tca.entites.Engine;



public class App {
    public static void main(String[] args) {

        Configuration configuration = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction txn = null;

        try {
            configuration = new Configuration();
            configuration.configure();

           
            sf = configuration.buildSessionFactory();
            session = sf.openSession();
            txn = session.beginTransaction();

        //----------------One-TO-One-Association Mapping--------------------------
/*
           Car c=new Car();
           c.setCno("MH14222");
           c.setCname("Swift");
           
           Engine e=new Engine();
           e.setEid(101);
           e.setType("Petrol");
           e.setSize("1200CC");
           c.setEngine(e);
           
           session.save(c);
          
           
           Engine e=new Engine();
           e.setEid(102);
           e.setType("Diseal");
           e.setSize("1000CC");
			
           Car c=new Car();
           c.setCno("MH14888");
           c.setCname("Thar");
           c.setEngine(e);
           e.setCar(c);
           
           session.save(e);

            
            Engine e=session.get(Engine.class, 102);
            Car c=session.get(Car.class, "MH14888");
            c.setEngine(e);
            
            session.update(c);
 */ 
            //**********************Fetchcing Logic**********************************
            
            Car c=session.get(Car.class, "MH14888");
                 
            System.out.println("Car Number "+c.getCno());
            System.out.println("Car Name "+c.getCname());
            
            Engine e=c.getEngine();
            System.out.println("Engine ID "+e.getEid());
            System.out.println("Engine Type "+e.getType());
            System.out.println("Engine Size "+e.getSize());


            
            

            
        //----------------------------------------------------    
           
            
            txn.commit();
            System.out.println("Done");
            
        } catch (Exception e) {
            e.printStackTrace();
            txn.rollback();
        } finally {

            session.close();
            sf.close();
        }
    }
}