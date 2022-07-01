package dao.custom;

import entity.Room;

import java.util.List;

public interface RoomDAO {
    boolean add(Room entity) throws Exception;

    boolean update(Room entity) throws Exception;

    boolean delete(String s) throws Exception;

    Room search(String s) throws Exception;

    List<Room> searchAll() throws Exception;
}
