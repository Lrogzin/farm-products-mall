package com.nuzoul.mapper;

import com.nuzoul.pojo.TbRolePerm;
import com.nuzoul.pojo.TbRolePermExample;
import com.nuzoul.common.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRolePermMapper extends BaseMapper {
    long countByExample(TbRolePermExample example);

    int deleteByExample(TbRolePermExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRolePerm record);

    int insertSelective(TbRolePerm record);

    List<TbRolePerm> selectByExample(TbRolePermExample example);

    TbRolePerm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRolePerm record, @Param("example") TbRolePermExample example);

    int updateByExample(@Param("record") TbRolePerm record, @Param("example") TbRolePermExample example);

    int updateByPrimaryKeySelective(TbRolePerm record);

    int updateByPrimaryKey(TbRolePerm record);
}