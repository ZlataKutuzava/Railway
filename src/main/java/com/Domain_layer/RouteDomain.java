package com.Domain_layer;

import com.Database_layer.Route;
import com.Database_layer.persistence.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class RouteDomain {

    private SessionFactory sessionFactory;
    public RouteDomain(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Iterable<Route> GetRoutes(){
        Session session = null;
        List routeList = null;
        try {
            if (sessionFactory != null){
                session = sessionFactory.openSession();
                session.beginTransaction();
                routeList = session.createQuery("from Route").list();
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return routeList;
    }

    public Route GetRoute(int id){
        Session session = null;
        Route route=null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            route = (Route) session.get(Route.class, id);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return route;
    }

    public Integer CreateRoute(int trainId,int stationId,String timeArrival,String timeDeparture){
        Session session = null;
        Transaction tx;
        Integer newRoute = null;
        try {
            session= sessionFactory.openSession();
            tx = session.beginTransaction();
            Route route = new Route();
            route.setTrainId(trainId);
            route.setStationId(stationId);
            route.setTimeArrival(timeArrival);
            route.setTimeDeparture(timeDeparture);
            newRoute = (Integer)session.save(route);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return newRoute;
    }

    public void UpdateRoute(int routeId, Integer stationId, Integer trainId, String timeArrival, String timeDeparture){
        Session session = null;
        Transaction tx;
        try {
            session= sessionFactory.openSession();
            tx = session.beginTransaction();
            Route route = (Route) session.get(Route.class, routeId);
            route.setTrainId(trainId);
            route.setStationId(stationId);
            route.setTimeArrival(timeArrival);
            route.setTimeDeparture(timeDeparture);
            session.update(route);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void DeleteRoute(int routeId){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Route route = (Route) session.get(Route.class, routeId);
            session.delete(route);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
