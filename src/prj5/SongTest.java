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
        
        int majorHeard[][] = song.getMajorHeard();
        int majorLike[][] = song.getMajorLiked();
        
        assertEquals(1, majorHeard[0][1]);
        assertEquals(1, majorLike[0][0]);
    }
    
    /**
     * test calculate all method
     */
    public void testCalculateAll() {
        for (int i = 0; i < 6; i++) {
            Student student2 = 
                    new Student("Read", "Southeast US", "CMDA");
            Student student = 
                    new Student("Art", "Northeast US", "Computer Science");
            song.increment(student, 1, 1);
            song.increment(student2, 1, 0);
        }
        
        int regionHeardPerc[] = song.getHobbyHeardPercent();
        
        assertEquals(1, regionHeardPerc[0]);
    }
}
