# tic-tac-toe

Basic Tic-tac-toe game written in Java.

Note: This example was a practice exercise I worked on for an upcoming coding interview I had in December 2021.

### Game Play:
1. First player will be presented with an empty game board and asked where they'd like to move.
```
Welcome! Here is your board:

-, -, -,
-, -, -,
-, -, -,

Player1 (X) where would you like to move?
```
2. Player will enter two integers (separated by a single space character). This represents the position on the board. Followed by Enter/Return.  
   The first integer represents the row and the second represents the column. 
```
Player1 (X) where would you like to move?
2 2

-, -, -, 
-, X, -, 
-, -, -, 

Player2 (O) where would you like to move?
```
3. Next, the second player will be asked where they'd like to move.
```
Player2 (O) where would you like to move?
1 3

-, -, O, 
-, X, -, 
-, -, -, 

Player1 (X) where would you like to move?
```
4. Play continues back and forth until a player wins or there is a draw.
-----
#### Known Issues:
1. There is a bug where player one starts in a corner and the diags are checked. 
   The opposite diag will contain all `-` and a winner will be declared. 
   This will need to be fixed by ignoring the filler character `-` of a board when checking for a win.
2. Using a `,` as the separator between integer moves throws an exception.
