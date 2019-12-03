package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * test cases for dataSolver
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 * 
 * @version 2019.12.02
 */
public class DataSolverTest extends TestCase {
    private DataSolver solver; 
    
    /**
     * setUp
     */
    public void setUp() {
        try {
            solver = new DataSolver("SongList2018HalfSongs.csv", 
                "MusicSurveyData2018HolesHalf.csv");
        }
        catch (FileNotFoundException e){
            System.out.println("wrong file");
        }
    }
    
    //*
    public void testReadSongFile() {
        String nullFile = null;
        Exception exception = null;
        try {
            solver.readSongFile(nullFile);
            fail("readSongFile() is not throwing an"
                + " exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("removeBack() is throwing the wrong type" + " of exceptions",
            exception instanceof FileNotFoundException);
        
        String correctToString = "{Title: Song Title, Artist: Artist, Genre: Genre, Year: "
            + "Year, Title: Hotline Bling, Artist: Drake, Genre: R&B, Year: "
            + "2015, Title: Creep, Artist: Radiohead, Genre: Alternative, "
            + "Year: 1992, Title: All of Me, Artist: John Legend, Genre: "
            + "R&B1, Year: 2013, Title: My Heart Will Go On, Artist: "
            + "Celine Dion, Genre: Pop, Year: 1997, Title: River Flows in You, "
            + "Artist: Yiruma, Genre: Instrumental, Year: 2011, Title: "
            + "Beauty and the Beast, Artist: Disney, Genre: Soundtrack, "
            + "Year: 1991, Title: A Whole New World, Artist: Disney, Genre: "
            + "Soundtrack1, Year: 1992, Title: Let it Go, Artist: Disney, Genre: "
            + "Soundtrack2, Year: 2013, Title: Hello, Artist: Adele, Genre: Soul, "
            + "Year: 2014, Title: Someone Like You, Artist: Adele, Genre: Soul1, "
            + "Year: 2011, Title: Wish You Were Here, Artist: Pink Floyd, Genre: "
            + "Rock, Year: 1975, Title: Yesterday, Artist: The Beatles, Genre: Pop1, "
            + "Year: 1965, Title: Eleanor R, Artist: The Beatles, Genre: Pop2, "
            + "Year: 1966, Title: Hey Jude, Artist: The Beatles, Genre: Rock1, Year: "
            + "1968, Title: Don't Look Back in Anger, Artist: Oasis, Genre: Pop3, Year: "
            + "1996, Title: Wonderwall, Artist: Oasis, Genre: Pop4, Year: 1995, Title: Clocks,"
            + " Artist: Coldplay, Genre: Rock2, Year: 2003, Title: Viva La Vida, Artist: "
            + "Coldplay, Genre: Pop5, Year: 2008, Title: Snow, Artist: Red Hot Chili Peppers,"
            + " Genre: Rock3, Year: 2006, Title: Smooth, Artist: Santana, Genre: Rock4, Year: "
            + "1999, Title: Careless Whisper, Artist: Wham!, Genre: Jazz, Year: 1984, Title: "
            + "Freebird, Artist: Lynyrd Skynyrd, Genre: Rock5, Year: 1974, Title: Tuesday's Gone, "
            + "Artist: Lynyrd Skynyrd, Genre: Rock6, Year: 1973, Title: Hotel California, Artist: "
            + "The Eagles, Genre: Rock7, Year: 1977, Title: Master of Puppets, Artist: Metallica, "
            + "Genre: Metal, Year: 1986, Title: Fade to Black, Artist: Metallica, Genre: Metal1, Year: "
            + "1984, Title: La La Land, Artist: City of Stars, Genre: Soundtrack3, Year: 2016, Title:"
            + " November Rain, Artist: Guns n Roses, Genre: Rock8, Year: 1992, Title: Stairway to Heaven,"
            + " Artist: Led Zeppelin, Genre: Rock9, Year: 1971, Title: Bohemian Rhapsody, Artist: Queen,"
            + " Genre: Rock10, Year: 1975, Title: Don't Stop Me Now, Artist: "
            + "Queen, Genre: Rock11, Year: 1979, Title: Tiny Dancer, Artist: Elton John, Genre:"
            + " Pop6, Year: 1972, Title: Piano Man, Artist: Billie Joel, Genre: Rock12, Year: 1973, "
            + "Title: People are Strange, Artist: The Doors, Genre: Rock13, Year: 1967}"; 
        
        try {
            SongList list = solver.readSongFile("SongList2018HalfSongs.csv");
            assertEquals(correctToString, list.toString());
        }
        catch (FileNotFoundException e) {
            
            System.out.println("File not found");
        }

    }
    
    
}
