package com.example.demo.service;

import com.example.demo.model.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface KhuyenMaiService {
    List<KhuyenMai> findALl();
    void save(KhuyenMai khuyenMai);
    void delete(Long id);
    List<KhuyenMai> findBySaleOff(int word);
    List<KhuyenMai> findByTimeStart(String word);
    List<KhuyenMai> findByTimeEnd(String word);
    List<KhuyenMai> findBySaleOffOrTimeStartOrTimeEnd(int sale,String dateS,String dateE);
}
