package com.Domain_layer;

import com.Database_layer.Train;
import com.Database_layer.persistence.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class TrainsDomain {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public Iterable<Train> GetTrains(){
        Session session = null;
        Iterable<Train> trainsList = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Trains");
            trainsList = query.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return trainsList;
    }

    public Train GetTrain(int id){
        Session session = null;
        Train train=null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            train = (Train) session.get(Train.class, id);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return train;
    }

    public Integer CreateTrain(int trainId,int trainNumber, String trainType){
        Session session = null;
        Transaction tx;
        Integer newTrain = null;
        try {
            session= sessionFactory.openSession();
            tx = session.beginTransaction();
            Train train = new Train();
            train.setTrainNumber(trainNumber);
            train.setTrainType(trainType);
            newTrain = (Integer)session.save(train);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return newTrain;
    }

    public void UpdateTrain(int trainId,int trainNumber, String trainType){
        Session session = null;
        Transaction tx;
        try {
            session= sessionFactory.openSession();
            tx = session.beginTransaction();
            Train train = (Train) session.get(Train.class, trainId);
            train.setTrainType(trainType);
            train.setTrainNumber(trainNumber);
            session.update(train);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void DeleteTrain(int trainId){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Train train = (Train) session.get(Train.class, trainId);
            session.delete(train);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
