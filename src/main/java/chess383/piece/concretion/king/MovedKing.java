/*
 *  MovedKing.java
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

package chess383.piece.concretion.king;

import chess383.ColorEnum;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.piece.abstraction.PieceVector;

/**
 * Provides a chess piece.
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
public class MovedKing extends King {
    
    /** ---------  Attributes  -------------------------------- */
    
    // inherited

    /** ---------  Constructors  ------------------------------ */
    
    private MovedKing( String location ) {
        
        super( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    // inherited
    
    /** ---------  Factory  ----------------------------------- */
    
    static PieceVector[] ATTRIBUTES() { 
        
        final int ADJACENT = 1;
        
        PieceVector[] result = new PieceVector[5];
        result[0] = PieceVector.create( AdjacencyEnum.BY_EDGE,  Direction.createBidirectionalDirection(), ADJACENT );
        result[1] = PieceVector.create( AdjacencyEnum.BY_EDGE,  Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK ), ADJACENT );
        result[2] = PieceVector.create( AdjacencyEnum.BY_EDGE,  Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE ), ADJACENT );
        result[3] = PieceVector.create( AdjacencyEnum.BY_POINT, Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK ), ADJACENT );
        result[4] = PieceVector.create( AdjacencyEnum.BY_POINT, Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE ), ADJACENT );
        return( result );
    }
    
    public static MovedKing create( String location ) {
        
        MovedKing result = new MovedKing( location );
        
        result.addMovingLines( ATTRIBUTES() );
        result.addCapturingLines( ATTRIBUTES() );
        
        return( result );
    }
    
    /** ------------------------------------------------------- */
    
    @Override
    public String toString() {
        
        return( "moved king: " + super.toString() );
    }
}
