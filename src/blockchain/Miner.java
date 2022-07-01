package blockchain;

public class Miner extends Thread{
    private final Blockchain blockchain;


    public Miner(Blockchain blockchain) {
        this.blockchain = blockchain;

    }

    @Override
    public void run() {
        Block block = new Block(blockchain.getHashOfThePreviousBlock(),
                blockchain.getStartZeros(), Thread.currentThread().getId());
        blockchain.addBlock(block);

    }
}
