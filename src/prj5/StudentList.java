package prj5;

/**
 * 
 * @author Ryan Bui
 *
 */
public class StudentList extends SinglyLinkedList<Student> {
    // fields
    // private int size;

    /**
     * constructor
     */
    public StudentList() {
        // size = 0;
        // may not need?
    }

    /**
     * loop data
     * 
     * @param list the song list
     */
    public void loopData(SongList list) {
        // the size of the student list
        for (int i = 0; i < this.size(); i++) {
            int[] data = this.get(i).getResponses(); // grabs students responses
            Student currentStudent = this.get(i); // grabs the student
            
            for (int j = 0; j < data.length; j += 2) {
                // grabs heard and like
                int heard = data[j];
                int like = data[j + 1];
                
                // increments the list
                list.get(j / 2).increment(currentStudent, heard, like);
            } // loops through responses
        } // loops through students
    } // end loop data method

}
