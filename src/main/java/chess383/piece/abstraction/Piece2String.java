/*
 *  Piece2String.java
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

package chess383.piece.abstraction;

import chess383.graph.board.LineBundleMigration;

/**
 * Provides a string description for an abstract chess piece.
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
public class Piece2String {
    
    private static String getLocationString()     { return "location "; }
    private static String getMovingString()       { return "moving: "; }
    private static String getCapturingString()    { return "capturing: "; }
    
    /** ---------  Attributes  -------------------------------- */
    
    private Piece piece;

    /** ---------  Constructors  ------------------------------ */
    
    public Piece2String( Piece piece ) {
        
        setPiece( piece );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private void setPiece( Piece value )   { this.piece = value; }
    private Piece getPiece( )              { return( this.piece ); }
    
    /** ------------------------------------------------------- */
    
    public static String extractLocation( String description, int length ) {
        
        int locationStart = description.indexOf( getLocationString() ) + getLocationString().length();
        return description.substring( locationStart, locationStart + length ).trim();
    }
    
    public static String extractMoving( String description ) {
        
        int capturingStart = description.indexOf( getCapturingString() );
        int movingStart = description.indexOf( getMovingString() ) + getMovingString().length();
        return description.substring( movingStart, capturingStart - 1 ).trim();
    }
    
     public static String extractCapturing( String description ) {
        
        int capturingStart = description.indexOf( getCapturingString() ) + getCapturingString().length();
        return description.substring( capturingStart ).trim();
    }
    
    @Override
    public String toString() {

        if( null == getPiece() ) return( "no piece defined!" );
        
        StringBuilder buffer = new StringBuilder();
        Piece describedPiece = getPiece();      
        buffer = buffer.append( getLocationString() + describedPiece.getLocation() + "\n" );
        buffer.append( getMovingString() + LineBundleMigration.bulldoze( LineBundleMigration.flatten( describedPiece.getMovingLines() ) ) + "\n" );
        buffer.append( getCapturingString() + LineBundleMigration.bulldoze( LineBundleMigration.flatten( describedPiece.getCapturingLines() ) ) + "\n" );
        
        return( buffer.toString() );
    }
}
