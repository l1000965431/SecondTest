package com.base.SpringServiceTest;

import com.base.SpringControllerModel.Usermodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by liumin on 15/12/23.
 */

/*@Service*/
public class SpringServiceTest {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void TraddUser(String name) {
        Session session = sessionFactory.getCurrentSession();
        Usermodel userModel = new Usermodel();
        userModel.setName(name);
        userModel.setPwd("123456");
        session.save(userModel);

        Usermodel userModel1 = new Usermodel();
        userModel1.setName(name);
        userModel1.setPwd("123456");
        session.save(userModel1);
    }


    public void Trupdate(String name) {
        Session session = sessionFactory.getCurrentSession();
        Usermodel userModel = new Usermodel();
        userModel.setName(name);
        session.update(userModel);
    }


    public void TrgetUser(){
        Session session = sessionFactory.getCurrentSession();
        List<Usermodel> list = session.createSQLQuery( "SELECT * FROM usermodel" ).addEntity(Usermodel.class).list();
        for (Usermodel userModel:list){
            System.out.println( userModel.getName() );
        }
        session.flush();
    }

}
