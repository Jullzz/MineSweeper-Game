import java.util.*;
public class MineSweeper
{
   public static int x;
   public static boolean gameover;
   public static int displayBoard(int xsize, int ysize, space[][] board)
   {
      gameover = false;
      System.out.println();
      System.out.println();
      System.out.print("   ");
      for(int i = 0 ; i<xsize; i++)
      {
         System.out.printf("%2d",i);
      }
      System.out.println();
      System.out.print("   ");
      for(int i = 0 ; i<xsize; i++)
      {
         System.out.print(" _");
      }
      System.out.println();
      for (int i = 0; i<ysize; i++)
      {
         System.out.printf("%2d |", i);
         for (int j = 0; j<xsize; j++)
         {
            if(board[j][i].Display() == 0)
            {
               gameover = true;
            }
         }
         System.out.println();
      }
      if(gameover == true)
      {
         return -1;
      }
      return 0;
   }
   public static void main(String[]args)
   {
      Random rand = new Random();
      Scanner kb = new Scanner(System.in);
      System.out.println("what size board");
      System.out.println("X SIZE:");
      int xsize = kb.nextInt();
      System.out.println("Y SIZE:");
      int ysize = kb.nextInt();
      System.out.println("How many bombs do you want");
      int numberofbomb = kb.nextInt();

      space[][] board = new space[xsize][ysize];
      for (int i = 0; i<ysize; i++)
      {
         for (int j = 0; j<xsize; j++)
{
            board[j][i] = new space(i,j);
         }
      }
      int q = 0;
      while(q <numberofbomb)
      {
         int x = rand.nextInt(xsize-2);
         int y = rand.nextInt(ysize-2);
         if(!board[x][y].hasBomb())
         {
            board[x][y].giveBomb();
            q++;
         }
      }

      for (int i = 0; i<ysize; i++)
      {
         for (int j = 0; j<xsize; j++)
         {
            board[j][i].assignNumber(xsize-1, ysize-1, board);
         }
      }
      while(1==1)
      {
         if(displayBoard(xsize, ysize, board)==-1)
         {
            System.out.println("GAME OVER");
            return;
         }

         System.out.println("Please Enter A Coordinate: ");
         boolean flag = false;
         System.out.println("Do you want to place a flag: ");
         kb.nextLine();
         String answer = kb.nextLine();
         if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))
         {
            flag = true;
         }

         do{
            System.out.println("X Coordinate: ");
            x =kb.nextInt();
         }while(x>xsize-1);

         int y = 0;

         do{
            System.out.println("Y Coordinate: ");
            y = kb.nextInt();
         }while(y>ysize-1);

         if(!flag)
         {
            board[x][y].click(ysize-1,xsize-1,board);
         }
         else
         {
            board[x][y].giveFlag();
            if(board[x][y].hasBomb())
            {
               numberofbomb --;
            }
         }
         if(numberofbomb == 0)
         {
            System.out.println("YOU WIN");
            return;
         }
      }
   }
}
