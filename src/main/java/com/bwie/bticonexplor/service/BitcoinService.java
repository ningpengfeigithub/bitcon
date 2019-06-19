package com.bwie.bticonexplor.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import java.util.Date;
public interface BitcoinService {
    void syncData(String tempblockhash);
    void synctx(JSONObject txJson, String blockhash, Date time, Integer confirmations);
    void syncTxDetail(JSONObject txJson, String txid);

    void syncTxDetailVout(JSONArray vouts, String txid);

    void syncTxDetailVin(JSONArray vins, String txid);
}
