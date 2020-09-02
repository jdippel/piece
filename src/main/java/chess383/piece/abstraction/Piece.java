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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides an abstract chess piece.
 *
 * @author    Jörg Dippel
 * @version   August 2020
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
        setMovingLines();
        setCapturingLines();
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private static void setBoard( ICoordinate value )            { board = value; }
    public static ICoordinate getBoard( )                        { return( board ); } 
    
    private void setLocation( String value )                     { this.location = value; }
    public String getLocation( )                                 { return( this.location ); }
    private void setMovingLines( )                               { setMovingLines( new HashSet<>() ); }
    private void setCapturingLines( )                            { setCapturingLines( new HashSet<>() ); }
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
    
    protected void addMovingLines( PieceVector[] attributes ) {
        
        if( validateLocation( location ) ) {
            for( PieceVector attribute : attributes ) {
                setMovingLines( mergeLines( getMovingLines(), clipLines( createLines( location, attribute.getAttribute(), attribute.getDirection() ), attribute.getLength() ) ) );
            }
        }
    }
    
    protected void addCapturingLines( PieceVector[] attributes ) {
        
        if( validateLocation( location ) ) {
            for( PieceVector attribute : attributes ) {
                setCapturingLines( mergeLines( getCapturingLines(), clipLines( createLines( location, attribute.getAttribute(), attribute.getDirection() ), attribute.getLength() ) ) );
            }
        }
    }
    
    protected Set<List<String>> createLines( String location, AdjacencyEnum attribute, Direction direction ) {
        
        Set<List<String>> result;
        
        result = getBoard().getLineBundles( location, direction, attribute );

        return( result );
    }
    
    protected Set<List<String>> clipLines( Set<List<String>> lines, int spread ) {
        
        Set<List<String>> result;

        if ( spread > 0 ) {
            result = new HashSet<List<String>>();
            for( List<String> line : lines ) {
                if ( line.size() <= spread + 1 ) {
                    result.add( line );
                }
                else {
                    List<String> newLine = new ArrayList<>( spread + 1 );
                    for ( int cursor = 0; cursor <= spread; cursor++ ) {
                        newLine.add( line.get( cursor ) );
                    }
                    result.add( newLine );
                }
            }
        }
        else {
            // do nothing: pass through
            result = lines;
        }

        return( result );
    }
    
    protected Set<List<String>> mergeLines( Set<List<String>> lines, Set<List<String>> addedLines ) {
        
        for( List<String> line : addedLines ) {
            lines.add( line );
        }
        return( lines );
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
    
    @Override
    public boolean equals( Object object ) {
        if( object instanceof Piece ) {
            Piece piece = ( Piece )object;
            return( getLocation().compareTo( piece.getLocation() ) == 0 
                 && getForsythEdwardsNotation() == piece.getForsythEdwardsNotation() );
        }
        else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getLocation().hashCode();
    }
}
