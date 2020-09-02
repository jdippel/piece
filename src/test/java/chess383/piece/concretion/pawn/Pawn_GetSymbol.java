/*
 *  Pawn_GetSymbol.java
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

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;

/**
 * <p>
 * The class Pawn_GetSymbol.java implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method String getSymbol( ) for class Pawn is tested")
public class Pawn_GetSymbol {    
	
    final String WHITE_PAWN_SYMBOL = "\u2659";
    final String BLACK_PAWN_SYMBOL = "\u265F";
    static { Piece.createBoard(); }
    
    @Test
    @DisplayName("for an initial white pawn the figurine symbol of a white pawn is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAnInitialWhitePawn() {
        
        final String LOCATION = "e2";
        Pawn piece = InitialWhitePawn.create( LOCATION );
        
        assertThat( WHITE_PAWN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for a moved white pawn the figurine symbol of a white pawn is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAMvvedWhitePawn() {
        
        final String LOCATION = "e4";
        Pawn piece = MovedWhitePawn.create( LOCATION );
        
        assertThat( WHITE_PAWN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.WHITE ) );;
    }
    
    @Test
    @DisplayName("for an arbitrary pawn the figurine symbol of a white pawn is returned")
    public void getSymbol_ShouldReturnTheFigurineOfAWhitePawn() {
        
        final String LOCATION = "e4";
        Pawn piece = MovedBlackPawn.create( LOCATION );
        
        assertThat( WHITE_PAWN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol() );;
    }
    
    @Test
    @DisplayName("for an initial black pawn the figurine symbol of a black pawn is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAnInitialBlackPawn() {
        
        final String LOCATION = "e7";
        Pawn piece = InitialBlackPawn.create( LOCATION );
        
        assertThat( BLACK_PAWN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
    
    @Test
    @DisplayName("for a moved black pawn the figurine symbol of a black pawn is returned")
    public void getSymbol_WithColorArgument_ShouldReturnTheFigurineOfAMovedBlackPawn() {
        
        final String LOCATION = "e4";
        Pawn piece = MovedBlackPawn.create( LOCATION );
        
        assertThat( BLACK_PAWN_SYMBOL ).as( "dictionary entry should fit" ).isEqualTo( piece.getSymbol( ColorEnum.BLACK ) );;
    }
}


