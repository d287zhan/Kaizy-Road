import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.Font;
import java.io.InputStream;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/*********************************************************
*  Name: Daniel Zhang, Serena Hacker, Kaizen Liu         *
*  Course: ICS 4U  Pd.4S                                 *
*  Assignment Summative                                  *
*  Purpose: A version of Crossy road renamed Kaizy Road  *
*  Due Date: May 28, 2018                                *
*********************************************************/


public class KaizyRoa extends JFrame implements MouseListener, MouseMotionListener, KeyListener



{
   int x = 0;
   int y = 0;
   int numCoins;
   
   
   Drawing draw = new Drawing();
   
   ImageIcon p = new ImageIcon("p.jpg");
   ImageIcon c = new ImageIcon("c.jpg");
   ImageIcon l = new ImageIcon("l.jpg");
   
   ImageIcon c2 = new ImageIcon("c2.jpg");
   ImageIcon p2 = new ImageIcon("p2.jpg");
   ImageIcon l2 = new ImageIcon("l2.jpg");
   
   ImageIcon i = new ImageIcon("i.jpg");
   ImageIcon i2 = new ImageIcon("i2.jpg"); 
   JFrame frame = new JFrame("Kaizy Road");
   JFrame frame1 = new JFrame ("INSTRUCTIONS");
   JFrame frame2 = new JFrame("CHARACTERS");
   JFrame frame3 = new JFrame("LEADERBOARD");
    JFrame frame4 = new JFrame("Kaizy Road");
    JFrame frame5 = new JFrame("Game Over");
    
    
   Drawing2 draw1 = new Drawing2(); 
   Drawing3 draw2 = new Drawing3();
   Drawing4 draw3 = new Drawing4();
   Drawing5 draw4 = new Drawing5();
   Drawing6 draw5 = new Drawing6();

   ImageIcon b = new ImageIcon("bb.png");
   ImageIcon b2 = new ImageIcon("bb2.png"); 
   ImageIcon k1 = new ImageIcon("k1.jpg"); 
   ImageIcon k2 = new ImageIcon("k2.jpg"); 
   ImageIcon k3 = new ImageIcon("k3.jpg"); 
   ImageIcon k4 = new ImageIcon("k4.jpg"); 
   ImageIcon k5 = new ImageIcon("k5.jpg"); 
   ImageIcon k6 = new ImageIcon("k6.jpg");
  
   boolean isSelected  = false;
   boolean isSelected1  = false;
   boolean isSelected2  = false;
   boolean isSelected3  = false;
   boolean isSelected4  = false;
   ImageIcon lead = new ImageIcon("lboard.jpg"); 
   boolean inside = false;
   boolean inside1 = false;
   boolean inside2 = false;
   boolean inside3 = false;
   boolean inside4 = false;
   boolean inside5 = false;
   
   boolean purchased = false;
   boolean purchased1 = false;
   boolean purchased2 = false;
   boolean purchased3 = false;
   boolean purchased4 = false;
   boolean purchased5 = false;
   
   
       
   ImageIcon r = new ImageIcon("r.jpg");
   ImageIcon w = new ImageIcon("w.jpg");
   ImageIcon ro = new ImageIcon("ro.jpg");
   ImageIcon gr = new ImageIcon("gr.jpg");
   
   ImageIcon t = new ImageIcon("t.jpg");
   ImageIcon at = new ImageIcon("at.jpg");
   
   ImageIcon log = new ImageIcon("log.jpg");
   
   ImageIcon train = new ImageIcon("train.jpg");
   ImageIcon red = new ImageIcon("red.jpg");
   ImageIcon green = new ImageIcon("green.jpg");
   
   ImageIcon coin = new ImageIcon("coin.jpg");
   
   ImageIcon redcar = new ImageIcon("redcar.jpg");
   ImageIcon bluecar = new ImageIcon("bluecar.jpg");
   ImageIcon yellowcar = new ImageIcon("yellowcar.jpg");
   
   
   
   ImageIcon char1 = new ImageIcon("k1.jpg");
   
   
   int hitSound;
   boolean trainOn;
   
   static final int WIDTH = 1200;
   
   
   
   
   move m = new move();
   moveT m1 = new moveT();
   moveC m2 = new moveC();
   
   //moveCH m3 = new moveCH();
   
   
   
   //Characters character1 = new Characters(); 
   
   Trains [] train1 = new Trains[1000];
   Trains []train1or = new Trains [1000];
   
   Logs [] log1 = new Logs[2000]; 
   Logs[]log1or = new Logs[2000];
   
   Cars [] car1 = new Cars[3000];
   Cars[] car1or = new Cars[3000];
   
   
   String [] rows = new String[1000];
   int [][] trees = new int[1000][12];
   int [][] treesor = new int[1000][12];
   int [][] coins = new int[1000][12];
   int [][] coinsor = new int [1000][12];
   String [] temp = new String[1000];
   
   int numFor = 0;
   int numBack = 0;
   int score = 0;
   
   boolean hit = false;
   boolean hit1 = false;
   
   int logNum = -1;
   
   int cx = 600;
   int cy = 500;
   
   int[]scores1 = new int[5];
   int[]allscores = new int[50];
   int nextScorenum = 0;
  

