package bo.custom;

import dto.DetailDTO;
import model.tm.DetailTM;

import java.util.List;

public interface DetailBO {
    boolean add(DetailDTO detailDTO) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(DetailDTO detailDTO) throws Exception;

    List<DetailTM> searchAll() throws Exception;

    List<DetailDTO> searchId(String id);

    String getDetailId();
}
