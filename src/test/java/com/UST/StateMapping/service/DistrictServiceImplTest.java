package com.UST.StateMapping.service;

import com.UST.StateMapping.entity.District;
import com.UST.StateMapping.repository.DistrictRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DistrictServiceImplTest {

    @Mock
    private DistrictRepository mockDistrictRepository;

    private DistrictServiceImpl districtServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        districtServiceImplUnderTest = new DistrictServiceImpl(mockDistrictRepository);
    }

    @Test
    void testGetAllDistrictsByState() {
        // Setup
        final List<District> expectedResult = List.of(new District("state", "district"));

        // Configure DistrictRepository.findByState(...).
        final List<District> districts = List.of(new District("state", "district"));
        when(mockDistrictRepository.findByState("state")).thenReturn(districts);

        // Run the test
        final List<District> result = districtServiceImplUnderTest.getAllDistrictsByState("state");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllDistrictsByState_DistrictRepositoryReturnsNoItems() {
        // Setup
        when(mockDistrictRepository.findByState("state")).thenReturn(Collections.emptyList());

        // Run the test
        final List<District> result = districtServiceImplUnderTest.getAllDistrictsByState("state");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
