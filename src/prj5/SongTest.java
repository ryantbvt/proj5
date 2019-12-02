/**
 * 
 */
package prj5;

import student.TestCase;

/**
 /**
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
 */
public class SongTest extends TestCase {
    private Song song;
    
    /**
     * set up
     */
    public void setUp() {
        song = new Song("title", "artist", "genre", "2000");
    }
    
    /**
     * test getTitle method
     */
    public void testGetTitle() {
        assertEquals("title", song.getTitle());
    }
    
    /**
     * test getArtist method
     */
    public void testGetArtist() {
        assertEquals("artist", song.getArtist());
    }
    
    /**
     * test getGenre method
     */
    public void testGetGenre() {
        assertEquals("genre", song.getGenre());
    }
    
    /**
     * test getYear method
     */
    public void testGetYear() {
        assertEquals("2000", song.getYear());
    }
    
    /**
     * test the toString method
     */
    public void testToString() {
        assertEquals("Title: title, Artist: artist,"
                + " Genre: genre, Year: 2000",
                song.toString());
    }
    
    /**
     * test the increment method
     */
    public void testIncrement() {
        Student student = 
                new Student("Art", "Northeast US", "Computer Science");
        song.increment(student, 1, 0);
        
        int[][] majorHeard = song.getMajorHeard();
        int[][] majorLike = song.getMajorLiked();
        
        assertEquals(1, majorHeard[0][1]);
        assertEquals(1, majorLike[0][0]);
        
        song.increment(student, 1, 0);
        
        assertEquals(2, majorHeard[0][1]);
    }
    
    /**
     * test calculate all method
     */
    public void testCalculateAll() {

        Student student = new Student("Read", "NorthEast", "Computer Science");
        Student student2 = new Student("Art", "Southeast", "Other Engineering");
        Student student3 = 
                new Student("Sport", "United States "
                        + "(other than Southeast or Northwest", "Math or CMDA");
        Student student4 = new Student("Music", ""
                + "Outside of United States", "Other");
        
        song.increment(student, 1, 0);
        song.increment(student, 0, 0);
        
        song.increment(student2, 1, 0);
        song.increment(student2, 0, 0);
        
        song.increment(student3, 1, 0);
        song.increment(student3, 0, 0);
        
        song.increment(student4, 1, 0);
        song.increment(student4, 0, 0);
        
        song.calculateAll();
        int[] hobbyHeardPerc = song.getHobbyHeardPercent();
        
        assertEquals(50, hobbyHeardPerc[0]);
    }
    
    /**
     * test get hobbyLiked()
     */
    public void testGetHobbyLiked() {
        int[][] test = song.getHobbyLiked();
        
        assertEquals(test, song.getHobbyLiked());
    }
    
    /**
     * test get hobbyHeard()
     */
    public void testGetHobbyHeard() {
        int[][] test = song.getHobbyHeard();
        
        assertEquals(test, song.getHobbyHeard());
    }
    
    /**
     * test getRegionLike()
     */
    public void testGetRegionLiked() {
        int[][] test = song.getRegionLiked();
        
        assertEquals(test, song.getRegionLiked());
    }
    
    /**
     * test get regionHeard()
     */
    public void testGetRegionHeard() {
        int[][] test = song.getRegionHeard();
        
        assertEquals(test, song.getRegionHeard());
    }
    
    /**
     * test getMajorLiked()
     */
    public void testGetMajorLiked() {
        int[][] test = song.getMajorLiked();
        
        assertEquals(test, song.getMajorLiked());
    }
    
    /**
     * test getMajorHeard()
     */
    public void testGetMajorHeard() {
        int[][] test = song.getMajorHeard();
        
        assertEquals(test, song.getMajorHeard());
    }
    
    /**
     * test getHobbyLikePercent
     */
    public void testGetHobbyLikePercent() {
        int[] test = song.getHobbyLikePercent();
        
        assertEquals(test, song.getHobbyLikePercent());
    }
    
    /**
     * test getHobbyHeardPercent
     */
    public void testGetHobbyHeardPercent() {
        int[] test = song.getHobbyHeardPercent();
        
        assertEquals(test, song.getHobbyHeardPercent());
    }
    
    /**
     * test getRegionLikePercent
     */
    public void testGetRegionLikePercent() {
        int[] test = song.getRegionLikePercent();
        
        assertEquals(test, song.getRegionLikePercent());
    }
    
    /**
     * test getRegionHeardPercent
     */
    public void testGetRegionHeardPercent() {
        int[] test = song.getRegionHeardPercent();
        
        assertEquals(test, song.getRegionHeardPercent());
    }
    
    /**
     * test getMajorLikePercent
     */
    public void testGetMajorLikePercent() {
        int[] test = song.getMajorLikePercent();
        
        assertEquals(test, song.getMajorLikePercent());
    }
    
    /**
     * test getMajorHeardPercent
     */
    public void testGetMajorHeardPercent() {
        int[] test = song.getMajorHeardPercent();
        
        assertEquals(test, song.getMajorHeardPercent());
    }
}
