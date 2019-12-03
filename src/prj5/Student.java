/**
 * 
 */
package prj5;

/**
 * Individual students
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
 */
public class Student {
    /**
     * fields
     */
    private String hobby;
    private String region;
    private String major;
    // private int studentID; // maybe wont need
    private int[] responses;
    private int responseIndex;

    /**
     * constructor for student class
     * 
     * @param hobby
     *            the hobby the student has
     * @param region
     *            the region the student is from
     * @param major
     *            the major the student is in
     */
    public Student(String hobby, String region, String major) {
        this.hobby = hobby;
        this.region = region;
        this.major = major;
        responseIndex = 0;
        responses = new int[140];
    }


    /**
     * gets the responses
     * 
     * @return the responses
     */
    public int[] getResponses() {
        return responses;
    }


    /**
     * gets the hobby
     * 
     * @return hobby name
     */
    public String getHobby() {
        return hobby;
    }


    /**
     * gets the region the student is from
     * 
     * @return the region name
     */
    public String getRegion() {
        return region;
    }


    /**
     * gets the major
     * 
     * @return the major of student
     */
    public String getMajor() {
        return major;
    }


    /**
     * changes student to a string
     * 
     * @return the string of the student
     */
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Major: " + getMajor());
        build.append(", Region: " + getRegion());
        build.append(", Hobby: " + getHobby());

        return build.toString();
    }


    /**
     * changes yes and no's to 1 and 0
     * for easier comparisons
     * 
     * @param str
     *            the string from the array
     */
    public void addResponse(String str) {
        if (str.equals("Yes")) {
            responses[responseIndex] = 1;
        }

        else if (str.equals("No")) {
            responses[responseIndex] = 0;
        }

        else {
            responses[responseIndex] = -1;
        }

        responseIndex++;
    }
}
