package com.company;

class Player extends Person {                           //17) Inheritance
	 private char playerPiece;                          //22) Modifiera

	 public Player(String name, char playerPiece){      //14) constuctor
	 	 name.trim();                                   //6) String Class
		 super.setName(name);                           //15) Super Keyword
		 this.playerPiece = playerPiece;                //21) this keyword
	 }
	 public String getName() {
			return super.getName();
		}
	 public char getPlayerPiece() {
	  return this.playerPiece;
	 }
}