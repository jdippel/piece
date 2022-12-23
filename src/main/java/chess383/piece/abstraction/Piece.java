/*
 *  Piece.java
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

package chess383.piece.abstraction;

import java.util.*;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides an abstract chess piece.
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
public abstract class Piece {

    /** ---------  Attributes  -------------------------------- */
    
    static private ICoordinate board = ICoordinateFactory.STANDARD.get( );
    
    private String location;
    private Set<List<String>> moving;
    private Set<List<String>> capturing;

    /** ---------  Constructors  ------------------------------ */
    
    protected Piece( String location ) {
        
        setLocation( location );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private static void setBoard( ICoordinate value )            { board = value; }
    public static ICoordinate getBoard( )                        { return( board ); } 
    
    private void setLocation( String value )                     { this.location = value; }
    public String getLocation( )                                 { return( this.location ); }
    protected void setMovingLines( Set<List<String>> value )     { this.moving = value; }
    public Set<List<String>> getMovingLines( )                   { return( this.moving ); }
    protected void setCapturingLines( Set<List<String>> value )  { this.capturing = value; }
    public Set<List<String>> getCapturingLines( )                { return( this.capturing ); }
    
    /** ---------  Factory  ----------------------------------- */
    
    public static void createBoard( ICoordinate board ) {
        setBoard( board );
    }
    
    public static void createBoard( ) {
        setBoard( ICoordinateFactory.STANDARD.get( ) );
    }

    /** ---------  abstract methods  -------------------------- */
    
    public abstract Character getForsythEdwardsNotation();
    
    public abstract Piece replace( String location);
    
    public abstract String getName( final Locale locale );

    public abstract String getName();
   
    public abstract String getType( final Locale locale );

    public abstract String getType();
    
    public abstract String getSymbol( ColorEnum color);
    
    public abstract String getSymbol();
    
    /** ------------------------------------------------------- */

    private Set<List<String>> createLines( String location, AdjacencyEnum attribute, Direction direction ) {
        return  getBoard().getLineBundles( location, direction, attribute );
    }

    private Set<List<String>> createClippedLines( PieceVector attribute ) {
        return clipLines( createLines( location, attribute.getAttribute(), attribute.getDirection() ), attribute.getLength() );
    }

    private Set<List<String>> createLines( PieceVector[] attributes ) {

        if( ! validateLocation( location ) ) return Collections.emptySet();

        Set<List<String>> result = new HashSet<>();
        for( PieceVector attribute : attributes ) {
            result.addAll( createClippedLines( attribute ) );
        }
        return result;
    }

    protected void addMovingLines( PieceVector[] attributes ) {
        setMovingLines( createLines( attributes ) );
    }

    protected void addCapturingLines( PieceVector[] attributes ) {
        setCapturingLines( createLines( attributes )  );
    }


    private List<String> clipLine( List<String> line, int spread ) {
        return ( line.size() <= spread ) ? line : line.subList( 0, spread );
    }

    private Set<List<String>> clipLinesWithPositiveSpread( Set<List<String>> lines, int spread ) {

        // ( spread > 0 )
        Set<List<String>> result = new HashSet<List<String>>();
        for( List<String> line : lines ) {
            result.add( clipLine( line, spread + 1 ) );
        }
        return result;
    }

    protected Set<List<String>> clipLines( Set<List<String>> lines, int spread ) {
        return ( spread > 0 ) ? clipLinesWithPositiveSpread( lines, spread ) : lines ;
    }

    /** ------------------------------------------------------- */
    
    protected static boolean validateLocation( String location ) {
        return ( location != null ) && getBoard().getAllLocations().contains( location );
    }
    
    public boolean isPawn()        { return false; }  // will be overwritten by pawns
    public boolean isWhitePawn()   { return false; }  // will be overwritten by white pawns
    public boolean isBlackPawn()   { return false; }  // will be overwritten by black pawns
    public boolean isKing()        { return false; }  // will be overwritten by kings
    public boolean isQueen()       { return false; }  // will be overwritten by queens
    public boolean isRook()        { return false; }  // will be overwritten by rooks
    public boolean isKnight()      { return false; }  // will be overwritten by knights
    public boolean isBishop()      { return false; }  // will be overwritten by bishops
    
    @Override
    public String toString() {
        return new Piece2String( this ).toString();
    }

    private boolean isMeaningfullyEquivalent( Piece piece ) {
        return( getLocation().compareTo( piece.getLocation() ) == 0
                && getForsythEdwardsNotation() == piece.getForsythEdwardsNotation() );
    }

    @Override
    public boolean equals( Object object ) {
        return ( object instanceof Piece ) && isMeaningfullyEquivalent( ( Piece )object );
    }
    
    @Override
    public int hashCode() {
        return getLocation().hashCode();
    }
}
