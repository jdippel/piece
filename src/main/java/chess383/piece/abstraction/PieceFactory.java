/*
 *  PieceFactory.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2010-2020 Jörg Dippel
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

import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Provides a piece according to the given parameters.
 *
 * @author    Jörg Dippel
 * @version   July 2020
 */
public class PieceFactory {

    static private List<String> WHITE_PAWN_STARTING_RANG = getRookLineContaining( "a2", "h2" );
    static private List<String> BLACK_PAWN_STARTING_RANG = getRookLineContaining( "a7", "h7" );
    
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
                          result = Bishop.create(location);
                      } break;

            case 'P': {
                          result = ( alreadyMoved ) ? MovedWhitePawn.create( location ) : InitialWhitePawn.create( location );
                      } break;
                     
            case 'p': {
                          result = ( alreadyMoved ) ? MovedBlackPawn.create( location ) : InitialBlackPawn.create( location );
                      } break;
        
            default: break;
        }
        
        return( result );
    }
    
    public static Piece createPiece( String location, char fen ) {
        
        if( fen == 'P' ) return createPiece( location, fen, ! WHITE_PAWN_STARTING_RANG.contains( location ) );
        else if( fen == 'p' ) return createPiece( location, fen, ! BLACK_PAWN_STARTING_RANG.contains( location ) );
        else return createPiece( location, fen, true );
        
    }

    private static List<String> getRookLineContaining( String origin, String anotherLocation ) {
        
        Rook rook = Rook.create( origin );
        Set<List<String>> lines = rook.getMovingLines();
        for( List<String> line : lines ) {
            if( line.contains( anotherLocation )) return line;
        }
        return new ArrayList<String>( 0 );
    }
}
