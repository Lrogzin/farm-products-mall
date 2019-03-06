package com.nuzoul.admin.service;

import com.nuzoul.common.pojo.DataTablesResult;
import com.nuzoul.pojo.TbThanks;

/**
 * @author Exrickx
 */
public interface ThanksService {

    /**
     * 获得捐赠列表
     * @return
     */
    DataTablesResult getThanksList();

    /**
     * 分页获取捐赠列表
     * @param page
     * @param size
     * @return
     */
    DataTablesResult getThanksListByPage(int page, int size);

    /**
     * 统计捐赠表数目
     * @return
     */
    Long countThanks();

    /**
     * 添加捐赠
     * @param tbThanks
     * @return
     */
    int addThanks(TbThanks tbThanks);

    /**
     * 更新捐赠
     * @param tbThanks
     * @return
     */
    int updateThanks(TbThanks tbThanks);

    /**
     * 删除捐赠
     * @param id
     * @return
     */
    int deleteThanks(int id);

    /**
     * 通过id获取
     * @param id
     * @return
     */
    TbThanks getThankById(int id);
}
