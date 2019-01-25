import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.Color;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.io.InputStream;


class MenuPanel extends JPanel{

	JButton play = new JButton("");
    JButton play2 = new JButton("");
	JButton play3 = new JButton("");
	int x,y,y2,y3,y4;
	
	Image menubkg = new ImageIcon("gamebkg.jpg").getImage();
	
	/* Setting icons on buttons */
	ImageIcon playbtn = new ImageIcon("playp1.jpg"); 
	ImageIcon playbtn2 = new ImageIcon("playp2.jpg"); 
	ImageIcon playbtn3 = new ImageIcon("playp3.jpg"); 
   
    Image welcome= new ImageIcon("welcome.png").getImage();
    Image welcome2= new ImageIcon("welcome2.png").getImage();	
	Image welcome3= new ImageIcon("welcome3.png").getImage();
	Image welcome4= new ImageIcon("welcome4.png").getImage();
	
	JPanel center = new JPanel(); 
	
	MenuPanel(){
		
	    SoundThread.play("super.wav");
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); 
		add(center);
		y=800;
		y2=1000;
		y3=1000;
		y4=1000;
		x=250;
		
		play.setIcon(playbtn); 
		play2.setIcon(playbtn2); 
		play3.setIcon(playbtn3);
        play.setBackground(Color.BLACK);
        play2.setBackground(Color.BLACK);		
		 play3.setBackground(Color.BLACK);
		
		
		
		center.add(play);
		center.add(play2);
		center.add(play3);
				
		
		play.addMouseListener(new Click());
		play2.addMouseListener(new Click());
	    play3.addMouseListener(new Click());
		
	}
	
	class Click extends MouseAdapter{ 
	
		public void mouseClicked(MouseEvent me){
			
			
			if(me.getSource()== play){
				ChickenGame.cl.show(ChickenGame.cards, "GamePanel"); 
				SoundThread.play("music.wav");
			}
			if(me.getSource()== play2){
				SoundThread.play("music.wav");
				ChickenGame.cl.show(ChickenGame.cards, "GamePanel2"); 
			}
			if(me.getSource()== play3){
				SoundThread.play("music.wav");
				ChickenGame.cl.show(ChickenGame.cards, "GamePanel3"); 
			}
				
			
		}
	}
	
	void functionF()
	{
	    if( y > -450 )
		y--;
	    else if( y2 > -550 )
		{
		  
          y2--;
	  
		}
		else if( y3 > -550 )
		{
		  
          y3--;
	  
		}
		else if( y4 > -500 )
		{
			y4--;
		}	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D)g; 
		setFocusable(true);		 
		
		functionF();
		g2d.drawImage(menubkg, 0,0, null);
		g2d.drawImage(welcome, x,y, null);
		g2d.drawImage(welcome2, x,y2, null);
		g2d.drawImage(welcome3, x,y3, null);
		g2d.drawImage(welcome4, x,y4, null);
		repaint();
	}
}


class Cat{

   int x_cat,y_cat; // x and y coord of egg
   
   
   Random rand = new Random();
   Random rand2=new Random();
   
   Cat()
   {
	   x_cat=(int)rand.nextInt(1000);
	   y_cat=(int)rand2.nextInt(1000);
   }
   public void setXCat( int a )
   {
	   x_cat=a;
   }
   public void setYCat( int b )
   {
	   y_cat=b;
   }
   public int getXCat()
   {
	   return x_cat;
   }
   public int getYCat()
   {
	   return y_cat;
   }   
   
};//end class
 class SoundThread extends Thread {

    private final String resource;

    public static void play(String resource) {
        Thread t = new SoundThread(resource);
        t.setDaemon(true);
        t.start();
    }

    public SoundThread(String resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        Clip clip = null;
        try {
            InputStream in = SoundThread.class.getClassLoader().getResourceAsStream(resource);
            if(in != null) {
                AudioInputStream stream = AudioSystem.getAudioInputStream(in);
                AudioFormat format = stream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.loop(0);
                do  {
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException iex) {
                       
                    }
                } while(clip.isRunning());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if(clip != null) {
                    clip.close();
                }
            } catch(Exception x) {
                x.printStackTrace(System.out);
            }
        }
    }
}
class Chicken{
	
