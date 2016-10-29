package route.reader;

import exceptions.Messages;
import exceptions.RouteReaderException;
import route.Checkpoint;
import route.Route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides reading route checkpoints from text file.
 *
 * @author Oleg Baslak
 * @version 1.0
 * @since 27.10.2016
 */
public class RouteFileReader extends RouteReader {

    private File routeFile;

    public RouteFileReader(File txtFile) {
        routeFile = txtFile;
    }

    /**
     * Gets route presented in file as lines of pairs of double
     * values (x and y coordinates).
     *
     * @return route read from file
     * @throws RouteReaderException if problem with file reading occurred
     *                              or if 0 or 1 checkpoints were found, or first
     *                              and last checkpoints are equals (they can't
     *                              be equal by the program's logic)
     */
    public Route read() throws Exception {
        ArrayList<Checkpoint> checkpoints = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.routeFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                try {
                    String[] splitLine = currentLine.split("\\s");
                    if (splitLine.length != 2) {
                        throw new Exception(Messages.INFO + " Can't found checkpoints in line \"" + currentLine + "\", skipped");
                    }
                    checkpoints.add(new Checkpoint(
                            Double.parseDouble(splitLine[0]),
                            Double.parseDouble(splitLine[1])));
                } catch (NumberFormatException e) {
                    System.out.println(Messages.INFO + " " + e.getMessage() + " can't parse to number, skipped");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            return new Route(checkpoints);
        } catch (IOException e) {
            throw new RouteReaderException(Messages.ERROR + " " + e.getMessage());
        }
    }
}
