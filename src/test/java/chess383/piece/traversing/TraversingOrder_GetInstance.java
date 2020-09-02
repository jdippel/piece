/*
 *  TraversingOrder_GetInstance.java
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
package chess383.piece.traversing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;

/**
 * <p>
 * The class TraversingOrder_GetInstance provides an ordered list of locations.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
@DisplayName("the public method Traversing_Traverse traversePieces( ) for class Traversing is tested")
public class TraversingOrder_GetInstance {     
    
    @Test
    @DisplayName("getting the list of locations for the Forsyth-Edwards notation")
    public void getTheListOfOrderedLocations() {
        
        ICoordinate board = ICoordinateFactory.STANDARD.get( );
        
        List<String> fenOrderedList = 
            Arrays.asList( 
                "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
                "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
                "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
                "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
                "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
                "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
                "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
                "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1" );
        
        List<String> listOfLocations = TraversingOrder.STANDARD.getInstance();
        assertThat( listOfLocations.size() ).as("list structure must contain all locations").isEqualTo( board.getAllLocations().size() );
        for( int cursor = 0; cursor < fenOrderedList.size(); cursor++ ) {
            assertThat( listOfLocations.get( cursor ) ).as( "location must be named equal" ).isEqualTo( fenOrderedList.get( cursor ) );
        }
    }
}


