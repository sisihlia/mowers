import com.model.Lawn;
import com.model.Mower;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

public class Application {
    private String filepath;
    private Path path;
    private List<String> lines;



    public List<String> readFromFile (String path) {
        try {
            lines= Files.lines(Paths.get(path)).collect(Collectors.toList());
        } catch (IOException e) {
            //add some loggers here
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        String input="src/test/resources/input.txt";
        Application file = new Application();
        List<String> myparse=file.readFromFile(input);
        Lawn lawn = new Lawn(myparse.get(0));
        lawn.parse(myparse);
        lawn.start();
        System.out.println("==============================after mowing=====================");
        ConcurrentLinkedDeque<Mower> mowers=lawn.getMowers();
        mowers.stream().forEach(entry -> {
            System.out.println(entry.getCoordinate().toString()  + " " + entry.getOriantation() );
        });
    }

}
