/*
 *  PieceFactory.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2010-2021 Jörg Dippel
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

import chess383.exception.PiecePlacementStringUnsupportedPieceAbbreviationException;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.BlackPawn;
import chess383.piece.concretion.pawn.Pawn;
import chess383.piece.concretion.pawn.WhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Provides a piece according to the given parameters.
 *
 * @author    Jörg Dippel
 * @version   September 2021
 */
public class PieceFactory {
    
    public static Piece createPiece( String location, char fen, boolean alreadyMoved ) {
        
        Piece result = null;
        
        switch( fen ) {
        
            case 'K':
            case 'k': {
                          result = ( alreadyMoved ) ? MovedKing.create( location ) : InitialKing.create( location );
                      } break;
            
            case 'Q':
            case 'q': {
                          result = Queen.create( location );
                      } break;

            case 'R':
            case 'r': {
                          result = Rook.create( location );
                      } break;

            case 'N':
            case 'n': {
                          result = Knight.create( location );
                      } break;

            case 'B':
            case 'b': {
                          result = Bishop.create( location );
                      } break;

            case 'P': {
                          result = WhitePawn.create( location );
                      } break;
                     
            case 'p': {
                          result = BlackPawn.create( location );
                      } break;
        
            default: break;
        }
        
        return( result );
    }
    
    public static Piece createPiece( String location, char fen, Locale language ) {
        
        Piece piece = Bishop.create( location );
        if( Character.toUpperCase( piece.getType( language ).charAt( 0 ) ) == Character.toUpperCase( fen ) ) return piece;
        
        piece = Knight.create( location );
        if( Character.toUpperCase( piece.getType( language ).charAt( 0 ) ) == Character.toUpperCase( fen ) ) return piece;
        
        piece = Rook.create( location );
        if( Character.toUpperCase( piece.getType( language ).charAt( 0 ) ) == Character.toUpperCase( fen ) ) return piece;
        
        piece = Queen.create( location );
        if( Character.toUpperCase( piece.getType( language ).charAt( 0 ) ) == Character.toUpperCase( fen ) ) return piece;
        
        piece = MovedKing.create( location );
        if( Character.toUpperCase( piece.getType( language ).charAt( 0 ) ) == Character.toUpperCase( fen ) ) return piece;
        
        PiecePlacementStringUnsupportedPieceAbbreviationException.throwPiecePlacementStringUnsupportedPieceAbbreviationException( 
                String.format( "Unsupported piece abbreviation for FEN with letter %c", fen ) );
        return piece;
    }
    
    public static Piece createPiece( String location, char fen ) {
        
        return createPiece( location, fen, true );       
    }

    public static List<String> getRookLineContaining( String origin, String anotherLocation ) {
        
        Rook rook = Rook.create( origin );
        Set<List<String>> lines = rook.getMovingLines();
        for( List<String> line : lines ) {
            if( line.contains( anotherLocation )) return line;
        }
        return Collections.emptyList();
    }

    public static boolean isPawnToBePromoted( String location, Piece piece ) {

        if( piece instanceof Pawn ) {
            Piece pawn = (Pawn) PieceFactory.createPiece( location, piece.getForsythEdwardsNotation() );
            return pawn.getMovingLines().isEmpty() && pawn.getMovingLines().isEmpty();
        }
        else {
            return false;
        }
    }
}
