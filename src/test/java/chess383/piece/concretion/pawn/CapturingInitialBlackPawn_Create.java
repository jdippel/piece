/*
 *  CapturingInitialBlackPawn_Create.java
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
package chess383.piece.concretion.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
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
 * The class CapturingInitialBlackPawn_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2019
 *
 */
@DisplayName("the public method InitialBlackPawn create( ) for class InitialBlackPawn is tested for capturings")
public class CapturingInitialBlackPawn_Create {     

    @ParameterizedTest( name = "given a standard board from location {0} the capturings must match {1}" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource_ForCapturings( String origin, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        InitialBlackPawn piece = InitialBlackPawn.create( origin );
        Set<List<String>> capturings = piece.getCapturingLines( );
    
        assertThat( expectedResultList.size() ).as("structures must be of equal size").isEqualTo( capturings.size() );
        for( List<String> moves : capturings ) {
            assertThat( expectedResultList )
                      .as( "possible line must be contained within the expected result list" )
                      .contains( String.join( " ", moves ) );
        }
    }
    
    
    private static final ArrayList<String> ARRAY_LIST = new ArrayList<String>();
    private static final List<String>  EMPTY_STRING_LIST = ARRAY_LIST;
    
    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "e7", Arrays.asList( "e7 d6", "e7 f6" ) ),
            Arguments.of( "e1", EMPTY_STRING_LIST )
            
        ); }
}


