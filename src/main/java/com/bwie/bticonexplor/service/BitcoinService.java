package com.bwie.bticonexplor.service;

import com.alibaba.fastjson.JSONObject;
import java.util.Date;
public interface BitcoinService {
    void syncData(String tempblockhash);
    void synctx(JSONObject txJson, String blockhash, Date time, Integer confirmations);
}
