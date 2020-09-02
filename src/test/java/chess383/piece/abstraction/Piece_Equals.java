/*
 *  Piece_Equals.java
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
package chess383.piece.abstraction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Piece_Equals implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the protected static method boolean validateLocation() for class Piece is tested")
public class Piece_Equals {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("queens on same locations are equal")
    public void compareSameTypesonSameLocation() {
        
        final String LOCATION = "e4";
        
        assertThat( Queen.create( LOCATION ).equals( Queen.create( LOCATION ) ) ).as( "Queens on same locations are equal" ).isTrue();
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@Test
    @DisplayName("pieces on same locations are equal if they are the same type")
    public void compareDifferentTypesonSameLocation() {
        
        final String LOCATION = "e4";
        
        assertThat( Queen.create( LOCATION ).equals( Rook.create( LOCATION ) ) ).as( "Pieces on same locations are equal" ).isFalse();
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@Test
    @DisplayName("pieces on same locations are equal if they are the same type")
    public void comparePieceWithAnotherType() {
        
        final String LOCATION = "e4";
        
        assertThat( Queen.create( LOCATION ).equals( new String( "chess" ) ) ).as( "Pieces on same locations are equal" ).isFalse();
    }
    
}


