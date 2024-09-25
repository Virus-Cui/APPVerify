package cn.mrcsh.backend.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.mrcsh.backend.entity.dto.VerifyDTO;
import cn.mrcsh.backend.entity.pojo.Verify;
import cn.mrcsh.backend.entity.vo.PageVo;
import cn.mrcsh.backend.mapper.VerifyMapper;
import cn.mrcsh.backend.service.VerifyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Service
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private VerifyMapper verifyMapper;

    @Override
    public boolean verify(VerifyDTO verifyDTO) {
        QueryWrapper<Verify> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("domain", verifyDTO.getDomain())
                .eq("liscense", verifyDTO.getLiscense());
        Verify verify = verifyMapper.selectOne(queryWrapper);
        if(verify.getHwid() != null && !verify.getHwid().isEmpty()){
            if(!verify.getHwid().equals(verifyDTO.getHwid())){
                return false;
            }
        }
        if(verify != null && verify.getExpireTime().after(new Date())){
            if(verify.getHwid() == null || verify.getHwid().isEmpty()){
                verify.setHwid(verifyDTO.getHwid());
                verifyMapper.updateById(verify);
            }
            return true;
        }
        return false;
    }

    @Override
    public void insert(Verify verify) {
        verify.setLiscense(UUID.randomUUID().toString().replaceAll("-","").toUpperCase(Locale.ROOT));
        verify.setId(IdUtil.getSnowflakeNextIdStr());
        verifyMapper.insert(verify);
    }

    @Override
    public PageVo<Verify> selectPage(String domain, Integer currentPage, Integer pageSize) {
        PageVo<Verify> result = new PageVo<>();
        Page<Verify> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Verify> queryWrapper = new QueryWrapper();
        queryWrapper.like("domain", "%"+domain+"%");
        verifyMapper.selectPage(page, queryWrapper);
        result.setData(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    @Override
    public void change(Verify verify) {
        verifyMapper.updateById(verify);
    }

    @Override
    public void delete(String id) {
        verifyMapper.deleteById(id);
    }


}
