import tkinter as tk
import random

class NumberGuessingGame:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("Number Guessing Game")

        self.target_number = random.randint(1, 100)
        self.guesses_left = 10

        self.label = tk.Label(self.window, text="Guess a number between 1 and 100")
        self.label.pack()

        self.entry = tk.Entry(self.window)
        self.entry.pack()

        self.submit_button = tk.Button(self.window, text="Submit", command=self.check_guess)
        self.submit_button.pack()

        self.result_label = tk.Label(self.window, text="")
        self.result_label.pack()

    def check_guess(self):
        guess = int(self.entry.get())
        self.guesses_left -= 1

        if guess == self.target_number:
            self.result_label.config(text="Congratulations! You guessed the number.")
            self.submit_button.config(state=tk.DISABLED)
        elif self.guesses_left == 0:
            self.result_label.config(text=f"Game Over. The number was {self.target_number}.")
            self.submit_button.config(state=tk.DISABLED)
        elif guess < self.target_number:
            self.result_label.config(text=f"Try again. The number is higher. Guesses left: {self.guesses_left}")
        else:
            self.result_label.config(text=f"Try again. The number is lower. Guesses left: {self.guesses_left}")

        self.entry.delete(0, tk.END)

game = NumberGuessingGame()
game.window.mainloop()
