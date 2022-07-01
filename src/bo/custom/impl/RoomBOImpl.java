package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        return roomDAO.add(new Room(
                roomDTO.getId(),
                roomDTO.getType(),
                roomDTO.getDuration(),
                roomDTO.getKeyMoney(),
                roomDTO.getStatus()

        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return roomDAO.delete(id);
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(new Room(
                roomDTO.getId(),
                roomDTO.getType(),
                roomDTO.getDuration(),
                roomDTO.getKeyMoney(),
                roomDTO.getStatus()
        ));
    }

    @Override
    public List<RoomDTO> searchAll() throws Exception {
        List<Room> all = roomDAO.searchAll();
        ArrayList<RoomDTO> roomDTOS = new ArrayList<>();

        for (Room room : all) {
            roomDTOS.add(new RoomDTO(
                    room.getRoomId(),
                    room.getRoomType(),
                    room.getDuration(),
                    room.getKeyMoney(),
                    room.getStatus()
            ));
        }
        return roomDTOS;
    }

    @Override
    public RoomDTO search(String id) {
        try {
            Room item=roomDAO.search(id);
            return new RoomDTO(item.getRoomId(),item.getRoomType(),item.getDuration(),item.getKeyMoney(),item.getStatus());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
