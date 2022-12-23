/*
 *  Bishop.java
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

package chess383.piece.concretion.bishop;

import java.util.Arrays;
import java.util.Locale;

import chess383.ColorEnum;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.piece.abstraction.Piece;
import chess383.piece.abstraction.PieceVector;
import chess383.piece.dictionary.SmallDictionary;

/**
 * Provides a chess piece.
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
public class Bishop extends Piece {
    
    /** ---------  Attributes  -------------------------------- */
    
    // inherited

    /** ---------  Constructors  ------------------------------ */
    
    private Bishop( String location ) {
        
        super( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    // inherited
    
    /** ---------  Factory  ----------------------------------- */
    
    static PieceVector[] ATTRIBUTES() { 
        
        final int UNLIMITED = 0;

        return new PieceVector[] {
                PieceVector.create(AdjacencyEnum.BY_POINT, Direction.createUnidirectionalDirection(ColorEnum.WHITE, ColorEnum.BLACK), UNLIMITED),
                PieceVector.create(AdjacencyEnum.BY_POINT, Direction.createUnidirectionalDirection(ColorEnum.BLACK, ColorEnum.WHITE), UNLIMITED)
        };
    }
    
    public static Bishop create( String location ) {
        
        Bishop result = new Bishop( location );
        
        result.addMovingLines( ATTRIBUTES() );
        result.addCapturingLines( ATTRIBUTES() );
        
        return( result );
    }
    
    public Character getForsythEdwardsNotation() {
        
        return( 'b' );
    }
    
    public Bishop replace( String location ) {
        
        return create( location );
    }
    
    /** ------------------------------------------------------- */

    @Override
    public boolean isBishop() { return true; }  // will be overwritten by bishops
    
    @Override
    public String toString() { return( "bishop: " + super.toString() ); }

    
    private static final SmallDictionary pieceName = SmallDictionary.create( Arrays.asList( 
            "de", "Läufer",
            "en", "bishop"
            ) );
    
    @Override
    public String getName( final Locale locale ) { return pieceName.get( locale.toLanguageTag() ); }
    
    @Override
    public String getName()                      { return pieceName.get( "default" ); }
    
    
    private static final SmallDictionary pieceType = SmallDictionary.create( Arrays.asList( 
            "de", "L",
            "en", "b"
            ) );
    
    @Override
    public String getType( final Locale locale ) { return pieceType.get( locale.toLanguageTag() ); }
    
    @Override
    public String getType()                      { return pieceType.get( "default" ); }
    
    
    private static final SmallDictionary pieceSymbol = SmallDictionary.create( Arrays.asList( 
            ColorEnum.WHITE.toString(), "\u2657",
            ColorEnum.BLACK.toString(), "\u265D"
            ) );
    
    @Override
    public String getSymbol( ColorEnum color )   { return pieceSymbol.get( color.toString() ); }
    
    @Override
    public String getSymbol()                    { return pieceSymbol.get( ColorEnum.WHITE.toString() ); }
}
