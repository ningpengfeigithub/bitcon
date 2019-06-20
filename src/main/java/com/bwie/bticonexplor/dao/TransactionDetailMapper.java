package com.bwie.bticonexplor.dao;

import com.bwie.bticonexplor.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    Double getBalance(@Param("address") String address);
}