/*
 *  Traversing_GetPieceCollection_Exceptions.java
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

import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ColorEnum;
import chess383.exception.PiecePlacementStringLocationsMissingException;
import chess383.exception.PiecePlacementStringTooManyFreeLocationsException;
import chess383.exception.PiecePlacementStringTooShortException;
import chess383.exception.PiecePlacementStringUnsupportedPieceAbbreviationException;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Traversing_GetPieceCollection_Exceptions throws an exception for an invalid Forsyth-Edwards-Notation.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method List<Piece> getPieceCollection( ) for class Traversing is tested related to thrown exceptions")
public class Traversing_GetPieceCollection_Exceptions {     
    
	static { Piece.createBoard(); }
	
    @SuppressWarnings("rawtypes")
	@ParameterizedTest( name = "given an invalid Forsyth-Edwards notation \"{0}\" then an exception is trown on scanning the input" )
    @MethodSource("stringAndMessageProvider")
    public void testWithMultiArgMethodSource_TraversingForsythEdwardsNotation( String forsythEdwardsNotation, ColorEnum color, Class clazz, String info ) {

    	 assertThatThrownBy(() -> { Traversing.create( forsythEdwardsNotation ).getPieceCollection( isAssociated( color ) ); })
                   .isExactlyInstanceOf( clazz )
                   .hasMessageContaining( info );
    }
    
    private Predicate<Character> isAssociated( ColorEnum color ) {
    	return ( color == ColorEnum.WHITE ) ? (ch) -> Character.isUpperCase(ch) : (ch) -> Character.isLowerCase(ch);
    }
    
  
    
    public static Stream<Arguments> stringAndMessageProvider() {
        return Stream.of(
            
            Arguments.of( "r3k2r/8/8/7L/8/8/8/8", ColorEnum.WHITE, PiecePlacementStringUnsupportedPieceAbbreviationException.class, "Unsupported piece abbreviation for FEN with letter L" ),
            Arguments.of( "r3k2r/8/8/7L/8/4l3/8/8", ColorEnum.BLACK, PiecePlacementStringUnsupportedPieceAbbreviationException.class, "Unsupported piece abbreviation for FEN with letter l" ),
            Arguments.of( "r3k2r/8/8/7x/8/8/8/8", ColorEnum.BLACK, PiecePlacementStringUnsupportedPieceAbbreviationException.class, "Unsupported piece abbreviation for FEN with letter x" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/9/9/8/PPPPPPPP/RNBQKBNR additional text", ColorEnum.WHITE, PiecePlacementStringLocationsMissingException.class, "location h1" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/9/9/8/PPPPPPPP/RNBQKBNR2 additional text", ColorEnum.BLACK, PiecePlacementStringLocationsMissingException.class, "location h7" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/7/7/8/PPPPPPPP/RNBQKBNR additional text", ColorEnum.WHITE, PiecePlacementStringTooShortException.class, "location f1" ),
            Arguments.of( "rbnqk bnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR additional text", ColorEnum.WHITE, PiecePlacementStringTooShortException.class, "" ),
            Arguments.of( "rbnqk bnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR additional text", ColorEnum.BLACK, PiecePlacementStringTooShortException.class, "" ),
            Arguments.of( "rbnqk", ColorEnum.WHITE, PiecePlacementStringTooShortException.class, "" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKB8 additional text", ColorEnum.WHITE, PiecePlacementStringTooManyFreeLocationsException.class, "" ),
            Arguments.of( "rbnqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKB8 additional text", ColorEnum.BLACK, PiecePlacementStringTooManyFreeLocationsException.class, "" )
         
        ); }
}


