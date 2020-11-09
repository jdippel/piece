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
import java.util.function.Predicate;

import chess383.exception.PiecePlacementStringLocationsMissingException;
import chess383.exception.PiecePlacementStringTooManyFreeLocationsException;
import chess383.exception.PiecePlacementStringTooShortException;
import chess383.exception.PiecePlacementStringUnsupportedPieceAbbreviationException;
import chess383.piece.abstraction.Piece;
import chess383.piece.abstraction.PieceFactory;

/**
 * Provides information about a collection of pieces.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public class Traversing {
    
    /** ---------  Attributes  -------------------------------- */
    
    private String forsythEdwardsNotation;

    /** ---------  Constructors  ------------------------------ */
    
    private Traversing( String fen )      { setFEN( fen ); }
    
    /** ---------  Getter and Setter  ------------------------- */
   
    private void setFEN( String value )   { this.forsythEdwardsNotation = value; }
    private String getFEN( )              { return( this.forsythEdwardsNotation ); }
    
    /** ---------  Factory  ----------------------------------- */
    
    public static Traversing create(  String fen) {
        
        return new Traversing( fen );
    }
    
    /** ------------------------------------------------------- */
    
    public List<Piece> getPieceCollection( Predicate<Character> isAssociated ) {
        
        List<Piece> playerPieces = new ArrayList<Piece>();
        
        String pieceCollection = getFEN();
        int pieceCollectionLength = pieceCollection.length();
        int counterForEmptyLocations = 0;
        String location = "";
        char letter = ' ';
        
        int cursor = 0;
        Iterator<String> iterator = TraversingOrder.STANDARD.getInstance().iterator();
        while( cursor < pieceCollectionLength ) {
            letter = pieceCollection.charAt( cursor );
            
            if( Character.isWhitespace( letter ) ) {
                if( iterator.hasNext() ) {
                    PiecePlacementStringTooShortException.throwPiecePlacementStringTooShortException( 
                            String.format( "There are still locations defined for position %s but following pieces are detected: %s", getFEN(), playerPieces )); 
                }
                break;
            }
            else if( Character.isDigit( letter )) {
                counterForEmptyLocations = parseInt( pieceCollection.substring( cursor ) );
                
                while( counterForEmptyLocations > 0 ) {
                    counterForEmptyLocations--;
                    if( iterator.hasNext() )  {
                        location = iterator.next();
                    }
                    else {
                        PiecePlacementStringTooManyFreeLocationsException.throwPiecePlacementStringTooManyFreeLocationsException(
                            String.format( "There are too many free locations defined for position %s but following pieces are detected: %s", getFEN(), playerPieces )); 
                    }
                }
                
                while( cursor < pieceCollectionLength && Character.isDigit( pieceCollection.charAt( cursor  ) ) ) cursor++;
            }
            else if( Character.isLetter( letter ) ) {
                if( iterator.hasNext() )  {
                    location = iterator.next();
                    if( isAssociated.test( letter ) ) {
                        
                        Piece piece = PieceFactory.createPiece( location, letter );
                        if( piece != null  ) {
                            playerPieces.add( piece );
                        }
                        else {
                            PiecePlacementStringUnsupportedPieceAbbreviationException.throwPiecePlacementStringUnsupportedPieceAbbreviationException( 
                                     String.format( "Unsupported piece abbreviation for FEN with letter %c", letter ));
                        }
                    }
                }
                else {
                    PiecePlacementStringLocationsMissingException.throwPiecePlacementStringLocationsMissingException(
                        String.format( "There are no more locations defined for position %s but following pieces are detected: %s", getFEN(), playerPieces )); 
                }
                cursor++;
            }
            else cursor++;
        }
        
        if( iterator.hasNext() ) {
        	PiecePlacementStringTooShortException.throwPiecePlacementStringTooShortException( 
                    String.format( "There are still locations defined for position %s but following pieces are detected: %s", getFEN(), playerPieces )); 
        }
        
        return playerPieces;
    }

    private Integer parseInt( String description ) {
        return Character.getNumericValue( description.charAt( 0 ) );
    }   
}
