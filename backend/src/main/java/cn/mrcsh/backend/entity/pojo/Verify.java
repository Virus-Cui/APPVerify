package cn.mrcsh.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_verify")
public class Verify extends BaseEntity{
    private String  id;
    private String appName;
    private String domain;
    private String hwid;
    private String owner;
    private String liscense;
    private Date expireTime;
}
