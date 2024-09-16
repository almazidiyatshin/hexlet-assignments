package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.io.File;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathFrom1, String pathFrom2, String pathTo) {
        CompletableFuture<String> read1 = CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(pathFrom1);

            try {
                if (!Files.exists(path)) {
                    throw new NoSuchFileException(pathFrom1);
                }

                return Files.readString(path);
            } catch (NoSuchFileException e) {
                throw new RuntimeException("File not found: " + pathFrom1);
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + pathFrom1);
            }
        });

        CompletableFuture<String> read2 = CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(pathFrom2);

            try {
                if (!Files.exists(path)) {
                    throw new NoSuchFileException(pathFrom2);
                }

                return Files.readString(path);
            } catch (NoSuchFileException e) {
                throw new RuntimeException("File not found: " + pathFrom2);
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + pathFrom2);
            }
        });

        return read1.thenCombine(read2, (file1, file2) -> {
            String content = file1 + file2;

            try {
                Files.writeString(Path.of(pathTo), content);
            } catch (IOException e) {
                throw new RuntimeException("Error writing file to pathTo: " + e.getMessage());
            }

            return content;
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

