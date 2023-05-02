package com.UST.StateMapping.controller;


import com.UST.StateMapping.entity.District;
import com.UST.StateMapping.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/{state}")
    public List<District> getAllDistrictsByState(@PathVariable String state) {
        return districtService.getAllDistrictsByState(state);
    }
}
