import java.util.*;

public class asciiAnimator
{
  /**
 * Utility class responsible for rendering ASCII-based animations
 * in the console, including the opening animation and a disco ball effect.
 * All methods are static and intended to be used without creating an instance.
 */

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
   /**
   * Entry point for running this class directly.
   * It simply triggers the opening animation sequence.
   *
   * @param args command-line arguments (not used).
   */
     public static void main(String[] args)
    {
        playOpeningAnimation();  
    }
      /**
     * Plays the main opening animation sequence in the console.
     * The animation iterates over a list of pre-defined ASCII frames
     * and displays them with a fixed frame rate.
     */
    public static void playOpeningAnimation()
    {
        List<String> frames = getFrames();

        int fps = 10;
        long frameTime = 1000 / fps;

        
        try 
        {
            
            System.out.print(HIDE_CURSOR);
            System.out.print(ANSI_RED);

            int i = 0;
            for (String frame : frames) {
                long t0 = System.nanoTime();

                System.out.print(CLEAR);
                System.out.print(HOME);

                if(i == 24)
                    System.out.print(ANSI_RESET);

                
                System.out.print(frame);
                System.out.flush();

                long elapsedMs = (System.nanoTime() - t0) / 1_000_000;
                long sleepMs = Math.max(0, frameTime - elapsedMs);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break; 
                }
                i++;

            }

                
                System.out.print(ANSI_RESET);
                System.out.print(SHOW_CURSOR);
                System.out.println("by:  Yavuz Selim Yaşar, Volkan Dinç,  Kemal Ege İncereis,  İdil Zeren Çoban");
            } 
            finally
            {
                
                System.out.print(ANSI_RESET);
                System.out.print(SHOW_CURSOR);
                System.out.flush();
            }
            discoball();
    }
     /**
     * Displays an ASCII-art disco ball on the console.
     * This method is used at the end of the animation as a final visual effect.
     */
    public static void discoball() 
    {
        System.out.print(CLEAR);
        String[] BALL = new String[]
        {
"                                                                   @@                                                                   ",
"                                                                   @@                                                                   ",
"                                                                   @@                                                                   ",
"                                                                   @@                                                                   ",
"                                                                   @@                                                                   ",
"                                      *                            @@                                                                   ",
"                                      @                         :@%  #@-                                                                 ",
"                                   @@@@@@@.                     @.     @                                                                 ",
"                                      @                         @%    %@                                                                 ",
"                                      +                          @@@@@@                                                                  ",
"                                                          *@@@@@%#@@@@+@@@@@@=                                                          ",
"                                                     %@@   @@+  @% @==@:  %@+  +@@*                                                     ",
"                                                  @@     @*.. .@   @=..%@    @@    =@#                                                  ",
"                                               %@     -@:    =@    @=...+@     +@     -@:                                               ",
"                            .  .             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*                                             ",
"                                           @%      @#      -%      @       @       @*    ..@=                                           ",
"                                         -@      .@       -@       @        @       +@.    .=@                                          ",
"                                        @+      +@        @        @         @        @.     .@-                                        ",
"                                       @.      @@        @.        @         @*        @..     %#                                       ",
"                                      @       *@        -@         @          @         @.      *%                                      ",
"                                     @       .@         @          @          #%        .@.     .@@                                     ",
"                                    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.                                    ",
"                                   .%       #+        .@           @.          #+.........@        @                                    ",
"                                   @        @.        .@           @.          .@.........+#       =+                                   ",
"                                  .%       ##         -#           @.           @-........-@        @                                   ",
"                                  #:       @.        .*:           @.           @=.........@=       @                                   ",
"                                  @        @.         %            @.           @+.........##       -=                                  ",
"                                  @        @.         @            @            #*         +%        *                                  ",
"                                  @%######%@*+======++@#----------=@#===========@@+++++++++%@-------%*                                  ",
"                                  @-.......@          @.           @            @-         =#       :+                                  ",
"                                  @+...... @          #.           @            @:         %*       #:                                  ",
"                                  -#.......%=         =+           @            @.        .@        @                                   ",
"                                   @:......+@         .@           @            @.       .:@       .@                                   ",
"                                   ##.......@.         @           @           +*         @.       @                                    ",
"                                    @=-----=#@         @*          @-          @=........+@       @%                                    ",
"                                     @       *%........:@----------@.         +@         @.      *@                                     ",
"                                     =@       @*       .@%........:@          @         @-       @                                      ",
"                                      -@       @-       .@........:@         :@        @%      .@                                       ",
"                                        @       @=       %@.......:@         @        @*      +@                                       ",
"                                         @#      #%       @*......:@        @-       @:      @=                                        ",
"                                          =@      .@.      @+.....:@       %+      *@      %@                                          ",
"                                            +@*#**#%@@#####@@@%%%%@@%#***#@@#****#@@%####%@                                            ",
"                                              -@:     @%....-@:    @     @*.  ..@*     %@                                               ",
"                                                 @@     @@:..:@%   @    @+   :@%    *@#                                                 ",
"                                                    %@*   *@*..#@  @   @. .%@.   @@+                                                    ",
"                                                        *@@+@@@#*@#@-@%:%@@#%@@:                                                        ",
"                                                               -%@@@@@@#.                                                               ",
"                                                                                                                                        ",
"                                                       LEADER: YAVUZ SELİM YAŞAR                                                         "
        };

        
        String[] NAMES = { "Kemal Ege İncereis", "Volkan Dinç", "İdil Zeren Çoban" };

        int[][] COLORS = new int[][]
        {
            {255,   0, 255},  
            {0,   255, 255},   
            {255, 255,   0},   
            {0,   255, 128},   
            {255, 105, 180},   
            {0,   128, 255}    
        };

        int width = BALL[0].length();

        
        int[] colColorIndex = new int[width];
        for (int col = 0; col < width; col++)
        {
            colColorIndex[col] = col % COLORS.length;
        }

        
        StringBuilder patternBuilder = new StringBuilder();
        patternBuilder.append("   ");
        for (int i = 0; i < NAMES.length; i++)
        {
            patternBuilder.append(NAMES[i]).append("   ");
        }
        String basePattern = patternBuilder.toString();

        
        StringBuilder longPattern = new StringBuilder(basePattern);
        while (longPattern.length() < width * 3)
        {
            longPattern.append(basePattern);
        }
        String namePattern = longPattern.toString();
        int nameOffset = 0;

        while (true)
        {
            StringBuilder frame = new StringBuilder();

            
            for (int row = 0; row < BALL.length; row++)
            {
                String line = BALL[row];

                for (int col = 0; col < width; col++)
                {
                    char ch = ' ';
                    if (col < line.length())
                    {
                        ch = line.charAt(col);
                    }

                    if (ch == ' ')
                    {
                        frame.append(' ');
                        continue;
                    }

                    int idx = colColorIndex[col];
                    int r = COLORS[idx][0];
                    int g = COLORS[idx][1];
                    int b = COLORS[idx][2];

                    frame.append("\u001B[38;2;")
                        .append(r).append(";")
                        .append(g).append(";")
                        .append(b).append("m")
                        .append(ch)
                        .append(ANSI_RESET);
                }
                frame.append('\n');



            }


            
            for (int col = 0; col < width; col++)
            {
                int idx = colColorIndex[col];
                int r = COLORS[idx][0];
                int g = COLORS[idx][1];
                int b = COLORS[idx][2];

                char ch = namePattern.charAt((nameOffset + col) % namePattern.length());

                if (ch == ' ')
                {
                    frame.append(' ');
                }
                else
                {
                    frame.append("\u001B[38;2;")
                        .append(r).append(";")
                        .append(g).append(";")
                        .append(b).append("m")
                        .append(ch)
                        .append(ANSI_RESET);
                }
            }
            frame.append('\n');

                            frame.append(ANSI_RESET)
                .append("Press ENTER to continue")
                .append(ANSI_RESET)
                .append('\n');

            
            System.out.print(CLEAR);
            System.out.print(frame.toString());

            
            int firstColor = colColorIndex[0];
            for (int i = 0; i < width - 1; i++)
            {
                colColorIndex[i] = colColorIndex[i + 1];
            }
            colColorIndex[width - 1] = firstColor;

            
            nameOffset = (nameOffset + 1) % namePattern.length();

            try {
                if (System.in.available() > 0) {

                    // <<< BUFFER CLEAN >>> 
                    while (System.in.available() > 0) {
                        System.in.read();
                    }

                    return;   
                }
            } catch (Exception e) {}


            try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break; // break from the animation
                }        
        }
    }
      /**
     * Builds and returns the list of ASCII frames used in the opening animation.
     * Each element in the list represents a single frame of the animation.
     *
     * @return a list of strings where each string is one ASCII-art frame.
     */



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
            """,
            """                                                                                                                                                                                                                                            
                                                @@     @@:..:@%   @    @+   :@%    *@#                                                 
                                                    %@*   *@*..#@  @   @. .%@.   @@+                                                    
                                                        *@@+@@@#*@#@-@%:%@@#%@@:                                                        
                                                               -%@@@@@@#.                                                               
            """,
            """                                                                                                                                
                               
                                   @:......+@         .@           @            @.       .:@       .@                                   
                                   ##.......@.         @           @           +*         @.       @                                    
                                    @=-----=#@         @*          @-          @=........+@       @%                                    
                                     @       *%........:@----------@.         +@         @.      *@                                     
                                     =@       @*       .@%........:@          @         @-       @                                      
                                      -@       @-       .@........:@         :@        @%      .@                                       
                                        @       @=       %@.......:@         @        @*      +@                                        
                                         @#      #%       @*......:@        @-       @:      @=                                         
                                          =@      .@.      @+.....:@       %+      *@      %@                                           
                                            +@*#**#%@@#####@@@%%%%@@%#***#@@#****#@@%####%@                                             
                                              -@:     @%....-@:    @     @*.  ..@*     %@                                               
                                                 @@     @@:..:@%   @    @+   :@%    *@#                                                 
                                                    %@*   *@*..#@  @   @. .%@.   @@+                                                    
                                                        *@@+@@@#*@#@-@%:%@@#%@@:                                                        
                                                               -%@@@@@@#.     
            """,
            """                                                                                                                                 
                                    
                                      @       *@        -@         @          @         @.      *%                                      
                                     @       .@         @          @          #%        .@.     .@@                                     
                                    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.                                    
                                   .%       #+        .@           @.          #+.........@        @                                    
                                   @        @.        .@           @.          .@.........+#       =+                                   
                                  .%       ##         -#           @.           @-........-@        @                                   
                                  #:       @.        .*:           @.           @=.........@=       @                                   
                                  @        @.         %            @.           @+.........##       -=                                  
                                  @        @.         @            @            #*         +%        *                                  
                                  @%######%@*+======++@#----------=@#===========@@+++++++++%@-------%*                                  
                                  @-.......@          @.           @            @-         =#       :+                                  
                                  @+...... @          #.           @            @:         %*       #:                                  
                                  -#.......%=         =+           @            @.        .@        @                                   
                                   @:......+@         .@           @            @.       .:@       .@                                   
                                   ##.......@.         @           @           +*         @.       @                                    
                                    @=-----=#@         @*          @-          @=........+@       @%                                    
                                     @       *%........:@----------@.         +@         @.      *@                                     
                                     =@       @*       .@%........:@          @         @-       @                                      
                                      -@       @-       .@........:@         :@        @%      .@                                       
                                        @       @=       %@.......:@         @        @*      +@                                        
                                         @#      #%       @*......:@        @-       @:      @=                                         
                                          =@      .@.      @+.....:@       %+      *@      %@                                           
                                            +@*#**#%@@#####@@@%%%%@@%#***#@@#****#@@%####%@                                             
                                              -@:     @%....-@:    @     @*.  ..@*     %@                                               
                                                 @@     @@:..:@%   @    @+   :@%    *@#                                                 
                                                    %@*   *@*..#@  @   @. .%@.   @@+                                                    
                                                        *@@+@@@#*@#@-@%:%@@#%@@:                                                        
                                                               -%@@@@@@#.     
            """,
            """            
            
            
                                                                   @@                                                                   
                                                                   @@                                                                   
                                                                   @@                                                                   
                                                                   @@                                                                   
                                                                   @@                                                                   
                                      *                            @@                                                                   
                                      @                         :@%  #@-                                                                
                                   @@@@@@@.                     @.     @                                                                
                                      @                         @%    %@                                                                
                                      +                          @@@@@@                                                                 
                                                          *@@@@@%#@@@@+@@@@@@=                                                          
                                                     %@@   @@+  @% @==@:  %@+  +@@*                                                     
                                                  @@     @*.. .@   @=..%@    @@    =@#                                                  
                                               %@     -@:    =@    @=...+@     +@     -@:                                               
                            .  .             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*                                             
                                           @%      @#      -%      @       @       @*    ..@=                                           
                                         -@      .@       -@       @        @       +@.    .=@                                          
                                       @.      @@        @.        @         @*        @..     %#                                       
                                      @       *@        -@         @          @         @.      *%                                      
                                     @       .@         @          @          #%        .@.     .@@                                     
                                    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.                                    
                                   .%       #+        .@           @.          #+.........@        @                                    
                                   @        @.        .@           @.          .@.........+#       =+                                   
                                  .%       ##         -#           @.           @-........-@        @                                   
                                  #:       @.        .*:           @.           @=.........@=       @                                   
                                  @        @.         %            @.           @+.........##       -=                                  
                                  @        @.         @            @            #*         +%        *                                  
                                  @%######%@*+======++@#----------=@#===========@@+++++++++%@-------%*                                  
                                  @-.......@          @.           @            @-         =#       :+                                  
                                  @+...... @          #.           @            @:         %*       #:                                  
                                  -#.......%=         =+           @            @.        .@        @                                   
                                   @:......+@         .@           @            @.       .:@       .@                                   
                                   ##.......@.         @           @           +*         @.       @                                    
                                    @=-----=#@         @*          @-          @=........+@       @%                                    
                                     @       *%........:@----------@.         +@         @.      *@                                     
                                     =@       @*       .@%........:@          @         @-       @                                      
                                        @       @=       %@.......:@         @        @*      +@                                        
                                         @#      #%       @*......:@        @-       @:      @=                                         
                                          =@      .@.      @+.....:@       %+      *@      %@                                           
                                            +@*#**#%@@#####@@@%%%%@@%#***#@@#****#@@%####%@                                             
                                              -@:     @%....-@:    @     @*.  ..@*     %@                                               
                                                 @@     @@:..:@%   @    @+   :@%    *@#                                                 
                                                    %@*   *@*..#@  @   @. .%@.   @@+                                                    
                                                        *@@+@@@#*@#@-@%:%@@#%@@:                                                        
                                                               -%@@@@@@#.     
            """,
            """                                                                                                                                      
                                                                       @@                                                                   
                                                                       @@                                                                   
                                                                       @@                                                                   
                                                                       @@                                                                   
                                          *                            @@                                                                   
                                          @                         :@%  #@-                                                                
                                       @@@@@@@.                     @.     @                                                                
                                          @                         @%    %@                                                                
                                          +                          @@@@@@                                                                 
                                                              *@@@@@%#@@@@+@@@@@@=                                                          
                                                         %@@   @@+  @% @==@:  %@+  +@@*                                                     
                                                      @@     @*.. .@   @=..%@    @@    =@#                                                  
                                                   %@     -@:    =@    @=...+@     +@     -@:                                               
                                .  .             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*                                             
                                               @%      @#      -%      @       @       @*    ..@=                                           
                                             -@      .@       -@       @        @       +@.    .=@                                          
                                            @+      +@        @        @         @        @.     .@-                                        
                                           @.      @@        @.        @         @*        @..     %#                                       
                                          @       *@        -@         @          @         @.      *%
                                          @       *@        -@         @          @         @.      *%                                      
                                         @       .@         @          @          #%        .@.     .@@                                     
                                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.                                    
                                       .%       #+        .@           @.          #+.........@        @                                    
                                       @        @.        .@           @.          .@.........+#       =+                                   
                                      .%       ##         -#           @.           @-........-@        @                                   
                                      #:       @.        .*:           @.           @=.........@=       @                                   
                                      @        @.         %            @.           @+.........##       -=                                  
                                      @        @.         @            @            #*         +%        *                                  
                                      @%######%@*+======++@#----------=@#===========@@+++++++++%@-------%*                                  
                                      @-.......@          @.           @            @-         =#       :+                                  
                                      @+...... @          #.           @            @:         %*       #:                                  
                                      -#.......%=         =+           @            @.        .@        @                                   
                                       @:......+@         .@           @            @.       .:@       .@                                   
                                       ##.......@.         @           @           +*         @.       @                                    
                                        @=-----=#@         @*          @-          @=........+@       @%                                    
                                         @       *%........:@----------@.         +@         @.      *@                                     
                                         =@       @*       .@%........:@          @         @-       @                                      
                                              -@       @-       .@........:@         :@        @%      .@                                       
                                            @       @=       %@.......:@         @        @*      +@                                        
                                             @#      #%       @*......:@        @-       @:      @=
                                             @#      #%       @*......:@        @-       @:      @=                                         
                                              =@      .@.      @+.....:@       %+      *@      %@                                           
                                                +@*#**#%@@#####@@@%%%%@@%#***#@@#****#@@%####%@                                             
                                                  -@:     @%....-@:    @     @*.  ..@*     %@                                               
                                                     @@     @@:..:@%   @    @+   :@%    *@#                                                 
                                                        %@*   *@*..#@  @   @. .%@.   @@+                                                    
                                                            *@@+@@@#*@#@-@%:%@@#%@@:                                                        
                                                                   -%@@@@@@#.     
            """,
            """
                                                                           @@                                                                   
                                                                           @@                                                                   
                                                                           @@                                                                   
                                              *                            @@                                                                   
                                              @                         :@%  #@-                                                                
                                           @@@@@@@.                     @.     @                                                                
                                              @                         @%    %@                                                                
                                              +                          @@@@@@                                                                 
                                                                  *@@@@@%#@@@@+@@@@@@=                                                          
                                                             %@@   @@+  @% @==@:  %@+  +@@*                                                     
                                                      @@     @*.. .@   @=..%@    @@    =@#                                                  
                                                       %@     -@:    =@    @=...+@     +@     -@:                                               
                                .  .                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*                                             
                                                   @%      @#      -%      @       @       @*    ..@=                                           
                                                 -@      .@       -@       @        @       +@.    .=@                                          
                                                @+      +@        @        @         @        @.     .@-                                        
                                               @.      @@        @.        @         @*        @..     %#                                       
                                              @       *@        -@         @          @         @.      *%                                      
                                             @       .@         @          @          #%        .@.     .@@                                     
                                            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.                                    
                                           .%       #+        .@           @.          #+.........@        @                                    
                                           @        @.        .@           @.          .@.........+#       =+                                   
                                          .%       ##         -#           @.           @-........-@        @                                   
                                          #:       @.        .*:           @.           @=.........@=       @                                   
                                          @        @.         %            @.           @+.........##       -=                                  
                                          @        @.         @            @            #*         +%        *                                  
                                          @%######%@*+======++@#----------=@#===========@@+++++++++%@-------%*                                  
                                          @-.......@          @.           @            @-         =#       :+                                  
                                          @+...... @          #.           @            @:         %*       #:                                  
                                          -#.......%=         =+           @            @.        .@        @                                   
                                           @:......+@         .@           @            @.       .:@       .@                                   
                                           ##.......@.         @           @           +*         @.       @                                    
                                            @=-----=#@         @*          @-          @=........+@       @%                                    
                                             @       *%........:@----------@.         +@         @.      *@                                     
                                             =@       @*       .@%........:@          @         @-       @                                      
                                                  -@       @-       .@........:@         :@        @%      .@                                       
                                                @       @=       %@.......:@         @        @*      +@                                        
                                                 @#      #%       @*......:@        @-       @:      @=                                         
                                                  =@      .@.      @+.....:@       %+      *@      %@                                           
                                                    +@*#**#%@@#####@@@%%%%@@%#***#@@#****#@@%####%@                                             
                                                      -@:     @%....-@:    @     @*.  ..@*     %@                                               
                                                         @@     @@:..:@%   @    @+   :@%    *@#                                                 
                                                            %@*   *@*..#@  @   @. .%@.   @@+                                                    
                                                                *@@+@@@#*@#@-@%:%@@#%@@:                                                        
                                                                       -%@@@@@@#. 
            """

        };       
        return Arrays.asList(f);
    }
        
    

}

