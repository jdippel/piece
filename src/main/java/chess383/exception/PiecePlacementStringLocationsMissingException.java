/*
 *  PiecePlacementStringLocationsMissingException.java
 * 
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

package chess383.exception;

/**
 * This class defines a derived exception.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 * 
 */
public class PiecePlacementStringLocationsMissingException extends Chess383PieceException {
	
	/**
     * exception is derived from Exception which implements interface java.io.Serializable
     */
	private static final long serialVersionUID = 6751578148252721123L;

	/**
     * Constructor creates a special exception
     */    
    public PiecePlacementStringLocationsMissingException( ) { }
    
    /**
     * Constructor creates a special exception
     * 
     * @param message is a description of the exception
     */    
    public PiecePlacementStringLocationsMissingException( String message ) {
        
        super( message );
    }
    
    public static void throwPiecePlacementStringLocationsMissingException( String info ) throws Chess383PieceException {
    	
        throw new PiecePlacementStringLocationsMissingException( info );
    }
}
