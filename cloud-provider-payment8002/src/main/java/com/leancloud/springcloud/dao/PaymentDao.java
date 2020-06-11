package com.leancloud.springcloud.dao;

import com.leancloud.springcloud.entities.Payment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PaymentDao {

    /**
     * [新增]
     * @author weibin
     * @date 2020/05/28
     **/
    int insert(Payment pyament);

    /**
     * [刪除]
     * @author weibin
     * @date 2020/05/28
     **/
    int delete(int id);

    /**
     * [更新]
     * @author weibin
     * @date 2020/05/28
     **/
    int update(Payment pyament);

    /**
     * [查询] 根据主键 id 查询
     * @author weibin
     * @date 2020/05/28
     **/
    Payment load(int id);

    /**
     * [查询] 分页查询
     * @author weibin
     * @date 2020/05/28
     **/
    List<Payment> pageList(int offset, int pagesize);

    /**
     * [查询] 分页查询 count
     * @author weibin
     * @date 2020/05/28
     **/
    int pageListCount(int offset,int pagesize);
}
