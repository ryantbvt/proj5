package prj5;

import student.TestCase;

/**
 * test case for song list
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
 */
public class SongListTest extends TestCase {
    /**
     * setUp
     */
    public void setUp() {
        // setup not needed
    }

    /**
     * test sort method
     */
    public void testSort1() {
        SongList list = new SongList();
        Song song1 = new Song("A", "A", "A", "1990");
        Song song2 = new Song("B", "B", "B", "2000");
        Song song3 = new Song("C", "C", "C", "2010");

        list.add(song1);
        list.add(song2);
        list.add(song3);

        //assertEquals(1, listTitle.toString());
        list.sort("title");
        assertEquals("{Title: A, Artist: A, Genre: A, Year: 1990, "
                + "Title: B, Artist: B, Genre: B, Year: 2000, "
                + "Title: C, Artist: C, Genre: C, Year: 2010}", list.toString());
    }
    
    /**
     * test sort method artist
     */
    public void testSort2() {
        SongList list = new SongList();
        Song song1 = new Song("A", "A", "A", "1990");
        Song song2 = new Song("B", "B", "B", "2000");
        Song song3 = new Song("C", "C", "C", "2010");

        list.add(song1);
        list.add(song2);
        list.add(song3);

        //assertEquals(1, listTitle.toString());
        list.sort("artist");
        assertEquals("{Title: A, Artist: A, Genre: A, Year: 1990, "
                + "Title: B, Artist: B, Genre: B, Year: 2000, "
                + "Title: C, Artist: C, Genre: C, Year: 2010}", list.toString());
    }
    
    /**
     * test sort method genre
     */
    public void testSort3() {
        SongList list = new SongList();
        Song song1 = new Song("A", "A", "A", "1990");
        Song song2 = new Song("B", "B", "B", "2000");
        Song song3 = new Song("C", "C", "C", "2010");

        list.add(song1);
        list.add(song2);
        list.add(song3);

        //assertEquals(1, listTitle.toString());
        list.sort("genre");
        assertEquals("{Title: A, Artist: A, Genre: A, Year: 1990, "
                + "Title: B, Artist: B, Genre: B, Year: 2000, "
                + "Title: C, Artist: C, Genre: C, Year: 2010}", list.toString());
    }
    
    /**
     * test sort method year
     */
    public void testSort4() {
        SongList list = new SongList();
        Song song1 = new Song("A", "A", "A", "1990");
        Song song2 = new Song("B", "B", "B", "2000");
        Song song3 = new Song("C", "C", "C", "2010");

        list.add(song1);
        list.add(song2);
        list.add(song3);

        //assertEquals(1, listTitle.toString());
        list.sort("year");
        assertEquals("{Title: A, Artist: A, Genre: A, Year: 1990, "
                + "Title: B, Artist: B, Genre: B, Year: 2000, "
                + "Title: C, Artist: C, Genre: C, Year: 2010}", list.toString());
    }
    
    /**
     * test sort method year
     */
    public void testSort5() {
        SongList list = new SongList();
        Song song1 = new Song("Roxanne", "A", "A", "1990");
        Song song2 = new Song("Day One", "B", "B", "2000");
        Song song3 = new Song("Animals", "C", "C", "2010");

        list.add(song1);
        list.add(song2);
        list.add(song3);

        //assertEquals(1, listTitle.toString());
        list.sort("title");
        assertEquals("{Title: Animals, Artist: C, Genre: C, Year: 2010, "
                + "Title: Day One, Artist: B, Genre: B, Year: 2000, "
                + "Title: Roxanne, Artist: A, Genre: A, Year: 1990}", list.toString());
    }
}
