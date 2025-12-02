import java.util.*;

public class asciiAnimator
{

    private static final String HOME       = "\u001B[H";
    private static final String HIDE_CURSOR= "\u001B[?25l";
    private static final String SHOW_CURSOR= "\u001B[?25h";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_MAGENTA = "\u001B[35m";
    private static final String ANSI_BOLD = "\u001B[1m";
    private static final String CLEAR = "\033[H\033[2J";

     public static void main(String[] args)
    {
        playOpeningAnimation();  
    }
    private static void playOpeningAnimation() 
    {
        List<String> frames = getFrames();

        int fps = 10;
        long frameTime = 1000 / fps;

        
        try 
        {
            //Hide the cursor, make the color red
            System.out.print(HIDE_CURSOR);
            System.out.print(ANSI_RED);

            int i = 0;
            for (String frame : frames) {
                long t0 = System.nanoTime();

                System.out.print(CLEAR);
                System.out.print(HOME);


                //print the frame
                System.out.print(frame);
                System.out.flush();

                long elapsedMs = (System.nanoTime() - t0) / 1_000_000;
                long sleepMs = Math.max(0, frameTime - elapsedMs);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break; // break from the animation
                }
                i++;

            }

                // Animation is over
                System.out.print(ANSI_RESET);
                System.out.print(SHOW_CURSOR);
                System.out.println("by:  Yavuz Selim Yaşar, Volkan Dinç,  Kemal Ege İncereis,  İdil Zeren Çoban");
            } 
            finally
            {
                // Clean the terminal no matter what
                System.out.print(ANSI_RESET);
                System.out.print(SHOW_CURSOR);
                System.out.flush();
            }

    }
     private static List<String> getFrames() 
    {    
        String f[] = new String[] {
            """
            """,
            """
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ░██▓█                                                                             
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                    ░                                                                                  
                                                                                     ▒                                                                                 
                                                                                     ██░                                                                               
                                                                                    ███▓                                                                               
                                                                                   ▒                                                                                   
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                                                                                                      
                                                                                          
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ▒                                                                                 
                                                                                                                                                                       
                                                                                    ▒█                                                                                 
                                                                                   ████                                                                                
                                                                                  ███▓▒                                                                                
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     █                                                                                 
                                                                                     ███                                                                               
                                                                                    ▓████                                                                              
                                                                                  ██████                                                                               
                                                                                  ██████                                                                               
                                                                                    ██▓                                                                                
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ░                                                                                 
                                                                                     ▒     ░ ░░░░                                                                      
                                                                                     █   ░▒░▓░░░░                                                                      
                                                                                     ▓   ▓░░▓░░░░                                                                      
                                                                                     ██▒░░░░░░░░                                                                       
                                                                                      ░░░░░░                                                                           
                                                                                                                                                                       
                                                                                     ▒▒                                                                                
                                                                                     ▓░                                                                                
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ░                                                                                 
                                                                                     ▒                                                                                 
                                                                                ░    ░                                                                                 
                                                                                █▒░             ░                                                                      
                                                                                 █▓  ▓       ░▓▓█▓                                                                     
                                                                                   ░  ░█▓▓████▓▒░                                                                      
                                                                                    █     ░ ░░░░                                                                       
                                                                                    ▓▓                                                                                 
                                                                                    ▓▓                                                                                 
                                                                                      ▒                                                                                
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                           ░░▒▒░░░    ░░                                                                               
                                                                         ▓░▒█░░░░░    ░░░░░▒                                                                           
                                                                        ░░▓█▓░░░░░     ░░█░ ▒                                                                          
                                                                         ▒ ░▒░░░░ ░     ░░▒▒░▓                                                                         
                                                                               ░   ▒░▒  ░░░░▓▓                                                                         
                                                                                    ▒░       ▓█                                                                        
                                                                                   ░░                                                                                  
                                                                                    ░                                                                                  
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                      ░                                                                                
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ░                                                                                 
                                                                                     ░       ░░░░░░░░░░                                                                
                                                                  ░░░░░░  ░░░░░▒░░       ░░░░░░░░░░░░░░                                                                
                                                                    ░░░░░░░░▒▒░▓▒░░    ░░░▒█▒▒▒▒▒▒▒░░                                                                  
                                                                    ░░▓▒░░░░░░░░░░░    ░░░░░░░░░░░░░░                                                                  
                                                                    ░░░░░░░░░░░░░░      ░░░░░░░░░░░░░                                                                  
                                                                      ░░░░░░░░░░░        ░░░░░░░░░░                                                                    
                                                                                               ░                                                                       
                                                                                                                                                                       
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ▒                                                                                 
                                                                                    ▒░       ░▓▓▒▒▒▓▒░░                                                                
                                                                  ░░░░░░░░░▒▒▒▒▒         ▒▒▒█▒░░░░░░░░                                                                 
                                                                 ░░░░░░░░░░░░░░░▓░▒   ░░▒▒░░░░░░░░░░░░                                                                 
                                                                   ░░░░░░░░░░░░░░░░░   ░░░░░░░░░░░░░░░                                                                 
                                                                    ░░░░░░░░░░░░░░░     ░░░░░░░░░░░                                                                    
                                                                       ░░  ░░             ░  ░░░░                                                                      
                                                                                    ░░                                                                                 
                                                                                    █▒                                                                                 
                                                                                    ▒░                                                                                 
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                   ░▒            ░                                                                     
                                                                      ▒▒▒▒▒░                ░▒▒▒▒░▒░                                                                   
                                                                    ░░░░░░░░▒▒░▒▒        ▒▒▓▒░░░░░░░                                                                   
                                                                    ░░ ░░░░░░░░░░▓░   ▒▓▒░░░░░░░░░░                                                                    
                                                                      ░░░░░░░░░░░░░    ░░░░░░░░░░░░                                                                    
                                                                         ░░░░░░░░░      ░░░░░░░░░                                                                      
                                                                             ░                                                                                         
                                                                                    ██                                                                                 
                                                                                    █▒                                                                                 
                                                                                    ░░                                                                                 
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                 █                                                                                     
                                                                               ▒████                                                                                   
                                                                     ░              ▓           ▒░░                                                                    
                                                                      ░░░                     ░░░░                                                                     
                                                                        ░░░░░▒░░░░▒  ▒▒▒▒▒░░░░░░                                                                       
                                                                          ░░░░░░░░    ░░░░░░░                                                                          
                                                                                     ▒                                                                                 
                                                                                    ░                                                                                  
                                                                                   ▓░▒                                                                                 
                                                                                    ░▒                                                                                 
                                                                                    ░                                                                                  
                                                                                    ░                                                                                  
                                                                                    ░                                                                                  
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                              █▒███░                                                                                   
                                                                              ██████                                                                                   
                                                                               ▓▒█▓ █                                                                                  
                                                                                     ▒   ░▒▒▒░      ░▒▒▓▓▒▓▒                                                           
                                                                  ░▒░░░░░▓▓▓▓▓▓▓▓▓   ░▒▒▒▒▒▒▒░░▒▒░░▒▒▒▓▓▓░                                                             
                                                                 ░░░░░░░░░░░░░   ▒█ █  ░░░░░░░░░░░░                                                                    
                                                                                    ░                                                                                  
                                                                                   ░░▓                                                                                 
                                                                                   █▒█                                                                                 
                                                                                    ░█                                                                                 
                                                                                    ░                                                                                  
                                                                                    ░                                                                                  
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ░                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                              ░ ░ ░▒                                                                                   
                                                                             ░█████▒                                                                                   
                                                                             ░███████▒▓                                                                                
                                                                             ▓████    ░░▓▓                                                                             
                                                                           ░░░░░░░  ▓      ░▒▓░                                                                        
                                                                        ░░░░                   █████▒                                                                  
                                                                     ▓▒░           ░░            ██████▒                                                               
                                                                ░▒░▒░░             █░░             ░██████░                                                            
                                                                ▒░░░               ▒░                 ▒██░░                                                            
                                                             ▒  ░                   ░                                                                                  
                                                                                    ░                                                                                  
                                                                                    ░                                                                                  
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                     ▓                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                ▒░ ▒                                                                                   
                                                                             ██████▒  ██░                                                                              
                                                                          ▒█▒██████▓   ▓██▒                                                                            
                                                                       ░▓▓░░░███████     ████                                                                          
                                                                      █▓░░        ░░░    █████▓                                                                        
                                                                     ▒▒░           ░▓    ██████▓                                                                       
                                                                     ▒░                   ██████                                                                       
                                                                    █░░                   ▓██████                                                                      
                                                                   ▒░░░                    ██████                                                                      
                                                                   █░░                      █████░                                                                     
                                                                  █░                        ▓█████                                                                     
                                                                 ▓▓                          ██ ██                                                                     
                                                                ░ ░                           █▒  █                                                                    
                                                                                               ▓                                                                       
                                                                                     ░                                                                                 
                                                                                     ░                                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                            ▒▒░      ░▓░                                                                               
                                                                         ░▓▓▓▒██████ ▒█████▓                                                                           
                                                                       ░▒░█████████    ███████▓                                                                        
                                                                      █░▒▓░████████▒    ▓███████                                                                       
                                                                     █░█░░▒████████      ░███████                                                                      
                                                                     ░░▓░░▒████████░▓      ██████░                                                                     
                                                                     ░░▓░░ █████░░▒▓░     ░███████                                                                     
                                                                    █░░█░░  ▒░░     ░     ▓███████                                                                     
                                                                    █░░█░░░               ███████▓                                                                     
                                                                    █░░█░░░░             ████████                                                                      
                                                                    █░░▒░░░              ███████                                                                       
                                                                     ░░░▓░░             ██████▓                                                                        
                                                                      ░░  ░             █████░                                                                         
                                                                      ░░               █ ██▒                                                                           
                                                                       ░                ▒░░                                                                            
                                                                        ░                                                                                              
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                        ░░░          ░█████▓░                                                                          
                                                                 ▒██████▓▒░▒█████▓██▒▓▓██████████░                                                                     
                                                               ░██████      ░█████░▒         ▒██████                                                                   
                                                              █████░░     █▓█████░▓█            ██████                                                                 
                                                             ████░░░      ██████████             ██████                                                                
                                                            █▒█▒░░░░     ████████████            ▓██████                                                               
                                                           ▓░░▓░░░       ████████████░            ██████░                                                              
                                                          ▒░░█░░░░       █████████████▒           ███████                                                              
                                                         ░░░░█░░░░      ▒████████████ ░           ▓██████░                                                             
                                                         ▒ ░▓░░░░       ░███████████  █            ███████                                                             
                                                        █░  █░░░         ██████████░ ▒█            ███████                                                             
                                                       ▒░░  █░░░          ████████   ░            ░██████▒                                                             
                                                       ▓░░  ▓░░░           ███▓█                  ███████                                                              
                                                      ▒  ░   ░░                                   ███▓██                                                               
                                                      ▒      ▒                                   ███░░██                                                               
                                                             ▓                                  ░██▓ ░█                                                                
                                                                                                 █   ▒                                                                 
                                                                                                     ▓                                                                 
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                           ░████████▒                                                                                                                  
                                      ███████████████████▒                                              ▒▓▓▒                                                           
                                   ▓████████████████████████▒                                    ▒▓████████████▓░                                                      
                                 ███████████████████████████████████▓░                      ░▓█████████████████████▒                                                   
                               ▓███████████████████████████████████████▓             ░▒▒▓▓█████████████████████████████                                                
                              ████████████████████████████████████████████         ██████████████████████████████████████                                              
                             ██████████████████████████████████████████████▒ ░█████████████████████████████████████████████                                            
                            ██████████████▓▓▒▒░░░        ▒██████████████████████████████████████████████████████████████████                                           
                           ███████████░  ░░░░                 ▒██████████████████████████         ▒█████████████████████████▓                                          
                           ████   ░░                              ░███████████████████░                ██████████████████████                                          
                           ██                                        ░██████████████▒                     ▒██████████████████▓                                         
                           ▓                                           ░▓██████████░  █                      ▓████████████████                                         
                                                                       █░██████████▓  █                        ▒██████████████                                         
                                                                      ░█████████████  █                          ▒█████▒░█████                                         
                                                                      █████████████▓                               █████ ░███                                          
                                                                     ▒█████████████▓▓                               ░██▒  ▓█▒                                          
                                                                     ████████████████                                ░██   █▒                                          
                                                                     ████████████████                                 ▒▓                                               
                                                                     ████████████████                                                                                  
                                                                     ████████████████                                                                                  
                                                                    ██████████████████                                                                                 
                                                                    ██████████████████                                                                                 
                                                                    ██ ██████████████                                                                                  
                                                                  ▒ █████████████████                                                                                  
                                                                   ██████████████████                                                                                  
                                                                   █████████████████▓                                                                                  
                                                                   ▒████████████████                                                                                   
                                                                    ███████████████                                                                                    
                                                                     ████████████░                                                                                     
                                                                      ██▒████▓██                                                                                       
                                                                       ███████▓                                                                                        
                                                                       ▓█████▓                                                                                         
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
            """,
            """   
            ██████████████████████████████                                                                                 ░██████████████████████████████████▓                 
    ███████████████████████████████                                                                             ░███████████████████████████████████                   
     █████████████████████████████████                                                                        ▓████████████████████████████████████                    
      ▒████████████████████████████████████▓                                                               ▓█████████████████████████████████████           ▓          
 ░▒██████████████████████████████████████████                                                            ██████████████████████████████████████    ░▒▒▓██████          
██████████████████████████████████████████████▒                                                         ██████████████████████████████████████████████████████         
████████████████████████████████████████████████░                                                      ████████████████████████████████████████████████████████        
██████████████████████████████████████████████████▒                                                  ████████████████████████████████████████████████████████████░     
█████████████████████████████████████████████████████                         █                   ██████████████████████████████████████████████████████████████████░  
███████████████████████████████████████████████████████▓                    ████▒            ▓█████████████████████████████████████████████████████████████████████████
██████████████████████████████████████████████████████████▓▒              ████████      ▓██████████████████████████████████████████████████████████████████████████████
█████████████████████████████████████████████████████████████▓           ▓████████░    ░███████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████         ░█████████░   ░███████████████████████████████████████████████████████████████████████████████░
████████████████████████████████████████████████████████████████        ██████████░  █████████████████████████████████████████████████████████████████████████████▒    
█████████████████████████████████████████████████████████████████      ░██████████▒ ██████████████████████████████████████████████████████████████████████████▓░       
██████████████████████████████████████████████████████████████████░   ░████████████████████████████████████████████████████████████████████████████████████▒           
████████████████████████████████████████████████████████████████████ ░█████████████████████████████████████████████████████████████████████████████████▒               
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████                    
   ░█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████▒                         
          ▒▓████████▒                       ░▒▓███████████████████████████████████████████████████████▓░                     ░▓██████▓▓▓▒░                             
                                                  ░███████████████████████████████████████████████▒░                                                                   
                                                     ░█████████████████████████████████████████▒                                                                       
                                                         ███████████████████████████████████░                                                                          
                                                            ██████████████████████████████                                                                             
                                                               ███████████████████████████                                                                             
                                                               ███████████████████████████                                                                             
                                                               ███████████████████████████                                                                             
                                                           ░   ███████████████████████████                                                                             
                                                           █▒ ▒██████████████████████████░  ▓                                                                          
                                                           ██ ▒██████████████████████████   ██                                                                         
                                                           ███▓█████████████████████████▓  ███                                                                         
                                                           █████████████████████████████ ▒███░                                                                         
                                                         ▓  █████████████████████████████████                                                                          
                                                         █▓░████████████████████████████████                                                                           
                                                         ███████████████████████████████████                                                                           
                                                         ███████████████████████████████████   ▒                                                                       
                                                         ███████████████████████████████████ ▒█                                                                        
                                                         █████████████████████████████████████                                                                         
                                                         █████████████████████████████████████                                                                         
                                                         █████████████████████████████████████                                                                         
                                                         ▒███████████████████████████████████                                                                          
                                                       █▒████████████████████████████████████                                                                          
                                                       ██████████████████████████████████████                                                                          
                                                       ██████████████████████████████████████                                                                          
                                                       ░████████████████████████████████████                                                                           
                                                        ███████████████████████████████████                                                                            
                                                        ███████████████████████████████████  ▒                                                                         
                                                         █████████████████████████████████ ▓█                                                                          
                                                         ▓██████████████████████████████████                                                                           
                                                          ███████▒█████████████████████████▓                                                                           
                                                           ███████████████████████████████▓                                                                            
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                               ▓▒                                                                                      
                                                                              ███                                                                                      
                                                                             ████                                                                                      
                                                                            ████░                                                                                      
                                                                           █████░                                                                                      
                                                                           █████░                                                                                      
                                                                          ▒█████░                                                                                      
                                                                          ██████░                                                                                      
                                                                         ▒██████▓                                                                                      
                ███                                                      ████████                                                                                      
              ██████▒                                                   ▓████████░                                                                                     
        ░▓████████████▓                                                ░█████████░                                                                                     
█████████████████████████▒▒▒▒▒▓█░                                      ██████████░                                                                                     
█████████████████████████████████▓                                    ░██████████▓░                                                                   ▒                
████████████████████████████████████                                  ████████████░                                           ▒█████████▓░    ░▓████████               
█████████████████████████████████████████▓                           ░████████████░                         ▓████████████████████████████████████████████▒             
█████████████████████████████████████████████████████                ░████████████▒                      ███████████████████████████████████████████████████▓          
████████████████████████████████████████████████████████            ░▓████████████▒░                 ░███████████████████████████████████████████████████████████▓     
██████████████████████████████████████████████████████████▓         ░██████████████░              ▓████████████████████████████████████████████████████████████████████
█████████████████████████████████████████████████████████████▒     ░▒██████████████▓░          ▒███████████████████████████████████████████████████████████████████████
████████████████████████████████████████████████████████████████▒ ░▒█████████████████▓▒    ░███████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████▓                ▒██████████████████████████████████████████████████
████████████████████████████▓░                          ░▓██████████████████████████████████▓                               ▒██████████████████████████████████████████
█████████████████████▓░                                     ░▓████████████████████████████▒                                        ░▒██████████████████████████████████
█████████████████▒                                          ░█████████████████████████████                                               ░▒████████████████████████████
██████████████▒                                             ▒█████████████████████████████                                                      ▓██████████████████████
█████████████                                              ░███████████████████████████████                                                           ░████████████████
░░░░     ▒██                                               ████████████████████████████████                                                               ▒███████████░
                                                           ████████████████████████████████                                                                   ░███░    
                                                          ░█████████████████████████████████                                                                           
                                                          ░█████████████████████████████████                                                                           
                                                          ██████████████████████████████████   █                                                                       
                                                          ██████████████████████████████████  ██                                                                       
                                                        ████████████████████████████████████████                                                                       
                                                       ▓████████████████████████████████████████                                                                       
                                                       █████████████████████████████████████████                                                                       
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                 ██                                                                                    
                                                                               ░███                                                                                    
                                                                               ████                                                                                    
                                                                              █████                                                                                    
                                                                              █████                                                                                    
                                                                             ████▓                                                                                     
                                                                             ████░                                                                                     
                                                                            █████░                                                                                     
                                                                            █████░                                                                                     
                                                                           ██████░                                                                                     
                                                                           ██████░                                                                                     
                                                                          ▓██████░                                                                                     
                                                                         ░███████░░                                                                                    
                                                                         ░███████░░                                                                                    
                                                                        ░████████▒░                                                                                    
                                                                        ░████████▓░                                                                                    
                                                                       ░▒█████████░                                                                                    
                                                                      ░░██████████░░                                                                                   
                                                                      ░▒██████████░░                                                                                   
                                                                     ░░███████████░░                                                                                   
                                                                     ░████████████▒░                                                                                   
                                                                    ░██████████████░                                                                                   
                                                                    ▓██████████████░░                                                                                  
                                                                   ░███████████████░░                                                                                  
                                                                  ░▒███████████████▓░                                                                                  
                                                                  ░█████████████████░                                                                                  
                                                                 ░▓█████████████████░                                                                                  
▓                                                               ░░███████████████████░                                                                                 
██▓          ██████▓           ░▒▓███████░                      ░████████████████████▓                                                                                 
██████████████████████████████████████████████▓▒░             ░▒▓█████████████████████▓                               ▒███████▓                                        
████████████████████████████████████████████████████████████████████████████████████████▓                     ▒████████████████████▒              ███▒                 
█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████░           ░█
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
████████████████████████████████████████████████░   ███████████████████████████████████████████████████████████████████████████████████████████████████████████████████
            """,
            """                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                                                                                                       
                                                                                ▒                                                                                      
                                                                                ██                                                                                     
                                                                               ░██                                                                                     
                                                                               ████                                                                                    
                                                                              █████                                                                                    
                                                                             ██████                                                                                    
                                                                             ██████                                                                                    
                                                                            ███████                                                                                    
                                                                           ████████                                                                                    
                                                                           ████████                                                                                    
                                                                          ░████████                                                                                    
                                                                          ▓███████░                                                                                    
                                                                          ▒███████                                                                                     
                                                                           ███████                                                                                     
                                                                           ███████                                                                                     
                                                                           ███████                                                                                     
                                                                          ▓███████                                                                                     
                                                                          ████████                                                                                     
                                                                          ████████                                                                                     
                                                                         ▓████████                                                                                     
                                                                         █████████                                                                                     
                                                                         █████████                                                                                     
                                                                         ████████                                                                                      
                                                                         ████████                                                                                      
                                                                         ░██████                                                                                       
                                                                         ▒██████░                                                                                      
                                                                        ░███████░                                                                                      
                                                                        ░███████░                                                                                      
                                                                       ░▓███████░                                                                                      
                                                                      ░░████████░░                                                                                     
                                                                      ░░████████░░                                                                                     
                                                                     ░░█████████░░                                                                                     
                                                                     ░░█████████░░░                                                                                    
                                                                    ░░██████████░░░                                                                                    
                                                                    ░░██████████▓░░                                                                                    
                                                                   ░░████████████░░░                                                                                   
                                                                   ░░████████████░░░                                                                                   
                                                                  ░░█████████████░░░                                                                                   
                                                                  ░░█████████████▒░░░                                                                                  
                                                                 ░░▓█████████████▓░░░                                                                                  
                                                                 ░░███████████████░░░                                                                                  
                                                                ░░▒███████████████░░░                                                                                  
                                                                ░░████████████████░░░░                                                                                 
                                                               ░░░████████████████░░░░                                                                                 
                                                              ░░░█████████████████░░░░                                                                                 
                                                              ░░░█████████████████▓░░░                                                                                 
                                                             ░░░▓██████████████████░░░░                                                                                
            """,
            """
            """
        };       
        return Arrays.asList(f);
    }
        
    

}