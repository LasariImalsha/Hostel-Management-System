package bo.custom.impl;

import bo.custom.DetailBO;
import dao.DAOFactory;
import dao.custom.impl.DetailDAOImpl;
import dto.DetailDTO;
import entity.Detail;
import model.tm.DetailTM;

import java.util.ArrayList;
import java.util.List;

public class DetailBOImpl implements DetailBO {

    private final DetailDAOImpl detailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.DETAIL);


    @Override
    public boolean add(DetailDTO detailDTO) throws Exception {
        return detailDAO.add(new Detail(
                detailDTO.getDetailId(),
                detailDTO.getDate(),
                detailDTO.getRoom(),
                detailDTO.getStudent()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return detailDAO.delete(id);    }

    @Override
    public boolean update(DetailDTO detailDTO) throws Exception {
        return detailDAO.update(new Detail(
                detailDTO.getDetailId(),
                detailDTO.getDate(),
                detailDTO.getRoom(),
                detailDTO.getStudent()
        ));
    }

    @Override
    public List<DetailTM> searchAll() throws Exception {
        List<Detail> all = detailDAO.searchAll();
        ArrayList<DetailTM> detailDTOS = new ArrayList<>();

        for (Detail detail : all) {
            detailDTOS.add(new DetailTM(
                    detail.getDetailId(),
                    detail.getDate(),
                    detail.getRoom().getRoomId(),
                    detail.getStudent().getId()
            ));
        }
        return detailDTOS;
    }

    @Override
    public List<DetailDTO> searchId(String id) {
        List<Detail> all = detailDAO.viewDetail(id);
        ArrayList<DetailDTO> detailDTOS = new ArrayList<>();

        for (Detail detail : all) {
            detailDTOS.add(new DetailDTO(
                    detail.getDetailId(),
                    detail.getDate(),
                    detail.getRoom(),
                    detail.getStudent()
            ));
        }
        return detailDTOS;
    }

    @Override
    public String getDetailId() {
        String lastId = detailDAO.getDetailId();
        return lastId;
    }
}
