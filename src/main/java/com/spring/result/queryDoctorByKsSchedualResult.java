package com.spring.result;


import com.spring.entity.DoctorGhCount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class queryDoctorByKsSchedualResult {
    private String month;
    private String day;
    private String weekStr;
    private String date;
    private String status;
    private List<DoctorGhCount> doctorList;



}
