package cn.mrcsh.backend.controller;

import cn.mrcsh.backend.entity.dto.VerifyDTO;
import cn.mrcsh.backend.entity.pojo.BaseEntity;
import cn.mrcsh.backend.entity.pojo.Verify;
import cn.mrcsh.backend.entity.vo.PageVo;
import cn.mrcsh.backend.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

@CrossOrigin
@RestController()
@RequestMapping("/verify")
public class VerifyController extends BaseController {

    @Autowired
    private VerifyService verifyService;

    @GetMapping
    public R getAll(String domain, Integer current_page, Integer page_size) {
        PageVo<Verify> pageVo = verifyService.selectPage(domain, current_page,page_size);
        return R.ok(pageVo);
    }

    @PostMapping("/check")
    public R verify(@RequestBody VerifyDTO verifyDTO){
        boolean success = verifyService.verify(verifyDTO);
        return R.ok(success);
    }

    @PostMapping()
    public R newLis(@RequestBody Verify verify){
        verifyService.insert(verify);
        return R.ok();
    }

    @PutMapping
    public R changeLis(@RequestBody Verify verify){
        verifyService.change(verify);
        return R.ok();
    }

    @DeleteMapping
    private R delLis(String id){
        verifyService.delete(id);
        return R.ok();
    }
}
