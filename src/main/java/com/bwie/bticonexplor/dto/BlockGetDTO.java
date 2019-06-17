package com.bwie.bticonexplor.dto;
 import java.util.Date;
 import java.util.List;
public class BlockGetDTO {
    private String blockhash;

    private Integer confirmations;

    private Integer strippedsize;

    private Integer size;

    private Integer weight;

    private Integer height;

    private Integer version;

    private String merkleroot;

    private Date time;

    private Date receivedTime;

    private String relayedBy;

    private Integer nonce;

    private Integer difficulty;

    private String chainwork;

    private Integer txsize;

    private String nextBlock;

    private String prevBlock;

    private Double outputTotal;

    private Double fees;

    private Double blockReward;

    public List<String> transactionList;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Integer getStrippedsize() {
        return strippedsize;
    }

    public void setStrippedsize(Integer strippedsize) {
        this.strippedsize = strippedsize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMerkleroot() {
        return merkleroot;
    }

    public void setMerkleroot(String merkleroot) {
        this.merkleroot = merkleroot;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getRelayedBy() {
        return relayedBy;
    }

    public void setRelayedBy(String relayedBy) {
        this.relayedBy = relayedBy;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getChainwork() {
        return chainwork;
    }

    public void setChainwork(String chainwork) {
        this.chainwork = chainwork;
    }

    public Integer getTxsize() {
        return txsize;
    }

    public void setTxsize(Integer txsize) {
        this.txsize = txsize;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
    }

    public String getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
    }
    public Double getFees() {
        return fees;
    }

    public BlockGetDTO setFees(Double fees) {
        this.fees = fees;
        return this;
    }

    public Double getBlockReward() {
        return blockReward;
    }

    public BlockGetDTO setBlockReward(Double blockReward) {
        this.blockReward = blockReward;
        return this;
    }

    public List<String> getTransactionList() {
        return transactionList;
    }

    public BlockGetDTO setTransactionList(List<String> transactionList) {
        this.transactionList = transactionList;
        return this;
    }

}
