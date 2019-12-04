# final-project-battleshipgame
This is the final project for CIT-591.
Team member: Zohair Siraj, Jiaxu Zhou, Yu Wang

Battleship ia a strategy type guessing game. In this project, the Battleship Game has been created for user to play.

## Getting Start
Please have the following installed first:
[Ecllipse](https://www.eclipse.org/downloads/) or other Java environment.

## Class Discription
Board Class
  		Has Square classes
  		Can be human or computer
  		Get display string (with newlines)
BoardSquare Class
    	Can get display character
   		Can be W, S, X, or O
   		for human, get S if ship but not hit
   		for computer never get s because we do not know places we have not hit
   		can have reference to a ship
   			if it does, can check the ship's attributes when hit
 Ship Class
 		The 5 ships are: Carrier (occupies 5 spaces), 
 		Battleship (4), Cruiser (3), Submarine (3), 
 		and Destroyer (2).
  		Enum for ship type
  		getShipLength using constants of the ship class
  		horizontal or vertical enums
  		starting position
  		numHit
  		numNotHit
  		if hit and numNotHit is 0, can output you sunk my shipName
 GameController class
  		setup time first
  		for human, go through ships and set up
  		for computer does similar method
  		when either comes across a ship, need to placeShip
			calls tryToPlaceShip until success is had
  		turn enum
  		if human turn, human can move
  		if computer turn, computer can move
  		player interface that human and computer inherit from
  		calls current player to move
  		move is made on opponents board
  		displays board no matter what
  		checks if a ship was sunk
  		if ship was sunk, gets name
 GameView
  		tellShipWasSunk method (input player and ship)
  		display boards
  		tell result of hit or miss
