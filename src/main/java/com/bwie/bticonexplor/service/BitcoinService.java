package com.bwie.bticonexplor.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import java.util.Date;
public interface BitcoinService{
    void blockchinfromhash(String blockhash);

    String syncData(String tempblockhash);

    void synctx(JSONObject txJson, String blockhash, Date time, Integer confirmations);

    void syncTxDetail(JSONObject txJson, String txid) throws Throwable;

    void syncTxDetailVout(JSONArray vouts, String txid);

    void syncTxDetailVin(JSONArray vins, String txid) throws Throwable;
}
