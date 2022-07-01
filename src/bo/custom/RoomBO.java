package bo.custom;

import dto.RoomDTO;

import java.util.List;

public interface RoomBO {
    boolean add(RoomDTO roomDTO) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(RoomDTO roomDTO) throws Exception;

    List<RoomDTO> searchAll() throws Exception;

    RoomDTO search(String id);
}
