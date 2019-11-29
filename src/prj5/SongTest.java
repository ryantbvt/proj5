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
}
