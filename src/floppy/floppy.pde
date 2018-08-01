
int x= 500;
int y= 999;
Car c = new Car(100, 1,10, 150);
 Car c1 = new Car(500, 999,10 , 150);
 Car c2 = new Car(900, 1,10 , 150);
void setup(){
 size(1000,1000); 
}

void draw(){
 if(intersects(c)){
     background(0,0,255);
 }
  else if (intersects(c1)){
     background(0,0,255);
  }
  
  else if(intersects(c2)){
     background(0,0,255);
  }
  
  else{
  background(0,0,255);
 fill(0,255,0);
 ellipse(x,y,50,50);
 keyPressed();
 boundry();
 c.display();
 c.Rc();
 c1.display();
 c1.Lc();
 c2.display();
 c2.Rc();
 
  }
}


void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                y -=5;
            }
            else if(keyCode == DOWN)
            {
                  y+=5; 
            }
            else if(keyCode == RIGHT)
            {
                 x+= 5;
            }
            else if(keyCode == LEFT)
            {
                x -=5;  //Frog X position goes left
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
  boolean intersects(Car car) {
      if ((y > car.getY() && y < car.getY()+50) && (x > car.getX() && x < car.getX()+car.getSize()))
      {
             return true;
      }
      else 
      {
             return false;
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
void Rc(){
  
 if(x>=1000){
   x=0;
 }
 x+=speed;
}
  void Lc(){
   
    if(x<=0){
     x=1000; 
    }
     x-=speed;
  }
  
  int getX(){
    
    return x;
}
int getY(){
  return y;
}
int getSize(){
  return size;
}


}