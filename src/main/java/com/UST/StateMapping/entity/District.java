package com.UST.StateMapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "districtslist")
@IdClass(DistrictId.class)
public class District {

        @Id
        @Column(name = "State")
        private String state;

        @Id
        @Column(name = "District")
        private String district;

        // getters and setters
}


