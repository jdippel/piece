/*
 *  BlackPawn.java
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
 * @version   November 2022
 *
 */
public abstract class BlackPawn extends Pawn {
    
    /** ---------  Attributes  -------------------------------- */
    
    // inherited

    /** ---------  Constructors  ------------------------------ */
    
    protected BlackPawn( String location ) {
        
        super( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    // inherited

    /** ---------  Factory  ----------------------------------- */
    
    static private List<String> BLACK_PAWN_STARTING_RANG = PieceFactory.getRookLineContaining( "a7", "h7" );
    
    public static BlackPawn create( String location ) {
        
        return ( BLACK_PAWN_STARTING_RANG.contains( location ) ) ? InitialBlackPawn.create( location ) : MovedBlackPawn.create( location );
    }

    public static Character getStaticForsythEdwardsNotation() { return( 'p' ); }
    /** ------------------------------------------------------- */

    public MovedBlackPawn replace( String location ) { return MovedBlackPawn.create( location ); }

    @Override
    public Character getForsythEdwardsNotation() { return getStaticForsythEdwardsNotation(); }
    
    @Override
    public boolean isBlackPawn() { return true; }  // will be overwritten by black pawns
}
