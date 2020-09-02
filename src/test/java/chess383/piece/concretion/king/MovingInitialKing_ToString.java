/*
 *  MovingInitialKing_ToString.java
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
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinateFactory;
import chess383.piece.abstraction.Piece;
import chess383.piece.abstraction.Piece2String;

/**
 * <p>
 * The class MovingInitialKing_ToString implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2019
 *
 */
@DisplayName("the public method String toString( ) for class InitialKing is tested for movings")
public class MovingInitialKing_ToString {   
    
    @ParameterizedTest( name = "given a standard board from location {0} the string representation is delegated to class Piece2String" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource_ForDelegation( String origin, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        InitialKing piece = InitialKing.create( origin );
        
        Piece2String description = new Piece2String( piece );
        assertThat( piece.toString() )
                  .as( "the string representation is delegated to class Piece2String and should match" )
                  .contains( description.toString() );
    }
    
    @ParameterizedTest( name = "given a standard board from location {0} the string representation starts with the piece name" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource_ForPieceName( String origin, List<String> expectedResultList ) {
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        String PIECE_NAME = "initial king";
        InitialKing piece = InitialKing.create( origin );

        assertThat( piece.toString() )
                  .as( "the string representation should start with the piece name" )
                  .startsWith( PIECE_NAME );
    }
    
    @ParameterizedTest( name = "given a standard board from location {0} the string representation contains the location" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource_ForLocation( String origin, List<String> expectedResultList ) {
        
        final int LOCATION_LENGTH = 2;
        
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        InitialKing piece = InitialKing.create( origin );
        Piece2String description = new Piece2String( piece );
        
        assertThat( Piece2String.extractLocation( description.toString(), LOCATION_LENGTH ) )
                  .as( "the string representation should contain the location" )
                  .isEqualTo( origin );
    }
    
    @ParameterizedTest( name = "given a standard board from location {0} the string representation contains all lines for movings given by {1}" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource_forMoves( String origin, List<String> expectedResultList ) {

        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        InitialKing piece = InitialKing.create( origin );
        
        String description = new Piece2String( piece ).toString();
        String moving = Piece2String.extractMoving( description );

        for( String list : expectedResultList ) {
            assertThat( moving )
                      .as( "sorted movings must be contained in expected list" )
                      .contains( list );
        }   
    }
    
    
    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "e1", Arrays.asList( "e1 d1 c1", "e1 d2", "e1 e2", "e1 f1 g1", "e1 f2" ) )
            
        ); }
}

