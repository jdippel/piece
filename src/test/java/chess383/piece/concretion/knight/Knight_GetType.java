/*
 *  Knight_GetType.java
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
package chess383.piece.concretion.knight;

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
 * The class Knight_GetType implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
@DisplayName("the public method String getType( ) for class Knight is tested")
public class Knight_GetType {    

	final String ORIGIN = "e5";
	static final ICoordinate board = ICoordinateFactory.STANDARD.get( );
	
    @ParameterizedTest( name = "given a dictionary the name {0} should be returned" )
    @MethodSource("dictionaryProvider")
    public void testWithMultiArgMethodSource_ForDictionary( String expected, Locale language ) {
        
        Knight piece = Knight.create( ORIGIN );
    
        assertThat( expected ).as( "dictionary entry should fit" ).isEqualTo( piece.getType( language ) );
    }
 
    
    public static Stream<Arguments> dictionaryProvider() {
        return Stream.of(
            
            Arguments.of( "S", Locale.GERMAN )
          , Arguments.of( "S", Locale.GERMANY )
          , Arguments.of( "n", Locale.ENGLISH )
          , Arguments.of( "S", Locale.KOREA )        // will be redirected to default
            
        ); }
    
    
    @Test
    @DisplayName("given a dictionary the default name should be returned")
    public void returnDefaultName() {
    	
    	Knight piece = Knight.create( ORIGIN );
    	
    	assertThat( "S" ).as( "default dictionary entry should fit" ).isEqualTo( piece.getType() );
    }
}


