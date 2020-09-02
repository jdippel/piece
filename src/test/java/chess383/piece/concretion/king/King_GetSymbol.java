/*
 *  King_GetSymbol.java
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
package chess383.piece.concretion.king;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class King_GetSymbol.java implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method String getSymbol( ) for class King is tested")
public class King_GetSymbol {    
    
    final String WHITE_KING_SYMBOL = "\u2654";
    final String BLACK_KING_SYMBOL = "\u265A";
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for an initial white king the figurine symbol of a white king is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAnInitialWhiteKing() {
        
        final String LOCATION = "e1";
        King piece = InitialKing.create( LOCATION );
        
        assertThat( WHITE_KING_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for a moved white king the figurine symbol of a moved white king is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAMovedWhiteKing() {
        
        final String LOCATION = "e4";
        King piece = MovedKing.create( LOCATION );
        
        assertThat( WHITE_KING_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for an arbitrary king the figurine symbol of a white king is returned")
    public void getSymbol_ShouldReturnTheFigurineOfAWhiteKing() {
        
        final String LOCATION = "e4";
        King piece = MovedKing.create( LOCATION );
        
        assertThat( WHITE_KING_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol() );;
    }
    
    @Test
    @DisplayName("for an initial black king the figurine symbol of a black king is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAnInitialBlackKing() {
        
        final String LOCATION = "e8";
        King piece = InitialKing.create( LOCATION );
        
        assertThat( BLACK_KING_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
    
    @Test
    @DisplayName("for a moved black king the figurine symbol of a black king is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAMovedBlackKing() {
        
        final String LOCATION = "e4";
        King piece = MovedKing.create( LOCATION );
        
        assertThat( BLACK_KING_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
}


