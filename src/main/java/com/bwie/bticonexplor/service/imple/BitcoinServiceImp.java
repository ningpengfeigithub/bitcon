package com.bwie.bticonexplor.service.imple;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

import com.bwie.bticonexplor.api.BitconJsonRpcApi;
import com.bwie.bticonexplor.api.BitconrestApi;
import com.bwie.bticonexplor.dao.BlockMapper;
import com.bwie.bticonexplor.dao.TransactionDetailMapper;
import com.bwie.bticonexplor.dao.TransactionMapper;
import com.bwie.bticonexplor.po.Block;
import com.bwie.bticonexplor.po.Transaction;
import com.bwie.bticonexplor.po.TransactionDetail;
import com.bwie.bticonexplor.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


public class BitcoinServiceImp implements BitcoinService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitconrestApi bitconrestApi;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private BitconJsonRpcApi bitconJsonRpcApi;
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Override
    @Transactional
    public void syncData(String tempblockhash) {
      while(tempblockhash !=null && !tempblockhash.isEmpty()){
          logger.info("begin to sync block from {}", tempblockhash);
          JSONObject blockjson = bitconrestApi.getBlockByblockhash(tempblockhash);
          Block block = new Block();
          block.setBlockhash(blockjson.getString("hash"));
          block.setChainwork(blockjson.getString("chainwork"));
          block.setConfirmations(blockjson.getInteger("confirmations"));
          block.setDifficulty(blockjson.getInteger("hash"));
          block.setHeight(blockjson.getInteger("height"));
          block.setMerkleroot(blockjson.getString("hash"));
          block.setNextBlock(blockjson.getString("nextBlock"));
          block.setNonce(blockjson.getInteger("nonce"));
          block.setPrevBlock(blockjson.getString("prevBlock"));
          block.setSize(blockjson.getInteger("size"));
          Long timestamp = blockjson.getLong("time");
          Date time = new Date(timestamp * 1000);
          block.setTime(time);
          block.setStrippedsize(blockjson.getInteger("strippedsize"));
          block.setVersion(blockjson.getInteger("version"));
          block.setWeight(blockjson.getInteger("weight"));
          blockMapper.insert(block);

          JSONArray txesArray = blockjson.getJSONArray("tx");

          for (Object txObj : txesArray) {
              JSONObject jsonObject = new JSONObject((LinkedHashMap) txObj);
              //synctx(jsonObject, tempblockhash, time, confirmations);
          }

          tempblockhash = block.getNextBlock();
      }
        logger.info("end sync block");
    }

    @Override
    @Transactional
    public void synctx(JSONObject txJson, String blockhash, Date time, Integer confirmations) {
        Transaction transaction = new Transaction();
        String txid = txJson.getString("txid");
        transaction.setTime(time);
        transaction.setTxhash("txid");
        transaction.setBlockhash("blockhash");
        transaction.setConfirmations(confirmations);
        transaction.setAmount(txJson.getDouble("amount"));
        transaction.setSize(txJson.getInteger("size"));
        transaction.setWeight(txJson.getFloat("weight"));
        transactionMapper.insert(transaction);
    }

    @Override
    @Transactional
    public void syncTxDetail(JSONObject txJson, String txid) throws Throwable {
        JSONArray vouts = txJson.getJSONArray("vout");
        syncTxDetailVout(vouts,txid);
        JSONArray vins= txJson.getJSONArray("vin");
        syncTxDetailVin(vins,txid);
    }

    @Override
    @Transactional
    public void syncTxDetailVin(JSONArray vins, String txid)throws Throwable {
        for (Object vin : vins) {
            JSONObject vinobj = new JSONObject((LinkedHashMap) vin);
            String vinTxhash=vinobj.getString("txid");
            Integer n=vinobj.getInteger("vout");
            if(vinTxhash != null){
                JSONObject vinTxJson=bitconJsonRpcApi.getTransactionsByhash(vinTxhash);
                JSONArray vouts = vinTxJson.getJSONArray("vout");
                JSONObject utxojson = vouts.getJSONObject(n);
                TransactionDetail txDetail = new TransactionDetail();
                txDetail.setAmount(-utxojson.getDouble("value"));
                txDetail.setTxhash(txid);
                //txDetail.setType((byte) TxDetailType.Send.ordinal());
                JSONObject scriptPubKey = utxojson.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if (addresses != null){
                    String address = addresses.getString(0);
                    txDetail.setAddress(address);
                }

            }
           }
        }


    @Override
    @Transactional
    public void syncTxDetailVout(JSONArray vouts, String txid) {
        for (Object vout : vouts) {
            JSONObject voutobj = new JSONObject((LinkedHashMap) vout);
            TransactionDetail transactionDetail = new TransactionDetail();
            transactionDetail.setAmount(voutobj.getDouble("value"));
            //transactionDetail.setType();
            transactionDetail.setTxhash(txid);
        }
    }


}