  public KaizyRoa()
   {
   
   
           
      //home
      draw.addMouseListener(this);
      draw.addMouseMotionListener(this);
      
       
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(new Color(0x89, 0xcf, 0xf0)); 
      frame.add(draw); 

      frame.setBackground(new Color(0x89, 0xcf, 0xf0));  

      
      
      
      frame.setSize(1200,900);
      frame.setVisible(true);  
      
      //instructions
      draw1.addMouseListener(this);
      draw1.addMouseMotionListener(this);
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setSize(1200,900);
      frame1.setLocationRelativeTo(null);
      frame1.getContentPane().setBackground(new Color(0x89, 0xcf, 0xf0)); 
      frame1.add(draw1); 
      
      frame1.setVisible(false);  
      frame1.setResizable(false);   

      //characters 
      draw2.addMouseListener(this);
      draw2.addMouseMotionListener(this);
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.setSize(1200,900);
      frame2.setLocationRelativeTo(null);
      frame2.getContentPane().setBackground(new Color(0x89, 0xcf, 0xf0)); 
      frame2.add(draw2); 
      
      frame2.setVisible(false);
      frame2.setResizable(false);
 
      //leaderboard
      draw3.addMouseListener(this);
      draw3.addMouseMotionListener(this);
      frame3.setSize(500,900);
      frame3.setLocationRelativeTo(null);
      frame3.getContentPane().setBackground(new Color(0x89, 0xcf, 0xf0)); 
      frame3.add(draw3); 
      
      frame3.setVisible(false);
      frame3.setResizable(false);
      
      frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame4.setSize(1200,900);
      frame4.setLocationRelativeTo(null);
      frame4.getContentPane().setBackground(new Color(0x89, 0xcf, 0xf0)); 
      
      frame4.getContentPane().add(draw4);
      frame4.addKeyListener(this);      
      frame4.setVisible(false);  
      //m.start();
     // m1.start();
      //m2.start();
      
      //game over
      draw5.addMouseListener(this);
      draw5.addMouseMotionListener(this);
      frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame5.setSize(400,300);
      frame5.setLocationRelativeTo(null);
      frame5.getContentPane().setBackground(new Color(0x89, 0xcf, 0xf0)); 
      frame5.add(draw5); 
      
      frame5.setVisible(false);  
      frame5.setResizable(false); 
      
      /* for(int t = 0; t<=999; t++)
      {
         train1[t] = new Trains();
         train1[t].a = -1500 - (int)(Math.random()*10000);
         train1or[t] = new Trains();
         train1or[t].a = -1500 - (int)(Math.random()*10000);
      }   
      
      for(int t = 0; t<=1998; t+=2)
      {
         log1[t] = new Logs();
         log1[t].a = -300 - (int)(Math.random()*500);
         log1[t+1] = new Logs();
         log1[t+1].a = log1[t].a +500 + (int)(Math.random()*400);
         log1or[t] = new Logs();
         log1or[t].a = log1[t].a;
         log1or[t+1] = new Logs();
         log1or[t+1].a = log1[t+1].a;
      }  
      
      for(int t = 0; t<=2997; t+=3)
      {
         car1[t] = new Cars();
         car1[t].a = -300 - (int)(Math.random()*200);
         car1[t+1] = new Cars();
         car1[t+1].a = car1[t].a +400 + (int)(Math.random()*200);
         car1[t+2] = new Cars();
         car1[t+2].a = car1[t+1].a +400 + (int)(Math.random()*200);
         car1or[t] = new Cars();
         car1or[t].a = car1[t].a;
         car1or[t+1] = new Cars();
         car1or[t+1].a = car1[t+1].a;
         car1or[t+2] = new Cars();
         car1or[t+2].a = car1[t+2].a;
         
      } 
   
   
   int rand;
   
   for (int i = 0; i<=999; i++)
         {
         if (i<=5)
         {
            rows[i] = "gr";
            temp[i] = "gr";
         }
         else
         {
            rand = (int)(Math.random()*10+1);
            if(rand>=1 && rand<=4)
            {
               rows[i] = "gr";
               temp[i] = "gr";
            }
            else if (rand>=5 && rand<=7)
            {
               rows[i] = "ro";
               temp[i] = "ro";
            }
            else if (rand >=8 && rand<=9)
            {
               rows[i] = "w";
               temp[i] = "w";
            }
            else
            {
               rows[i] = "r";
               temp[i] = "r";
            }
        }
        
       } 
       int treerand; 
       for (int k = 1; k<=1000; k++)
       {
         if (temp[k-1].equals("gr"))
         {
            for (int o = 1; o<=12; o++)
            {
               treerand = (int)(Math.random()*25+1);
               if(treerand>=1 && treerand<=3)
               {
                  trees[k-1][o-1] = 1;
                  treesor[k-1][o-1] = 1;
               }
               else if (treerand==4)
               {
                  trees[k-1][o-1] = 2;
                  treesor[k-1][o-1] = 2;
               }
               else 
               {
                  trees[k-1][o-1] = 0;
                  treesor[k-1][o-1] = 0;
               }
             }
          }
        } 
        
        
       int coinrand; 
       for (int k = 1; k<=1000; k++)
       {
         if (temp[k-1].equals("gr")||temp[k-1].equals("ro") || temp[k-1].equals("r"))
         {
            for (int o = 1; o<=12; o++)
            {
               coinrand = (int)(Math.random()*35+1);
               if(coinrand==1 && trees[k-1][o-1] != 1 && trees[k-1][o-1] != 2 )
               {
                  coins[k-1][o-1] = 1;
                  coinsor[k-1][o-1] = 1;
               }

               else 
               {
                  coins[k-1][o-1] = 0;
                  coinsor[k-1][o-1] = 0;
               }
             }
          }
        }*/
      
       /*  int max = scores1[0];
         for( int i = 1; i < scores1.length; i++) // Iterate through the First Index and compare with max
        {
            // O(1)
            if( max <scores1[i])
            {
                // O(1)
                int temp = max;
                max = scores1[i];// Change max if condition is True
                scores1[i+1]= temp;
            }
        }  
          */           
                      
    
   } 

      
      
     
      
      
      
      



      
    public void mouseMoved (MouseEvent e) 
    {
      x = e.getX();
      y = e.getY();
      draw.repaint();
      draw1.repaint();
      draw2.repaint();
      draw3.repaint();
      draw4.repaint();
      draw5.repaint();
      
    }  
      
      
    public void mouseDragged (MouseEvent e)
    {
    }  
      
