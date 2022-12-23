/*
 *  PieceVector.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides attributes for an abstract chess piece.
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
public class PieceVector {

/** ---------  Attributes  -------------------------------- */
    
    private AdjacencyEnum attribute;
    private Direction direction;
    private int length;

    /** ---------  Constructors  ------------------------------ */
    
    private PieceVector( AdjacencyEnum attribute, Direction direction, int length ) {
        
        setAttribute( attribute );
        setDirection( direction );
        setLength( length );
    }
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setAttribute( AdjacencyEnum value )  { this.attribute = value; }
    public AdjacencyEnum getAttribute( )              { return( this.attribute ); }
    private void setDirection( Direction value )      { this.direction = value; }
    public Direction getDirection( )                  { return( this.direction ); }
    private void setLength( int value )               { this.length = value; }
    public int getLength( )                           { return( this.length ); }
    
    /** ---------  Factory  ----------------------------------- */
    
    public static PieceVector create( AdjacencyEnum attribute, Direction direction, int length ) {
        return new PieceVector( attribute, direction, length );
    }
}
