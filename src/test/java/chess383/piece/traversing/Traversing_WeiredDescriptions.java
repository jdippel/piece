/*
 *  Traversing_WeiredDescriptions.java
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
package chess383.piece.traversing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinateFactory;
import chess383.exception.Chess383Exception;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Traversing_WeiredDescriptions implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
@DisplayName("the public method Traversing_Traverse traversePieces( ) for class Traversing is tested")
public class Traversing_WeiredDescriptions {  
    
    @Test
    @DisplayName("Only 56 locations are defined in description.")
    public void traversePieces_TooFewLocations() {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        String pieceDescriptionByFEN = "r3k2r/8/8/8/8/8/8";    // string too short
        
        assertThatThrownBy(() -> { Traversing.traversePieces( pieceDescriptionByFEN ); })
                .isExactlyInstanceOf( Chess383Exception.class )
                .hasMessageContainingAll( "There are still locations defined for input" );
    }
}


