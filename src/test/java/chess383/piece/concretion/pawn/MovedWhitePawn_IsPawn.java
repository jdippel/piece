/*
 *  MovedWhitePawn_IsPawn.java
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import chess383.ICoordinateFactory;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class MovedWhitePawn_IsPawn.java implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   June 2020
 *
 */
@DisplayName("the public method boolean isPawn() for class MovedWhitePawn is tested")
public class MovedWhitePawn_IsPawn {    
    
    @Test
    @DisplayName("for a moved white pawn the request for pawn attribute should return true")
    public void isPawn_WhenGivenMoveddWhitePawn_ThenTheQuestionISPawnshouldBeAnsweredWithTrue() {
        
        final String LOCATION = "e4";
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        MovedWhitePawn piece = MovedWhitePawn.create( LOCATION );
        
        assertThat( true )
                  .as( "the method should return true for pawns" )
                  .isEqualTo( piece.isPawn() );
    }
}


