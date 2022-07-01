package blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blockchain implements Serializable {
    private static final long serialVersionUID = 1l;
    private volatile int id = 0;

    private volatile String hashOfThePreviousBlock = "0";

    private List<Block> blocks = new ArrayList<>();

    private int startZeros = 0;

    private final int countOfBlocks = 5;

    Blockchain() {
        builtAndPrintBlocks();
    }

    public synchronized void addBlock(Block block) {
        block.setId(id);
        System.out.println(block);
        blocks.add(block);
    }

    public void builtAndPrintBlocks() {

        for (int i = 1; i <= countOfBlocks; i++) {
            id = i;
            Miner miner = new Miner(this);
            miner.start();
        }


    }


    public int getId() {
        return id;
    }

    public String getHashOfThePreviousBlock() {
        return hashOfThePreviousBlock;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public int getStartZeros() {
        return startZeros;
    }

    public int getCountOfBlocks() {
        return countOfBlocks;
    }
}
