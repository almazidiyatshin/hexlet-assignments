package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathFrom1, String pathFrom2, String pathTo) {
        CompletableFuture<String> read1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(pathFrom1));
            } catch (IOException e) {
                throw new RuntimeException("Error reading file from pathFrom1: " + e.getMessage());
            }
        });

        CompletableFuture<String> read2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(pathFrom2));
            } catch (IOException e) {
                throw new RuntimeException("Error reading file from pathFrom2: " + e.getMessage());
            }
        });

        return read1.thenCombine(read2, (file1, file2) -> {
            String combinedContent = file1 + file2;

            try {
                Files.writeString(Path.of(pathTo), combinedContent);
            } catch (IOException e) {
                throw new RuntimeException("Error writing file to pathTo: " + e.getMessage());
            }

            return combinedContent;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
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

