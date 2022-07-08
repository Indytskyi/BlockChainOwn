package blockchain.entity;

import blockchain.entity.Block;
import blockchain.validation.BlockValidator;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blockchain implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Block> blocks = new ArrayList<>();
    private int startZeros = 0;

    private final BlockValidator blockValidator = new BlockValidator();

    public synchronized void addBlock(Block block) {
        if (blockValidator.isValid(block, this)) {
            block.setTimeOfGeneratingBlock(System.currentTimeMillis()- block.getTimeOfGeneratingBlock());

            blockValidator.validZerosInHash(block, this);
            block.setId(blocks.size() + 1);
            System.out.println(block);
            blocks.add(block);
        }
    }

    public String getHashOfThePreviousBlock() {
        return blocks.isEmpty() ? "0" : blocks.get(blocks.size() - 1).getHashOfTheBlock();
    }

    public int getStartZeros() {
        return startZeros;
    }

    public void setStartZeros(int startZeros) {
        this.startZeros = startZeros;
    }

    public int getCountOfBlocks() {
        return 15;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
