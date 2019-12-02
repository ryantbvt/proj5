/**
 * 
 */
package prj5;

/**
 * List of songs
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 *
 * @version 2019.11.27
 */
public class SongList extends SinglyLinkedList<Song> {

    /**
     * constructor
     */
    public SongList() {
        // may not need?
    }

    /**
     * sort method
     * @param type the sorting type 
     *        based on the button clicked
     */
    public void sort(String type) {
        if (type.equals("title")) {
            for (int i = 0; i < this.size(); i++) {
                Song minTitleSong = this.get(i);
                int minIndex = i;
                for (int j = i; j < this.size(); j++) {
                    Song song = this.get(j);
                    String songName = song.getTitle();
                    String minSongName = minTitleSong.getTitle();
                    if (songName.compareTo(minSongName) < 0) {
                        minSongName = songName;
                        minTitleSong = song;
                        minIndex = j;
                    } // end if compare to word
                } // looks for the next song that should be in front
                //swaps the songs
                this.remove(minIndex);
                this.add(i, minTitleSong);
            } // end for loop for every song
        } // end if statement for button clicked
        
        else if (type.equals("genre")) {
            for (int i = 0; i < this.size(); i++) {
                Song minTitleSong = this.get(i);
                int minIndex = i;
                for (int j = i; j < this.size(); j++) {
                    Song song = this.get(j);
                    String songName = song.getGenre();
                    String minSongName = minTitleSong.getGenre();
                    if (songName.compareTo(minSongName) <= 0) {
                        minSongName = songName;
                        minTitleSong = song;
                        minIndex = j;
                    } // end if compare to word
                } // looks for the next song that should be in front
                //swaps the songs
                this.remove(minIndex);
                this.add(i, minTitleSong);
            } // end for loop for every song
        } //end sort by genre
        
        else if (type.equals("artist")) {
            for (int i = 0; i < this.size(); i++) {
                Song minTitleSong = this.get(i);
                int minIndex = i;
                for (int j = i; j < this.size(); j++) {
                    Song song = this.get(j);
                    String songName = song.getArtist();
                    String minSongName = minTitleSong.getArtist();
                    if (songName.compareTo(minSongName) <= 0) {
                        minSongName = songName;
                        minTitleSong = song;
                        minIndex = j;
                    } // end if compare to word
                } // looks for the next song that should be in front
                //swaps the songs
                this.remove(minIndex);
                this.add(i, minTitleSong);
            } // end for loop for every song
        } //end sort by artist
        
        else if (type.equals("year")) {
            for (int i = 0; i < this.size(); i++) {
                Song minTitleSong = this.get(i);
                int minIndex = i;
                for (int j = i; j < this.size(); j++) {
                    Song song = this.get(j);
                    String songName = song.getYear();
                    String minSongName = minTitleSong.getYear();
                    if (songName.compareTo(minSongName) <= 0) {
                        minSongName = songName;
                        minTitleSong = song;
                        minIndex = j;
                    } // end if compare to word
                } // looks for the next song that should be in front
                //swaps the songs
                this.remove(minIndex);
                this.add(i, minTitleSong);
            } // end for loop for every song
        } //end sort by year
    } //end sort method
    //test push
}
