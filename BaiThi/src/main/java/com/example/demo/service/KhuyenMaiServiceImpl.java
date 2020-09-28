package com.example.demo.service;

import com.example.demo.model.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> findALl() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public List<KhuyenMai> findBySaleOff(int word) {
        return khuyenMaiRepository.findBySaleOff(word);
    }

    @Override
    public List<KhuyenMai> findByTimeStart(String word) {
        return khuyenMaiRepository.findByTimeStart(word);
    }

    @Override
    public List<KhuyenMai> findByTimeEnd(String word) {
        return khuyenMaiRepository.findByTimeEnd(word);
    }

    @Override
    public List<KhuyenMai> findBySaleOffOrTimeStartOrTimeEnd(int sale, String dateS, String dateE) {
        return khuyenMaiRepository.findBySaleOffAndTimeStartAndTimeEnd(sale, dateS, dateE);
    }
}