	int x_chicken,y_chicken;

    Chicken()
	{
		x_chicken=450;
	    y_chicken=450;
    }
   public void setXChicken( int a )
   {
	   x_chicken=a;
   }
   public void setYChicken( int b )
   {
	   y_chicken=b;
   }
   public int getXChicken()
   {
	   return x_chicken;
   }
   public int getYChicken()
   {
	   return y_chicken;
   } 
};	

class Basket{


   int x_basket,y_basket;
   Random rand=new Random();
   
    Basket()
	{
		int x_basket=80;
		int y_basket=0;
    }
   public void setXBasket( int a )
   {
	   x_basket=a;
   }
   public void setYBasket( int b )
   {
	   y_basket=b;
   }
   public int getXBasket()
   {
	   return x_basket;
   }
   public int getYBasket()
   {
	   return y_basket;
   }   


};

class GamePanel3 extends JPanel{ 

    Image cloud=new ImageIcon("cloud.png").getImage();
	Image egg=new ImageIcon("egg.png").getImage();
	ImageIcon[] gamebkg={ new ImageIcon("sky.jpg")};
	ImageIcon[] image={ new ImageIcon("chickenR.png"),new ImageIcon("chickenL.png"),new ImageIcon("chicken.png")};
	Image basket= new ImageIcon("basket.png").getImage();
	
	Image basket4= new ImageIcon("basket.png").getImage();
	
	Image cat     = new ImageIcon("cat.png").getImage();
	Image gameOverbkg= new ImageIcon("gameOver.jpg").getImage();
	Image tempbkg; 
	
	
	
	
	Cat kedi1=new Cat();
	
	Cat kedi2=new Cat();
	
	Cat kedi3=new Cat();
	
    Chicken tavuk=new Chicken();
	
    Basket b1=new Basket();
	
	
	Basket b4=new Basket();
	
	
  	
	int x_egg,y_egg;
	int i=0;
	
	Random rand = new Random(); 
	Random rand2=new Random();
	
	JLabel time;
	JLabel points;
	
	int pointsCount = 0;
	int timeleft = 59;
	int counter  = 0;
	int c=1;
	int x,y=600,x1,y2=800,x3,y3=400,x2,x4,y4=500,x5,y5=250;
	

	
	
	boolean gameOver = false;
	
