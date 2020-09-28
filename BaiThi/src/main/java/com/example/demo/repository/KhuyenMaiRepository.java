package com.example.demo.repository;

import com.example.demo.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,Long> {
    List<KhuyenMai> findBySaleOff(int word);
    List<KhuyenMai> findByTimeStart(String word);
    List<KhuyenMai> findByTimeEnd(String word);
    List<KhuyenMai> findBySaleOffAndTimeStartAndTimeEnd(int sale,String dateS,String dateE);

}
