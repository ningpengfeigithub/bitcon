package com.bwie.bticonexplor.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bwie.bticonexplor.api.BitconJsonRpcApi;
import com.bwie.bticonexplor.api.BitconrestApi ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String test(){

        String tempblockhash = "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943";


        return null;
    }


   /* @GetMapping("/chaininfo")
    public String getBlockChainInfo(){
        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        return blockChainInfo.toJSONString();
    }

    @GetMapping("/tx/{txhash}")
    public String getTransactionsByhash(@PathVariable String txhash){
        JSONObject transactionsByhash = bitcoinRestApi.getTransactionsByhash(txhash);
        return transactionsByhash.toJSONString();
    }

    @GetMapping("/block/{blockhash}")
    public String getBlockByblockhash(@PathVariable String blockhash){
        JSONObject blockByblockhash = bitcoinRestApi.getBlockByblockhash(blockhash);
        return blockByblockhash.toJSONString();
    }

    @GetMapping("/block/notxdetails/{blockhash}")
    public String getBlockBynotxdetailsblockhash(@PathVariable String blockhash){
        JSONObject blockBynotxdetailsblockhash = bitcoinRestApi.getBlockBynotxdetailsblockhash(blockhash);
        return blockBynotxdetailsblockhash.toJSONString();
    }

    @GetMapping("/headers/{count}/{blockhash}")
    public JSONArray getBlockheaders(@PathVariable Integer count, @PathVariable String blockhash){
        JSONArray blockheaders = bitcoinRestApi.getBlockheaders(count, blockhash);
        return blockheaders;
    }

    @GetMapping("/blockhashbyheight/{height}")
    public String getblockhashbyheight(@PathVariable Integer height){
        JSONObject getblockhashbyheight = bitcoinRestApi.getblockhashbyheight(height);
        return getblockhashbyheight.toJSONString();
    }

    @GetMapping("/mempool/info")
    public String getmempool(){
        JSONObject getmempool = bitcoinRestApi.getmempool();
        return getmempool.toJSONString();
    }

    @GetMapping("/mempool/contents")
    public String getmempoolcontents(){
        JSONObject getmempoolcontents = bitcoinRestApi.getmempoolcontents();
        return getmempoolcontents.toJSONString();
    }*/
   @GetMapping("/chaininfo")
   public String getBlockChainInfo() throws Throwable {
       JSONObject blocks= bitconJsonRpcApi.getBlockChainInfo();
       return blocks.toJSONString();
   }

    @GetMapping("/tx/{txhash}")
    public String getTransactionsByhash(@PathVariable String txhash) throws Throwable {
        JSONObject transactionsByhash = bitconJsonRpcApi.getTransactionsByhash(txhash);
        return transactionsByhash.toJSONString();
    }

    @GetMapping("/block/{blockhash}")
    public String getBlockByblockhash(@PathVariable String blockhash) throws Throwable {
        JSONObject blockByblockhash = bitconJsonRpcApi.getBlockByblockhash(blockhash);
        return blockByblockhash.toJSONString();
    }

    @GetMapping("/block/notxdetails/{blockhash}")
    public String getBlockBynotxdetailsblockhash(@PathVariable String blockhash) throws Throwable {
        JSONObject blockBynotxdetailsblockhash = bitconJsonRpcApi.getBlockBynotxdetailsblockhash(blockhash);
        return blockBynotxdetailsblockhash.toJSONString();
    }

    @GetMapping("/headers/{count}/{blockhash}")
    public JSONArray getBlockheaders(@PathVariable Integer count, @PathVariable String blockhash) throws Throwable {
        JSONArray blockheaders = bitconJsonRpcApi.getBlockheaders(count, blockhash);
        return blockheaders;
    }

    @GetMapping("/blockhashbyheight/{height}")
    public String getblockhashbyheight(@PathVariable Integer height) throws Throwable {
        JSONObject getblockhashbyheight = bitconJsonRpcApi.getblockhashbyheight(height);
        return getblockhashbyheight.toJSONString();
    }

    @GetMapping("/mempool/info")
    public String getmempool() throws Throwable {
        JSONObject getmempool = bitconJsonRpcApi.getmempool();
        return getmempool.toJSONString();
    }

    @GetMapping("/mempool/contents")
    public String getmempoolcontents() throws Throwable {
        JSONObject getmempoolcontents = bitconJsonRpcApi.getmempoolcontents();
        return getmempoolcontents.toJSONString();
    }
}
