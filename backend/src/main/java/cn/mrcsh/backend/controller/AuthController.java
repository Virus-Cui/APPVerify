package cn.mrcsh.backend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.mrcsh.backend.entity.pojo.User;
import cn.mrcsh.backend.entity.query.AuthQueryEntity;
import cn.mrcsh.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController extends BaseController{

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public R getAllAuth(@RequestBody User user){
        String token = userService.login(user);
        if(token == null){
            return R.err("用户名密码不正确");
        }else {
            return R.ok(token);
        }
    }

    @GetMapping("/logout")
    public R logout(){
        StpUtil.logout();
        return R.ok();
    }
}
