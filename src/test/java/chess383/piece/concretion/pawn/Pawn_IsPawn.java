/*
 *  Pawn_IsPawn.java
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
package chess383.piece.concretion.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Pawn_IsPawn implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method boolean isPawn() for class Pawn is tested")
public class Pawn_IsPawn {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for an initial black pawn the attibute isPawn() is confirmed")
    public void isPawn_shouldReturnTrueForInitialBlackPawns() {
        
        final String LOCATION = "e7";
        Pawn piece = InitialBlackPawn.create( LOCATION );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isBlackPawn() ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for an initial white pawn the attibute isPawn() is confirmed")
    public void isPawn_shouldReturnTrueForInitialWhitePawns() {
        
        final String LOCATION = "e4";
        Pawn piece = InitialWhitePawn.create( LOCATION );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isWhitePawn() ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a moved black pawn the attibute isPawn() is confirmed")
    public void isPawn_shouldReturnTrueForMovedBlackPawns() {
        
        final String LOCATION = "e4";
        Pawn piece = MovedBlackPawn.create( LOCATION );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isBlackPawn() ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a moved white pawn the attibute isPawn() is confirmed")
    public void isPawn_shouldReturnTrueForMovedWhitePawns() {
        
        final String LOCATION = "e4";
        Pawn piece = MovedWhitePawn.create( LOCATION );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isWhitePawn() ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for other pieces the attibute isPawn() must be false")
    public void isPawn_shouldReturnFalseForOtherPieces() {
        
        final String LOCATION = "e4";
        
        assertThat( InitialWhitePawn.create( LOCATION ).isBlackPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedWhitePawn.create( LOCATION ).isBlackPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialBlackPawn.create( LOCATION ).isWhitePawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedBlackPawn.create( LOCATION ).isWhitePawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Rook.create( LOCATION ).isPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Knight.create( LOCATION ).isPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Bishop.create( LOCATION ).isPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( InitialKing.create( LOCATION ).isPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( MovedKing.create( LOCATION ).isPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
        assertThat( Queen.create( LOCATION ).isPawn() ).as( "must be false for an instance of an other piece" ).isFalse();
    }
}


