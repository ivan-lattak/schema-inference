package cz.cuni.mff.ksi.nosql.s13e.performance;

import com.mongodb.MongoClient;
import com.mongodb.MongoTimeoutException;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

class MongoClientWithRestart {

    private final List<String> restartCommand;

    public MongoClientWithRestart(List<String> restartCommand) {
        this.restartCommand = restartCommand;
    }

    void runWithRestart(Consumer<MongoClient> r) throws IOException {
        try (MongoClient client = new MongoClient()) {
            r.accept(client);
        } catch (MongoTimeoutException e) {
            System.out.println("    ERROR: Mongo connection failed! Trying to restart the mongodb server...");
            e.printStackTrace();

            restart();

            try (MongoClient client = new MongoClient()) {
                r.accept(client);
            }
        }
    }

    private void restart() throws IOException {
        try {
            new ProcessBuilder(restartCommand)
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
