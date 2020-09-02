/*
 *  Traversing_TraversePieces_Exceptions.java
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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.exception.Chess383Exception;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Traversing_TraversePieces_Exceptions throws an exception for an invalid Forsyth-Edwards-Notation.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public static method List<List<Piece>> traversePieces( ) for class Traversing is tested")
public class Traversing_TraversePieces_Exceptions {     
    
	static { Piece.createBoard(); }
	
    @ParameterizedTest( name = "given an invalid Forsyth-Edwards notation \"{0}\" then an exception is trown on scanning the input" )
    @MethodSource("stringAndMessageProvider")
    public void testWithMultiArgMethodSource_TraversingForsythEdwardsNotation( String forsythEdwardsNotation, String message ) {
        
    	try {
            @SuppressWarnings("unused")  // an exception is thrown
            List<List<Piece>> bothPieceCollections = Traversing.traversePieces( forsythEdwardsNotation );
    	}
    	catch( Chess383Exception exception ) {
    		
            assertThat( exception.getMessage().contains( message ) ).as( String.format( "Exception is described as: %s", exception.getMessage() ) ).isTrue();
    	}
    }
    
    
    public static Stream<Arguments> stringAndMessageProvider() {
        return Stream.of(
            
            Arguments.of( "r3k2r/8/8/7L/8/8/8/8", "Unsupported piece abbreviation" ),
            Arguments.of( "r3k2r/8/8/7x/8/8/8/8", "Unsupported piece abbreviation" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/9/9/8/PPPPPPPP/RNBQKBNR additional text", "There are no more locations defined for" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/9/9/8/PPPPPPPP/RNBQKBNR2 additional text", "There are no more locations defined for" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/7/7/8/PPPPPPPP/RNBQKBNR additional text", "There are still locations defined for input" ),
            Arguments.of( "rbnqk bnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR additional text", "There are still locations defined for input" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKB8 additional text", "There are no more locations defined for input" )
         
        ); }
}


