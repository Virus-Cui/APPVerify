package cn.mrcsh.backend.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private Date createTime;
    private Date updateTime;
}
