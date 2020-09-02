/*
 *  SmallDictionary.java
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

package chess383.piece.dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides information within a dictionary.
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
public class SmallDictionary {
    
    /** ---------  Attributes  -------------------------------- */
    
    private List<String> dictionary;

    /** ---------  Constructors  ------------------------------ */
    
    private SmallDictionary( )      { setDictionary(); }
    
    /** ---------  Getter and Setter  ------------------------- */
   
    private void setDictionary()            { this.dictionary = new ArrayList<String>(); }
    private List<String>getDictionary()     { return this.dictionary; }
    
    /** ------------------------------------------------------- */
    
    public static SmallDictionary create( List<String> listOfStrings ) {
    
        SmallDictionary result = new SmallDictionary();
        if( listOfStrings.size() > 1 && "default".compareTo( listOfStrings.get( 0 ) ) != 0 ) {
            result.getDictionary().add( "default" );
            result.getDictionary().add( listOfStrings.get( 1 ) );
        }
        for( int cursor = 1; cursor < listOfStrings.size(); cursor+=2 ) {
            result.getDictionary().add( listOfStrings.get( cursor - 1 ) );
            result.getDictionary().add( listOfStrings.get( cursor ) );
        }
        return result;
    }
    
    public String get( String key ) {
    
        for( int cursor = 1; cursor < getDictionary().size(); cursor+=2 ) {
            if( key.compareTo( getDictionary().get( cursor - 1 )) == 0 ) return getDictionary().get( cursor );
        }
        return getDictionary().get( 1 );
    }    
}
