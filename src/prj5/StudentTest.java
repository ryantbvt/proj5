/**
 * 
 */
package prj5;
import student.TestCase;

/**
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
 */
public class StudentTest extends TestCase {
    private Student student;
    
    /**
     * set up
     */
    public void setUp() {
        student = new Student("Art", "East Coast", "Comp Sci");
    }
    
    /**
     * test hobby method
     */
    public void testGetHobby() {
        assertEquals("Art", student.getHobby());
    }
    
    /**
     * test region method
     */
    public void testGetRegion() {
        assertEquals("East Coast", student.getRegion());
    }
    
    /**
     * test getMajor method
     */
    public void testGetMajor() {
        assertEquals("Comp Sci", student.getMajor());
    }
    
    /**
     * test toString method
     */
    public void testToString() {
        assertEquals("Major: Comp Sci, Region: East Coast, Hobby: Art",
                student.toString());
    }
}
