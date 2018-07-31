int x= 500;
int y= 1000;
Car c = new Car(100, 100,10, 150);
 Car c1 = new Car(500, 100,10 , 150);
 Car c2 = new Car(900, 100,10 , 150);
void setup(){
 size(1000,1000); 
}

void draw(){
 background(0,0,255);
 fill(0,255,0);
 ellipse(x,y,50,50);
 display();
}


void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                y -=100;
            }
            else if(keyCode == DOWN)
            {
                  y=+ 100; 
            }
            else if(keyCode == RIGHT)
            {
                 x=+ 100;
            }
            else if(keyCode == LEFT)
            {
                x -=100;  //Frog X position goes left
            }
      }
}



void boundry(){

 if(y==1000){
   y -=100;
 }
   else if(y==0){
    y =+ 100; 
   }
    else if (x==0){
     x +=100;
     
    }
    else if (x==1000){ 
     x-= 100; 
    
   }
  
  
}




class Car{
 
  int x;
  int y;
  int speed = 10;
  int size =50 ;
 
  
  public Car(int y, int x, int s, int size){
    this.x=x;
    this.y=y;
    speed=s;
    this.size=size;
    
    
  }
    
    void display() 
{
      fill(0,255,0);
      rect(x , y, size, 50);
}
    
  }
  