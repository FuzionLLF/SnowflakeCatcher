SnowFlake [] group;
  void setup()
  {
    size(300,300);
    background(31,190,214);
    noStroke();//light blue(sky)
    group = new SnowFlake[10];
    for(int i = 0; i < group.length;i++)
    {
      group[i] = new SnowFlake();
    }
  }
  void draw()
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
  void mouseDragged()
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
      myX = (int)(Math.random()*300);
      myY = (int)(Math.random()*300);
      isMoving = true;
      //class member variable initializations
    }
    void show()
    {
      noStroke();
      fill(255,255,255);//snowflake
      ellipse(myX,myY,5,5);
      //your code here
    }
    void lookDown()
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
    void erase()
    {
      fill(31,190,214);
      ellipse(myX,myY,7,7);
      //your code here
    }
    void move()
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
    void wrap()
    {
      if(myY >= 296)
      {
        myY = 0;
        myX = (int)(Math.random()*300);
      }
      //your code here
    }
  }
