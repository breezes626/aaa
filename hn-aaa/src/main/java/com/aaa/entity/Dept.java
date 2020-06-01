package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Dept {
    private Integer deptId;

    private String deptName;

    private Integer orderNum;

    private String status;

    private String delFlag;

    private String createTime;

}