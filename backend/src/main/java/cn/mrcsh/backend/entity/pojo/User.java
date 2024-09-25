package cn.mrcsh.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_user")
public class User extends BaseEntity{
    private String id;
    private String username;
    private String password;
    private String role;
}
