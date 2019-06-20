package com.bwie.bticonexplor.controller;

import com.bwie.bticonexplor.dao.TransactionDetailMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    private TransactionDetailMapper transactionDetailMapper;
    public Double getBalance(@RequestParam String address){
        transactionDetailMapper.getBalance(address);
        return null;
    }
}
