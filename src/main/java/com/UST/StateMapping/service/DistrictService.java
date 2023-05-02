package com.UST.StateMapping.service;

import com.UST.StateMapping.entity.District;
import com.UST.StateMapping.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public interface DistrictService {
    List<District> getAllDistrictsByState(String state);
}

