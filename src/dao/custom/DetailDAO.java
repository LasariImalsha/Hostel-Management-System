package dao.custom;

import entity.Detail;

import java.util.List;

public interface DetailDAO {
    boolean add(Detail entity) throws Exception;

    boolean update(Detail entity) throws Exception;

    boolean delete(String s) throws Exception;

    Detail search(String s) throws Exception;

    List<Detail> searchAll() throws Exception;

    List<Detail> viewDetail(String id);

    String getDetailId();
}