	GamePanel3(){
		
		
		x_egg=tavuk.getYChicken();
		setLayout(null);
		setFocusable(true);
		
		tempbkg = gamebkg[ i ].getImage();
		
		
		x=(int)rand.nextInt(1000);
		x2=(int)rand.nextInt(1000);
		x3=(int)rand.nextInt(1000);
		x4=(int)rand.nextInt(1000);
        x5=(int)rand.nextInt(1000);
		
		tavuk.setXChicken( 450 );
		tavuk.setYChicken( 450 );
        
    b1.setXBasket( 40 );
	b1.setYBasket( (int)rand.nextInt(850) );
	
	
	
	
	
	b4.setXBasket( 1200 );
	b4.setYBasket( (int)rand.nextInt(850) );
	
	
	
	
			
		x_egg=tavuk.getXChicken()+20;
		y_egg=tavuk.getYChicken();
		
		
	    	
	    time = new JLabel("Time: 59");
		time.setBounds(20, 10, 50, 20); 
	    
	    
	    points = new JLabel("Points: 0");
		points.setBounds(100,10,100,20);
		
		
		add(time);
		add(points);
		
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				if(ke.getKeyCode() == ke.VK_LEFT & tavuk.getXChicken()>10){
					tavuk.setXChicken( tavuk.getXChicken()-10 );
					x_egg=tavuk.getXChicken()+20;
					repaint(); // redraw at new position
				}
				if(ke.getKeyCode() == ke.VK_RIGHT & tavuk.getYChicken()<1000){
					tavuk.setXChicken( tavuk.getXChicken()+10 ); // redraw at new position
					x_egg=tavuk.getXChicken()+20;
					repaint();
				}
				
			}//end keypressed
		});	
	}//end constructor
	
	void movement(){
       	
        /*if( y_chicken < 800)
        	y_chicken++;
        else
            y_chicken=0;*/	
        

        if( b1.getYBasket() > 0 )
        b1.setYBasket( b1.getYBasket()-1);
        else
        b1.setYBasket(800);

       

        
	
	
	    if(  b4.getYBasket() > 0 )	
        b4.setYBasket( b4.getYBasket()-1);
        else
        b4.setYBasket(800);
	
	
		 
		
		if( y > 0 )
		{
		  y4--;
          y5--;		  
		  y--;
	      y2--;
		  y3--;
		}  
	    else 
		{	
		  y=800;
	      y2=950;
		  y3=600;
		  y5=250;
		  y4=752;
	    }
	  
	    y_egg=tavuk.getYChicken();
	
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				
				if( ke.getKeyCode() == ke.VK_DOWN){
					
					
					c=1;
					
					x_egg=80;     
		       }
				
			    if( ke.getKeyCode() == ke.VK_UP){
					
				
					c=0;
					
					x_egg=1250;
					 // redraw at new position
				}
			
				
				
			}
					public void keyReleased( KeyEvent kr )
			{
				x_egg=tavuk.getXChicken()+20;
				repaint();
            }
			
			
		});
		
		
		
		if(kedi1.getYCat()<=0 ){
			kedi1.setYCat( 900 );
			
			kedi1.setXCat( rand.nextInt(1000) );
		}
		else
			kedi1.setYCat( kedi1.getYCat()-1 );
		
		if(kedi2.getYCat()<=0 ){
			kedi2.setYCat( 900 );
			
			kedi2.setXCat( rand.nextInt(1000) );
		}
		else
			kedi2.setYCat( kedi2.getYCat()-1 );
		
		if(kedi3.getYCat()<=0 ){
			kedi3.setYCat( 900 );
			
			kedi3.setXCat( rand.nextInt(1000) );
		}
		else
			kedi3.setYCat( kedi3.getYCat()-1 );
		
	}
	
	void updateTime(){
		counter++;
		if(counter == 200) 
		{
		   timeleft--;  
		   counter = 0; 
		}
		time.setText("Time:"+timeleft);
	}
	
	void detectCollision(){
		
		Rectangle chickenRect = new Rectangle(tavuk.getXChicken(),tavuk.getYChicken(),100,65); //making a rectangle on the basket
		Rectangle cat    = new Rectangle( kedi1.getXCat(),kedi1.getYCat(),150,150); //making a rectangle on egg
		Rectangle cat2    = new Rectangle( kedi2.getXCat(),kedi2.getYCat(),150,150); //making a rectangle on egg
		Rectangle cat3  = new Rectangle( kedi3.getXCat(),kedi3.getYCat(),150,150);
		
		Rectangle egg =new Rectangle(x_egg,y_egg,150,150);
		Rectangle basket= new Rectangle(b1.getXBasket(),b1.getYBasket(),150,150);
		
		
		Rectangle basket4= new Rectangle(b4.getXBasket(),b4.getYBasket(),150,150);
		
		
		if(cat.intersects(chickenRect) || cat2.intersects(chickenRect) || cat3.intersects(chickenRect)){
		    
			SoundThread.play("fail.wav");
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(400, 400, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.WHITE);
			add(yourScore);
		}
		if(egg.intersects(basket) ){
		    
		   pointsCount+=5; 
		   points.setText("Points:"+pointsCount); 
       
		   
		}
	  
        if( egg.intersects(basket4) ){
		    
		   pointsCount+=5; 
		   points.setText("Points:"+pointsCount); 
                    
		}		
       		
		 
		
	}
	
	void checkGameOver(){
		if(timeleft <= 0)
		{
			SoundThread.play("fail.wav");
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(400, 400, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.WHITE);
			add(yourScore);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(tempbkg,0,0,null); 
		
		checkGameOver();
		
		if(gameOver == false){
			setFocusable(true);
			grabFocus();
			updateTime();
			
			movement();
			detectCollision();
			
			
			
			g2d.setColor(Color.WHITE);
			g2d.drawImage(cloud,x5,y5,null);
			g2d.drawImage(cloud,x4,y4,null);
		    g2d.drawImage(cloud,x,y,null);
			g2d.drawImage( cloud,x2,y2,null);
			g2d.drawImage(cloud, x3, y3,null);
			
			g2d.drawImage(cat, kedi1.getXCat(),kedi1.getYCat(),null);
			g2d.drawImage(cat, kedi2.getXCat(),kedi2.getYCat(),null); 
			g2d.drawImage(cat, kedi3.getXCat(),kedi3.getYCat(),null); 
			
			g2d.drawImage(basket,b1.getXBasket(),b1.getYBasket(),null);
			
			
			g2d.drawImage(basket4,b4.getXBasket(),b4.getYBasket(),null);
			
			
		    g2d.drawImage(egg,x_egg,y_egg,null);
			g2d.drawImage(image[ c ].getImage(), tavuk.getXChicken(),tavuk.getYChicken(), null); //drawing basket
		}
		
		repaint();	
	}
}










   	
class GamePanel extends JPanel{ 

