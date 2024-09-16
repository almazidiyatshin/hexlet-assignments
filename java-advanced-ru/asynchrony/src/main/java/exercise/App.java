package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.io.File;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathFrom1, String pathFrom2, String pathTo) {
        CompletableFuture<String> content1 = CompletableFuture.supplyAsync(() -> {
            String content = "";
            try {
                content = Files.readString(Path.of(pathFrom1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });

        CompletableFuture<String> content2 = CompletableFuture.supplyAsync(() -> {
            String content = "";
            try {
                content = Files.readString(Path.of(pathFrom2));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });

        return content1.thenCombine(content2, (cont1, cont2) -> {
            String union = cont1 + cont2;
            try {
                Files.writeString(Path.of(pathTo), union);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return union;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });
    }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        try {
            unionFiles(
                    "src/main/resources/file1.txt",
                    "src/main/resources/file2.txt",
                    "src/main/resources/file3.txt").get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // END
    }
}

