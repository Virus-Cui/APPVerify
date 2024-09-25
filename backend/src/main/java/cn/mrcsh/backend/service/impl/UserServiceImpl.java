package cn.mrcsh.backend.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.mrcsh.backend.entity.pojo.User;
import cn.mrcsh.backend.mapper.UserMapper;
import cn.mrcsh.backend.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername())
                        .eq("password", user.getPassword());
        User source = userMapper.selectOne(queryWrapper);
        if(source == null){
            return null;
        }

        StpUtil.login(source.getId());
        return StpUtil.getTokenInfo().getTokenValue();
    }
}