    Image cloud=new ImageIcon("cloud.png").getImage();
	Image egg=new ImageIcon("egg.png").getImage();
	ImageIcon[] gamebkg={ new ImageIcon("sky.jpg")};
	ImageIcon[] image={ new ImageIcon("chickenR.png"),new ImageIcon("chickenL.png"),new ImageIcon("chicken.png")};
	Image basket= new ImageIcon("basket.png").getImage();
	Image basket2= new ImageIcon("basket.png").getImage();
	Image basket3= new ImageIcon("basket.png").getImage();
	Image basket4= new ImageIcon("basket.png").getImage();
	Image basket5= new ImageIcon("basket.png").getImage();
	Image basket6= new ImageIcon("basket.png").getImage();
	Image cat     = new ImageIcon("cat.png").getImage();
	Image gameOverbkg= new ImageIcon("gameOver.jpg").getImage();
	Image tempbkg; 
	
	
	
	
	Cat kedi1=new Cat();
    Chicken tavuk=new Chicken();
	
    Basket b1=new Basket();
	Basket b2=new Basket();
	Basket b3=new Basket();
	Basket b4=new Basket();
	Basket b5=new Basket();
	Basket b6=new Basket();
  	
	int x_egg,y_egg;
	int i=0;
	
	Random rand = new Random(); 
	Random rand2=new Random();
	
	JLabel time;
	JLabel points;
	
	int pointsCount = 0;
	int timeleft = 59;
	int counter  = 0;
	int c=1;
	int x,y=600,x1,y2=800,x3,y3=400,x2,x4,y4=500,x5,y5=250;
	

	
	
	boolean gameOver = false;
	
