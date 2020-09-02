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

/**
 * Provides a chess piece.
 *
 * @author    Jörg Dippel
 * @version   July 2020
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

    /** ------------------------------------------------------- */

    public MovedBlackPawn replace( String location ) { return MovedBlackPawn.create( location ); }

    @Override
    public boolean isBlackPawn() { return true; }  // will be overwritten by black pawns
    
    @Override
    public String toString() { return( "initial black pawn: " + super.toString() ); }
}
