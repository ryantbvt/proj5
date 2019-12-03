package prj5;
import student.TestCase;

/**
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.12.1
 */
public class StudentListTest extends TestCase {
    /**
     * setUp
     */
    public void setUp() {
        // setUp not needed
    }
    
    /**
     * test loop data method
     */
    public void testLoopData() {
        StudentList studentList = new StudentList();
        
        Student student1 = 
                new Student("reading", "Northeast", "Computer Science");
        Student student2 = 
                new Student("reading", "Northeast", "Computer Science");
        
        for (int i = 0; i < 70; i++) {
            student1.addResponse("Yes");
            student1.addResponse("No");
        
            student2.addResponse("No");
            student2.addResponse("Yes");
        }
        
        studentList.add(student1);
        studentList.add(student2);
        
        SongList songList = new SongList();
        
        Song song1 = new Song("title", "artist", "genre", "year");

        for (int i = 0; i < 70; i++) {
            songList.add(song1);
        }
        
        studentList.loopData(songList);
        
        assertEquals(70, songList.get(0).getRegionHeard()[0][1]);
        assertEquals(70, songList.get(0).getHobbyHeard()[0][1]);
    }
}
