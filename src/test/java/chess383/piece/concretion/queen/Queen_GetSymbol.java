/*
 *  Queen_GetSymbol.java
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
package chess383.piece.concretion.queen;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Queen_GetSymbol.java implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method String getSymbol( ) for class Queen is tested")
public class Queen_GetSymbol {    

    final String WHITE_QUEEN_SYMBOL = "\u2655";
    final String BLACK_QUEEN_SYMBOL = "\u265B";
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for a white queen the figurine symbol of a white queen is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAWhiteQueen() {
        
        final String LOCATION = "e4";
        Queen piece = Queen.create( LOCATION );
        
        assertThat( WHITE_QUEEN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for an arbitrary queen the figurine symbol of a white queen is returned")
    public void getSymbol_ShouldReturnTheFigurineOfAWhiteQueen() {
        
        final String LOCATION = "e4";
        Queen piece = Queen.create( LOCATION );
        
        assertThat( WHITE_QUEEN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol() );;
    }
    
    @Test
    @DisplayName("for a black queen the figurine symbol of a black queen is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfABlackQueen() {
        
        final String LOCATION = "e4";
        Queen piece = Queen.create( LOCATION );
        
        assertThat( BLACK_QUEEN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
}


