package com.Domain_layer;


import com.Database_layer.Station;
import com.Database_layer.persistence.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class StationDomain {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public Iterable<Station> GetStations(){
        Session session = null;
        Iterable<Station> stationsList = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Stations");
            stationsList = query.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return stationsList;
    }

    public Station GetStation(int id){
        Session session = null;
        Station station=null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            station = (Station) session.get(Station.class, id);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return station;
    }

    public Integer CreateStation(String stationName){
        Session session = null;
        Transaction tx;
        Integer newStation = null;
        try {
            session= sessionFactory.openSession();
            tx = session.beginTransaction();
            Station station = new Station();
            station.setStationName(stationName);
            newStation = (Integer)session.save(station);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return newStation;
    }

    public void UpdateStation(int stationId,String stationName){
        Session session = null;
        Transaction tx;
        try {
            session= sessionFactory.openSession();
            tx = session.beginTransaction();
            Station station = (Station) session.get(Station.class, stationId);
            station.setStationId(stationId);
            station.setStationName(stationName);
            session.update(station);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void DeleteStation(int stationId){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Station station = (Station) session.get(Station.class, stationId);
            session.delete(station);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
