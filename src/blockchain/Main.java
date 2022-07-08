package blockchain;


import blockchain.entity.Blockchain;
import blockchain.service.BlockchainService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int countOfTheThread = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(countOfTheThread);
        Blockchain blockchain = new Blockchain();
        BlockchainService blockchainService = new BlockchainService();
        blockchainService.builtAndPrintBlocks(blockchain, service);
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
