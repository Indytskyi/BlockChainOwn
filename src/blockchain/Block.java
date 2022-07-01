package blockchain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Block implements Serializable {
    private static final long serialVersionUID = 1l;
    private final long timestamp = new Date().getTime();
    private String hashOfTheBlock;
    private final String hashOfThePreviousBlock;
    private int id;
    private long magicNumber;
    private int timeOfGeneratingBlock;

    private final long idOfMiner;

    private final int startZeros;

    public Block(String hashOfThePreviousBlock, int startZeros, long idOfMiner) {
        timeOfGeneratingBlock = LocalTime.now().toSecondOfDay();
        this.hashOfThePreviousBlock = hashOfThePreviousBlock;
        this.idOfMiner = idOfMiner;
        this.startZeros = startZeros;
        findMagicNumber(startZeros);
        timeOfGeneratingBlock = LocalTime.now().toSecondOfDay() - timeOfGeneratingBlock;
    }

    private void findMagicNumber(int zeroes) {
        final Random random = new Random();
        do {
            magicNumber = random.nextLong();
            hashOfTheBlock = StringUtil.applySha256(id + timeOfGeneratingBlock + hashOfThePreviousBlock + magicNumber);
        } while (!isHaveCurrentZeros(zeroes));
    }

    private boolean isHaveCurrentZeros(int zeroes) {
        for (int i = 0; i < zeroes; i++) {
            if (hashOfTheBlock.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public String getHashOfThePreviousBlock() {
        return hashOfThePreviousBlock;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nBlock:" +
                "\nCreated by miner # " + idOfMiner +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + hashOfThePreviousBlock +
                "\nHash of the block:\n" + hashOfTheBlock +
                 "\nBlock was generating for " + timeOfGeneratingBlock + " seconds" +
                "\nN was increased to " + startZeros;
    }
}
