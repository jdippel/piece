/*
 *  Piece_ValidateLocation.java
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
package chess383.piece.abstraction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class Piece_ValidateLocation implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the protected static method boolean validateLocation() for class Piece is tested")
public class Piece_ValidateLocation {    
    
    static {  Piece.createBoard(); }
    
    @Test
    @DisplayName("validation for valid location")
    public void validatePositive() {
        
        final String LOCATION = "e4";
        
        assertThat( Piece.validateLocation( LOCATION ) ).as( "validation for valid location" ).isTrue();
    }
    
    @Test
    @DisplayName("validation for invalid location")
    public void validateNegative() {
        
        final String LOCATION = "m9";
        
        assertThat( Piece.validateLocation( LOCATION ) ).as( "validation for invalid location" ).isFalse();
    }
    
    @Test
    @DisplayName("validation for null pointer")
    public void validateNull() {
      
        assertThat( Piece.validateLocation( null ) ).as( "validation for invalid location" ).isFalse();
    }
}


