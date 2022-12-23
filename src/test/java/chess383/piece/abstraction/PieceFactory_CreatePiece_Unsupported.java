/*
 *  PieceFactory_CreatePiece_Unsupported.java
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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinateFactory;
import chess383.exception.PiecePlacementStringUnsupportedPieceAbbreviationException;


/**
 * <p>
 * The class PieceFactory_CreatePiece_Unsupported implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2021
 *
 */
@DisplayName("the public static method Piece createPiece() for class PieceFactory is tested")
public class PieceFactory_CreatePiece_Unsupported {    
    
    static {  Piece.createBoard( ICoordinateFactory.STANDARD.get( ) ); }
    
    
    @Test
    @DisplayName("for an unsupported type with GERMAN type letter an exception is thrown")
    public void createGermanUnsupportedType() {
        
        final String LOCATION = "e5";
        
        assertThatThrownBy(() -> { PieceFactory.createPiece( LOCATION, 'B', Locale.GERMAN ); })
                .isInstanceOf( PiecePlacementStringUnsupportedPieceAbbreviationException.class )
                .hasMessageContaining( "Unsupported piece abbreviation for FEN with letter" );
    }
    
    @Test
    @DisplayName("for an unsupported type with ENGLISH type letter an exception is thrown")
    public void createEnglishUnsupportedType() {
        
        final String LOCATION = "e5";
        
        assertThatThrownBy(() -> { PieceFactory.createPiece( LOCATION, 'z', Locale.ENGLISH ); })
                .isInstanceOf( PiecePlacementStringUnsupportedPieceAbbreviationException.class )
                .hasMessageContaining( "Unsupported piece abbreviation for FEN with letter" );
    }
}
