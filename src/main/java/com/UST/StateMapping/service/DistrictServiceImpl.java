package com.UST.StateMapping.service;

import com.UST.StateMapping.entity.District;
import com.UST.StateMapping.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAllDistrictsByState(String state) {
        return districtRepository.findByState(state);
    }
}
