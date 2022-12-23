/*
 *  Piece_CreateBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2021 Jörg Dippel
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;

/**
 * <p>
 * The class Piece_CreateBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public static method void createBoard() for class Piece is tested")
public class Piece_CreateBoard {    
    
    @Test
    @DisplayName("undefined board should be rejected by calling the attribute")
    public void rejectBoardOnReadingTheRelatedAttribute() {

        Piece.createBoard( null );

        assertThat( Piece.getBoard() ).as( "undefined board should be rejected" ).isNull();
    }

    @Test
    @DisplayName("undefined board should be rejected by NPE on trying to get information")
    public void rejectBoardOnGettingInformation() {

        Piece.createBoard( ( ICoordinate )null );
        assertThatThrownBy(() -> { Piece.getBoard( ).getAllLocations(); })
                .isInstanceOf( NullPointerException.class );

    }

    @Test
    @DisplayName("assigning different boards should have changing effects")
    public void differentBoardsAreDifferent() {

        int numberOfLocations = Piece.getBoard().getAllLocations().size();
        Piece.createBoard( ICoordinateFactory.THREE_DIMENSIONAL.get() );
        assertThat( Piece.getBoard().getAllLocations().size() != numberOfLocations ).as( "different board may have different number of locations" ).isTrue();

    }

    @Test
    @DisplayName("implicitely a STANDARD board is defined")
    public void itIsNotNecessaryToDefineAStandardBoard() {

        Piece.createBoard();
        int numberOfLocations = Piece.getBoard().getAllLocations().size();

        Piece.createBoard( ICoordinateFactory.THREE_DIMENSIONAL.get() );
        Piece.createBoard();
        assertThat( Piece.getBoard().getAllLocations().size() == numberOfLocations ).as( "implicitely a standard board is taken" ).isTrue();

    }

    @Test
    @DisplayName("board should be defined")
    public void compareSameTypesonSameLocation() {

        Piece.createBoard();
        final String LOCATION = "e4";
        
        assertThat( Piece.getBoard().getAllLocations().contains( LOCATION ) ).as( "board as a set of locations should be defined" ).isTrue();
    }
}


