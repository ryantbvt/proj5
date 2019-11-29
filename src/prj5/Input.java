package prj5;

import java.io.FileNotFoundException;

/**
 * Input class that contains the main method and is used to begin the program by
 * creating a GUIProjectWindow and call the DataSolver class. Acts like a
 * projectRunner() class.
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 * 
 * @version 2019.11.17
 *
 */
public class Input {
    /**
     * New Input Object
     */
    public Input() {
        // constructor not needed
    }

    /**
     * The main method It's the entry point of the java
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataSolver dataSolver = null;
        if (args.length == 2) {
            dataSolver = new DataSolver(args[0], args[1]);
            GUIWindow display = new GUIWindow();
        }

        else {
            dataSolver = 
                    new DataSolver("SongList2018HalfSongs.csv", "MusicSurveyData2018HolesHalf.csv");
            GUIWindow display = new GUIWindow();
        }
    }

}
