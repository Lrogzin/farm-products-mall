package com.nuzoul.admin.service.impl;

import com.nuzoul.admin.service.ExpressService;
import com.nuzoul.mapper.TbExpressMapper;
import com.nuzoul.pojo.TbExpress;
import com.nuzoul.pojo.TbExpressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Exrickx
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private TbExpressMapper tbExpressMapper;

    @Override
    public List<TbExpress> getExpressList() {

        TbExpressExample example = new TbExpressExample();
        example.setOrderByClause("sort_order asc");
        return tbExpressMapper.selectByExample(example);
    }

    @Override
    public int addExpress(TbExpress tbExpress) {

        tbExpress.setCreated(new Date());
        tbExpressMapper.insert(tbExpress);
        return 1;
    }

    @Override
    public int updateExpress(TbExpress tbExpress) {

        tbExpress.setUpdated(new Date());
        tbExpressMapper.updateByPrimaryKey(tbExpress);
        return 1;
    }

    @Override
    public int delExpress(int id) {

        tbExpressMapper.deleteByPrimaryKey(id);
        return 1;
    }
}