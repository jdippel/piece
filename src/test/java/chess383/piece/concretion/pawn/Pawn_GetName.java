/*
 *  Pawn_GetName.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;

/**
 * <p>
 * The class Pawn_GetName implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
@DisplayName("the public method String getName( ) for class Pawn is tested")
public class Pawn_GetName {    

	static final ICoordinate board = ICoordinateFactory.STANDARD.get( );
	
    @ParameterizedTest( name = "given a dictionary the name {0} should be returned for initial white pawn" )
    @MethodSource("dictionaryProvider")
    public void testWithMultiArgMethodSource_ForDictionaryAndForInitialWhitePawn( String expected, Locale language ) {
        
    	final String ORIGIN = "e2";
        Pawn piece = InitialWhitePawn.create( ORIGIN );
    
        assertThat( expected ).as( "dictionary entry should fit" ).isEqualTo( piece.getName( language ) );
    }
    
    @ParameterizedTest( name = "given a dictionary the name {0} should be returned for moved white pawn" )
    @MethodSource("dictionaryProvider")
    public void testWithMultiArgMethodSource_ForDictionaryAndMovedWhitePawn( String expected, Locale language ) {
        
    	final String ORIGIN = "e5";
        Pawn piece = MovedWhitePawn.create( ORIGIN );
    
        assertThat( expected ).as( "dictionary entry should fit" ).isEqualTo( piece.getName( language ) );
    }
    
    @ParameterizedTest( name = "given a dictionary the name {0} should be returned for moved black pawn" )
    @MethodSource("dictionaryProvider")
    public void testWithMultiArgMethodSource_ForDictionaryAndMovedBlackPawn( String expected, Locale language ) {
        
    	final String ORIGIN = "e5";
        Pawn piece = MovedBlackPawn.create( ORIGIN );
    
        assertThat( expected ).as( "dictionary entry should fit" ).isEqualTo( piece.getName( language ) );
    }
    
    @ParameterizedTest( name = "given a dictionary the name {0} should be returned for initial black pawn" )
    @MethodSource("dictionaryProvider")
    public void testWithMultiArgMethodSource_ForDictionaryAndInitialBlackPawn( String expected, Locale language ) {
        
    	final String ORIGIN = "e7";
        Pawn piece = InitialBlackPawn.create( ORIGIN );
    
        assertThat( expected ).as( "dictionary entry should fit" ).isEqualTo( piece.getName( language ) );
    }
 
    
    public static Stream<Arguments> dictionaryProvider() {
        return Stream.of(
            
            Arguments.of( "Bauer", Locale.GERMAN )
          , Arguments.of( "Bauer", Locale.GERMANY )
          , Arguments.of( "pawn", Locale.ENGLISH )
          , Arguments.of( "Bauer", Locale.KOREA )        // will be redirected to default
            
        ); }
    
    
    
    
    @Test
    @DisplayName("given a dictionary the default name should be returned for moved black pawn")
    public void returnDefaultNameForMovedBlackPawn() {
    	
    	final String ORIGIN = "e5";
    	Pawn piece = MovedBlackPawn.create( ORIGIN );
    	
    	assertThat( "Bauer" ).as( "default dictionary entry should fit" ).isEqualTo( piece.getName() );
    }
    
    @Test
    @DisplayName("given a dictionary the default name should be returned for moved white pawn")
    public void returnDefaultNameForMovedWhitePawn() {
    	
    	final String ORIGIN = "e5";
    	Pawn piece = MovedWhitePawn.create( ORIGIN );
    	
    	assertThat( "Bauer" ).as( "default dictionary entry should fit" ).isEqualTo( piece.getName() );
    }
    
    @Test
    @DisplayName("given a dictionary the default name should be returned for initial white pawn")
    public void returnDefaultNameForInitialWhitePawn() {
    	
    	final String ORIGIN = "e2";
    	Pawn piece = InitialWhitePawn.create( ORIGIN );
    	
    	assertThat( "Bauer" ).as( "default dictionary entry should fit" ).isEqualTo( piece.getName() );
    }
    
    @Test
    @DisplayName("given a dictionary the default name should be returned for initial black pawn")
    public void returnDefaultNameForInitialBlackPawn() {
    	
    	final String ORIGIN = "e7";
    	Pawn piece = MovedBlackPawn.create( ORIGIN );
    	
    	assertThat( "Bauer" ).as( "default dictionary entry should fit" ).isEqualTo( piece.getName() );
    }
}


