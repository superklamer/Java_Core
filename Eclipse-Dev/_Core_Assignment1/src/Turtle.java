import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, 
                 ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }  
  
  /////////////////// methods ///////////////////////

//  public static void main(String[] args)
//  {
//    World earth = new World();
//    Turtle t1 = new Turtle(earth);
//    t1.forward();
//  }
 
  
  /**
   * Method that puts the turtle in the center of the screen
   */
  public void center() {
	  ModelDisplay displayModel = this.getModelDisplay();
	  this.penUp();
	  
  	  this.moveTo(displayModel.getWidth() /2 , 
		  displayModel.getHeight() / 2);

	  this.penDown();
  }
  
  /**
   * Method to draw an arrow
   * @param length
   */
  public void drawArrow(int length) {
	  this.moveTo(100, 100);
	  this.turnRight();
	  this.forward(length);
	  this.turn(120);
	  this.forward(length);
	  this.turn(120);
	  this.forward(length);
  }

  /**
   * Method to draw equilateral triangle
   * @param length
   */
  public void drawTriangle(int length) {
	  drawPolygonHelper(length, 3);
  }
  
  /**
   * Method to draw a rectangle
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public void drawRectangle(int width, int height) {
	  // Rectangle has 4 sides so we need to iterate 4 times
	  // turn right with each iteration
	  // if in even iteration, draw height
	  // if in odd iteration, drawing width
	  
	  for (int i = 1; i <= 4; i++) {
		  this.turnRight(); 
		  if (i % 2 == 0) {
			  this.forward(height);
		  }
		  else {
			   this.forward(width); 
		  }
	  }
}
  
  /**
   * Method to draw hexagon
   * @param length the length of the heagon's sides
   */
  public void drawHexagon(int length) {
	 drawPolygonHelper(length, 5);
  }
 
  /**
   * Method to draw pentagon
   * @param length the length of the pentagon's sides
   */
  public void drawPentagon(int length) {
	  drawPolygonHelper(length, 6);
  }
  
  /**
   * Method that draws a star
   */
  public void drawStart() {
	  for (int i = 0; i < 20; i++) {
		  this.forward(i * 5);
		  this.turn(144);
	  }
  }
  
  /**
   * Method that draws funnyShapes
   */
  public void drawFunnyShapes() {
	  for (int i = 0; i < 50; i++) {
		  this.forward(150);
		  this.turn(-123);
	  }
	  
	  Color currentColor = this.getBodyColor();
	  this.setBodyColor(Color.ORANGE);
	  for (int i = 0; i < 50; i++) {
		  this.forward(50);
		  this.turn(150);
	  }
	  this.setBodyColor(currentColor);
  }
  
  private boolean outOfBoundCheck(int posX, int posY) {
	  ModelDisplay displayMode = this.getModelDisplay();
	  int maxHeight = displayMode.getHeight();
	  int maxWidth = displayMode.getWidth();
	  
	  if (this.getXPos() > maxWidth || this.getYPos() > maxHeight)
		  return false;
	  else
		  return true;
  }
  
  /**
   * Helper method that draws polygon shapes
   * @param length the polygon sides length
   * @param sides how many sides the polygon has
   */
  private void drawPolygonHelper(int length, int sides) {
  	  // Start drawing the polygon
	  
	  // Get the current turtle X position; this is the pivot point
	  int circleX = this.getXPos();
	  int circleY = this.getYPos();
	  
	  // the radius of the circle is the provided length
	  int radius = length;
	  
	  // Move the turtle to the 1st point with pen up
	  // This is required so the turtle doesn't start drawing from the middle of the circle
	  this.penUp();
	  this.moveTo((int)(circleX + radius * Math.cos(2.0 * Math.PI * 0)), 
	  		(int)(circleY + radius * Math.sin(2.0 * Math.PI * 0)));
	  this.penDown();
	  
	  // The real drawing starts here 
	  for (int i = 1; i <= sides; i++) {
		  int xx = (int)(circleX + radius * Math.cos(2.0 * Math.PI * i/sides));
		  int xy = (int)(circleY + radius * Math.sin(2.0 * Math.PI * i/sides));
		  
		  this.moveTo(xx, xy);
	  }
  }
  
  
} // this } is the end of class Turtle, put all new methods before this

// The easy way to draw Hexagon
//for (int i = 0 ; i < 6; i++) {
//	  this.forward(length);
//	  this.turn(60);
//}

// The easy way to draw Pentagon
//for (int i = 0; i < 5; i++) {
//this.forward(length);
//this.turn(72);
//}





















