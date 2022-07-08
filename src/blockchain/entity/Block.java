package blockchain.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;

public class Block implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long timestamp;
    private long timeOfGeneratingBlock;
    private String hashOfThePreviousBlock;
    private int id;
    private long magicNumber;
    private String hashOfTheBlock;

    private final long idOfMiner;

    private String messageN;

    public Block(String hashOfThePreviousBlock, long idOfMiner) {
        timeOfGeneratingBlock = LocalTime.now().toSecondOfDay();
        this.hashOfThePreviousBlock = hashOfThePreviousBlock;
        this.idOfMiner = idOfMiner;
    }

    public String getHashOfThePreviousBlock() {
        return hashOfThePreviousBlock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeOfGeneratingBlock(long timeOfGeneratingBlock) {
        this.timeOfGeneratingBlock = timeOfGeneratingBlock;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setMagicNumber(long magicNumber) {
        this.magicNumber = magicNumber;
    }

    public void setHashOfTheBlock(String hashOfTheBlock) {
        this.hashOfTheBlock = hashOfTheBlock;
    }

    public long getTimeOfGeneratingBlock() {
        return timeOfGeneratingBlock;
    }

    public int getId() {
        return id;
    }

    public long getMagicNumber() {
        return magicNumber;
    }

    public String getHashOfTheBlock() {
        return hashOfTheBlock;
    }
    public void setMessageN(String messageN) {
        this.messageN = messageN;
    }

    @Override
    public String toString() {
        int balance = 100;
        return "\nBlock:" +
                "\nCreated by miner" + idOfMiner +
                "\nminer" + idOfMiner + " gets " + balance + " VC" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + hashOfThePreviousBlock +
                "\nHash of the block:\n" + hashOfTheBlock +
                "\nBlock data:" +
                "\nBlock was generating for " + (timeOfGeneratingBlock / 1000) + " seconds" +
                messageN;
    }

}
