package blockchain.validation;

import blockchain.entity.Block;
import blockchain.entity.Blockchain;

public class BlockValidator {
    public boolean isValid(Block block, Blockchain blockchain) {
        return blockchain.getHashOfThePreviousBlock().equals(block.getHashOfThePreviousBlock());

    }


    public  void validZerosInHash(Block block, Blockchain blockchain) {

        if (block.getTimeOfGeneratingBlock() > 2000) {
            blockchain.setStartZeros(blockchain.getStartZeros() - 1);
            block.setMessageN("\nN was decreased to " + blockchain.getStartZeros());

        } else if (block.getTimeOfGeneratingBlock() < 20) {
            blockchain.setStartZeros(blockchain.getStartZeros() + 1);
            block.setMessageN("\nN was increased to " + blockchain.getStartZeros());

        } else
            block.setMessageN("\nN stays the same");
    }


}
