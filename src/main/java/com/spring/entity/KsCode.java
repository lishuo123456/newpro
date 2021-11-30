package com.spring.entity;

import lombok.Data;

@Data
public class KsCode {
    private String mzdctcode;
    //科室编码
    private String mzkscode;
    //科室名称
    private String mzksname;
    //拼音
    private String py;

    private String Note;

    private String flag;


}
