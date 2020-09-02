/*
 *  Rook_GetSymbol.java
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
package chess383.piece.concretion.rook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Rook_GetSymbol.java implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method String getSymbol( ) for class Rook is tested")
public class Rook_GetSymbol {    

    final String WHITE_ROOK_SYMBOL = "\u2656";
    final String BLACK_ROOK_SYMBOL = "\u265C";
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for a white rook the figurine symbol of a white rook is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAWhiteRook() {
        
        final String LOCATION = "e4";
        Rook piece = Rook.create( LOCATION );
        
        assertThat( WHITE_ROOK_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for an arbitrary rook the figurine symbol of a white rook is returned")
    public void getSymbol_ShouldReturnTheFigurineOfAWhiteRook() {
        
        final String LOCATION = "e4";
        Rook piece = Rook.create( LOCATION );
        
        assertThat( WHITE_ROOK_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol() );;
    }
    
    @Test
    @DisplayName("for a black rook the figurine symbol of a black rook is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfABlackRook() {
        
        final String LOCATION = "e4";
        Rook piece = Rook.create( LOCATION );
        
        assertThat( BLACK_ROOK_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
}


