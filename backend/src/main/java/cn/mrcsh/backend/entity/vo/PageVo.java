package cn.mrcsh.backend.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVo <E>{
    private long total;
    private List<E> data;
}
