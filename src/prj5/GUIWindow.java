package prj5;

import CS2114.TextShape;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The interative GUI window for the program that displays the glyphs according
 * to the sorting and calculations in the back-end.
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 * 
 * @version 2019.11.17
 *
 */
public class GUIWindow {

    // Fields......................................................
    private Window window;
    private TextShape[] titles;
    private TextShape[] artists;
    private Shape[] heard;
    private Shape[] likes;

    private int topCornerIndex;
    private DataSolver solver;

    // default pole sizes
    public static final int POLE_HEIGHT = 40;
    public static final int POLE_WIDTH = 5;

    // Buttons fields
    private Button quitButton;
    private Button sortArt;
    private Button sortTitle;
    private Button sortYear;
    private Button sortGenre;
    private Button prevButton;
    private Button nextButton;
    private Button repHobby;
    private Button repMajor;
    private Button repRegion;

    // legend TextShape fields
    private TextShape legendTitle;
    private TextShape category1;
    private TextShape category2;
    private TextShape category3;
    private TextShape category4;

    private String sortType;

    // Constructor................................................
    /**
     * Creates a new GUIWindow Object
     */
    public GUIWindow(String songFile, String surveyFile)
            throws FileNotFoundException {
        window = new Window();
        window.setTitle("Project 5");
        
        solver = new DataSolver(songFile, surveyFile);
        
        titles = new TextShape[9];
        artists = new TextShape[9];
        
        likes = new Shape[36];
        heard = new Shape[36];
        
        topCornerIndex = 0;
        
        createButtons();
        addPoles();
        addTempGlyphs();
        createLegendText();
        createLegendBox();
        addTitlesandArtists();
        
        
    }

    // Poles......................................................
    /**
     * add 9 poles to the window
     */
    public void addPoles() {
        int xPole = 125;
        int yPole = 50;
        int incX = 300;
        int incY = 200;

        // row 1
        Shape poleR1C1 = new Shape(xPole, yPole, POLE_WIDTH, POLE_HEIGHT,
                Color.BLACK);
        window.addShape(poleR1C1);

        Shape poleR1C2 = new Shape(xPole + incX * 1, yPole, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR1C2);

        Shape poleR1C3 = new Shape(xPole + incX * 2, yPole, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR1C3);
        // row 2
        Shape poleR2C1 = new Shape(xPole, yPole + incY * 1, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR2C1);

        Shape poleR2C2 = new Shape(xPole + incX * 1, yPole + incY * 1,
                POLE_WIDTH, POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR2C2);

        Shape poleR2C3 = new Shape(xPole + incX * 2, yPole + incY * 1,
                POLE_WIDTH, POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR2C3);
        // row 3
        Shape poleR3C1 = new Shape(xPole, yPole + incY * 2, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR3C1);

        Shape poleR3C2 = new Shape(xPole + incX * 1, yPole + incY * 2,
                POLE_WIDTH, POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR3C2);

        Shape poleR3C3 = new Shape(xPole + incX * 2, yPole + incY * 2,
                POLE_WIDTH, POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR3C3);
    }

