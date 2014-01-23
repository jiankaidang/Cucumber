package cucumber.examples.java.codebreaker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jiankai Dang on 1/23/14.
 */
public class CodebreakerTest {
    @Test
    public void commandPrompt() {
        String[] prompts = new String[8];

        Codebreaker codebreaker = new Codebreaker("1234");

        for (int i = 0; i < 8; i++) {
            prompts[i] = codebreaker.breakcode("1235");
        }

        Assert.assertArrayEquals(prompts, new String[]{
                "(Guesses Remaining: 7) What is your guess? Clue: 2220",
                "(Guesses Remaining: 6) What is your guess? Clue: 2220",
                "(Guesses Remaining: 5) What is your guess? Clue: 2220",
                "(Guesses Remaining: 4) What is your guess? Clue: 2220",
                "(Guesses Remaining: 3) What is your guess? Clue: 2220",
                "(Guesses Remaining: 2) What is your guess? Clue: 2220",
                "(Guesses Remaining: 1) What is your guess? Clue: 2220",
                "You have run out of guesses. The secret code was: 1234"
        });
    }

    @Test
    public void cluesAndALoss() {
        String[] prompts = new String[8], inputs = new String[]{
                "6789",
                "4321",
                "9874",
                "2134",
                "1235",
                "1235",
                "1235",
                "1235",
        };

        Codebreaker codebreaker = new Codebreaker("1234");

        for (int i = 0; i < 8; i++) {
            prompts[i] = codebreaker.breakcode(inputs[i]);
        }

        Assert.assertArrayEquals(prompts, new String[]{
                "(Guesses Remaining: 7) What is your guess? Clue: 0000",
                "(Guesses Remaining: 6) What is your guess? Clue: 1111",
                "(Guesses Remaining: 5) What is your guess? Clue: 2000",
                "(Guesses Remaining: 4) What is your guess? Clue: 2211",
                "(Guesses Remaining: 3) What is your guess? Clue: 2220",
                "(Guesses Remaining: 2) What is your guess? Clue: 2220",
                "(Guesses Remaining: 1) What is your guess? Clue: 2220",
                "You have run out of guesses. The secret code was: 1234"
        });
    }

    @Test
    public void badUserInput() {
        String[] prompts = new String[2], inputs = new String[]{
                "111",
                "1234"
        };

        Codebreaker codebreaker = new Codebreaker("1234");

        for (int i = 0; i < inputs.length; i++) {
            prompts[i] = codebreaker.breakcode(inputs[i]);
        }

        Assert.assertArrayEquals(prompts, new String[]{
                "(Guesses Remaining: 7) What is your guess? 111 is an invalid guess. Please guess again.",
                "You have guessed the secret code. You win!"
        });
    }
}
