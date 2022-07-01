package dao.custom.impl;

import dao.custom.DetailDAO;
import entity.Detail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class DetailDAOImpl implements DetailDAO {
    @Override
    public boolean add(Detail entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Detail entity) throws Exception {
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

        Detail detail = session.load(Detail.class, s);
        session.delete(detail);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Detail search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Detail> searchAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Detail");
        List <Detail> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<Detail> viewDetail(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Detail where student = : id");
        List <Detail> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getDetailId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String i = (String) session.createNativeQuery("SELECT detailId FROM Detail ORDER BY detailId DESC LIMIT 1")
                .uniqueResult();
        return (i == null) ? null : i;
    }
}
