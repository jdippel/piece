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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class WhitePawn_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method WhitePawn create() for class WhitePawn is tested")
public class WhitePawn_Create {    
    
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("a pawn is created and it should be of type MovedWhitePawn")
    public void WhitePawn_CreateMovedWhitePawn() {
        
        final String LOCATION = "e5";
        
        Pawn pawn = WhitePawn.create( LOCATION );
        
        assertThat( pawn instanceof MovedWhitePawn ).as( "the method should return true for the correct instance" ).isTrue();
    }
    
    @Test
    @DisplayName("a pawn is created and it should be of type InitialWhitePawn")
    public void WhitePawn_CreateInitialWhitePawn() {
        
        final String LOCATION = "e2";
        
        Pawn pawn = WhitePawn.create( LOCATION );
        
        assertThat( pawn instanceof InitialWhitePawn ).as( "the method should return true for the correct instance" ).isTrue();
    }
}


