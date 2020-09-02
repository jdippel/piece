/*
 *  CapturingInitialBlackPawn_Replace.java
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
 * The class CapturingInitialBlackPawn_Replace implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   June 2020
 *
 */
@DisplayName("the public method MovedBlackPawn replace( ) for class InitialBlackPawn is tested for capturings")
public class CapturingInitialBlackPawn_Replace {     

    @ParameterizedTest( name = "given a standard board a black pawn from location {0} moved to location {1} the movings must match {2}" )
    @MethodSource("stringAndStringAndListProvider")
    public void testWithMultiArgMethodSource_ForCapturings( String origin, String target, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        MovedBlackPawn piece = InitialBlackPawn.create( origin ).replace( target );
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
            
            Arguments.of( "e7", "e5",  Arrays.asList( "e5 d4", "e5 f4" ) ),
            Arguments.of( "e7", "d6",  Arrays.asList( "d6 c5", "d6 e5" ) )
            
        ); }
}


