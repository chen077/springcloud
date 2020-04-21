package com.jason.dot.springcloud.dao;

import com.jason.dot.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@Mapper
public interface PaymentDAO {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
