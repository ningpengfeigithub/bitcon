package com.bwie.bticonexplor.api;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BitconrestApi", url = "http://localhost:18332")
public interface BitconrestApi{




    @GetMapping("/rest/chaininfo.json")
    JSONObject getBlockChainInfo();


    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlockByblockhash(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/tx/{txhash}.json")
    JSONObject getTransactionsByhash(@PathVariable(value = "txhash") String txhash);


    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getBlockBynotxdetailsblockhash(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    JSONArray getBlockheaders(@PathVariable Integer count, @PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    JSONObject getblockhashbyheight(@PathVariable(value = "height") Integer height);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getmempool();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getmempoolcontents();

}
