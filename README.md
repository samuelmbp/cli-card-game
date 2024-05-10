# CLI Card Game


## Getting Started
To run the CLI Card Game, follow these steps:

- Clone this repository to your local machine.
  - git clone https://github.com/samuelmbp/cli-card-game
- Open the project in a text editor of your choice (e.g.,IntelliJ IDEA) to access the source code
- Open the Main.java class in IntelliJ IDEA and use the "run" button (typically a green triangle icon) to compile and execute the game.
- Choose one of the following games: 
    - Clash of Cards
    - Good King, Bad Queen

## Combined Game Features
- Deal a Card
- Shuffle a Card
- Reset Deck
- Populate Deck Cards 
- Get Deck Of Cards
- Display Game Score For Each Player

## Usage - Clash of Cards (Samuel Raducan)
The rules of the game are as follows:

1. Each player draws one card from the deck in each round
2. The player with the higher card value wins the round and earns 10 points
3. In case of a tie, the game proceeds to a 'Clash of Cards' where each player draws three more cards
4. The player with the higher value on the fourth drawn card wins the 'Clash of Cards' and earns 30 additional points
5. If there is a second tie immediately after the first tie, no points are awarded
6. Each player starts with 0 points, and the game continues until the deck is empty
7. The player with the highest score at the end of the game wins

## Usage - Good King, Bad Queen (Sanjida Begum)
The rules of the game are as follows:

1. Each player turns a card at the same time
2. The player with the highest card takes both cards and wins that round
3. If the cards are of the same rank, it is a tie
4. But if you can capture a King, you are awarded 5 cards from your opponent
5. However, if you capture a Queen, you lose 5 cards
6. The player with the most cards win the game

## Technologies
- Java
- JUnit5
- Maven

### Contributors
- Samuel Raducan
- Sanjida Begum

