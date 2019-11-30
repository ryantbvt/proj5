package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * the data solver reads and sorts
 * the files
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
 */
public class DataSolver {
    /**
     * fields
     */
    private SongList songList;
    private StudentList studentList;
    
    /**
     * constructor
     * @throws FileNotFoundException 
     */
    public DataSolver(String songFile, String dataFile) 
            throws FileNotFoundException {
        songList = readSongFile(songFile);
        studentList = readDataFile(dataFile);
    }
    
    /**
     * reads the song files and puts it into a list
     * @param the file being read
     * @return the list of songs
     * @throws FileNotFoundException 
     */
    private SongList readSongFile(String songFile) 
            throws FileNotFoundException {
        SongList temp = new SongList();
        
        if (songFile == null) {
            throw new FileNotFoundException();
        }
        
        Scanner songScanner = new Scanner(new File(songFile));
        
        while (songScanner.hasNextLine()) {
            String line = songScanner.nextLine();
            String[] split = line.split(",");
            Song song = new Song(split[0], split[1], split[3], split[2]);
            temp.add(song);
        }
        songScanner.close();
        return temp;
    }
    
    /**
     * reads the data list with the students
     * 
     * @param dataFile the file that's being read
     * @return the list of students with hobby region major
     * @throws FileNotFoundException 
     */
    private StudentList readDataFile(String dataFile)
            throws FileNotFoundException {
        StudentList temp = new StudentList();
        
        if (dataFile == null) {
            throw new FileNotFoundException();
        }
        
        Scanner dataScanner = new Scanner(new File(dataFile));
        
        while (dataScanner.hasNextLine()) {
            String line = dataScanner.nextLine();
            String[] split = line.split(",");
            // int studentID = Integer.parseInt(split[0]);
            String major = split[2];
            String hobby = split[4];
            String region = split[3];
            Student student = new Student(hobby, region, major);
            // adds the student's responses
            for (int i = 5; i < split.length; i++) {
                
                student.addResponse(split[i]);
            }
            
            // adds the student to the list if the student isn't null
            if (student != null) {
                temp.add(student);
            }
        }
        
        dataScanner.close();
        return temp;
    } // end readDataFile
    
    // loops data
    /**
     * takes the student list and
     * goes through the list
     * updating the like and heard 
     * in song
     */
    public void loop() {
        studentList.loopData(songList);
    }
}
