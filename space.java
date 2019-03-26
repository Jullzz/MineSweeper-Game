public class space
{
   private int xcor;
   private int ycor;
   private int number;
   private boolean hasBomb;
   private boolean hasFlag;
   private boolean hasClicked;

   public space(int ycor, int xcor)
   {
      this.xcor = xcor;
      this.ycor = ycor;
      this.number = 0;
      this.hasBomb = false;
      this.hasFlag = false;
      this.hasClicked = false;
   }
   public int getnumber()
   {
      return number;
   }
   public boolean hasClicked()
   {
      return hasClicked;
   }
   public void giveFlag()
   {
      if(!hasClicked)
      {
         hasFlag = true;
      }
   }
   public void giveBomb()
   {
      this.hasBomb = true;
   }
   public void assignNumber(int xmax, int ymax, space[][] space)
   {
      if(this.xcor != xmax)
      {
         if(space[xcor+1][ycor].hasBomb)
            this.number +=1;
      }
      if(this.xcor != 0)
      {
         if(space[xcor-1][ycor].hasBomb())
            this.number+=1;

      }
      if(this.ycor != ymax)
      {
         if(space[xcor][ycor+1].hasBomb())
            this.number+=1;
}
      if(this.ycor != 0 )
      {
         if(space[xcor][ycor-1].hasBomb())
            this.number+=1;

      }
      if(this.xcor != xmax && this.ycor != ymax)
      {
         if(space[xcor+1][ycor+1].hasBomb())
            this.number+=1;

      }
      if(this.xcor != 0 && this.ycor != ymax)
      {
         if(space[xcor-1][ycor+1].hasBomb())
            this.number+=1;
      }
      if(this.xcor != xmax && this.ycor !=0)
      {
         if(space[xcor+1][ycor-1].hasBomb())
            this.number+=1;
      }
      if(this.xcor !=0 && this.ycor !=0)
      {
         if(space[xcor-1][ycor-1].hasBomb())
            this.number +=1;
      }
   }
   public void display(space[][] space)
   {
      System.out.println();
      System.out.println();
      System.out.print("   ");
      for(int i = 0 ; i<10; i++)
      {
         System.out.printf("%2d",i);
      }
      System.out.println();
      System.out.print("   ");
      for(int i = 0 ; i<10; i++)
      {
         System.out.print(" _");
      }
      System.out.println();
      for (int i = 0; i<10; i++)
      {
         System.out.printf("%2d |", i);
         for (int j = 0; j<10; j++)
         {
            space[j][i].Display();
         }
         System.out.println();
      }

   }
   public void click(int ymax, int xmax, space[][] space)
   {
      if(!hasFlag)
      {

         this.hasClicked = true;
         if(this.xcor != xmax)
         {if( !space[xcor+1][ycor].hasClicked() && number ==0 && !hasBomb)
			{space[xcor+1][ycor].click( ymax, xmax, space);}
         }
         if(this.xcor != 0)
         {if(!space[xcor-1][ycor].hasClicked() && number ==0 && !hasBomb)
            {space[xcor-1][ycor].click(ymax, xmax, space);}

         }
         if(this.ycor != ymax)
         {if(!space[xcor][ycor+1].hasClicked() && number ==0 && !hasBomb)
            {space[xcor][ycor+1].click(ymax, xmax, space);
            }
         }
         if(this.ycor != 0 )
         {if(!space[xcor][ycor-1].hasClicked() && number ==0&& !hasBomb)
            {space[xcor][ycor-1].click(ymax, xmax, space);

            }
            if(this.xcor != xmax && this.ycor != ymax)
            {if(!space[xcor+1][ycor+1].hasClicked() && number ==0&& !hasBomb)
               {space[xcor+1][ycor+1].click( ymax, xmax, space);}
            }
            if(this.xcor != 0 && this.ycor != ymax)
            {if(!space[xcor-1][ycor+1].hasClicked() && number ==0&& !hasBomb)
               {space[xcor-1][ycor+1].click( ymax,  xmax, space);}

            }
            if(this.xcor != xmax && this.ycor !=0)
            {if(! space[xcor+1][ycor-1].hasClicked() && number ==0&& !hasBomb)
               {space[xcor+1][ycor-1].click( ymax,  xmax,space);}

            }
            if(this.xcor !=0 && this.ycor !=0)
            {if(!space[xcor-1][ycor-1].hasClicked() && number ==0&& !hasBomb)
               {space[xcor-1][ycor-1].click(ymax, xmax, space);}

            }

            /*  up               space[xcor][ycor-1].click(space);
                up right        space[xcor+1][ycor-1].click(space);
                up left          space[xcor-1][ycor-1].click();
                same          space[xcor][ycor].click(space);
                down right     space[xcor+1][ycor+1].click(space);
                right           space[xcor+1][ycor].click(space);
                down            space[xcor][ycor+1].click(space);
                down left        space[xcor-1][ycor+1].click(space);
                left             space[xcor-1][ycor].click(space);*/
         }
      }
   }
   public boolean hasBomb()
   {
      return hasBomb;
   }
   public int Display()
   {
      if(!hasFlag)
      {
         if(hasClicked)
         {
	   if(hasBomb)
            {
               System.out.print("X ");
               return 0;
            }
            else
            {
               if(number ==0)
               {
                  System.out.print("  ");
               }
               else {
                  System.out.print(number +" ");
               }
            }
         }
         else
         {
            System.out.print("\u25A1 ");
         }
      }
      else
      {
         System.out.print("F ");
      }
      return 1;
   }
}

