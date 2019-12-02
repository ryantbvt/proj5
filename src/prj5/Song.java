/**
 * 
 */
package prj5;

/**
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 * 
 * @version 2019.11.27
 *
 */
public class Song {
    /**
     * fields
     */
    private String title;
    private String genre;
    private String year;
    private String artist;
    
    /**
     * left array is 4 categories
     * right array is yes or no
     * 
     * 
     * 0-3 respectively
     * Hobby  Read
     *        Art
     *        Sport
     *        Music
     * Region Northeast US
     *        Southeast US
     *        the rest of US
     *        outside the US
     * Major  Computer Science
     *        Other Engineering
     *        Math or CMDA
     *        Other
     *        
     * Yes = 1
     * No = 0
     */
    private int hobbyLike[][];
    private int hobbyHeard[][];
    private int regionLike[][];
    private int regionHeard[][];
    private int majorLike[][];
    private int majorHeard[][];
    
    // percentages of like and heard
    private int[] hobbyHeardPercent;
    private int[] hobbyLikePercent;
    private int[] regionHeardPercent;
    private int[] regionLikePercent;
    private int[] majorLikePercent;
    private int[] majorHeardPercent;
    
    /**
     * constructor of song class
     * 
     * @param title of the song
     * @param genre of the song
     * @param year when it was made
     */
    public Song(String title, String artist, String genre, String year) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        
        hobbyLike = new int[4][2];
        hobbyHeard = new int[4][2];
        regionLike = new int[4][2];
        regionHeard = new int[4][2];
        majorLike = new int[4][2];
        majorHeard = new int[4][2];
        
