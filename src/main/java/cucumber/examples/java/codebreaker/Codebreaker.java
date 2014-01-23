package cucumber.examples.java.codebreaker;

/**
 * Created by Jiankai Dang on 1/22/14.
 */
public class Codebreaker {
    private String code;
    private int numberOfGuesses = 0;

    public Codebreaker(String code) {
        this.code = code;
    }

    public String breakcode(String input) {
        numberOfGuesses++;

        if (numberOfGuesses == 8 && !input.matches(code)) {
            return "You have run out of guesses. The secret code was: " + code;
        }

        StringBuilder clue = new StringBuilder(), clue2 = new StringBuilder(), clue1 = new StringBuilder(), clue0 = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int index = code.indexOf(input.charAt(i));
            if (index == i) {
                clue2.append('2');
            } else if (index != -1) {
                clue1.append('1');
            } else {
                clue0.append('0');
            }
        }

        return clue.append("(Guesses Remaining: ").append(8 - numberOfGuesses).append(") What is your guess? Clue: ").append(clue2).append(clue1).append(clue0).toString();
    }
}
