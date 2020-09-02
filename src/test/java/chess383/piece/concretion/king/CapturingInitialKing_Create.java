/*
 *  CapturingInitialKing_Create.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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
 * The class CapturingInitialKing_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2019
 *
 */
@DisplayName("the public method InitialKing create( ) for class InitialKing is tested for capturings")
public class CapturingInitialKing_Create {  
    
    
    @ParameterizedTest( name = "given a standard board from location {0} the capturings must match {1}" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource_ForCapturings( String origin, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        InitialKing piece = InitialKing.create( origin );
        Set<List<String>> capturings = piece.getCapturingLines( );
    
        assertThat( expectedResultList.size() ).as("structures must be of equal size").isEqualTo( capturings.size() );
        for( List<String> moves : capturings ) {
            assertThat( expectedResultList )
                      .as( "possible line must be contained within the expected result list" )
                      .contains( String.join( " ", moves ) );
        }
    }
    
    
    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "e1", Arrays.asList( "e1 d1", "e1 d2", "e1 e2", "e1 f1", "e1 f2" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 c3", "d4 c4", "d4 c5", "d4 d3", "d4 d5", "d4 e3", "d4 e4", "d4 e5" ) )
            
        ); }
}