	GamePanel(){
		
		 x_egg=tavuk.getYChicken();
		setLayout(null);
		setFocusable(true);
		
		tempbkg = gamebkg[ i ].getImage();
		
		
		x=(int)rand.nextInt(1000);
		x2=(int)rand.nextInt(1000);
		x3=(int)rand.nextInt(1000);
		x4=(int)rand.nextInt(1000);
        x5=(int)rand.nextInt(1000);
		
		tavuk.setXChicken( 450 );
		tavuk.setYChicken( 450 );
        
        	b1.setXBasket( 40 );
	b1.setYBasket( (int)rand.nextInt(850) );
	
	b2.setXBasket( 40 );
	b2.setYBasket( (int)rand.nextInt(850) );
	
	b3.setXBasket( 40 );
	b3.setYBasket( (int)rand.nextInt(850) );
	
	b4.setXBasket( 1200 );
	b4.setYBasket( (int)rand.nextInt(850) );
	
	b5.setXBasket( 1200 );
	b5.setYBasket( (int)rand.nextInt(850) );
	
	b6.setXBasket( 1200 );
	b6.setYBasket( (int)rand.nextInt(850) );
			
		x_egg=tavuk.getXChicken()+20;
		y_egg=tavuk.getYChicken();
		
		
	    	
	    time = new JLabel("Time: 59");
		time.setBounds(20, 10, 50, 20); 
	    
	    
	    points = new JLabel("Points: 0");
		points.setBounds(100,10,100,20);
		
		
		add(time);
		add(points);
		
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				if(ke.getKeyCode() == ke.VK_LEFT & tavuk.getXChicken()>10){
					tavuk.setXChicken( tavuk.getXChicken()-10 );
					x_egg=tavuk.getXChicken()+20;
					repaint(); 
				}
				if(ke.getKeyCode() == ke.VK_RIGHT & tavuk.getYChicken()<1000){
					tavuk.setXChicken( tavuk.getXChicken()+10 ); // redraw at new position
					x_egg=tavuk.getXChicken()+20;
					repaint();
				}
				
			}
		});	
	}
	
	void movement(){
       	
        /*if( y_chicken < 800)
        	y_chicken++;
        else
            y_chicken=0;*/	
        

        if( b1.getYBasket() > 0 )
        b1.setYBasket( b1.getYBasket()-1);
        else
        b1.setYBasket(800);

        if( b2.getYBasket() > 0 )
        b2.setYBasket( b2.getYBasket()-1);
        else
        b2.setYBasket(800);

        if(  b3.getYBasket() > 0 )	
        b3.setYBasket( b3.getYBasket()-1);
        else
        b3.setYBasket(800);
	
	
	    if(  b4.getYBasket() > 0 )	
        b4.setYBasket( b4.getYBasket()-1);
        else
        b4.setYBasket(800);
	
	    if(  b5.getYBasket() > 0 )	
        b5.setYBasket( b5.getYBasket()-1);
        else
        b5.setYBasket(800);
	
		 if(  b6.getYBasket() > 0 )	
        b6.setYBasket( b6.getYBasket()-1);
        else
        b6.setYBasket(800);
		
		if( y > 0 )
		{
		  y4--;
          y5--;		  
		  y--;
	      y2--;
		  y3--;
		}  
	    else 
		{	
		  y=800;
	      y2=950;
		  y3=600;
		  y5=250;
		  y4=752;
	    }
	  
	    y_egg=tavuk.getYChicken();
	
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				
				if( ke.getKeyCode() == ke.VK_DOWN){
					
					c=1;
					
					x_egg=80;     
		       }
				
			    if( ke.getKeyCode() == ke.VK_UP){
					c=0;
					
					x_egg=1250;
					 // redraw at new position
				}
				
				
				
			}//end keypressed
			
				public void keyReleased( KeyEvent kr )
			{
				x_egg=tavuk.getXChicken()+20;
				repaint();
            }
			
		});
		
		
		
		if(kedi1.getYCat()<=0 ){
			kedi1.setYCat( 900 );
			
			kedi1.setXCat( rand.nextInt(1000) );
		}
		else
			kedi1.setYCat( kedi1.getYCat()-1 );
		
		
	}
	
	void updateTime(){
		counter++;
		if(counter == 200) 
		{
		   timeleft--;  
		   counter = 0; 
		}
		time.setText("Time:"+timeleft);
	}
	
	void detectCollision(){
		
		Rectangle chickenRect = new Rectangle(tavuk.getXChicken(),tavuk.getYChicken(),100,65); //making a rectangle on the basket
		Rectangle cat    = new Rectangle( kedi1.getXCat(),kedi1.getYCat(),150,150); //making a rectangle on egg
		
		Rectangle egg =new Rectangle(x_egg,y_egg,150,150);
		Rectangle basket= new Rectangle(b1.getXBasket(),b1.getYBasket(),150,150);
		Rectangle basket2=new Rectangle(b2.getXBasket(),b2.getYBasket(),150,150);
		Rectangle basket3=new Rectangle(b3.getXBasket(),b3.getYBasket(),150,150);
		Rectangle basket4= new Rectangle(b4.getXBasket(),b4.getYBasket(),150,150);
		Rectangle basket5= new Rectangle(b5.getXBasket(),b5.getYBasket(),150,150);
		Rectangle basket6= new Rectangle(b6.getXBasket(),b6.getYBasket(),150,150);
		
		if(cat.intersects(chickenRect)){
		    
			SoundThread.play("fail.wav");
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(400, 400, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.RED);
			add(yourScore);
		}
		if(egg.intersects(basket) || egg.intersects(basket2)|| egg.intersects(basket3) ){
		    
		   pointsCount+=5; 
		   points.setText("Points:"+pointsCount); 
       
		   
		}
	  
        if(egg.intersects(basket4) || egg.intersects(basket5)|| egg.intersects(basket6) ){
		    
		   pointsCount+=5; 
		   points.setText("Points:"+pointsCount); 
                    
		}		
       		
		 
		
	}
	
	void checkGameOver(){
		if(timeleft <= 0)
		{   
	       
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(500, 450, 500, 500);
			gameOver = true;
			yourScore.setForeground(Color.WHITE);
			add(yourScore);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(tempbkg,0,0,null); //game background
		
		checkGameOver();
		
		if(gameOver == false){
			setFocusable(true);
			grabFocus();
			updateTime();
			
			movement();
			detectCollision();
			
			
			
			g2d.setColor(Color.WHITE);
			g2d.drawImage(cloud,x5,y5,null);
			g2d.drawImage(cloud,x4,y4,null);
		    g2d.drawImage(cloud,x,y,null);
			g2d.drawImage( cloud,x2,y2,null);
			g2d.drawImage(cloud, x3, y3,null);
			g2d.drawImage(cat, kedi1.getXCat(),kedi1.getYCat(),null);
			 
			g2d.drawImage(basket,b1.getXBasket(),b1.getYBasket(),null);
			g2d.drawImage(basket2,b2.getXBasket(),b2.getYBasket(),null);
			g2d.drawImage(basket3,b3.getXBasket(),b3.getYBasket(),null);
			
			g2d.drawImage(basket4,b4.getXBasket(),b4.getYBasket(),null);
			g2d.drawImage(basket5,b5.getXBasket(),b5.getYBasket(),null);
			g2d.drawImage(basket6,b6.getXBasket(),b6.getYBasket(),null);
			
		    g2d.drawImage(egg,x_egg,y_egg,null);
			g2d.drawImage(image[ c ].getImage(), tavuk.getXChicken(),tavuk.getYChicken(), null); //drawing basket
		}
		
		repaint();	
	}
}
class GamePanel2 extends JPanel{ 

