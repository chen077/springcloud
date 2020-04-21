package com.jason.dot.springcloud.dao;

import com.jason.dot.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDAO {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
