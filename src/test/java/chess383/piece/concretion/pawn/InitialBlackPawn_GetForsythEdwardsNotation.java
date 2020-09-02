/*
 *  InitialBlackPawn_GetForsythEdwardsNotation.java
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import chess383.ICoordinateFactory;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class InitialBlackPawn_GetForsythEdwardsNotation implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2019
 *
 */
@DisplayName("the public method Character getForsythEdwardsNotation() for class InitialBlackPawn is tested")
public class InitialBlackPawn_GetForsythEdwardsNotation {    
    
    @Test
    @DisplayName("for an initial black pawn the FEN abbreviation ignoring upper/lower case should match the given abrreviation")
    public void getForsythEdwardsNotation_WhenGivenInitialBlackPawn_ThenTheFENAbbreviationMatches() {
        
        final Character FEN_DESCRIPTION = 'p';
        final String LOCATION = "e4";
        Piece.createBoard( ICoordinateFactory.STANDARD.get( ) );
        InitialBlackPawn piece = InitialBlackPawn.create( LOCATION );
        
        assertThat( piece.getForsythEdwardsNotation() )
                  .as( "the Character representation ignoring upper/lower case should match" )
                  .isEqualTo( FEN_DESCRIPTION );
    }
}


