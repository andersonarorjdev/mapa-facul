import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class app {
    public static void main(String[] args) throws IOException {

        // Create a BufferedReader to read the input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Read the data using the readline
        String name = reader.readLine();

        //Print the readline
        System.out.println("Hello " + name);

    }
}