package prj5;

import CS2114.TextShape;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;

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
    private TextShape[] artist;
    private Shape[] heard;
    private Shape[] likes;
    private Shape[] poles;

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

    // add linked list
    
    // legend textShape fields
    private TextShape legendTitle;
    private TextShape category1;
    private TextShape category2;
    private TextShape category3;
    private TextShape category4;

// Constructor................................................

    /**
     * Constructor for the GUI creates the GUIWindow
     * 
     * TODO add param to link the list to window
     * 
     * @param list singly linked list
     */
    public GUIWindow() {
        window = new Window();
        window.setTitle("Project 5");

        createButtons();

        addTempGlyphs();
        addPoles();

        createLegendText();
        addLegend();

    }

// Methods....................................................
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

    // add poles

    /**
     * tests hard coding default glyphs for first pole
     */
    public void addTempGlyphs() {

        int xPole = 125;
        int yPole = 50;

        int glyphX = 130;
        int glyphY = 50;

        int glyphWidth = 100;
        int glyphHeight = 10; // public static final int

        // Temp hard code RIGHT glyph
        Shape glyph = new Shape(glyphX, glyphY, glyphWidth, glyphHeight,
                Color.MAGENTA);
        window.addShape(glyph);
        Shape glyph2 = new Shape(glyphX, glyphY + glyphHeight * 1, glyphWidth,
                glyphHeight, Color.BLUE);
        window.addShape(glyph2);
        Shape glyph3 = new Shape(glyphX, glyphY + glyphHeight * 2, glyphWidth,
                glyphHeight, Color.ORANGE);
        window.addShape(glyph3);
        Shape glyph4 = new Shape(glyphX, glyphY + glyphHeight * 3, glyphWidth,
                glyphHeight, Color.GREEN);
        window.addShape(glyph4);

        // Temp hard code LEFT glyph
        Shape glyph5 = new Shape(xPole - glyphWidth, glyphY, glyphWidth,
                glyphHeight, Color.MAGENTA);
        window.addShape(glyph5);
        Shape glyph6 = new Shape(xPole - glyphWidth, glyphY + glyphHeight * 1,
                glyphWidth, glyphHeight, Color.BLUE);
        window.addShape(glyph6);
        Shape glyph7 = new Shape(xPole - glyphWidth, glyphY + glyphHeight * 2,
                glyphWidth, glyphHeight, Color.ORANGE);
        window.addShape(glyph7);
        Shape glyph8 = new Shape(xPole - glyphWidth, glyphY + glyphHeight * 3,
                glyphWidth, glyphHeight, Color.GREEN);
        window.addShape(glyph8);

    }

    public void addLegend() {
        //updateLegendText("hobby");
        addLegendBox();
    }
    
    /**
     * Creates the box for the legend
     */
    public void addLegendBox() {
        int x = 850;
        int y = 250;
        int boxWidth = 150;
        int boxHeight = 250;

        // Pole
        TextShape heard = new TextShape(x + 20, y + 175, "Heard");
        TextShape like = new TextShape(x + 90, y + 175, "Likes");
        Shape pole = new Shape(x + boxWidth / 2, y + 175, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(heard);
        window.addShape(like);
        window.addShape(pole);

        // Box
        Shape box = new Shape(x, y, boxWidth, boxHeight, Color.BLACK);
        window.addShape(box);

        heard.setBackgroundColor(Color.WHITE);
        like.setBackgroundColor(Color.WHITE);
        box.setBackgroundColor(Color.WHITE);
    }

    /**
     * updates the legend based on category
     * 
     * @param String "category" will either be: "hobby", "major", or "region"
     */
    public void createLegendText() {
        int x = 850;
        int y = 250;

        // Legend Title -- based on category
        legendTitle = new TextShape(x + 9, y + 5, "Category Legend");

        // 4 categories
        category1 = new TextShape(x + 10, y + 25, "Read");
        category2 = new TextShape(x + 10, y + 45, "Art");
        category3 = new TextShape(x + 10, y + 65, "Sports");
        category4 = new TextShape(x + 10, y + 85, "Music");

        // Song Title
        TextShape songTitle = new TextShape(x + 25, y + 150, "Song Title"); // TODO
        
        // set background colors
        legendTitle.setBackgroundColor(Color.WHITE);
        category1.setBackgroundColor(Color.WHITE);
        category2.setBackgroundColor(Color.WHITE);
        category3.setBackgroundColor(Color.WHITE);
        category4.setBackgroundColor(Color.WHITE);
        
        songTitle.setBackgroundColor(Color.WHITE); // TODO

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
        window.addShape(songTitle);
        }
    
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

    /**
     * add 9 poles to the window
     */
    public void addPoles() {

        int xPole = 125;
        int yPole = 50;

        // row 1
        Shape poleR1C1 = new Shape(xPole, yPole, POLE_WIDTH, POLE_HEIGHT,
                Color.BLACK);
        window.addShape(poleR1C1);

        Shape poleR1C2 = new Shape(xPole + 300 * 1, yPole, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR1C2);

        Shape poleR1C3 = new Shape(xPole + 300 * 2, yPole, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR1C3);

        // row 2
        Shape poleR2C1 = new Shape(xPole, yPole + 200 * 1, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR2C1);

        Shape poleR2C2 = new Shape(xPole + 300 * 1, yPole + 200 * 1, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR2C2);

        Shape poleR2C3 = new Shape(xPole + 300 * 2, yPole + 200 * 1, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR2C3);

        // row 3
        Shape poleR3C1 = new Shape(xPole, yPole + 200 * 2, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR3C1);

        Shape poleR3C2 = new Shape(xPole + 300 * 1, yPole + 200 * 2, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR3C2);

        Shape poleR3C3 = new Shape(xPole + 300 * 2, yPole + 200 * 2, POLE_WIDTH,
                POLE_HEIGHT, Color.BLACK);
        window.addShape(poleR3C3);

        // use getX() and getY() to get position of poles for glyph calculations

    }
    
    public void clickedRepHobby(Button button) {
        updateLegendText("hobby");
    }
    
    public void clickedRepMajor(Button button) {
        updateLegendText("major");
    }
    
    public void clickedRepRegion(Button button) {
        updateLegendText("region");
    }
    
    
    

    /**
     * Quit button, when clicked, closes the window
     * 
     * @param quit the clickable button
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }

}
