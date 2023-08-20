# Turing Machine Program

## Description

This Java program simulates a Turing Machine that accepts strings from the language L = {0^(2^n); n >= 0}. This project was developed as part of an Automata Theory course during my bachelor's studies. A Turing Machine is a mathematical model of computation consisting of a tape with cells, a read/write head, and a set of states. The machine accepts strings where the length of the sequence of zeros is a power of 2 (0, 1, 2, 4, 8, ...).

## Features

- Accepts strings from language L = {0^(2^n); n >= 0}.
- Simulates a Turing Machine with tape, read/write head, and states.

## Usage

1. Clone the repository to your local machine.
   ```bash
    git clone https://github.com/Michael-Moulana/turing-machine.git
2. Open the project in your Java development environment.
3. Compile and run the `MainClass` to execute the Turing Machine program.
4. Follow the on-screen instructions to enter the number of zeros and observe the machine's behavior.

## How It Works

1. User inputs the number of zeros.
2. The `TuringMachine` class is instantiated with the input.
3. The Turing Machine's logic is executed, processing the input string.
4. Machine displays the tape's state after each step and reports acceptance or rejection.

## Contributing

Contributions are welcome! If you find issues or want to make improvements, open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
