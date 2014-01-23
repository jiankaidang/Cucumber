Feature: Codebreaker
  As a person who likes to play guessing games
  I want a program that clones Mastermind from the commandline
  So that I can get used to using BDD, Gherkin, and Cucumber

  Scenario: Command prompt
    Given I start codebreaker with code "1234"
    When I run the game with the following inputs:
      | inputs |
      | 1235   |
      | 1235   |
      | 1235   |
      | 1235   |
      | 1235   |
      | 1235   |
      | 1235   |
      | 1235   |
    Then I should see the following prompts:
      | prompt                                                 |
      | (Guesses Remaining: 7) What is your guess? Clue: 2220  |
      | (Guesses Remaining: 6) What is your guess? Clue: 2220  |
      | (Guesses Remaining: 5) What is your guess? Clue: 2220  |
      | (Guesses Remaining: 4) What is your guess? Clue: 2220  |
      | (Guesses Remaining: 3) What is your guess? Clue: 2220  |
      | (Guesses Remaining: 2) What is your guess? Clue: 2220  |
      | (Guesses Remaining: 1) What is your guess? Clue: 2220  |
      | You have run out of guesses. The secret code was: 1234 |

#  Scenario: Clues and a loss
#    Given I start codebreaker with code "1234"
#    When I run the game with the following inputs:
#      | inputs |
#      | 6789   |
#      | 4321   |
#      | 9874   |
#      | 2134   |
#      | 1235   |
#      | 1235   |
#      | 1235   |
#      | 1235   |
#    Then I should see the following clues:
#      | clues                                                  |
#      | Clue: 0000                                             |
#      | Clue: 1111                                             |
#      | Clue: 2000                                             |
#      | Clue: 2211                                             |
#      | Clue: 2220                                             |
#      | Clue: 2220                                             |
#      | Clue: 2220                                             |
#      | You have run out of guesses. The secret code was: 1234 |
#
#  Scenario: Bad user input response and win output
#    Given I start codebreaker with code "1234"
#    When I run the game with the following inputs:
#      | inputs |
#      | 111    |
#      | 1234   |
#    Then I should see the following clues:
#      | clues                                        |
#      | 111 is an invalid guess. Please guess again. |
#      | You have guessed the secret code. You win!   |