    public void mouseClicked (MouseEvent e)
    {
     if(numCoins <5)
      {
         System.out.println("Not enough Coins Keep Playing");
         
      }
         
      else if( frame2.isActive()&& purchased == false && x>=0 && x <=250 && y>=200 && y <= 450)
      { 
         inside = true;
         numCoins -=5;
         System.out.println("YOU HAVE PURCHASED THIS CHARACTER" );
         
         
        
         
      }
      
      
      else if(  frame2.isActive()&& purchased1 == false && x>=400 && x <=650 && y>=200 && y <= 450)
      { 
         inside1 = true;
        
         inside = false;
          numCoins -=5;
          System.out.println("YOU HAVE PURCHASED THIS CHARACTER" );
         
      }
      
      else if( frame2.isActive()&&purchased2 == false && x >= 800 && x<= 1050 && y >=200 && y <= 450)
      {
         inside2 = true; 
         
         inside1 = false;
          numCoins -=5;
          System.out.println("YOU HAVE PURCHASED THIS CHARACTER" );
         
      
      }
      
      else if( frame2.isActive()&&purchased3 == false && x>=0 && x<=250 && y>=500 & y <= 750)
      {
         inside2 = false; 
         
         inside3 = true;
          numCoins -=5;
          System.out.println("YOU HAVE PURCHASED THIS CHARACTER" );
         
      }
      
      else if( frame2.isActive()&&purchased4 == false && x>=400 && x<=650 && y>=500 & y <= 750)
      {
        
         inside3 = false;
         inside4 = true;
          numCoins -=5;
          System.out.println("YOU HAVE PURCHASED THIS CHARACTER" );

      }
      
      else if( frame2.isActive()&&purchased5 == false && x>=800 && x<=1050 && y>=500 & y <= 750)
      {
        
         inside4 = false;
         inside5 = true;
          numCoins -=5;
          System.out.println("YOU HAVE PURCHASED THIS CHARACTER" );

      }
      
      else if(  frame2.isActive()&& purchased1 == true && x>=400 && x <=650 && y>=200 && y <= 450)
      { 
         
         System.out.println("SELECT");
         isSelected = true;
         
         
         
      }
      
      else if(  frame2.isActive()&& purchased2 == true && x >= 800 && x<= 1050 && y >=200 && y <= 450)
      { 
         
         System.out.println("SELECT");
         isSelected1 = true;
         
         
         
      }

     else if(  frame2.isActive()&& purchased3 == true&& x>=0 && x<=250 && y>=500 & y <= 750)
      { 
         
         System.out.println("SELECT");
         isSelected2 = true;
         
         
         
      }


   else if(  frame2.isActive()&& purchased4 == true && x>=400 && x<=650 && y>=500 & y <= 750)
      { 
         
         System.out.println("SELECT");
         isSelected3 = true;
         
         
         
      }


   else if(  frame2.isActive()&& purchased5 == true && x>=800 && x<=1050 && y>=500 & y <= 750)
      { 
         
         System.out.println("SELECT");
         isSelected4 = true;
         
         
         
      }



     
     
     if(x>= 1090 && x<=1190 && y>=10 && y<=110)
      {
        frame.setVisible(false);
        frame1.setVisible(true);
        
      }
      
      else if(x>= 1000 && x<=1150 && y>=750 && y<=850)
      {
         inside = false;
         inside1 = false;
         inside2 = false;
         inside3 = false;
         inside4 = false;
         inside5 = false;
         frame1.setVisible(false);
         frame2.setVisible(false);
         frame3.setVisible(false);
         frame.setVisible(true);
        
      }
      
      else if(x>= 345 && x<=495 && y>=600 && y<=700)
      {
         frame.setVisible(false);
         frame2.setVisible(true);
      
      }
      else if(x>= 705 && x<=855 && y>=600 && y<=700)
      {
          
         frame3.setVisible(true);
         frame5.setVisible(false);
      }
      
      else  if (x>= 525 && x<=675 && y>=600 && y<=700)

      {
         frame.setVisible(false); 
          
          score = 0;
         cx = 600;
          cy = 500;
         hit = false;
          hit1= false;
          
          numFor = 0;
         numBack = 0;
         hitSound = 0;
          
          trainOn = false;
          
          
           for(int t = 0; t<=999; t++)
      {
         train1[t] = new Trains();
         train1[t].a = -1500 - (int)(Math.random()*10000);
         train1or[t] = new Trains();
         train1or[t].a = -1500 - (int)(Math.random()*10000);
      }   
      
      for(int t = 0; t<=1998; t+=2)
      {
         log1[t] = new Logs();
         log1[t].a = -300 - (int)(Math.random()*500);
         log1[t+1] = new Logs();
         log1[t+1].a = log1[t].a +500 + (int)(Math.random()*400);
         log1or[t] = new Logs();
         log1or[t].a = log1[t].a;
         log1or[t+1] = new Logs();
         log1or[t+1].a = log1[t+1].a;
      }  
      
      for(int t = 0; t<=2997; t+=3)
      {
         car1[t] = new Cars();
         car1[t].a = -300 - (int)(Math.random()*200);
         car1[t+1] = new Cars();
         car1[t+1].a = car1[t].a +400 + (int)(Math.random()*200);
         car1[t+2] = new Cars();
         car1[t+2].a = car1[t+1].a +400 + (int)(Math.random()*200);
         car1or[t] = new Cars();
         car1or[t].a = car1[t].a;
         car1or[t+1] = new Cars();
         car1or[t+1].a = car1[t+1].a;
         car1or[t+2] = new Cars();
         car1or[t+2].a = car1[t+2].a;
         
      } 
   
   
   int rand;
   
   for (int i = 0; i<=999; i++)
         {
         if (i<=5)
         {
            rows[i] = "gr";
            temp[i] = "gr";
         }
         else
         {
            rand = (int)(Math.random()*10+1);
            if(rand>=1 && rand<=4)
            {
               rows[i] = "gr";
               temp[i] = "gr";
            }
            else if (rand>=5 && rand<=7)
            {
               rows[i] = "ro";
               temp[i] = "ro";
            }
            else if (rand >=8 && rand<=9)
            {
               rows[i] = "w";
               temp[i] = "w";
            }
            else
            {
               rows[i] = "r";
               temp[i] = "r";
            }
        }
        
       } 
       int treerand; 
       for (int k = 1; k<=1000; k++)
       {
         if (temp[k-1].equals("gr"))
         {
            for (int o = 1; o<=12; o++)
            {
               treerand = (int)(Math.random()*25+1);
               if(treerand>=1 && treerand<=3)
               {
                  trees[k-1][o-1] = 1;
                  treesor[k-1][o-1] = 1;
               }
               else if (treerand==4)
               {
                  trees[k-1][o-1] = 2;
                  treesor[k-1][o-1] = 2;
               }
               else 
               {
                  trees[k-1][o-1] = 0;
                  treesor[k-1][o-1] = 0;
               }
             }
          }
        } 
        
        
       int coinrand; 
       for (int k = 1; k<=1000; k++)
       {
         if (temp[k-1].equals("gr")||temp[k-1].equals("ro") || temp[k-1].equals("r"))
         {
            for (int o = 1; o<=12; o++)
            {
               coinrand = (int)(Math.random()*35+1);
               if(coinrand==1 && trees[k-1][o-1] != 1 && trees[k-1][o-1] != 2 )
               {
                  coins[k-1][o-1] = 1;
                  coinsor[k-1][o-1] = 1;
               }

               else 
               {
                  coins[k-1][o-1] = 0;
                  coinsor[k-1][o-1] = 0;
               }
             }
          }
        }

      
         nextScorenum ++;
          m = new move();
          m1 = new moveT();
         m2 = new moveC();
         m.start();
         m1.start();
          m2.start();
      
          
          
          
          
          
          frame4.setVisible(true);
          
          
                   
          
     
      }
      
      // how to restart the game
      else if(frame5.isActive() && x>= 50 && x<=150 && y>=170&& y<=245)

      {  
         
         frame5.setVisible(false);
         frame4.setVisible(false); 
         frame.setVisible(true);
        
       }  
       
     else if(frame5.isActive() && x>= 250 && x<=350 && y>=170 && y<=245)
     {
         //scores1[0] = score;
         frame5.setVisible(false);
         frame3.setVisible(true);
         
     
     }


    }
    

