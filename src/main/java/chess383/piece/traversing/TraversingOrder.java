/*
 *  TraversingOrder.java
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.piece.concretion.rook.Rook;

/**
 * Provides locations in a defined order.
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
public enum TraversingOrder {
    
    STANDARD;
    
    /** ---------  Attributes  -------------------------------- */
    
    private List<String> orderedLocations = ( List<String> ) null;
    
    /** ------------------------------------------------------- */
    
    public List<String> getInstance( ) {

        if( orderedLocations == ( List<String> ) null ) {
            orderedLocations = createInstance( );
        }
        return orderedLocations;
    }
    
    private List<String> createInstance( ) {
        
        final String STARTING_LOCATION = "a8";                      // left upper corner
        final String ENDING_LOCATION_ON_SAME_FILE = "a1";           // left lower corner
        
        ICoordinate board = ICoordinateFactory.STANDARD.get( );
        
        List<String> listOfLocations = new ArrayList<String>( board.getAllLocations().size() );
        List<String> fileRookLine = getRookLineContainingAnotherLocation( STARTING_LOCATION, ENDING_LOCATION_ON_SAME_FILE );
        for( String row : fileRookLine ) {
            Iterator<String> iterator = getRookLineWithoutAnotherNamedLocation( row, STARTING_LOCATION, ENDING_LOCATION_ON_SAME_FILE ).iterator();
            while( iterator.hasNext() ) {
                listOfLocations.add( iterator.next() );
            }
        }
        return listOfLocations;
    }
    
    private static List<String> getRookLineWithoutAnotherNamedLocation( String origin, String startingLocation, String anotherLocation ) {
        
        Rook rook = Rook.create( origin );
        Set<List<String>> lines = rook.getMovingLines();
        for( List<String> line : lines ) {
            if( origin.compareTo( startingLocation ) == 0 ) {
                if( line.contains( anotherLocation ) ) continue;
            }
            else if( origin.compareTo( anotherLocation ) == 0 ) {
                if( line.contains( startingLocation ) ) continue;
            }
            else {
                if( line.contains( startingLocation ) ||  line.contains( anotherLocation ) ) continue;
            }
            return line;
        }
        return new ArrayList<String>( 0 );
    }
    
    private static List<String> getRookLineContainingAnotherLocation( String origin, String anotherLocation ) {
        
        Rook rook = Rook.create( origin );
        Set<List<String>> lines = rook.getMovingLines();
        for( List<String> line : lines ) {
            if( line.contains( anotherLocation )) return line;
        }
        return new ArrayList<String>( 0 );
    }
}