    Image cloud=new ImageIcon("cloud.png").getImage();
	Image egg=new ImageIcon("egg.png").getImage();
	ImageIcon[] gamebkg={ new ImageIcon("sky.jpg")};
	ImageIcon[] image={ new ImageIcon("chickenR.png"),new ImageIcon("chickenL.png"),new ImageIcon("chicken.png")};
	Image basket= new ImageIcon("basket.png").getImage();
	Image basket2= new ImageIcon("basket.png").getImage();
	Image basket3= new ImageIcon("basket.png").getImage();
	Image basket4= new ImageIcon("basket.png").getImage();
	Image basket5= new ImageIcon("basket.png").getImage();
	Image basket6= new ImageIcon("basket.png").getImage();
	Image cat     = new ImageIcon("cat.png").getImage();
	Image gameOverbkg= new ImageIcon("gameOver.jpg").getImage();
	Image tempbkg;
	
	
	
	
	Cat kedi1=new Cat();
	
	Cat kedi2=new Cat();
	
    Chicken tavuk=new Chicken();
	
    Basket b1=new Basket();
	
	Basket b3=new Basket();
	Basket b4=new Basket();
	Basket b5=new Basket();
	
  	
	int x_egg,y_egg;
	int i=0;
	
	Random rand = new Random();
	Random rand2=new Random();
	
	JLabel time;
	JLabel points;
	
	int pointsCount = 0;
	int timeleft = 59;
	int counter  = 0;
	int c=1;
	int x,y=600,x1,y2=800,x3,y3=400,x2,x4,y4=500,x5,y5=250;
	

	
	
