/*
 *  Pawn.java
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

import java.util.Arrays;
import java.util.Locale;

import chess383.ColorEnum;
import chess383.piece.abstraction.Piece;
import chess383.piece.dictionary.SmallDictionary;

/**
 * Provides a chess piece.
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
public abstract class Pawn extends Piece {
    
    /** ---------  Attributes  -------------------------------- */
    
    // inherited

    /** ---------  Constructors  ------------------------------ */
    
    protected Pawn( String location ) {
        
        super( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    // inherited
    
    /** ------------------------------------------------------- */
    
    public Character getForsythEdwardsNotation() {
        
        return( 'p' );
    }
 
    /** ------------------------------------------------------- */

    @Override
    public boolean isPawn() { return true; }  // will be overwritten by pawns
    
   
    private static final SmallDictionary pieceName = SmallDictionary.create( Arrays.asList( 
            "de", "Bauer",
            "en", "pawn"
            ) );
    
    @Override
    public String getName( final Locale locale ) { return pieceName.get( locale.toLanguageTag() ); }
    
    @Override
    public String getName()                      { return pieceName.get( "default" ); }
    
    
    private static final SmallDictionary pieceType = SmallDictionary.create( Arrays.asList( 
            "de", " ",
            "en", " "
            ) );
    
    @Override
    public String getType( final Locale locale ) { return pieceType.get( locale.toLanguageTag() ); }
    
    @Override
    public String getType()                      { return pieceType.get( "default" ); }
    
    
    private static final SmallDictionary pieceSymbol = SmallDictionary.create( Arrays.asList( 
            ColorEnum.WHITE.toString(), "\u2659",
            ColorEnum.BLACK.toString(), "\u265F"
            ) );
    
    @Override
    public String getSymbol( ColorEnum color )   { return pieceSymbol.get( color.toString() ); }
    
    @Override
    public String getSymbol()                    { return pieceSymbol.get( ColorEnum.WHITE.toString() ); }
}
