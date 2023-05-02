package com.UST.StateMapping.repository;

import com.UST.StateMapping.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,String> {

    List<District> findByState(String state);
}
