import java.util.*;
public class numbergame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int chance =9;
        int finish =0;
        boolean p_again=true;
        System.out.println("Let's Play a Number Guessing Game!");
        System.out.println("There are "+chance+" chances to win the game");
        while(p_again){
            int random =getrandN(1,100);
            boolean guess=false;
            for(int i=0;i<chance;i++){
                System.out.println("Chance "+(i+1)+"\nEnter the guess: ");
                int user=sc.nextInt();
                if(user==random){
                    guess=true;
                    finish+=1;
                    System.out.println("Congratulations, You have won the game!!!");
                    break;
                }
                else if(user>random){
                    System.out.println("Guess is Too High");
                }
                else{
                    System.out.println("Guess is Too Low");
                }
            }
            if(guess==false){
                System.out.println("Bad Luck User!! You have lost the chances. The number is " +random);
            }
            System.out.println("Do you wanna play the game again??(yes/no)");
            String p=sc.next();
            p_again=p.equalsIgnoreCase("yes");
        }
        System.out.println("So that's it, Hope you have enjoyed the game.");
        System.out.println("Your Score is : "+finish);
    }
    public static int getrandN(int min,int max){
        return (int)(Math.random()*(max-min+1)+min);
    }
} 