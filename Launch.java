import java.util.Scanner;

class Guesser {
    int guessNum;

    int guessingNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guesser! Kindly guess the number");
        guessNum = sc.nextInt();
        return guessNum;
    }
}

class Player {
    int guessNum;

    int guessingNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player! Kindly guess the number");
        guessNum = sc.nextInt();
        return guessNum;
    }
}

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void collectNumFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessingNumber();
    }

    void collectNumFromPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        numFromPlayer1 = p1.guessingNumber();
        numFromPlayer2 = p2.guessingNumber();
        numFromPlayer3 = p3.guessingNumber();
    }

    void compare() {
        if (numFromGuesser == numFromPlayer1) {
            if (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("sab ne sahi answer diya hai sab winner hai!");
            } else if (numFromGuesser == numFromPlayer2) {
                System.out.println("Player! 1 and Player! 2 are the winners!");
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player! 1 and Player! 3 are the winners!");
            } else {
                System.out.println("Player! 1 is the winner!");
            }
        } else if (numFromGuesser == numFromPlayer2) {
            System.out.println("Player! 3 is the winner!");
        } else {
            System.out.println(" sab ka sab guessed wrong hai . You lost the game!");
        }
    }
}

public class Launch {
    public static void main(String args[]) {
        System.out.println("Game Started");
        Umpire u = new Umpire();
        u.collectNumFromGuesser();
        u.collectNumFromPlayers();
        u.compare();
    }
}
