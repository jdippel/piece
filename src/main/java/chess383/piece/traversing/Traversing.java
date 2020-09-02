/*
 *  Traversing.java
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

package chess383.piece.traversing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chess383.exception.Chess383Exception;
import chess383.piece.abstraction.Piece;
import chess383.piece.abstraction.PieceFactory;

/**
 * Provides information about a collection of pieces.
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
public class Traversing {
    
    /** ---------  Attributes  -------------------------------- */
    
    private String forsythEdwardsNotation;

    /** ---------  Constructors  ------------------------------ */
    
    private Traversing( String fen )      { setFEN( fen ); }
    
    /** ---------  Getter and Setter  ------------------------- */
   
    private void setFEN( String value )   { this.forsythEdwardsNotation = value; }
    public String getFEN( )               { return( this.forsythEdwardsNotation ); }
    
    /** ------------------------------------------------------- */
    
    public static List<List<Piece>> traversePieces( String forsythEdwardsNotation ) {
    
        return new Traversing( forsythEdwardsNotation ).getBothPieceCollections();
    }
    
    /** ------------------------------------------------------- */
    
    private List<List<Piece>> getBothPieceCollections() {
        
        List<Piece> whitePlayerPieces = new ArrayList<Piece>();
        List<Piece> blackPlayerPieces = new ArrayList<Piece>();
        
        String pieceCollection = getFEN();
        int counterForEmptyLocations = 0;
        int cursor = 0;
        String location = "";
        char letter = ' ';
        
        
        cursor = 0;
        Iterator<String> iterator = TraversingOrder.STANDARD.getInstance().iterator();
        while( cursor < pieceCollection.length() ) {
            letter = pieceCollection.charAt( cursor );

            if( Character.isWhitespace( letter ) ) {
                break;
            }
            else if( Character.isDigit( letter )) {
                counterForEmptyLocations = Character.getNumericValue( letter );
                cursor++;
                
                while( counterForEmptyLocations > 0 ) {
                    counterForEmptyLocations--;
                    if( iterator.hasNext() )  {
                        location = iterator.next();
                    }
                    else {
                        throw new Chess383Exception( 
                            String.format( "There are no more locations defined for input %s", pieceCollection ));
                    }
                }
            }
            else if( Character.isLetter( letter )){
                // here a piece with fen 'letter' is found on location
                Piece piece = null;
                if( iterator.hasNext() )  {
                    location = iterator.next();
                }
                else {
                    throw new Chess383Exception( 
                        String.format( "There are no more locations defined for input %s", pieceCollection ));
                }
                if( Character.isLowerCase( letter) ) {
                    
                    piece = PieceFactory.createPiece( location, letter );
                    if( piece != null  ) {
                        blackPlayerPieces.add( piece );
                    }
                    else {
                        throw new Chess383Exception( 
                                String.format( "Unsupported piece abbreviation for FEN with letter %c", letter ));
                    }
                }
                else {
                    piece = PieceFactory.createPiece( location, letter );
                    if( piece != null  ) {
                        whitePlayerPieces.add( piece );
                    }
                    else {
                        throw new Chess383Exception( 
                                String.format( "Unsupported piece abbreviation for FEN with letter %c", letter ));
                    }
                }
                cursor++;
            }
            else {
                cursor++;
            }
            
        }
        
        if( iterator.hasNext() )  {
            location = iterator.next();
            throw new Chess383Exception( 
                    String.format( "There are still locations defined for input %s but their definitions are missing starting for location %s",
                        pieceCollection, location ));
                        
        }
        
        
        List<List<Piece>> result = new ArrayList<List<Piece>>( 2 );
        result.add( whitePlayerPieces );
        result.add( blackPlayerPieces );
        return result;
    }
}
