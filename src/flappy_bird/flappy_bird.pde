 int x = 500;
  int y= 500;
  int birdYVelocity = 100;
  int px= 1000;
 int upperPipeHeight = (int) random(100, 300);
 int score;
 boolean isAlive =true;
void setup(){

  
  size(1000,1000);
  
}

void draw(){
  if(isAlive==false){
   background(0, 0, 255);
   fill(255,255,255);
text("Score: "+score, 500, 800);

  }
 else{ background(0, 0, 255);
  fill(255, 0, 0);
stroke(255, 255, 255);

ellipse(x, y, 100, 100);
y= y+5;

fill(0, 255, 0);
rect(px, 500, 100, 500);
 
fill(0, 255, 0);
rect(px, 0, 100, upperPipeHeight);
px-= 5;
 teleportPipes();
 
 }
 if(intersectsPipes()==true){
     background(0, 0, 255);
isAlive =false;

 }
 
 if(y==1000){
       isAlive=false;
  
 }
}

void mousePressed(){
  y -= 100;
}

void teleportPipes()
  
  
{
  if (px==0){
   upperPipeHeight = (int) random(100, 300);
 px=1000; 
}
 if (intersectsPipes()==false) {
 score =+ 1;
 text("Score: "+score, 500, 800);
 }
 else if( intersectsPipes()==true){
   
   text("Score: "+score, 500, 800);
}

}


boolean intersectsPipes() { 
     if (y < upperPipeHeight && x > px && x < (px+100)){
          return true; }
     else if (y>500 && x > px && x < (px+100)) {
          return true; }
     else { return false; }
}