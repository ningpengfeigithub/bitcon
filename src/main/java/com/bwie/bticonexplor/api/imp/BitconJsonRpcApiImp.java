package com.bwie.bticonexplor.api.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.bwie.bticonexplor.api.BitconJsonRpcApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
@Component
public class BitconJsonRpcApiImp implements BitconJsonRpcApi{


    private JsonRpcHttpClient jsonRpcHttpClient;
    //添加权限
    public BitconJsonRpcApiImp(@Value("${bitcoin.jsonrpc.username}") String username,
                                 @Value("${bitcoin.jsonrpc.password}") String password,
                                 @Value("${bitcoin.jsonrpc.url}") String url) throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s",username,password);
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url),headers);
    }
    @Override
    public JSONObject getBlockChainInfo() throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getmempool() throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getmempool", new Object[]{}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getmempoolcontents() throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getmempoolcontents", new Object[]{}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getTransactionsByhash(String txhash) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getTransactionsByhash", new Object[]{txhash}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getblockhashbyheight(Integer height) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblockhashbyheight", new Object[]{height}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONArray getBlockheaders(Integer count, String blockhash) throws Throwable {
        JSONArray jsonObject = jsonRpcHttpClient.invoke("getBlockheaders", new Object[]{count,blockhash}, JSONArray.class);
        return jsonObject;
    }

    @Override
    public JSONObject getBlockBynotxdetailsblockhash(String blockhash) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getBlockBynotxdetailsblockhash", new Object[]{blockhash}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getBlockByblockhash(String blockhash) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getBlockByblockhash", new Object[]{blockhash}, JSONObject.class);
        return jsonObject;
    }


}
