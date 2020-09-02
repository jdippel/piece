/*
 *  Bishop_IsBishop.java
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
package chess383.piece.concretion.bishop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Bishop_IsBishop implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method boolean isBishop() for class Bishop is tested")
public class Bishop_IsBishop {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for a bishop the attibute isBishop() is confirmed")
    public void isBishop_shouldReturnTrueForBishops() {
        
        final String LOCATION = "e4";
        Bishop piece = Bishop.create( LOCATION );
        
        assertThat( piece.isBishop() ).as( "should confirm the bishop instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for other pieces the attibute isBishop() must be false")
    public void isBishop_shouldReturnFalseForOtherPieces() {
        
        final String LOCATION = "e4";
        
        assertThat( InitialWhitePawn.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedWhitePawn.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialBlackPawn.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedBlackPawn.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Rook.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Knight.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialKing.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedKing.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Queen.create( LOCATION ).isBishop() ).as( "must be false for an instance of an other piece" ).isFalse();
    }
}


