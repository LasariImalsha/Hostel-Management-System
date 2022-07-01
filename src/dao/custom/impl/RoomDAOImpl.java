package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class, s);
        session.delete(room);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Room search(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, s);

        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public List<Room> searchAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Room");
        List <Room> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
