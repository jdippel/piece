/*
 *  Knight_GetSymbol.java
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
package chess383.piece.concretion.knight;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Knight_GetSymbol.java implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method String getSymbol( ) for class Knight is tested")
public class Knight_GetSymbol {    
	
    final String WHITE_KNIGHT_SYMBOL = "\u2658";
    final String BLACK_KNIGHT_SYMBOL = "\u265E";
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for a white knight the figurine symbol of a white knight is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAWhiteKnight() {
        
        final String LOCATION = "e4";
        Knight piece = Knight.create( LOCATION );
        
        assertThat( WHITE_KNIGHT_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for an arbitrary knight the figurine symbol of a white knight is returned")
    public void getSymbol_ShouldReturnTheFigurineOfAWhiteKnight() {
        
        final String LOCATION = "e4";
        Knight piece = Knight.create( LOCATION );
        
        assertThat( WHITE_KNIGHT_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol() );;
    }
    
    @Test
    @DisplayName("for a black knight the figurine symbol of a black knight is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfABlackKnight() {
        
        final String LOCATION = "e4";
        Knight piece = Knight.create( LOCATION );
        
        assertThat( BLACK_KNIGHT_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
}