	boolean gameOver = false;
	
	GamePanel2(){
		
		 x_egg=tavuk.getYChicken();
		setLayout(null);
		setFocusable(true);
		
		tempbkg = gamebkg[ i ].getImage();
		
		
		x=(int)rand.nextInt(1000);
		x2=(int)rand.nextInt(1000);
		x3=(int)rand.nextInt(1000);
		x4=(int)rand.nextInt(1000);
        x5=(int)rand.nextInt(1000);
		
		tavuk.setXChicken( 450 );
		tavuk.setYChicken( 450 );
        
        	b1.setXBasket( 40 );
	b1.setYBasket( (int)rand.nextInt(850) );
	
	
	
	b3.setXBasket( 40 );
	b3.setYBasket( (int)rand.nextInt(850) );
	
	b4.setXBasket( 1200 );
	b4.setYBasket( (int)rand.nextInt(850) );
	
	b5.setXBasket( 1200 );
	b5.setYBasket( (int)rand.nextInt(850) );
	
	
			
		x_egg=tavuk.getXChicken()+20;
		y_egg=tavuk.getYChicken();
		
		
	    	
	    time = new JLabel("Time: 59");
		time.setBounds(20, 10, 50, 20); 
	    
	    
	    points = new JLabel("Points: 0");
		points.setBounds(100,10,100,20);
		
		
		add(time);
		add(points);
		
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				if(ke.getKeyCode() == ke.VK_LEFT & tavuk.getXChicken()>10){
					tavuk.setXChicken( tavuk.getXChicken()-10 );
					x_egg=tavuk.getXChicken()+20;
					repaint(); 
				}
				if(ke.getKeyCode() == ke.VK_RIGHT & tavuk.getYChicken()<1000){
					tavuk.setXChicken( tavuk.getXChicken()+10 );
					x_egg=tavuk.getXChicken()+20;
					repaint();
				}
				
			}
			
