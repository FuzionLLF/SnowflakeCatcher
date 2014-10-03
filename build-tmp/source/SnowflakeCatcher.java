import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] group;
  public void setup()
  {
    size(400,400);
    background(31,190,214);
    noStroke();//light blue(sky)
    group = new SnowFlake[100];
    for(int i = 0; i < group.length;i++)
    {
      group[i] = new SnowFlake();
    }
  }
  public void draw()
  {
    for(int i = 0; i <group.length;i++)
    {
      group[i].erase();
      group[i].lookDown();
      group[i].move();
      group[i].wrap();
      group[i].show();
    }
    //your code here
  }
  public void mouseDragged()
  {
   if(mouseButton == LEFT)
    {
      fill(255, 102, 0);
      ellipse(mouseX,mouseY,10,10);
    }
   else if(mouseButton == RIGHT)
   {
    fill(31,190,214);
    ellipse(mouseX,mouseY,10,10);
   }
    //your code here
  }
  class SnowFlake
  {
    int myX, myY;
    boolean isMoving = true;//class member variable declarations
    SnowFlake() //constructor
    {
      myX = (int)(Math.random()*400);
      myY = (int)(Math.random()*400);
      isMoving = true;
      //class member variable initializations
    }
    public void show()
    {
      noStroke();
      fill(255,255,255);//snowflake
      ellipse(myX,myY,5,5);
      //your code here
    }
    public void lookDown()
    {
      if((myY < 410) && (myY > 0) && (get(myX,myY+3)!=color(31,190,214)))
      {
        isMoving = false;
      }
      else
      {
        isMoving = true;
      }
      //your code here
    }
    public void erase()
    {
      fill(31,190,214);
      ellipse(myX,myY,7,7);
      //your code here
    }
    public void move()
    {
      if(isMoving == true)
      {
        myY = myY + 1;
      }
      else 
      {
        myY = myY;
      }
      //your code here
    }
    public void wrap()
    {
      if(myY >= 396)
      {
        myY = 0;
        myX = (int)(Math.random()*400);
      }
      //your code here
    }
  }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
