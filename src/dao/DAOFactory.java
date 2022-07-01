package dao;

import dao.custom.impl.DetailDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance(){
        return daoFactory==null? daoFactory=new DAOFactory(): daoFactory;
    }

    public enum DAOType{
        STUDENT,ROOM,DETAIL
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            case DETAIL:
                return (T) new DetailDAOImpl();
            default:
                return null;
        }
    }
}
