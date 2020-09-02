/*
 *  Bishop_Replace.java
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

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinateFactory;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Bishop_Replace implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   June 2020
 *
 */
@DisplayName("the public method Bishop replace( ) for class Bishop is tested")
public class Bishop_Replace {    

    @ParameterizedTest( name = "given a standard board a bishop from location {0} moved to location {1} the movings must match {2}" )
    @MethodSource("stringAndStringAndListProvider")
    public void testWithMultiArgMethodSource_ForMovings( String origin, String target, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        Bishop piece = Bishop.create( origin ).replace( target );
        Set<List<String>> movings = piece.getMovingLines( );
    
        assertThat( expectedResultList.size() ).as("structures must be of equal size").isEqualTo( movings.size() );
        for( List<String> moves : movings ) {
            assertThat( expectedResultList )
                      .as( "possible line must be contained within the expected result list" )
                      .contains( String.join( " ", moves ) );
        }
    }
    
    @ParameterizedTest( name = "given a standard board a bishop from location {0} moved to location {1} the movings must match {2}" )
    @MethodSource("stringAndStringAndListProvider")
    public void testWithMultiArgMethodSource_ForCapturings( String origin, String target, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        Bishop piece = Bishop.create( origin ).replace( target );
        Set<List<String>> capturings = piece.getCapturingLines( );
    
        assertThat( expectedResultList.size() ).as("structures must be of equal size").isEqualTo( capturings.size() );
        for( List<String> moves : capturings ) {
            assertThat( expectedResultList )
                      .as( "possible line must be contained within the expected result list" )
                      .contains( String.join( " ", moves ) );
        }
    }
    
    
    public static Stream<Arguments> stringAndStringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "c3", "a1", Arrays.asList( "a1 b2 c3 d4 e5 f6 g7 h8" ) ),
            Arguments.of( "c2", "e4", Arrays.asList( "e4 d3 c2 b1", "e4 d5 c6 b7 a8", "e4 f5 g6 h7", "e4 f3 g2 h1" ) ),
            Arguments.of( "d8", "h4", Arrays.asList( "h4 g3 f2 e1", "h4 g5 f6 e7 d8" ) )
            
        ); }
}


