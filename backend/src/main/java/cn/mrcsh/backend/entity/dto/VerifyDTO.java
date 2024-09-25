package cn.mrcsh.backend.entity.dto;

import lombok.Data;

@Data
public class VerifyDTO {
    private String domain;
    private String hwid;
    private String liscense;
}
