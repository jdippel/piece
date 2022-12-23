/*
 *  MovedBlackPawn.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019, 2020 Jörg Dippel
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

import chess383.ColorEnum;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.piece.abstraction.PieceVector;

/**
 * Provides a chess piece.
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
public class MovedBlackPawn extends BlackPawn {
    
    /** ---------  Attributes  -------------------------------- */
    
    // inherited

    /** ---------  Constructors  ------------------------------ */
    
    private MovedBlackPawn( String location ) {
        
        super( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    // inherited
    
    /** ---------  Factory  ----------------------------------- */
    
    private static PieceVector[] MOVING_ATTRIBUTES() { 
        
        final int DISTANCE = 1;

        return new PieceVector[] {
                PieceVector.create( AdjacencyEnum.BY_EDGE, Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE ), DISTANCE )
        };
    }
    
    private static PieceVector[] CAPTURING_ATTRIBUTES() { 
        
        final int DISTANCE = 1;

        return new PieceVector[] {
                PieceVector.create( AdjacencyEnum.BY_POINT, Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE ), DISTANCE )
        };
    }
    
    public static MovedBlackPawn create( String location ) {
        
        MovedBlackPawn result = new MovedBlackPawn( location );
        
        result.addMovingLines( MOVING_ATTRIBUTES() );
        result.addCapturingLines( CAPTURING_ATTRIBUTES() );
        
        return( result );
    }
   
    /** ------------------------------------------------------- */

    @Override
    public String toString() {
        
        return( "moved black pawn: " + super.toString() );
    }
}
