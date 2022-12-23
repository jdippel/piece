/*
 *  PieceFactory_GetRookLineContaining.java
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
package chess383.piece.abstraction;

import chess383.ICoordinateFactory;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.pawn.BlackPawn;
import chess383.piece.concretion.pawn.WhitePawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class PieceFactory_IsPawnToBePromoted implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public static method boolean isPawnToBePromoted for class PieceFactory is tested")
public class PieceFactory_IsPawnToBePromoted {
    
    static {  Piece.createBoard( ICoordinateFactory.STANDARD.get( ) ); }
    
    @Test
    @DisplayName("white pawn is not to be promoted")
    public void isPawnToBePromoted_WhitePawnIsNotToBePromoted() {
        
        final String LOCATION = "e4";
        WhitePawn pawn = (WhitePawn) PieceFactory.createPiece( "e2", 'P' );
        
        assertThat( PieceFactory.isPawnToBePromoted( LOCATION, pawn ) ).as( "pawn should not be promoted" ).isFalse();
    }

    @Test
    @DisplayName("white pawn is to be promoted")
    public void isPawnToBePromoted_WhitePawnIsToBePromoted() {

        final String LOCATION = "e8";
        WhitePawn pawn = (WhitePawn) PieceFactory.createPiece( "e4", 'P' );

        assertThat( PieceFactory.isPawnToBePromoted( LOCATION, pawn ) ).as( "pawn should not be promoted" ).isTrue();
    }

    @Test
    @DisplayName("black pawn is not to be promoted")
    public void isPawnToBePromoted_BlackPawnIsNotToBePromoted() {

        final String LOCATION = "e4";
        BlackPawn pawn = (BlackPawn) PieceFactory.createPiece( "e2", 'p' );

        assertThat( PieceFactory.isPawnToBePromoted( LOCATION, pawn ) ).as( "pawn should not be promoted" ).isFalse();
    }

    @Test
    @DisplayName("black pawn is to be promoted")
    public void isPawnToBePromoted_BlackPawnIsToBePromoted() {

        final String LOCATION = "e1";
        BlackPawn pawn = (BlackPawn) PieceFactory.createPiece( "e7", 'p' );

        assertThat( PieceFactory.isPawnToBePromoted( LOCATION, pawn ) ).as( "pawn should not be promoted" ).isTrue();
    }

    @Test
    @DisplayName("a bishop is not to be promoted")
    public void isPawnToBePromoted_BishopIsNotToBePromoted() {

        final String LOCATION = "e1";
        Piece piece = PieceFactory.createPiece( "e7", 'b' );

        assertThat( PieceFactory.isPawnToBePromoted( LOCATION, piece ) ).as( "bishop should not be promoted" ).isFalse();
    }
}