			public void keyReleased( KeyEvent kr )
			{
				x_egg=tavuk.getXChicken()+20;
				repaint();
            }				
			
		});	
	}
	
	void movement(){
       	
        /*if( y_chicken < 800)
        	y_chicken++;
        else
            y_chicken=0;*/	
        

        if( b1.getYBasket() > 0 )
        b1.setYBasket( b1.getYBasket()-1);
        else
        b1.setYBasket(800);

       

        if(  b3.getYBasket() > 0 )	
        b3.setYBasket( b3.getYBasket()-1);
        else
        b3.setYBasket(800);
	
	
	    if(  b4.getYBasket() > 0 )	
        b4.setYBasket( b4.getYBasket()-1);
        else
        b4.setYBasket(800);
	
	    if(  b5.getYBasket() > 0 )	
        b5.setYBasket( b5.getYBasket()-1);
        else
        b5.setYBasket(800);
	
		 
		
		if( y > 0 )
		{
		  y4--;
          y5--;		  
		  y--;
	      y2--;
		  y3--;
		}  
	    else 
		{	
		  y=800;
	      y2=950;
		  y3=600;
		  y5=250;
		  y4=752;
	    }
	  
	    y_egg=tavuk.getYChicken();
	
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				
				if( ke.getKeyCode() == ke.VK_DOWN){
					
					c=1;
					
					x_egg=80;     
		       }
				
			    if( ke.getKeyCode() == ke.VK_UP){
					c=0;
					
					x_egg=1250;
					 
				}
				
				
				
			}
			
			
		});
		
		
		
		if(kedi1.getYCat()<=0 ){
			kedi1.setYCat( 900 );
			
			kedi1.setXCat( rand.nextInt(1000) );
		}
		else
			kedi1.setYCat( kedi1.getYCat()-1 );
		
		if(kedi2.getYCat()<=0 ){
			kedi2.setYCat( 900 );
			
			kedi2.setXCat( rand.nextInt(1000) );
		}
		else
			kedi2.setYCat( kedi2.getYCat()-1 );
		
	}
	
	void updateTime(){
		counter++;
		if(counter == 200) 
		{
		   timeleft--;  
		   counter = 0; 
		}
		time.setText("Time:"+timeleft);
	}
	
	void detectCollision(){
		
		Rectangle chickenRect = new Rectangle(tavuk.getXChicken(),tavuk.getYChicken(),100,65); 
		Rectangle cat    = new Rectangle( kedi1.getXCat(),kedi1.getYCat(),150,150); 
		Rectangle cat2    = new Rectangle( kedi2.getXCat(),kedi2.getYCat(),150,150); 
		
		Rectangle egg =new Rectangle(x_egg,y_egg,150,150);
		Rectangle basket= new Rectangle(b1.getXBasket(),b1.getYBasket(),150,150);
		
		Rectangle basket3=new Rectangle(b3.getXBasket(),b3.getYBasket(),150,150);
		Rectangle basket4= new Rectangle(b4.getXBasket(),b4.getYBasket(),150,150);
		Rectangle basket5= new Rectangle(b5.getXBasket(),b5.getYBasket(),150,150);
		
		
		if(cat.intersects(chickenRect) || cat2.intersects(chickenRect) ){
		    
			SoundThread.play("fail.wav");
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(400, 400, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.RED);
			add(yourScore);
		}
		if(egg.intersects(basket) || egg.intersects(basket3) ){
		    
	    		
		   pointsCount+=5; 
		   points.setText("Points:"+pointsCount); 
       
		   
		}
	  
        if(egg.intersects(basket4) || egg.intersects(basket5) ){
		    
		   pointsCount+=5; 
		   points.setText("Points:"+pointsCount); 
                    
		}		
       		
		 
		
	}//end collision detection
	
	void checkGameOver(){
		if(timeleft <= 0)
		{
			SoundThread.play("fail.wav");
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(400, 400, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.RED);
			add(yourScore);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(tempbkg,0,0,null); //game background
		
		checkGameOver();
		
		if(gameOver == false){
			setFocusable(true);
			grabFocus();
			updateTime();
			
			movement();
			detectCollision();
			
			
			
			g2d.setColor(Color.WHITE);
			g2d.drawImage(cloud,x5,y5,null);
			g2d.drawImage(cloud,x4,y4,null);
		    g2d.drawImage(cloud,x,y,null);
			g2d.drawImage( cloud,x2,y2,null);
			g2d.drawImage(cloud, x3, y3,null);
			
			g2d.drawImage(cat, kedi1.getXCat(),kedi1.getYCat(),null);
			g2d.drawImage(cat, kedi2.getXCat(),kedi2.getYCat(),null); 
			
			g2d.drawImage(basket,b1.getXBasket(),b1.getYBasket(),null);
			
			g2d.drawImage(basket3,b3.getXBasket(),b3.getYBasket(),null);
			
			g2d.drawImage(basket4,b4.getXBasket(),b4.getYBasket(),null);
			g2d.drawImage(basket5,b5.getXBasket(),b5.getYBasket(),null);
			
			
		    g2d.drawImage(egg,x_egg,y_egg,null);
			g2d.drawImage(image[ c ].getImage(), tavuk.getXChicken(),tavuk.getYChicken(), null); //drawing basket
		}
		
		repaint();	
	}
}
public class ChickenGame extends JFrame{
	
	static MenuPanel mp = new MenuPanel();

	static GamePanel gp = new GamePanel();
	static GamePanel2 gp2 = new GamePanel2();
	static GamePanel3 gp3 = new GamePanel3();
	static CardLayout cl = new CardLayout();
	static JPanel cards = new JPanel(); 
	
	ChickenGame(){
		
		cards.setLayout(cl);
		cards.add(mp, "MenuPanel");
		cards.add(gp3, "GamePanel3");
	    cards.add(gp2, "GamePanel2");
		cards.add(gp, "GamePanel");
		cl.show(cards, "MenuPanel");
		add(cards);
		
		setTitle("Catch The Eggs Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1380, 1024); 
		setVisible(true);   
	}
	
	public static void main(String args[]){
		
		new ChickenGame();
	}
}