   public void mousePressed (MouseEvent e)
   {
   }

   public void mouseReleased (MouseEvent e)
   {
   }

   public void mouseEntered (MouseEvent e)
   {
     

   }

   public void mouseExited (MouseEvent e)
   {
   }
      
      
   public void keyPressed(KeyEvent e)
   {
   
   
   if (!hit && ! hit1)
   {
      int typed = e.getKeyCode();
      if (typed == KeyEvent.VK_W) 
      {
         if (trees[9-cy/100][cx/100] ==0)
         {
            moveFor();
            //m3.interrupt();
            cx= (int)(Math.round(cx/100.0)*100);
         }
         if(coins[8-cy/100][cx/100] ==1)
         {
            try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/coin.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};
                  
            numCoins ++;
            coins[8-cy/100][cx/100] =0;
            coinsor[score + 8-cy/100][cx/100] =0;
         }
  
      }
      else if (typed == KeyEvent.VK_A)
      {
         if (cx > 0 && trees[8-cy/100][cx/100-1] ==0)
         {
            cx-=100;
            //character1.a-=100;
         }
         if(coins[8-cy/100][cx/100] ==1)
         {
             try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/coin.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};
            numCoins ++;
            coins[8-cy/100][cx/100] =0;
            coinsor[score + 8-cy/100][cx/100] =0;
         }
      }
      else if (typed == KeyEvent.VK_D)
      {
         if (cx<1100 && trees[8-cy/100][cx/100+1] ==0)
         {
            cx+=100;
            //character1.a+=100;
         }
         if(coins[8-cy/100][cx/100] ==1)
         {
             try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/coin.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};
            numCoins ++;
            coins[8-cy/100][cx/100] =0;
            coinsor[score + 8-cy/100][cx/100] =0;
         }
      }
      else if (typed == KeyEvent.VK_S)
      {
         if (trees[7-cy/100][cx/100] ==0)
         {
            moveBack();
            //m3.interrupt();
            cx= (int)(Math.round(cx/100.0)*100);
         }
         if(coins[8-cy/100][cx/100] ==1)
         {
             try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/coin.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};
            numCoins ++;
            coins[8-cy/100][cx/100] =0;
            coinsor[score + 8-cy/100][cx/100] =0;
         }
      }
       
      draw4.repaint(); 
      
      }
      
    }
   
   public void keyReleased(KeyEvent e)
   {}
   
   public void keyTyped(KeyEvent e)
   {}

   /*** moveFor *****************************************
   * Purpose: Moves the character forward                *
   *                                                     *
   * Parameters: none                                    *
   * Returns: none                                       *
   ******************************************************/ 
  public void moveFor()
   {
      numFor ++;
      score = numFor - numBack;
      int i = 0;
      int tempLENGTH = 1000;
      while (i<tempLENGTH)
      {
        
         temp[i] = temp[i+1];
         i++;
         tempLENGTH--;
      }
      
      int treesLENGTH = 1000;
      int f = 0;
      while (f< treesLENGTH)
      {
         for (int g = 0; g<= 11; g++)
         {
            trees[f][g] = trees[f+1][g];
            coins[f][g] = coins[f+1][g];
            
         }
         train1[f] = train1[f+1];
         for (int s = 0; s<=1; s++)
            log1[f] = log1[f+1];
         for (int s = 0; s<=2; s++)
            car1[f] = car1[f+1];
            
         f++;
         treesLENGTH--;
      }
      
    
      draw4.repaint();
   }   
   
   /*** moveBack *****************************************
   * Purpose: Moves the character back                   *
   *                                                     *
   * Parameters: none                                    *
   * Returns: none                                       *
   ******************************************************/ 
   public void moveBack()
   {
      numBack ++;
      score = numFor - numBack;
      int e = 0;
      int tempLENGTH = 1000;
      while (e<tempLENGTH)
      {
         temp[e] = rows[e+numFor -numBack];
         e++;
         tempLENGTH--;
      }
      
      int treesLENGTH = 1000;
      int h = 0;
      while (h< treesLENGTH)
      {
         for (int g = 0; g<= 11; g++)
         {
            trees[h][g] = treesor[h+numFor-numBack][g];
            coins[h][g] = coinsor[h+numFor -numBack][g];
         }
         train1[h] = train1or[h+ numFor-numBack];
         log1[h] = log1or[h+numFor-numBack];
         car1[h] = car1or[h+numFor-numBack];
         
         h++;
         treesLENGTH--;
      }

  
      draw4.repaint();
   } 
   
   

   
         

   
   class Logs 
   {
      int a;
      int b;
   
      public Logs()
      {
         a = -300;
         b=0;
      } 
      
      public Logs(int g)
      {
         a = g ;
         b=0;
      }
       
   }
   
   class Trains
   {
      int a; 
      long TIME; 
      int b;
      public Trains()
      {
         a = -1500;
         TIME = System.currentTimeMillis();
         b=0;
      }
      
      public Trains(int g)
      {
         a = g ;
         TIME = System.currentTimeMillis();
         b=0;
      }
   }
   
   class Cars
   {
      int a; 
      int col; 
      int b;
      public Cars()
      {
         a = -1500;
         col = (int)(Math.random()*3+1);
         b=0;
      }
      
      public Cars(int g)
      {
         a = g ;
         col = (int)(Math.random()*3+1);
         b=0;
      }
      
   }
   
   
   
    class Characters
   {
      int a; 
      public Characters()
      {
         a = 600;
      }

   }
   
   class move extends Thread
   {   
         
   /*** Run *********************************************
   * Purpose: Moves the logs and checks if character     *
   *          is on them                                 *
   * Parameters: none                                    *
   * Returns: none                                       *
   ******************************************************/        
       public void run()
      {
         try
         {
            while (true)
            {
               sleep(20);
               
               
               for (int r = 0; r<=1998; r++)
               {  
            
                  log1[r].a +=3;
                  if (log1[r].a >= WIDTH)
                  {
                    
                     log1[r].a = -300;
                  }
                 
             }    
               
             boolean logCheck = false;
             
             
               for(int i = 0; i<=1998; i++)
               {
        
                  if ( ((cx >= log1[i].a && cx <= (log1[i].a+210) && cy+50 >= (log1[i].b) && cy <= (log1[i].b+70))|| (cx+100 >= log1[i].a && cx+100 <= (log1[i].a+210) && cy+50 >= (log1[i].b) && cy <= (log1[i].b+70))))
                     logCheck = true;
               }
               
               if (logCheck)
               {
              
                     cx+=3;  
   
                }
                else if (temp[3].equals("w"))
                {
          
                     m.interrupt();
                     m1.interrupt();
                     m2.interrupt();
                     hit1 = true;
                     frame5.setVisible(true);
                     allscores[nextScorenum]= score;
                   //System.out.println(allscores[nextScorenum]);
                     nextScorenum ++;
          
                 }
                  
             
                   
                 if (cx >= WIDTH)
                  {
                    
                     cx -=1400;
                  }
                  
                  
               
                  
               
               
                  
               

               
            
                  
                  
               draw4.repaint();
            }
         }
         catch (InterruptedException e)
         {
         }
      }
        
       
   }
   
   
   class moveT extends Thread
   {   
         
   /*** run **********************************************
   * Purpose: Moves the train                            *
   *                                                     *
   * Parameters: none                                    *
   * Returns: none                                       *
   ******************************************************/        
       public void run()
      {
         try
         {
            while (true)
            {
               sleep(20);
                                 
                for (int r = 0; r<=999; r++)
               {  
                  if (System.currentTimeMillis() - train1[r].TIME >7000)
                  {              
                     train1[r].a +=10;
                     if (train1[r].a >= WIDTH)
                     {
                        train1[r].TIME = System.currentTimeMillis();
                        train1[r].a = -1500;
                                         
                     
                     }
                  
                 
                  /* for (int i = 0; i <=8; i++)
                  {
                     if (temp[i].equals("r"))
                        trainOn = true;
                  }
                  
                  if (train1[r].a == -1200 && trainOn)
                  {
                     try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/train.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};

                  
                  
                  }*/
                  

                  
                  
                  }
                  
                  
                  
                  
             }    
                  
               draw.repaint();
            }
         }
         catch (InterruptedException e)
         {
         }
      }
        
       
   }
   
   
   class moveC extends Thread
   {   
         
       /*** run *****************************************
   * Purpose: Moves the car                              *
   *                                                     *
   * Parameters: none                                    *
   * Returns: none                                       *
   ******************************************************/        
       public void run()
      {
         try
         {
            while (true)
            {
               sleep(25);
               
               
               for (int r = 0; r<=2997; r++)
               {  
            
                  car1[r].a +=5;
                  if (car1[r].a >= WIDTH)
                  {
                    
                     car1[r].a = -300;
                  }
                 
             }    

                
                  
               draw.repaint();
            }
         }
         catch (InterruptedException e)
         {
         }
      }
        
       
   }
         
   
   class Drawing extends JComponent
   {
      /*** paint ********************************************
   * Purpose: Prints the number of times the button was  *
   *          clicked                                    *
   * Parameters: g - Graphics object for drawing on      *
   * Returns: none                                       *
   ******************************************************/
      
      public void paint(Graphics g)
      {
      
         Font font = null;
         Font f = null;
    
         try{
         AffineTransform at = new AffineTransform();
         at.scale(100,100);
         at.shear(0,0.25);
         
         font = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);
         f = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);

         }catch(IOException| FontFormatException e){}   
         
         g.setFont(font);
         g.drawString("Kaizy",405,110);
         g.drawString("Road",447,210);
         g.drawString("Kaizy",405,130);
         g.drawString("Road",447,230);
         
         g.drawString("Kaizy",395,120);
         g.drawString("Road",437,220);
         g.drawString("Kaizy",415,120);
         g.drawString("Road",457,220);
         
         
         for (int p = 1; p <= 40; p++)
         {
            g.drawString("Kaizy",405+p,120-p);
            g.drawString("Road",447+p,220-p);
         }
         
         g.setFont(f);
         g.setColor(Color.WHITE);
         
         
         g.drawString("Kaizy",405,120);
         g.drawString("Road",447,220);
         
         
         
         if (x>= 345 && x<=495 && y>=600 && y<=700)
            g.drawImage(c2.getImage(), 345, 600, 150, 100, this); 
         else 
            g.drawImage(c.getImage(), 345, 600, 150, 100, this); 
         
         
        if (x>= 525 && x<=675 && y>=600 && y<=700)
            g.drawImage(p2.getImage(), 525, 600, 150, 100, this);
         else 
            g.drawImage(p.getImage(), 525, 600, 150, 100, this); 
        
        
       if (x>= 705 && x<=855 && y>=600 && y<=700)
            g.drawImage(l2.getImage(), 705, 600, 150, 100, this);
         else 
            g.drawImage(l.getImage(), 705, 600, 150, 100, this);  
         
         
      if (x>= 1090 && x<=1190 && y>=10 && y<=110)
            g.drawImage(i.getImage(), 1090, 10, 100,100, this);
         else 
            g.drawImage(i2.getImage(), 1090, 10, 100,100, this);  
      
      
     
         
       
         
         
      }
      
    
   }   
 
    class Drawing2 extends JComponent
   {
      
      /*** paint ********************************************
   * Purpose: Prints the number of times the button was  *
   *          clicked                                    *
   * Parameters: g - Graphics object for drawing on      *
   * Returns: none                                       *
   ******************************************************/
      public void paint(Graphics g)
      {
     
         Font font = null;
         Font f = null;
         
          try{
         AffineTransform at = new AffineTransform();
         at.scale(100,100);
         at.shear(0,0);
         
         font = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);
         f = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);

         }catch(IOException| FontFormatException e){}   
         g.setFont(font);
         g.drawString("Instructions",55,120);
        
         g.drawString("Instructions",55,140);
        
         
         g.drawString("Instructions",45,130);
        
         g.drawString("Instructions",65,130);
         
   
    
      

        
         
         
         for (int p = 1; p <= 40; p++)
         {
            g.drawString("Instructions",55+p,130-p);
            g.drawString("W", 75+p,450-(p-20));
            g.drawString("S", 600+p,450-(p-20));
            g.drawString("A", 75+p,685-(p-20));
            g.drawString("D", 600+p,685-(p-20));
         }
         
         g.setFont(font);
         g.setColor(Color.WHITE);
         
         
         g.drawString("Instructions",55,130);
         g.drawString("W", 75,465);
         g.drawString("A", 75,700);
         g.drawString("S", 600,465);
         g.drawString("D",600,700);
         
        
         Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 75); 
         g.setFont(f1);
         g.setColor(Color.WHITE);
         g.drawString("use WASD keys to get Kaizy",55,220);
         g.drawString("across as many roads as possible!!!!",55,300);
         Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 100); 
         g.setFont(f2);
         g.drawString("UP",350,430);
         g.drawString("DOWN",785,430);
         g.drawString("LEFT",300,665);
         g.drawString("RIGHT",785,665);
         
         
         if (x>= 1000 && x<=1150 && y>=750 && y<=850)
         {
            g.drawImage(b2.getImage(), 1000, 750,150, 100, this); 
           
         }
         else 
          {
            g.drawImage(b.getImage(), 1000, 750, 150, 100, this); 
           
             
           }
      
      }
      
   }
   
   class Drawing3 extends JComponent
   {
        Font font = null;
         Font f = null;
         
         /*** paint ********************************************
   * Purpose: Prints the number of times the button was  *
   *          clicked                                    *
   * Parameters: g - Graphics object for drawing on      *
   * Returns: none                                       *
   ******************************************************/
         public void paint(Graphics g)
         {

          try{
         AffineTransform at = new AffineTransform();
         at.scale(100,100);
         at.shear(0,0);
         
         font = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);
         f = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);

         }catch(IOException| FontFormatException e){}   
         g.setFont(font);
         g.drawString("Characters",55,120);
        
         g.drawString("Characters",55,140);
        
         
         g.drawString("Characters",45,130);
        
         g.drawString("Characters",65,130);
         for (int p = 1; p <= 40; p++)
         {
            g.drawString("Characters",55+p,130-p);
          }
         
         g.setFont(font);
         g.setColor(Color.WHITE);
         
         
         g.drawString("Characters",55,130);
         
           
         
         if (x>= 1000 && x<=1150 && y>=750 && y<=850)
         {
            g.drawImage(b2.getImage(), 1000, 750,150, 100, this); 
           
         }
         else   
          {
            g.drawImage(b.getImage(), 1000, 750, 150, 100, this); 
           
          }
          if( inside == true)
          {
            
            g.setColor(Color.GREEN);
            g.fillRect(0,190,260,270);
            purchased = true;
          }
          
          else if(inside1 == true)
          {
            g.setColor(Color.GREEN);
            g.fillRect(390,190,270,270);
            purchased1 = true;

          }
          
          else if(inside2 == true)
          {
            g.setColor(Color.GREEN);
            g.fillRect(790,190,270,270);
            purchased2 = true;
          }
          
          else if (inside3 == true)
          {
            g.setColor(Color.GREEN);
            g.fillRect(0,490,270,270);
            purchased3 = true;
            
          }
         
          else if (inside4 == true)
          {
            g.setColor(Color.GREEN);
            g.fillRect(390,490,270,270);
            purchased4 = true;
          }
           
           
           else if (inside5 == true)
          {
            g.setColor(Color.GREEN);
            g.fillRect(790,490,270,270);
            purchased5 = true;
          }


         
         g.drawImage(k1.getImage(), 0, 200, 250, 250, this);   
         g.drawImage(k2.getImage(), 400, 200, 250, 250, this); 
         g.drawImage(k3.getImage(), 800, 200, 250, 250, this); 
         g.drawImage(k4.getImage(), 0, 500, 250, 250, this); 
         g.drawImage(k5.getImage(), 400, 500, 250, 250, this); 
         g.drawImage(k6.getImage(), 800, 500, 250, 250, this);   
         
         Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 65); 
         g.setColor(Color.BLACK);
         g.setFont(f1);
   
         g.drawString("CLICK ONCE TO BUY",100,820);
         g.drawString("DOUBLE CLICK TO SELECT", 100,870);

  
      
   }
   
  }
  
  

  class Drawing4 extends JComponent //leaderboard
  {
        /*** paint ********************************************
   * Purpose: Prints the number of times the button was  *
   *          clicked                                    *
   * Parameters: g - Graphics object for drawing on      *
   * Returns: none                                       *
   ******************************************************/
  
         public void paint(Graphics g)
         {
         int largest = allscores[0];
         for (int k = 0; k<=4; k++)
         {
            
            for (int i = 1; i<=49; i++)
            { 
            
               if(allscores[i]>largest )
               {
                  largest = allscores[i];
                  //allscores[i]=0;
                }
            }
            scores1[k] = largest; 
         }
            
         
                 
         Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 75); 
         
         g.setFont(f1);
         
         
         g.setColor(Color.WHITE);
         g.drawString("1.",10,170);
         g.drawString("" + allscores[0],300,170);
         g.drawString("2.",10,330);
          g.drawString("" + allscores[1],300,330);
         g.drawString("3.", 10,490);
          g.drawString("" + allscores[2],300,490);
         
         g.drawString("4.",10,650);
          g.drawString("" + allscores[3],300,650);
         g.drawString("5.",10,810);
          g.drawString("" + allscores[4],300,810);
          g.drawImage(lead.getImage(),-200,-17,900,150, this);

      
  }
}


