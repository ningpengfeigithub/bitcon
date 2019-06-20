package com.bwie.bticonexplor.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bwie.bticonexplor.api.BitconJsonRpcApi;
import com.bwie.bticonexplor.api.BitconrestApi ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TestApiController {
    @Autowired
    private BitconrestApi bitcoinRestApi;
    @Autowired
    private BitconJsonRpcApi bitconJsonRpcApi;
    @GetMapping("/test")
    public String test()throws Throwable{
        //JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        JSONObject transactionsByhash = bitcoinRestApi.getTransactionsByhash("00000000000ed3139372c0b8449f0fb1778b128f247546a551316edf5e531fb7");
        //JSONObject blockByblockhash = bitcoinRestApi.getBlockByblockhash("00000000000ed3139372c0b8449f0fb1778b128f247546a551316edf5e531fb7");
        //JSONObject blockBynotxdetailsblockhash = bitcoinRestApi.getBlockBynotxdetailsblockhash("00000000000ed3139372c0b8449f0fb1778b128f247546a551316edf5e531fb7");
        //JSONArray blockheaders = bitcoinRestApi.getBlockheaders("", "");
        //JSONObject getblockhashbyheight = bitcoinRestApi.getblockhashbyheight("");
         //JSONObject getmempool = bitcoinRestApi.getmempool();
         //JSONObject getmempoolcontents = bitcoinRestApi.getmempoolcontents();


        //JSONObject blocks= bitconJsonRpcApi.getBlockChainInfo();

        //String tempblockhash = "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943";


        return null;
    }
    
}
