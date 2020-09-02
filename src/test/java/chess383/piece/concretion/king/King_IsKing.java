/*
 *  King_IsKing.java
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
package chess383.piece.concretion.king;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class King_IsKing implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method boolean isKing() for class King is tested")
public class King_IsKing {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for a moved king the attibute isKing() is confirmed")
    public void isKing_shouldReturnTrueForMovedKings() {
        
        final String LOCATION = "e4";
        King piece = MovedKing.create( LOCATION );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for an initial king the attibute isKing() is confirmed")
    public void isKing_shouldReturnTrueForKings() {
        
        final String LOCATION = "e8";
        King piece = InitialKing.create( LOCATION );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for other pieces the attibute isKing() must be false")
    public void isKing_shouldReturnFalseForOtherPieces() {
        
        final String LOCATION = "e4";
        
        assertThat( InitialWhitePawn.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedWhitePawn.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialBlackPawn.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedBlackPawn.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Rook.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Knight.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Bishop.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Queen.create( LOCATION ).isKing() ).as( "must be false for an instance of an other piece" ).isFalse();
    }
}