    // Legend.....................................................
    /**
     * Creates the box for the legend
     */
    public void createLegendBox() {
        int x = 850;
        int y = 250;
        int boxWidth = 150;
        int boxHeight = 250;

        // Pole area
        TextShape heard = new TextShape(x + 20, y + 175, "Heard");
        TextShape like = new TextShape(x + 90, y + 175, "Likes");
        TextShape songTitle = new TextShape(x + 25, y + 150, "Song Title");
        Shape pole = new Shape(x + boxWidth / 2, y + 175, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(heard);
        window.addShape(like);
        window.addShape(pole);
        window.addShape(songTitle);

        // Box
        Shape box = new Shape(x, y, boxWidth, boxHeight, Color.BLACK);
        window.addShape(box);

        heard.setBackgroundColor(Color.WHITE);
        like.setBackgroundColor(Color.WHITE);
        box.setBackgroundColor(Color.WHITE);
        songTitle.setBackgroundColor(Color.WHITE);
    }

    /**
     * Creates the default text for the legend
     */
    public void createLegendText() {
        int x = 850;
        int y = 250;

        // Legend Title -- based on category
        legendTitle = new TextShape(x + 9, y + 5, "Hobby Legend");

        // 4 categories
        category1 = new TextShape(x + 10, y + 25, "Read");
        category2 = new TextShape(x + 10, y + 45, "Art");
        category3 = new TextShape(x + 10, y + 65, "Sports");
        category4 = new TextShape(x + 10, y + 85, "Music");

        // set background colors
        legendTitle.setBackgroundColor(Color.WHITE);
        category1.setBackgroundColor(Color.WHITE);
        category2.setBackgroundColor(Color.WHITE);
        category3.setBackgroundColor(Color.WHITE);
        category4.setBackgroundColor(Color.WHITE);

        // set foreground colors
        category1.setForegroundColor(Color.BLUE);
        category2.setForegroundColor(Color.MAGENTA);
        category3.setForegroundColor(Color.ORANGE);
        category4.setForegroundColor(Color.GREEN);

        // add shapes to window
        window.addShape(legendTitle);
        window.addShape(category1);
        window.addShape(category2);
        window.addShape(category3);
        window.addShape(category4);
    }

    /**
     * Updates the text in the legend based on survey category
     * 
     * @param String "category" will either be: "hobby", "major", or "region"
     */
    public void updateLegendText(String category) {
        if (category == "hobby") {
            legendTitle.setText("Hobby Legend");
            category1.setText("Read");
            category2.setText("Art");
            category3.setText("Sports");
            category4.setText("Music");
        }
        if (category == "major") {
            legendTitle.setText("Major Legend");
            category1.setText("Comp sci");
            category2.setText("Other Eng");
            category3.setText("Math/CMDA");
            category4.setText("Other");

        }
        if (category == "region") {
            legendTitle.setText("Region Legend");
            category1.setText("Northeast US");
            category2.setText("Southeast US");
            category3.setText("The rest of US");
            category4.setText("Outside the US");
        }
    }

    // Glyphs.....................................................
    /**
     * TODO adding glyphs
     */
    public void addTempGlyphs() {

        int xPole = 125;
        int yPole = 50;

        int glyphX = 130;
        int glyphY = 50;

        int glyphWidth = 100;
        int glyphHeight = 10; // public static final int
        SongList list = solver.getSongList();
        int currSong = 0;
        // Temp hard code RIGHT glyph
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Song song = list.get(topCornerIndex + currSong);
                int[] heardInfo = song.getHobbyHeardPercent();

                Shape glyph = new Shape(glyphX + row * 300, glyphY + col * 200,
                        heardInfo[0], glyphHeight, Color.MAGENTA);
                window.addShape(glyph);
                Shape glyph2 = new Shape(glyphX + row * 300,
                        glyphY + glyphHeight * 1 + col * 200, heardInfo[1],
                        glyphHeight, Color.BLUE);
                window.addShape(glyph2);
                Shape glyph3 = new Shape(glyphX + row * 300,
                        glyphY + glyphHeight * 2 + col * 200, heardInfo[2],
                        glyphHeight, Color.ORANGE);
                window.addShape(glyph3);
                Shape glyph4 = new Shape(glyphX + row * 300,
                        glyphY + glyphHeight * 3 + col * 200, heardInfo[3],
                        glyphHeight, Color.GREEN);
                window.addShape(glyph4);

                // Temp hard code LEFT glyph
                Shape glyph5 = new Shape(xPole - glyphWidth + row * 300,
                        glyphY + col * 200, glyphWidth, glyphHeight,
                        Color.MAGENTA);
                window.addShape(glyph5);
                Shape glyph6 = new Shape(xPole - glyphWidth + row * 300,
                        glyphY + glyphHeight * 1 + col * 200, glyphWidth,
                        glyphHeight, Color.BLUE);
                window.addShape(glyph6);
                Shape glyph7 = new Shape(xPole - glyphWidth + row * 300,
                        glyphY + glyphHeight * 2 + col * 200, glyphWidth,
                        glyphHeight, Color.ORANGE);
                window.addShape(glyph7);
                Shape glyph8 = new Shape(xPole - glyphWidth + row * 300,
                        glyphY + glyphHeight * 3 + col * 200, glyphWidth,
                        glyphHeight, Color.GREEN);
                window.addShape(glyph8);

            }
        }

    }

    // Song Titles & Artist Names................................
    /**
     * Adds the song titles and artist names above every glyph
     */
    public void addTitlesandArtists() {
        int titleX = 75; // starting x for titles
        int titleY = 10; // starting y for titles

        int artistX = 75; // starting x for artists
        int artistY = 30; // starting y for artists

        int incX = 300;
        int incY = 200;

        int i = 0;
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {

                TextShape title = new TextShape(titleX + row * incX,
                        titleY + col * incY, "song title");
                titles[i] = title;
                window.addShape(title);

                TextShape artist = new TextShape(artistX + row * incX,
                        artistY + col * incY, "artist name");
                artists[i] = artist; // bottom info, need to change name
                window.addShape(artist);
                i++;

                title.setBackgroundColor(Color.WHITE);
                artist.setBackgroundColor(Color.WHITE);

            }
        }

    }

    // Updating Song Title & Artists names by sorting method...........

    /**
     * Updates the bottom row of info below the song title
     */
    public void updateBottom() {
        if (sortType == "artist" || sortType == "song") {
            updateArtists();
        }

        if (sortType == "year") {
            updateYear();
        }

        if (sortType == "genre")
            updateGenre();
    }
    
    /**
     * updates the song titles
     */
    public void updateTitles() {
        SongList list = solver.getSongList();
        for (int i = 0; i < titles.length; i++) {
            titles[i].setText(list.get(topCornerIndex + i).getTitle());
        }
    }

    /**
     * updates the artist name
     */
    public void updateArtists() {
        SongList list = solver.getSongList();
        for (int i = 0; i < artists.length; i++) {
            artists[i].setText(list.get(topCornerIndex + i).getArtist());
        }
    }

    /**
     * Updates the year the song was created
     */
    public void updateYear() {
        SongList list = solver.getSongList();
        for (int i = 0; i < artists.length; i++) {
            artists[i].setText(list.get(topCornerIndex + i).getYear());
        }
    }

    /**
     * updates the genre of the song
     */
    public void updateGenre() {
        SongList list = solver.getSongList();
        for (int i = 0; i < artists.length; i++) {
            artists[i].setText(list.get(topCornerIndex + i).getGenre());
        }
    }


    // Buttons....................................................
    /**
     * Creates and displays all the buttons
     */
    private void createButtons() {
        // quit button
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit"); // calls the clickedQuit()
                                                 // method

        // sort by artist button
        sortArt = new Button("Sort by Artist Name");
        sortArt.onClick(this, "clickedSortArt");

        // sort by the title
        sortTitle = new Button("Sort by Song Title");
        sortTitle.onClick(this, "clickedSortTitle");

        // sort by the year
        sortYear = new Button("Sort by Release Year");
        sortYear.onClick(this, "clickedSortYear");

        // sort by the genre
        sortGenre = new Button("Sort by Genre");
        sortGenre.onClick(this, "clickedSortGenre");

        // represent by hobby
        repHobby = new Button("Represent Hobby");
        repHobby.onClick(this, "clickedRepHobby");

        // represent by major
        repMajor = new Button("Represent Major");
        repMajor.onClick(this, "clickedRepMajor");

        // represent by region
        repRegion = new Button("Represent Region");
        repRegion.onClick(this, "clickedRepRegion");

        // next button
        nextButton = new Button("Next");
        nextButton.onClick(this, "clickedNext");

        // previous button
        prevButton = new Button("Prev");
        prevButton.onClick(this, "clickedPrev");

        // add north side buttons
        window.addButton(prevButton, WindowSide.NORTH);
        window.addButton(sortArt, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
        window.addButton(sortYear, WindowSide.NORTH);
        window.addButton(sortGenre, WindowSide.NORTH);
        window.addButton(nextButton, WindowSide.NORTH);

        // add south side buttons
        window.addButton(repHobby, WindowSide.SOUTH);
        window.addButton(repMajor, WindowSide.SOUTH);
        window.addButton(repRegion, WindowSide.SOUTH);
        window.addButton(quitButton, WindowSide.SOUTH);
    }

    // Clicked Button Functions...................................
    /**
     * Quit button, when clicked, closes the window
     * 
     * @param quit the clickable button
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }

    public void clickedRepHobby(Button hobbyButton) {
        updateLegendText("hobby");

    }

    public void clickedRepMajor(Button majorButton) {
        updateLegendText("major");
    }

    public void clickedRepRegion(Button regionButton) {
        updateLegendText("region");
    }

    public void clickedPrev(Button prevButton) {
        if (topCornerIndex >= 9) {
            topCornerIndex -= 9;
            // refresh();
            updateTitles();
            updateArtists();
        } else if (topCornerIndex > 0 && topCornerIndex < 9) {
            topCornerIndex = 0;
            // refresh();
            updateTitles();
            updateArtists();
        }
        if (topCornerIndex == 0) {
            prevButton.disable();
        }

        int size = solver.getSongList().size();
        int numSongsLeft = size - (topCornerIndex + 9);
        if (numSongsLeft > 0) {
            nextButton.enable();
        }
    }

    public void clickedNext(Button nextButton) {
        int size = solver.getSongList().size();
        int numSongsLeft = size - (topCornerIndex + 9);
        if (numSongsLeft >= 9) {
            topCornerIndex += 9;
            // refresh();
            updateTitles();
            updateArtists();

            // TODO need if-statement to check if sorting by artist, song, year
            // or genre

        } else if (numSongsLeft > 0 && numSongsLeft < 9) {
            topCornerIndex += numSongsLeft;
            // refresh();
            updateTitles();
            updateArtists();
        }

        if (numSongsLeft == 0) {
            nextButton.disable();
        }

        if (topCornerIndex > 0) {
            prevButton.enable();
        }

    }

    /**
     * Sorts the songs by artist name and displays on window
     * @param artButton
     */
    public void clickedSortArt(Button artButton) {
        solver.getSongList().sort("artist");
        // refresh();
        // removeSurveyInfo();
        updateTitles();
        updateArtists();
        sortType = "artist";
    }

    /**
     * Sorts the songs by song title and displays on window
     * @param titleButton
     */
    public void clickedSortTitle(Button titleButton) {
        solver.getSongList().sort("title");
        // refresh();
        // removeSurveyInfo();
        updateTitles();
        updateArtists();
        sortType = "title";
    }

    /**
     * Sorts the songs by genre and displays on window
     * @param genreButton
     */
    public void clickedSortGenre(Button genreButton) {
        solver.getSongList().sort("genre");
        // refresh();
        // removeSurveyInfo();
        updateTitles();
        updateGenre();
        sortType = "genre";
    }
    /**
     * Sorts the songs by year and displays on window
     * @param yearButton
     */
    public void clickedSortYear(Button yearButton) {
        solver.getSongList().sort("year");
        // refresh();
        // removeSurveyInfo();
        updateTitles();
        updateYear();
        sortType = "year";
    }

    // Other (helper) methods.....................................
    /**
     * TODO
     */
    public void refresh() {
        removeSurveyInfo();
        updateTitles();
        updateArtists();
        addTempGlyphs();
        // updateBottom();
    }

    /**
     * TODO removes the glyphs from the window
     */
    public void removeSurveyInfo() {
        for (int i = 0; i < 36; i++) {
            likes[i].remove();
            heard[i].remove();
        }
    }

}
