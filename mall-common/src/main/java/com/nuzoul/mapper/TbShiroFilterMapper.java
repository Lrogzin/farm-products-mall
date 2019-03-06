package com.nuzoul.mapper;

import com.nuzoul.pojo.TbShiroFilter;
import com.nuzoul.pojo.TbShiroFilterExample;
import com.nuzoul.common.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbShiroFilterMapper extends BaseMapper {
    long countByExample(TbShiroFilterExample example);

    int deleteByExample(TbShiroFilterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShiroFilter record);

    int insertSelective(TbShiroFilter record);

    List<TbShiroFilter> selectByExample(TbShiroFilterExample example);

    TbShiroFilter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShiroFilter record, @Param("example") TbShiroFilterExample example);

    int updateByExample(@Param("record") TbShiroFilter record, @Param("example") TbShiroFilterExample example);

    int updateByPrimaryKeySelective(TbShiroFilter record);

    int updateByPrimaryKey(TbShiroFilter record);
}