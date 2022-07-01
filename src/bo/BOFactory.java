package bo;

import bo.custom.impl.DetailBOImpl;
import bo.custom.impl.RoomBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType{
        STUDENT,ROOM,DETAIL;
    }

    public <T> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case ROOM:
                return (T) new RoomBOImpl();
            case DETAIL:
                return (T) new DetailBOImpl();
            default:
                return null;
        }
    }
}
