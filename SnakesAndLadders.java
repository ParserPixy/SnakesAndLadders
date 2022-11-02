import java.util.*;
class SnakesAndLadders
{
    static int p1,p2,times;//scores of players 1 and 2
    static String ic1,ic2,n1,n2;;//icons and names chosen by the players
    SnakesAndLadders()
    {
        p1=1;
        p2=1;
        ic1="";
        ic2="";
        n1="";
        n2="";
        times=0;
    }

    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int co=0;//for storing the choice 
                 //whether user wants to start fresh game or end the game
        while(true)
        {
            int ch=0;//stores the choice : 1 for rules and 2 to start the game
           
            SnakesAndLadders play= new SnakesAndLadders();
            //creates the object 'play' to call methods 'rules' & 'start game'
            
            
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\tWelcome to the SNAKES and LADDER game");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n\n\n\t\t\t\tEnter 1 for rules of game\n\t\t\t\t      2 to start the game");
            while(true)//repeats the game if the user wants to play again
            {         
              p1=1;
              p2=1;
              ic1="";
              ic2="";
              //to ensure that the score at start of every game is 1
            if(times>0)
                {
                    System.out.println("\n\n\n\t\t\t\tEnter 1 for rules of game\n\t\t\t\t      2 to start the game");
                }
                ch=in.nextInt();
                
                switch(ch)
                {
                    case 1: play.rules();
                    System.out.println("Enter 2 to start the game");
                    break;
                    case 2: play.startGame();
                    times++;
                    for( ;; )
                    {
                        System.out.println("\n\n\n\nDo you want to continue? type 1 to continue OR 2 to Quit");
                        co=in.nextInt();
                        if(co==1 || co==2)
                            break;
                        System.out.println("Incorrect choice. Type again");
                    }
                    if(co==2)
                    {
                        System.out.println("\u000c\n\n\n\nThank You\n\n\n\n\n\n Quitting......");
                        for(int j =0;j<=100000000;j++)
                        {}
                        System.exit(0);
                        
                    }
                    break;
                    default:System.err.println("Enter 1/2 only");
                }

            }
            }

            
        }
    

    public void rules()
    {
        System.out.println("\n\n\n**********************************************************************************************************************************************");
        System.out.println("\t\t\t\t\t\tRULES of the game");
        System.out.println("**********************************************************************************************************************************************");
        System.out.println("*This program will stimulate a regular snake and ladder game");
        System.out.println("*This game is played by two players\n*Both the players start at square 1 and the first to reach square 100 wins");
        System.out.println("*When you land on top of a snake you go down a few squares");
        System.out.println("*When you land near a ladder you go up a few squares");
        System.out.println("*S represents a snake while L represents a ladder");
        System.out.println("*VALUABLE HINTS\n#Snakes are at squares 34,48,59,64,68,80,83,89,93,98");
        System.out.println("#Ladders are at squares 8,19,36,40,43,51,54,61,62,70");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void present()
    { 
        System.out.print("\n\n\t\t\t\t");
        int k=100;
        for(int i=1;i<=10;i++)
        {
            if(i%2!=0)
            {

                for(int j=0;j<10;j++)
                {

                    if(k==34||k==48||k==59||k==64||k==68||k==80||k==83||k==89||k==93||k==98)
                        System.out.print("S\t");
                    else if(k==8||k==19||k==36|k==40||k==43||k==51||k==54||k==61||k==62||k==66)
                        System.out.print("L\t");
                    else if(k==p1&&k!=p2)
                        System.out.print(ic1+"\t");
                    else if(k==p2&&k!=p1)
                        System.out.print(ic2+"\t");
                    else if(k==p1&&k==p2)
                        System.out.print(ic1+ic2+"\t");
                    else
                        System.out.print(k+"\t");
                    k--;
                }
                k=k-10;
            }
            else
            {
                for (int j=10;j>0;j--)
                {
                    k++;
                    if(k==34||k==48||k==59||k==64||k==68||k==80||k==83||k==89||k==93||k==98)
                        System.out.print("S\t");
                    else if(k==8||k==19||k==36|k==40||k==43||k==51||k==54||k==61||k==62||k==66)
                        System.out.print("L\t");
                    else if(k==p1&&k!=p2)
                        System.out.print(ic1+"\t");
                    else if(k==p2&&k!=p1)
                        System.out.print(ic2+"\t");
                    else if(k==p1&&k==p2)
                        System.out.print(ic1+ic2+"\t");
                    else
                        System.out.print(k+"\t");

                }
                k=k-10;
            }
            System.out.print("\n\n\t\t\t\t");
        }

    }

    public int calc_score(int p,int dvalue)
    {
        int snakes[]={34,48,59,64,68,80,83,89,93,98};
        int fsnakes[]={7,11,18,24,2,56,22,50,67,13};

        int ladders[]={8,19,36,40,43,51,54,61,62,70};
        int fladders[]={26,38,57,82,77,91,88,99,96,87};

        p=p+dvalue;
        if(p>100)
            p=p-dvalue;
        for( int i=0;i<10;i++)
        {
            if(snakes[i]==p)
            {
                System.out.println("Swallowed by snake:(");
                p=fsnakes[i];
            }
            if(ladders[i]==p)
            {
                System.out.println("climb up the ladder!!!");
                p=fladders[i];
            }
        }
        return (p);
    }

    public boolean isWin(int score)
    {
        return (100==score);
    }
    public void ask()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name of player 1");
        n1=in.nextLine();
        System.out.println("Choose an icon(@/#/$/%)");
        while(true)
        {
            ic1=in.next();
            if(ic1.equals("@")||ic1.equals("$")||ic1.equals("#")||ic1.equals("%"))
                break;
            else
                System.err.println("Wrong choice\nChoose only @/#/$/%");
        }

        System.out.println("Enter name of player 2");
        n2=in.nextLine();
        n2=in.nextLine();
        System.out.println("Choose an icon(@/#/$/%)");
        while(true)
        {
            ic2=in.next();
            if(ic1.compareTo(ic2)!=0)
            {
                if(ic2.equals("@")||ic2.equals("$")||ic2.equals("#")||ic2.equals("%"))
                    break;
                else
                    {
                        System.err.println("Wrong choice\nChoose only @/#/$/%");
                        System.out.println("Wrong choice\nChoose only @/#/$/%");
                    }
            }
            else
                {
                    System.err.println("This icon is already chosen by "+n1+"\nChoose another icon");
                   System.out.println("This icon is already chosen by "+n1+"\nChoose another icon");
        }
      }
    }
    public void startGame()
    {
        SnakesAndLadders info=new SnakesAndLadders();
        Scanner in=new Scanner(System.in);
        int currentp=1;
        int dice=0;
        String str;
         
         info.ask();
         
         System.out.println("Tossing the coin.......");
         for(int k=0;k<=999999999;k++)
            {}
         int coin=(int)((Math.random()*2)+1);
         if(coin==1)
            currentp=1;
         else 
            currentp=-1;
            
            
        x:do
        {
            
            System.out.println(currentp==1?"\n\n\t\t\t\t"+n1+"'s Turn":"\n\t\t\t\t"+n2+"'s Turn");
            System.out.println("\t\t\t\tEnter r to roll Dice or q to quit");

            while(true)
            {
                str=in.next();
                if(str.equals("r"))
                {
                    dice=(int)((Math.random()*6)+1);
                    break;
                }
                else if(str.equals("q"))
                    System.exit(0);
                else
                    System.err.println("Enter r to roll dice or q to quit");
            }
            if(currentp==1)
            {
                System.out.println('\u000c');
                
                
                System.out.println("\t\t\t\tYou rolled "+dice);
                p1=calc_score(p1,dice);
                System.out.println("\t\t\t\tyour score:"+p1+"\t"+n2+"'s score:"+p2);
                System.out.println("\t\t\t\t----------------------------------------------------------------------------");
                present();
                
                if(isWin(p1))
                {
                    System.out.println("\n\n\t\t\t"+n1+" Wins!!!!!");
                    for(long l=0;l<=999999999;l++)
                    {
                    }
                    System.out.println("\u000c");
                    System.out.println("\n\n**********************************************************************************************************************************************");
                    System.out.println("\t\t\t\t\t\tCERTIFICATE OF APPRECIATION");
                    System.out.println("**********************************************************************************************************************************************");
                    System.out.println("\n\n\n\t\t\tThis is to certify that "+n1+" has secured the winning position in the game of snakes and ladders\n\n\n\n\n\n\n\n");
                    break x;

                }
            }
            else
            {
                System.out.println('\u000c');
                System.out.println("\t\t\t\tYou rolled "+dice);
                p2=calc_score(p2,dice);
                System.out.println("\t\t\t\tyour score:"+p2+"\t"+n1+"'s score:"+p1);
                
                System.out.println("\t\t\t\t----------------------------------------------------------------------------");
                present();
                if(isWin(p2))
                {
                     System.out.println("\n\n\t\t\t"+n2+" Wins!!!!!");
                    for(long l=0;l<=999999999;l++)
                    {
                    }
                    System.out.println("\u000c");
                    System.out.println("\n\n**********************************************************************************************************************************************");
                    System.out.println("\t\t\t\t\t\tCERTIFICATE OF APPRECIATION");
                    System.out.println("**********************************************************************************************************************************************");
                    System.out.println("\n\n\n\t\t\tThis is to certify that "+n2+" has secured the winning position in the game of snakes and ladders\n\n\n\n\n\n\n\n");
                    break x;

                }
            }
            currentp=-currentp;
        }while("r".equals(str));
    }
}