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
    public SongList readSongFile(String songFile) 
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
    public StudentList readDataFile(String dataFile)
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
            
            student.setResponseSize(split.length);
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
    
    // calculate the percentages taking data from songList
    public void calculate() {
        int songSize = songList.size();
        
        for (int i = 0; i < songSize; i++) {
            Song currentSong = songList.get(i);
        }
    }
    
    // make 3 helper methods for each of the cat
    /**
     * calculates the percentages for hobby heard
     * 
     * @param song the song it's checking
     * @return the percentages of each cat
     */
    private int[] calcHobbyHeard(Song song) {
        int[][] hobbyHeard = song.getHobbyHeard();
        int[] hobbyPercent = new int[4]; // array of 4 cat
        
        hobbyPercent[0] = (int)((1.0 * hobbyHeard[0][1] 
                / hobbyHeard[0][0] + hobbyHeard[0][1])) * 100;
        
        hobbyPercent[1] = (int)((1.0 * hobbyHeard[1][1] 
                / hobbyHeard[1][0] + hobbyHeard[1][1])) * 100;
        
        hobbyPercent[2] = (int)((1.0 * hobbyHeard[2][1] 
                / hobbyHeard[2][0] + hobbyHeard[2][1])) * 100;
        
        hobbyPercent[3] = (int)((1.0 * hobbyHeard[3][1] 
                / hobbyHeard[3][0] + hobbyHeard[3][1])) * 100;
        
        return hobbyPercent;
    }
    
    /**
     * calculates the percentages for hobby like
     * 
     * @param song the song it's checking
     * @return the percentages of each cat
     */
    private int[] calcHobbyLike(Song song) {
        int[][] hobbyLike = song.getHobbyLiked();
        int[] hobbyPercent = new int[4]; // array of 4 cat
        
        hobbyPercent[0] = (int)((1.0 * hobbyLike[0][1] 
                / hobbyLike[0][0] + hobbyLike[0][1])) * 100;
        
        hobbyPercent[1] = (int)((1.0 * hobbyLike[1][1] 
                / hobbyLike[1][0] + hobbyLike[1][1])) * 100;
        
        hobbyPercent[2] = (int)((1.0 * hobbyLike[2][1] 
                / hobbyLike[2][0] + hobbyLike[2][1])) * 100;
        
        hobbyPercent[3] = (int)((1.0 * hobbyLike[3][1] 
                / hobbyLike[3][0] + hobbyLike[3][1])) * 100;
        
        return hobbyPercent;
    }
    
    /**
     * calculates percent for region heard
     * 
     * @param song the song it calculates the percent
     * @return the 4 cat and percentages
     */
    private int[] calcRegionHeard(Song song) {
        int[][] regionHeard = song.getRegionHeard();
        int[] regionPercent = new int[4]; // array of 4 cat
        
        regionPercent[0] = (int)((1.0 * regionHeard[0][1] 
                / regionHeard[0][0] + regionHeard[0][1])) * 100;
        
        regionPercent[1] = (int)((1.0 * regionHeard[1][1] 
                / regionHeard[1][0] + regionHeard[1][1])) * 100;
        
        regionPercent[2] = (int)((1.0 * regionHeard[2][1] 
                / regionHeard[2][0] + regionHeard[2][1])) * 100;
        
        regionPercent[3] = (int)((1.0 * regionHeard[3][1] 
                / regionHeard[3][0] + regionHeard[3][1])) * 100;
        
        return regionPercent;
    }
    
    /**
     * calculates percent for region like
     * 
     * @param song the song it calculates the percent
     * @return the 4 cat and percentages
     */
    private int[] calcRegionLike(Song song) {
        int[][] regionLike = song.getRegionLiked();
        int[] regionPercent = new int[4]; // array of 4 cat
        
        regionPercent[0] = (int)((1.0 * regionLike[0][1] 
                / regionLike[0][0] + regionLike[0][1])) * 100;
        
        regionPercent[1] = (int)((1.0 * regionLike[1][1] 
                / regionLike[1][0] + regionLike[1][1])) * 100;
        
        regionPercent[2] = (int)((1.0 * regionLike[2][1] 
                / regionLike[2][0] + regionLike[2][1])) * 100;
        
        regionPercent[3] = (int)((1.0 * regionLike[3][1] 
                / regionLike[3][0] + regionLike[3][1])) * 100;
        
        return regionPercent;
    }
    
    /**
     * calculates percent for major heard
     * 
     * @param song the song it calculates the percent
     * @return the 4 cat and percentages
     */
    private int[] calcMajorHeard(Song song) {
        int[][] majorHeard = song.getMajorHeard();
        int[] majorPercent = new int[4]; // array of 4 cat
        
        majorPercent[0] = (int)((1.0 * majorHeard[0][1] 
                / majorHeard[0][0] + majorHeard[0][1])) * 100;
        
        majorPercent[1] = (int)((1.0 * majorHeard[1][1] 
                / majorHeard[1][0] + majorHeard[1][1])) * 100;
        
        majorPercent[2] = (int)((1.0 * majorHeard[2][1] 
                / majorHeard[2][0] + majorHeard[2][1])) * 100;
        
        majorPercent[3] = (int)((1.0 * majorHeard[3][1] 
                / majorHeard[3][0] + majorHeard[3][1])) * 100;
        
        return majorPercent;
    }
    
    /**
     * calculates percent for major like
     * 
     * @param song the song it calculates the percent
     * @return the 4 cat and percentages
     */
    private int[] calcMajorLike(Song song) {
        int[][] majorLike = song.getMajorLiked();
        int[] majorPercent = new int[4]; // array of 4 cat
        
        majorPercent[0] = (int)((1.0 * majorLike[0][1] 
                / majorLike[0][0] + majorLike[0][1])) * 100;
        
        majorPercent[1] = (int)((1.0 * majorLike[1][1] 
                / majorLike[1][0] + majorLike[1][1])) * 100;
        
        majorPercent[2] = (int)((1.0 * majorLike[2][1] 
                / majorLike[2][0] + majorLike[2][1])) * 100;
        
        majorPercent[3] = (int)((1.0 * majorLike[3][1] 
                / majorLike[3][0] + majorLike[3][1])) * 100;
        
        return majorPercent;
    }
}
