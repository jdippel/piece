/*
 *  Rook_IsRook.java
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
package chess383.piece.concretion.rook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;

/**
 * <p>
 * The class Rook_IsRook implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method boolean isRook() for class Rook is tested")
public class Rook_IsRook {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for a rook the attibute rook is confirmed")
    public void isRook_shouldReturnTrueForRooks() {
        
        final String LOCATION = "e4";
        Rook piece = Rook.create( LOCATION );
        
        assertThat( piece.isRook() ).as( "should confirm the rook instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for other pieces the attibute isRook() must be false")
    public void isRook_shouldReturnFalseForOtherPieces() {
        
        final String LOCATION = "e4";
        
        assertThat( InitialWhitePawn.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedWhitePawn.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialBlackPawn.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedBlackPawn.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Knight.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Bishop.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialKing.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedKing.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Queen.create( LOCATION ).isRook() ).as( "must be false for an instance of an other piece" ).isFalse();
    }
}


