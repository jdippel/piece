/*
 *  Piece_HashCode.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020, 2021 Jörg Dippel
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

/**
 * <p>
 * The class Piece_HashCode implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2021
 *
 */
@DisplayName("the public method int hashCode() for class Piece is tested")
public class Piece_HashCode {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("queens on same locations have the same hashCode")
    public void compareSameTypesonSameLocation() {
        
        final String LOCATION = "e4";
        
        assertThat( Queen.create( LOCATION ).hashCode() == Queen.create( LOCATION ).hashCode() ).as( "Queens on same locations have the same hashCode" ).isTrue();
    }
    
    @Test
    @DisplayName("queens on different locations should have different hashCodes")
    public void compareSameTypesOnDifferentLocations() {
        
        final String LOCATION = "e4";
        final String DIFFERENT_LOCATION = "b2";
        
        assertThat( Queen.create( LOCATION ).hashCode() == Queen.create( DIFFERENT_LOCATION ).hashCode() ).as( "Queens on different locations should have different hashCode" ).isFalse();
    }
}


