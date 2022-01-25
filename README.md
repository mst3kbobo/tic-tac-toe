# tic-tac-toe

Basic Tic-tac-toe game written in Java.

Note: This example was a practice exercise I worked on for an upcoming coding interview I had in December 2021.

#### Known Issues:
1. There is a bug where player one starts in a corner and the diags are checked. 
   The opposite diag will contain all `-` and a winner will be declared. 
   This will need to be fixed by ignoring the filler character `-` of a board when checking for a win.
