/*
 *  PieceFactory_GetRookLineContaining.java
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

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinateFactory;

/**
 * <p>
 * The class PieceFactory_GetRookLineContaining implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method List<String> getRookLineContaining for class PieceFactory is tested")
public class PieceFactory_GetRookLineContaining {    
    
    static {  Piece.createBoard( ICoordinateFactory.STANDARD.get( ) ); }
    
    @Test
    @DisplayName("existing line should contain the expected location")
    public void getRookLineContaining_ContainsExpectedLocation() {
        
        final String LOCATION = "e4";
        List<String> rookLine = PieceFactory.getRookLineContaining( "a4", "h4" );
        
        assertThat( rookLine.contains( LOCATION ) ).as( "should contain the named location" ).isTrue();
    }
    
    @Test
    @DisplayName("existing line should not contain the expected location")
    public void getRookLineContaining_DoesNotcontainADefinedLocation() {
        
        final String LOCATION = "e5";
        List<String> rookLine = PieceFactory.getRookLineContaining( "a4", "h4" );
        
        assertThat( rookLine.contains( LOCATION ) ).as( "should not contain the named location" ).isFalse();
    }
    
    @Test
    @DisplayName("not existing line should not contain the expected location")
    public void getRookLineContaining_NotExistingRookLine() {
        
        final String LOCATION = "e5";
        List<String> rookLine = PieceFactory.getRookLineContaining( "a1", "h4" );
        
        assertThat( rookLine.isEmpty() ).as( "should not contain any location" ).isTrue();
        assertThat( rookLine.contains( LOCATION ) ).as( "should not contain the named location" ).isFalse();
    }
    
}


