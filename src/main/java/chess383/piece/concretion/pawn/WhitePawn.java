/*
 *  WhitePawn.java
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

import java.util.List;

import chess383.piece.abstraction.PieceFactory;


/**
 * Provides a chess piece.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public abstract class WhitePawn extends Pawn {
    
    /** ---------  Attributes  -------------------------------- */
    
    // inherited

    /** ---------  Constructors  ------------------------------ */
    
    protected WhitePawn( String location ) {
        
        super( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    // inherited
    
    /** ---------  Factory  ----------------------------------- */
    
    static private List<String> WHITE_PAWN_STARTING_RANG = PieceFactory.getRookLineContaining( "a2", "h2" );
    
    public static WhitePawn create( String location ) {
        
        return ( WHITE_PAWN_STARTING_RANG.contains( location ) ) ? InitialWhitePawn.create( location ) : MovedWhitePawn.create( location );
    }

    /** ------------------------------------------------------- */
    
    public MovedWhitePawn replace( String location ) { return MovedWhitePawn.create( location ); }

    @Override
    public boolean isPawn() { return true; }       // will be overwritten by pawns
    
    @Override
    public boolean isWhitePawn() {return true; }   // will be overwritten by white pawns
}
