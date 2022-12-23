/*
 *  WhitePawn_Create.java
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

import chess383.piece.abstraction.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class WhitePawn_GetStaticForsythEdwardsNotation implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public static method Character getStaticForsythEdwardsNotation() for class WhitePawn is tested")
public class WhitePawn_GetStaticForsythEdwardsNotation {
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("the letter for a white pawn used in the Forsyth-Edwards-Notation is checked ")
    public void WhitePawn_CheckLetterForWhitePawnUsedInFEN() {
        
        final Character LETTER = 'P';
        
        assertThat( WhitePawn.getStaticForsythEdwardsNotation() ).
                as( "the method should return true for the correct instance" ).
                isEqualTo( LETTER );
    }
}


