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
        if (args.length == 2) {
            GUIWindow display = new GUIWindow(args[0], args[1]);
        }

        else {
            GUIWindow display = new GUIWindow("SongList2019F.csv",
                "MusicSurveyData2019F.csv");
        }
    }

}
