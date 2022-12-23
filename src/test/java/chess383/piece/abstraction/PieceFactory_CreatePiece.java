/*
 *  PieceFactory_CreatePiece.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020, 2021 Jörg Dippel
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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinateFactory;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.King;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class PieceFactory_CreatePiece implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2021
 *
 */
@DisplayName("the public static method Piece createPiece() for class PieceFactory is tested")
public class PieceFactory_CreatePiece {    
    
    static {  Piece.createBoard( ICoordinateFactory.STANDARD.get( ) ); }
    
    @Test
    @DisplayName("for a white bishop the attribute bishop is confirmed")
    public void createWhiteBishop() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'B' );
        
        assertThat( piece.isBishop() ).as( "should confirm the bishop instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white knight the attribute knight is confirmed")
    public void createWhiteKnight() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'N' );
        
        assertThat( piece.isKnight() ).as( "should confirm the knight instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white rook the attribute rook is confirmed")
    public void createWhiteRook() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'R' );
        
        assertThat( piece.isRook() ).as( "should confirm the rook instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white initial king the attribute king is confirmed")
    public void creatWhiteInitialKing() {
        
        final String LOCATION = "e1";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K' );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white initial king the attribute king is confirmed")
    public void creatWhiteInitialKingWithMoveAttribute() {
        
        final String LOCATION = "e1";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K', false );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white initial king the attribute king is confirmed")
    public void creatWhiteInitialKingWithMoveAttribute_ButCheckingInstanceExplicitely() {
        
        final String LOCATION = "e1";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K', false );
        
        assertThat( piece instanceof InitialKing ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white moved king the attribute king is confirmed")
    public void createWhiteMovedKing() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K' );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white moved king the attribute king is confirmed")
    public void createWhiteMovedKingWithMoveAttribute() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K', true );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white moved king the attribute king is confirmed")
    public void createWhiteMovedKingWithMoveAttribute_ButCheckingInstanceExplicitely() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K', true );
        
        assertThat( piece instanceof MovedKing ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white queen the attribute queen is confirmed")
    public void createWhiteQueen() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'Q' );
        
        assertThat( piece.isQueen() ).as( "should confirm the bishop instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white initial pawn the attribute white pwan is confirmed")
    public void createWhiteInitialPawn() {
        
        final String LOCATION = "e2";
        Piece piece = PieceFactory.createPiece( LOCATION, 'P' );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isWhitePawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece instanceof InitialWhitePawn ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a white moved pawn the attribute pawn is confirmed")
    public void createWhiteMovedPawn() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'P' );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isWhitePawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece instanceof MovedWhitePawn ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    
    
    
    @Test
    @DisplayName("for a black bishop the attribute bishop is confirmed")
    public void createBlackBishop() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'b' );
        
        assertThat( piece.isBishop() ).as( "should confirm the bishop instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black knight the attribute knight is confirmed")
    public void createBlackKnight() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'n' );
        
        assertThat( piece.isKnight() ).as( "should confirm the knight instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black rook the attribute rook is confirmed")
    public void createBlackRook() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'r' );
        
        assertThat( piece.isRook() ).as( "should confirm the rook instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black initial king the attribute king is confirmed")
    public void creatBlackInitialKing() {
        
        final String LOCATION = "e8";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k' );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black initial king the attribute king is confirmed")
    public void creatBlackInitialKingWithMoveAttribute() {
        
        final String LOCATION = "e8";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k', false );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black initial king the attribute king is confirmed")
    public void creatBlackInitialKingWithMoveAttribute_ButCheckingInstanceExplicitely() {
        
        final String LOCATION = "e8";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k', false );
        
        assertThat( piece instanceof InitialKing ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black moved king the attribute king is confirmed")
    public void createBlackMovedKing() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k' );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black moved king the attribute king is confirmed")
    public void createBlackMovedKingWithMoveAttribute() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k', true );
        
        assertThat( piece.isKing() ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black moved king the attribute king is confirmed")
    public void createBlackMovedKingWithMoveAttribute_ButCheckingInstanceExplicitely() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k', true );
        
        assertThat( piece instanceof MovedKing ).as( "should confirm the king instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black queen the attribute queen is confirmed")
    public void createBlackQueen() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'q' );
        
        assertThat( piece.isQueen() ).as( "should confirm the bishop instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black initial pawn the attribute Black pwan is confirmed")
    public void createBlackInitialPawn() {
        
        final String LOCATION = "e7";
        Piece piece = PieceFactory.createPiece( LOCATION, 'p' );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isBlackPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece instanceof InitialBlackPawn ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    @Test
    @DisplayName("for a black moved pawn the attribute pawn is confirmed")
    public void createBlackMovedPawn() {
        
        final String LOCATION = "e4";
        Piece piece = PieceFactory.createPiece( LOCATION, 'p' );
        
        assertThat( piece.isPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece.isBlackPawn() ).as( "should confirm the pawn instance" ).isTrue();
        assertThat( piece instanceof MovedBlackPawn ).as( "should confirm the pawn instance" ).isTrue();
    }
    
    
    @Test
    @DisplayName("for a bishop with GERMAN type letter the attribute bishop is confirmed")
    public void createGermanBishopType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'L', Locale.GERMAN );
        
        assertThat( piece instanceof Bishop ).as( "should confirm the bishop instance" ).isTrue();
        assertThat( piece.getType( Locale.GERMAN ).toUpperCase() ).as( "should confirm the German piece letter" ).isEqualTo( "L" );
    }
    
    @Test
    @DisplayName("for a bishop with ENGLISH type letter the attribute bishop is confirmed")
    public void createEnglishBishopType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'b', Locale.ENGLISH );
        
        assertThat( piece instanceof Bishop ).as( "should confirm the bishop instance" ).isTrue();
        assertThat( piece.getType( Locale.ENGLISH ).toUpperCase() ).as( "should confirm the English piece letter" ).isEqualTo( "B" );
    }
    
    @Test
    @DisplayName("for a knight with GERMAN type letter the attribute knight is confirmed")
    public void createGermanKnightType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'S', Locale.GERMAN );
        
        assertThat( piece instanceof Knight ).as( "should confirm the knight instance" ).isTrue();
        assertThat( piece.getType( Locale.GERMAN ).toUpperCase() ).as( "should confirm the German piece letter" ).isEqualTo( "S" );
    }
    
    @Test
    @DisplayName("for a knight with ENGLISH type letter the attribute knight is confirmed")
    public void createEnglishKnightType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'N', Locale.ENGLISH );
        
        assertThat( piece instanceof Knight ).as( "should confirm the knight instance" ).isTrue();
        assertThat( piece.getType( Locale.ENGLISH ).toUpperCase() ).as( "should confirm the English piece letter" ).isEqualTo( "N" );
    }
    
    @Test
    @DisplayName("for a rook with GERMAN type letter the attribute rook is confirmed")
    public void createGermanRookType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'T', Locale.GERMAN );
        
        assertThat( piece instanceof Rook ).as( "should confirm the rook instance" ).isTrue();
        assertThat( piece.getType( Locale.GERMAN ).toUpperCase() ).as( "should confirm the German piece letter" ).isEqualTo( "T" );
    }
    
    @Test
    @DisplayName("for a rook with ENGLISH type letter the attribute rook is confirmed")
    public void createEnglishRookType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'r', Locale.ENGLISH );
        
        assertThat( piece instanceof Rook ).as( "should confirm the rook instance" ).isTrue();
        assertThat( piece.getType( Locale.ENGLISH ).toUpperCase() ).as( "should confirm the English piece letter" ).isEqualTo( "R" );
    }
    
    @Test
    @DisplayName("for a queen with GERMAN type letter the attribute queen is confirmed")
    public void createGermanQueenType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'D', Locale.GERMAN );
        
        assertThat( piece instanceof Queen ).as( "should confirm the queen instance" ).isTrue();
        assertThat( piece.getType( Locale.GERMAN ).toUpperCase() ).as( "should confirm the German piece letter" ).isEqualTo( "D" );
    }
    
    @Test
    @DisplayName("for a queen with ENGLISH type letter the attribute queen is confirmed")
    public void createEnglishQueenType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'Q', Locale.ENGLISH );
        
        assertThat( piece instanceof Queen ).as( "should confirm the queen instance" ).isTrue();
        assertThat( piece.getType( Locale.ENGLISH ).toUpperCase() ).as( "should confirm the English piece letter" ).isEqualTo( "Q" );
    }
    
    @Test
    @DisplayName("for a king with GERMAN type letter the attribute king is confirmed")
    public void createGermanKingType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'K', Locale.GERMAN );
        
        assertThat( piece instanceof King ).as( "should confirm the king instance" ).isTrue();
        assertThat( piece.getType( Locale.GERMAN ).toUpperCase() ).as( "should confirm the German piece letter" ).isEqualTo( "K" );
    }
    
    @Test
    @DisplayName("for a king with ENGLISH type letter the attribute king is confirmed")
    public void createEnglishKingType() {
        
        final String LOCATION = "e5";
        Piece piece = PieceFactory.createPiece( LOCATION, 'k', Locale.ENGLISH );
        
        assertThat( piece instanceof King ).as( "should confirm the king instance" ).isTrue();
        assertThat( piece.getType( Locale.ENGLISH ).toUpperCase() ).as( "should confirm the English piece letter" ).isEqualTo( "K" );
    }
}


