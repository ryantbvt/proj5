package prj5;

/**
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
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
            Student currentStudent = this.get(i); // grabs the student
            int[] data = currentStudent.getResponses(); // grabs students responses

            for (int j = 0; j < data.length; j += 2) { // loops through the data
                // grabs heard and like
                int heard = data[j];
                int like = data[j + 1];
                
                // increments the list 
                list.get(j / 2).increment(currentStudent, heard, like);

            } // loops through responses
        } // loops through students
    } // end loop data method

}