        hobbyHeardPercent = new int[4];
        hobbyLikePercent = new int[4];
        regionHeardPercent = new int[4];
        regionLikePercent = new int[4];
        majorHeardPercent = new int[4];
        majorLikePercent = new int[4];
    }
    
    // methods ------------------------
    
    /**
     * get the title of the song
     * 
     * @return the song title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * gets the artist of the song
     * 
     * @return the artist name
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * gets the genre of the song
     * 
     * @return the song genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * gets the year of the song
     * 
     * @return year when song was made
     */
    public String getYear() {
        return year;
    }
    
    /**
     * returns the 2D array of hobby liked
     * 
     * @return hobby liked
     */
    public int[][] getHobbyLiked() {
        return hobbyLike;
    }
    
    /**
     * returns the 2D array of hobby heard
     * 
     * @return hobby heard
     */
    public int[][] getHobbyHeard() {
        return hobbyHeard;
    }
    
    /**
     * returns the 2D array of region liked
     * 
     * @return region liked
     */
    public int[][] getRegionLiked() {
        return regionLike;
    }
    
    /**
     * returns the 2D array of region heard
     * 
     * @return region heard
     */
    public int[][] getRegionHeard() {
        return regionHeard;
    }
    
    /**
     * returns the 2D array of major liked
     * 
     * @return major liked
     */
    public int[][] getMajorLiked() {
        return majorLike;
    }
    
    /**
     * returns the 2D array of major heard
     * 
     * @return major heard
     */
    public int[][] getMajorHeard() {
        return majorHeard;
    }
    
    /**
     * return the array of percentages
     * for hobby likes
     * 
     * @return percentages
     */
    public int[] getHobbyLikePercent() {
        return hobbyLikePercent;
    }
    
    /**
     * return the array of percentages
     * for hobby heard
     * 
     * @return percentages
     */
    public int[] getHobbyHeardPercent() {
        return hobbyHeardPercent;
    }
    
    /**
     * return the array of percentages
     * for region likes
     * 
     * @return percentages
     */
    public int[] getRegionLikePercent() {
        return regionLikePercent;
    }
    
    /**
     * return the array of percentages
     * for region heard
     * 
     * @return percentages
     */
    public int[] getRegionHeardPercent() {
        return regionHeardPercent;
    }
    
    /**
     * return the array of percentages
     * for major like
     * 
     * @return percentages
     */
    public int[] getMajorLikePercent() {
        return majorLikePercent;
    }
    
    /**
     * return the array of percentages
     * for major heard
     * 
     * @return percentages
     */
    public int[] getMajorHeardPercent() {
        return majorHeardPercent;
    }
    
    /**
     * convert song to 1 line of string
     */
    public String toString() {
        return "Title: " + title + 
                ", Artist: " + artist +
                ", Genre: " + genre +
                ", Year: " + year;
    }
    
    // sorting yes and no's for each song
    /**
     * increments hobby
     * 
     * @param type hobby
     * @param heard the yes or no for heard
     * @param like the yes or no for like
     */
    private void incrementHobby(String type, int heard, int like) {
        // incrementing the heard
        if (type.equals("Read")) {
            if (heard == 1) {
                hobbyHeard[0][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                hobbyHeard[0][0]++;
            }
            
            if (like == 1) {
                hobbyLike[0][1]++;
            }
            
            else if (like == 0) {
                hobbyLike[0][0]++;
            }
        } // checks what hobby
        
        else if (type.equals("Art")) {
            if (heard == 1) {
                hobbyHeard[1][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                hobbyHeard[1][0]++;
            }
            
            if (like == 1) {
                hobbyLike[1][1]++;
            }
            
            else if (like == 0) {
                hobbyLike[1][0]++;
            }
        }
        
        else if (type.equals("Sports")) {
            if (heard == 1) {
                hobbyHeard[2][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                hobbyHeard[2][0]++;
            }
            
            if (like == 1) {
                hobbyLike[2][1]++;
            }
            
            else if (like == 0) {
                hobbyLike[2][0]++;
            }
        }
        
        else if (type.equals("Music")) {
            if (heard == 1) {
                hobbyHeard[3][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                hobbyHeard[3][0]++;
            }
            
            if (like == 1) {
                hobbyLike[3][1]++;
            }
            
            else if (like == 0) {
                hobbyLike[3][0]++;
            }
        }
    }
    
    /**
     * increments region
     * 
     * @param type region
     * @param heard yes or no
     * @param like yes or no
     */
    private void incrementRegion(String type, int heard, int like) {
        if (type.equals("Northeast")) {
            if (heard == 1) {
                regionHeard[0][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                regionHeard[0][0]++;
            }
            
            if (like == 1) {
                regionLike[0][1]++;
            }
            
            else if (like == 0) {
                regionLike[0][0]++;
            }
        } // checks what hobby
        
        else if (type.equals("Southeast")) {
            if (heard == 1) {
                regionHeard[1][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                regionHeard[1][0]++;
            }
            
            if (like == 1) {
                regionLike[1][1]++;
            }
            
            else if (like == 0) {
                regionLike[1][0]++;
            }
        }
        
        else if (type.equals("United States (other than Southeast or Northwest")) {
            if (heard == 1) {
                regionHeard[2][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                regionHeard[2][0]++;
            }
            
            if (like == 1) {
                regionLike[2][1]++;
            }
            
            else if (like == 0) {
                regionLike[2][0]++;
            }
        }
        
        else if (type.equals("Outside of United States")) {
            if (heard == 1) {
                regionHeard[3][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                regionHeard[3][0]++;
            }
            
            if (like == 1) {
                regionLike[3][1]++;
            }
            
            else if (like == 0) {
                regionLike[3][0]++;
            }
        }
    }
    
    /**
     * increments major
     * 
     * @param type major
     * @param heard yes or no for heard
     * @param like yes or no
     */
    private void incrementMajor(String type, int heard, int like) {
        if (type.equals("Computer Science")) {
            if (heard == 1) {
                majorHeard[0][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                majorHeard[0][0]++;
            }
            
            if (like == 1) {
                majorLike[0][1]++;
            }
            
            else if (like == 0) {
                majorLike[0][0]++;
            }
        } // checks what hobby
        
        else if (type.equals("Other Engineering")) {
            if (heard == 1) {
                majorHeard[1][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                majorHeard[1][0]++;
            }
            
            if (like == 1) {
                majorLike[1][1]++;
            }
            
            else if (like == 0) {
                majorLike[1][0]++;
            }
        }
        
        else if (type.equals("CMDA")) {
            if (heard == 1) {
                majorHeard[2][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                majorHeard[2][0]++;
            }
            
            if (like == 1) {
                majorLike[2][1]++;
            }
            
            else if (like == 0) {
                majorLike[2][0]++;
            }
        }
        
        else if (type.equals("Other")) {
            if (heard == 1) {
                majorHeard[3][1]++;
            } // checks yes or no
            
            else if (heard == 0) {
                majorHeard[3][0]++;
            }
            
            if (like == 1) {
                majorLike[3][1]++;
            }
            
            else if (like == 0) {
                majorLike[3][0]++;
            }
        }
    }
    
    //increments everything by using student
    /**
     * increments everything, hobby, region, major
     * 
     * @param student the student it's pulling responses from
     * @param answer1 heard responses
     * @param answer2 like responses
     */
    public void increment(Student student, int answer1, int answer2) {
        String hobby = student.getHobby();
        String region = student.getRegion();
        String major = student.getMajor();
        
        incrementHobby(hobby, answer1, answer2);
        incrementRegion(region, answer1, answer2);
        incrementMajor(major, answer1, answer2);
    }
    
    // calculate the percentages taking data from songList
    /**
     * calculates all the percentages
     * for the song
     */
    public void calculateAll() {
        hobbyHeardPercent = calcHobbyHeard();
        hobbyLikePercent = calcHobbyLike();
        regionHeardPercent = calcRegionHeard();
        regionLikePercent = calcRegionLike();
        majorHeardPercent = calcMajorHeard();
        majorLikePercent = calcMajorLike();
    }
    
    // make 3 helper methods for each of the cat
    /**
     * calculates the percentages for hobby heard
     * 
     * @return the percentages of each cat
     */
    private int[] calcHobbyHeard() {
        int[][] hobbyHeard = this.getHobbyHeard();
        int[] hobbyPercent = new int[4]; // array of 4 cat
        
        hobbyPercent[0] = (int)((double)(hobbyHeard[0][1] 
                / (double)(hobbyHeard[0][0] + hobbyHeard[0][1])) * 100);
        
        hobbyPercent[1] = (int)((double)(hobbyHeard[1][1] 
                / (double)(hobbyHeard[1][0] + hobbyHeard[1][1])) * 100);
        
        hobbyPercent[2] = (int)((double)(hobbyHeard[2][1] 
                / (double)(hobbyHeard[2][0] + hobbyHeard[2][1])) * 100);
        
        hobbyPercent[3] = (int)((double)(hobbyHeard[3][1] 
                / (double)(hobbyHeard[3][0] + hobbyHeard[3][1])) * 100);
        
        return hobbyPercent;
    }
    
    /**
     * calculates the percentages for hobby like
     * 
     * @return the percentages of each cat
     */
    private int[] calcHobbyLike() {
        int[][] hobbyLike = this.getHobbyLiked();
        int[] hobbyPercent = new int[4]; // array of 4 cat
        
        hobbyPercent[0] = (int)((double)(hobbyLike[0][1] 
                / (double)(hobbyLike[0][0] + hobbyLike[0][1])) * 100);
        
        hobbyPercent[1] = (int)((double)(hobbyLike[1][1] 
                / (double)(hobbyLike[1][0] + hobbyLike[1][1])) * 100);
        
        hobbyPercent[2] = (int)((double)(hobbyLike[2][1] 
                / (double)(hobbyLike[2][0] + hobbyLike[2][1])) * 100);
        
        hobbyPercent[3] = (int)((double)(hobbyLike[3][1] 
                / (double)(hobbyLike[3][0] + hobbyLike[3][1])) * 100);
        
        return hobbyPercent;
    }
    
    /**
     * calculates percent for region heard
     * 
     * @return the 4 cat and percentages
     */
    private int[] calcRegionHeard() {
        int[][] regionHeard = this.getRegionHeard();
        int[] regionPercent = new int[4]; // array of 4 cat
        
        regionPercent[0] = (int)((double)(regionHeard[0][1] 
                / (double)(regionHeard[0][0] + regionHeard[0][1])) * 100);
        
        regionPercent[1] = (int)((double)(regionHeard[1][1] 
                / (double)(regionHeard[1][0] + regionHeard[1][1])) * 100);
        
        regionPercent[2] = (int)((double)(regionHeard[2][1] 
                / (double)(regionHeard[2][0] + regionHeard[2][1])) * 100);
        
        regionPercent[3] = (int)((double)(regionHeard[3][1] 
                / (double)(regionHeard[3][0] + regionHeard[3][1])) * 100);
        
        return regionPercent;
    }
    
    /**
     * calculates percent for region like
     * 
     * @return the 4 cat and percentages
     */
    private int[] calcRegionLike() {
        int[][] regionLike = this.getRegionLiked();
        int[] regionPercent = new int[4]; // array of 4 cat
        
        regionPercent[0] = (int)((double)(regionLike[0][1] 
                / (double)(regionLike[0][0] + regionLike[0][1])) * 100);
        
        regionPercent[1] = (int)((double)(regionLike[1][1] 
                / (double)(regionLike[1][0] + regionLike[1][1])) * 100);
        
        regionPercent[2] = (int)((double)(regionLike[2][1] 
                / (double)(regionLike[2][0] + regionLike[2][1])) * 100);
        
        regionPercent[3] = (int)((double)(regionLike[3][1] 
                / (double)(regionLike[3][0] + regionLike[3][1])) * 100);
        
        return regionPercent;
    }
    
    /**
     * calculates percent for major heard
     * 
     * @return the 4 cat and percentages
     */
    private int[] calcMajorHeard() {
        int[][] majorHeard = this.getMajorHeard();
        int[] majorPercent = new int[4]; // array of 4 cat
        
        majorPercent[0] = (int)((double)(majorHeard[0][1] 
                / (double)(majorHeard[0][0] + majorHeard[0][1])) * 100);
        
        majorPercent[1] = (int)((double)(majorHeard[1][1] 
                / (double)(majorHeard[1][0] + majorHeard[1][1])) * 100);
        
        majorPercent[2] = (int)((double)(majorHeard[2][1] 
                / (double)(majorHeard[2][0] + majorHeard[2][1])) * 100);
        
        majorPercent[3] = (int)((double)(majorHeard[3][1] 
                / (double)(majorHeard[3][0] + majorHeard[3][1])) * 100);
        
        return majorPercent;
    }
    
    /**
     * calculates percent for major like
     * 
     * @return the 4 cat and percentages
     */
    private int[] calcMajorLike() {
        int[][] majorLike = this.getMajorLiked();
        int[] majorPercent = new int[4]; // array of 4 cat
        
        majorPercent[0] = (int)((double)majorLike[0][1] 
                / (double)(majorLike[0][0] + majorLike[0][1]) * 100);
        
        majorPercent[1] = (int)((double)(majorLike[1][1] 
                / (double)(majorLike[1][0] + majorLike[1][1])) * 100);
        
        majorPercent[2] = (int)((double)(majorLike[2][1] 
                / (double)(majorLike[2][0] + majorLike[2][1])) * 100);
        
        majorPercent[3] = (int)((double)(majorLike[3][1] 
                / (double)(majorLike[3][0] + majorLike[3][1])) * 100);
        
        return majorPercent;
    }
}
