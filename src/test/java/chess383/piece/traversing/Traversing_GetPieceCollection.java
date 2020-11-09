/*
 *  Traversing_GetPieceCollection.java
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ColorEnum;
import chess383.ICoordinateFactory;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Traversing_GetPieceCollection transforms a Forsyth-Edwards-Notation into two lists of pieces.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method List<Piece> getPieceCollection( ) for class Traversing is tested")
public class Traversing_GetPieceCollection {     
    
	static { Piece.createBoard( ICoordinateFactory.STANDARD.get( ) ); }
	
    @ParameterizedTest( name = "given a Forsyth-Edwards notation \"{0}\" a piece list is generated" )
    @MethodSource("stringAndColorAndListProvider")
    public void testWithMultiArgMethodSource_TraversingForsythEdwardsNotation( String forsythEdwardsNotation, ColorEnum color, List<Piece> pieces ) {
        
        List<Piece> pieceList = Traversing.create( forsythEdwardsNotation ).getPieceCollection( color.isOfWhiteColor() ? ch -> Character.isUpperCase( ch ) : ch -> Character.isLowerCase( ch ) );
        assertThat( pieceList.size() ).as("list structure must be of equal size").isEqualTo( pieces.size() );
        for( Piece piece : pieceList ) {
            assertThat( pieces ).as( "piece must be contained in named list" ).contains( piece );
        }
    }
    
    
    public static Stream<Arguments> stringAndColorAndListProvider() {
        return Stream.of(
            
            Arguments.of( "r3k2r/8/8/8/8/8/8/8", ColorEnum.WHITE, Arrays.asList() )
          , Arguments.of( "r3k2r/8/8/8/8/8/8/8", ColorEnum.BLACK, Arrays.asList( Rook.create( "a8" ), InitialKing.create( "e8" ), Rook.create( "h8" ) ))
          , Arguments.of( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", ColorEnum.WHITE,
        		  Arrays.asList(  InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
        	                Knight.create( "b1" ), Knight.create( "g1" ), Bishop.create( "c1" ), Bishop.create( "f1" ),
        	                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
        	                InitialWhitePawn.create( "e2" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" ) ))
          , Arguments.of( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", ColorEnum.BLACK,
        		  Arrays.asList( InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
        	                Knight.create( "b8" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
        	                InitialBlackPawn.create( "a7" ), InitialBlackPawn.create( "b7" ), InitialBlackPawn.create( "c7" ), InitialBlackPawn.create( "d7" ),
        	                InitialBlackPawn.create( "e7" ), InitialBlackPawn.create( "f7" ), InitialBlackPawn.create( "g7" ), InitialBlackPawn.create( "h7" )))
            
        ); }
}


