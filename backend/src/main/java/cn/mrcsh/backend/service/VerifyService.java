package cn.mrcsh.backend.service;

import cn.mrcsh.backend.entity.dto.VerifyDTO;
import cn.mrcsh.backend.entity.pojo.Verify;
import cn.mrcsh.backend.entity.vo.PageVo;

public interface VerifyService {

    boolean verify(VerifyDTO verifyDTO);

    void insert(Verify verify);

    PageVo<Verify> selectPage(String domain, Integer currentPage, Integer pageSize);

    void change(Verify verify);

    void delete(String id);
}
