
/*
 *  Starter.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package chess383.piece.runner;

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * This class starts an application to view the text output.
 *
 * @author    Jörg Dippel
 * @version   Juli 2020
 *
 */
public final class Starter {

	private static void provide( Piece piece ) {
		System.out.println( String.format("Dies ist ein(e) %s, der/die %s%s hat die Figurine %s oder %s", piece.getName(), piece.getType(), piece.getLocation(),
				piece.getSymbol(), piece.getSymbol( ColorEnum.BLACK ) ));
	}
	
    public static void main( String[] args ) {

    	final String ORIGIN = "e5";

    	provide( MovedKing.create( ORIGIN ) );
    	provide( Queen.create( ORIGIN ) );
    	provide( Rook.create( ORIGIN ) );
    	provide( Knight.create( ORIGIN ) );
    	provide( Bishop.create( ORIGIN ) );
    	provide( MovedBlackPawn.create( ORIGIN ) );	
    }
}