class Drawing5 extends JComponent
   {
   /*** paint ********************************************
   * Purpose: Prints the number of times the button was  *
   *          clicked                                    *
   * Parameters: g - Graphics object for drawing on      *
   * Returns: none                                       *
   ******************************************************/
      
      public void paint(Graphics g)
      {
        
        
        for(int i = 0; i<=999; i++)
        {
            
            if ((cx >= train1[i].a && cx <= (train1[i].a+1500) && cy >= (train1[i].b) && cy <= (train1[i].b+150))|| (cx+100 >= train1[i].a && cx+100 <= (train1[i].a+1500) && cy >= (train1[i].b) && cy <= (train1[i].b+150)))
            
            {
              
               m.interrupt();
               m1.interrupt();
               m2.interrupt();
               frame5.setVisible(true);
               hit = true;
               
          
               
               
                if (hit == true && hitSound<1)
        {
               hitSound ++;
               allscores[nextScorenum]= score;
               System.out.println(allscores[nextScorenum]);
               nextScorenum ++;
        try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/hit.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};
        }     

               
            }
        } 
        
         for(int i = 0; i<=2997; i++)
        {
            if ((cx >= car1[i].a && cx <= (car1[i].a+210) && cy >= (car1[i].b) && cy <= (car1[i].b+155))||(cx+100 >= car1[i].a && cx+100 <= (car1[i].a+210) && cy >= (car1[i].b) && cy <= (car1[i].b+155)))
            
            {
              
                             m.interrupt();
               m1.interrupt();
               m2.interrupt();
                hit = true;
               
          
                  
                   if (hit == true && hitSound <1)
        {
        hitSound ++;
         allscores[nextScorenum]= score;
               System.out.println(allscores[nextScorenum]);
            nextScorenum ++;
        try
            {
               AudioClip open  = Applet.newAudioClip(new             
                              URL("file:/Users/serenahacker/Desktop/Project/hit.wav"));
               open.play();
            } catch (MalformedURLException murle) 
                  {};
        }     

                  
                  
                frame5.setVisible(true);
                
            
               
            }
        } 
        
        
         
        
        if (temp[8- cy/100].equals ("w"))
        {
            for (int j = 0; j<=(3+numFor -numBack); j++)
            {
               if (rows[j].equals("w"))
               {
                  logNum+=2;
               }
            } 
            
                        
            
        }
        

        for (int p = 0; p <=8; p++)
        {
            if (temp[p].equals ("ro"))
            {
               g.drawImage(ro.getImage(), 0, 800-p*100, 1200, 100, this);
               
            }
            else if (temp[p].equals("gr"))
            {
               g.drawImage(gr.getImage(), 0, 800-p*100, 1200, 100, this);
          

               
            }
            else if (temp[p].equals("w"))
            {
               g.drawImage(w.getImage(), 0, 800-p*100, 1200, 100, this);
               
               
               for (int d = 0; d<=1; d++)
               {
               g.drawImage(log.getImage(), log1[p+d].a, 745-((p-1)*100+30), 210, 70, this);
               log1[p+d].b = 745-((p-1)*100+30);
               }

               

   
            }
            else 
            {
               g.drawImage(r.getImage(), 0, 800-p*100, 1200, 100, this);
    
             }
        }
      
      
      if(isSelected == true)
      {
        g.drawImage(k2.getImage(),cx,cy,100,100,this);
      } 
     else if(isSelected1 == true)
      {
        g.drawImage(k3.getImage(),cx,cy,100,100,this);
      } 
      else if(isSelected2 == true)
      {
        g.drawImage(k4.getImage(),cx,cy,100,100,this);
      } 
      
      else if(isSelected3 == true)
      {
        g.drawImage(k5.getImage(),cx,cy,100,100,this);
      } 
        
      else if(isSelected4 == true)
      {
        g.drawImage(k6.getImage(),cx,cy,100,100,this);
      } 
    else 
        g.drawImage(k1.getImage(), cx, cy, 100, 100, this);
        
           
        for (int c = 8; c >=0; c--)
        {
            if (temp[c].equals("gr"))
            {
              for (int d = 0; d <=11; d++)
               {
                  if(trees[c][d] ==1)
                     g.drawImage(t.getImage(), d*100, 700-((c-1)*100 + 55), 100, 130, this);
                  if (trees[c][d] ==2)
                     g.drawImage(at.getImage(), d*100, 700-((c-1)*100 + 55), 100, 130, this);
                  if (coins[c][d] ==1)
                     g.drawImage(coin.getImage(), d*100+22, 775-((c-1)*100 + 55), 65, 65, this);  
                  
                }
             }
             
             
             if  (temp[c].equals("ro"))
             {
               for (int d = 0; d<=11; d++)
               {
                  if (coins[c][d] ==1)
                     g.drawImage(coin.getImage(), d*100+22, 775-((c-1)*100 + 55), 65, 65, this);
               }
               for (int d=0; d <=2; d++)
               {
                  if (car1[c+d].col == 1)
                     g.drawImage(redcar.getImage(), car1[c+d].a, 670-((c-1)*100+30), 210, 155,this);
                  else if (car1[c+d].col ==2)
                     g.drawImage(bluecar.getImage(), car1[c+d].a, 670-((c-1)*100+30), 210, 155,this);
                  else 
                     g.drawImage(yellowcar.getImage(), car1[c+d].a, 670-((c-1)*100+30), 210, 155, this);
                  car1[c+d].b = 670-((c-1)*100+30);
               }
               
             }

             
             if  (temp[c].equals("r"))
             {
             
               for (int d = 0; d<=11; d++)
               {
                  if (coins[c][d] ==1)
                     g.drawImage(coin.getImage(), d*100+22, 775-((c-1)*100 + 55), 65, 65, this);
               }
               
               g.drawImage(train.getImage(), train1[c].a, 620-((c-1)*100), 1500, 150, this);
               train1[c].b = 620-((c-1)*100);
               if (train1[c].a == 1200 || train1[c].a <=-1500)
                  g.drawImage(green.getImage(), 780, 682-((c-1)*100), 40, 120, this); 
               else 
                  g.drawImage(red.getImage(), 780, 682-((c-1)*100), 40, 120, this);
               
             }
             
             
                          
                
         }


        
         g.drawImage(coin.getImage(), 1120, 60, 65, 65, this);
        
         Font font = null;
        
        try{
         AffineTransform at = new AffineTransform();
         at.scale(80,80);
         
         font = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);
         

         }catch(IOException| FontFormatException e){}   
         
        
         
         g.setFont(font);
         
         if (score>=0)
         {
            for (int p = 1; p <= 20; p++)
               g.drawString(""+score,50+p,130-p);
            
            g.setColor(Color.WHITE);
         
         
            g.drawString(""+score,50,130);

         }
         else 
         {
            for (int p = 1; p <= 20; p++)
               g.drawString("0",50+p,130-p);
            
            g.setColor(Color.WHITE);
         
         
            g.drawString("0",50,130);
         }
        
        
         g.setColor(Color.BLACK);
         int v; 
         if (numCoins <= 19)
         {
            v = 1000; 
         }
         else 
            v = 950;
         
         for (int p = 1; p <= 20; p++)
               g.drawString(""+ numCoins,v+p,130-p);
         g.setColor(Color.ORANGE);
         
         g.drawString(""+numCoins,v,130);
         
                      
      }
      
   }
   
   
   class Drawing6 extends JComponent
   {
        Font font = null;
         Font f = null;
        
        /*** paint ********************************************
   * Purpose: Prints the number of times the button was  *
   *          clicked                                    *
   * Parameters: g - Graphics object for drawing on      *
   * Returns: none                                       *
   ******************************************************/
        
         public void paint(Graphics g)
         {

          try{
         AffineTransform at = new AffineTransform();
         at.scale(38,38);
         at.shear(0,0);
         
         font = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);
         f = Font.createFont(Font.TRUETYPE_FONT, new File("8bit.ttf")).deriveFont(at);

         }catch(IOException| FontFormatException e){}   
         g.setFont(font);
         g.setColor(Color.WHITE);
         g.drawString(""+score,170,70);
         g.drawString("great score",5,150);
         if (x>= 50 && x<=150 && y>=170&& y<=245)
         {
            g.drawImage(b2.getImage(),50,170,100,75 , this); 
           
         }
         else 
          {
            g.drawImage(b.getImage(),50 ,170 ,100 ,75 , this); 
           
             
           }
           
         if (x>= 250 && x<=350 && y>=170 && y<=245)
            g.drawImage(l2.getImage(), 250, 175, 100, 75, this);
         else 
            g.drawImage(l.getImage(), 250, 170, 100, 75, this);  


         
   }
   }

   /*** actionPerformed **********************************
   * Purpose: Deal with the button being pressed         *
   * Parameters: e - details about the button event      *
   * Returns: none                                       *
   ******************************************************/
    public void actionPerformed(ActionEvent e)
    {
      
    }

    
   public static void main(String [] args)
   {

      new KaizyRoa();
      
      
   }
}