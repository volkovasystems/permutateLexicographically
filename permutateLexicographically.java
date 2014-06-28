package permutateLexicographically;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;
import java.util.Collections;

import convertToSequence.convertToSequence;

/*
	NOTE: Always compile with '-d .' 
		And always run with <package-name>.<class-name> format
*/
public class permutateLexicographically{
	private static final String EMPTY_STRING = "";
	
	private static final String NUMBER_PATTERN = "^\\d+$";
	private static final String RANGE_SEPARATOR = "-";

	public static void main( String... parameters ){
		/*
			Parameters: 
				startingIndex
				endingIndex
				dictionary
				separator
		*/
		String startingIndex = parameters[ 0 ];
		String endingIndex = parameters[ 1 ];
		String dictionary = parameters[ 2 ];

		String separator = EMPTY_STRING;
		if( parameters.length == 4 ){
			separator = parameters[ 3 ];
		}

		HashMap<BigInteger, String> sequenceList = null;
		try{
			sequenceList = permutateLexicographically( startingIndex, endingIndex, dictionary, separator );
		}catch( Exception exception ){
			System.err.print( exception.getMessage( ) );
			return;
		}
		
		if( sequenceList.length( ) ){
			Collection<String> sequenceResultList = sequenceList.values( );

			for( String sequence:sequenceResultList ){
				System.out.print( sequence );
			}	
		}
	}

	public static final HashMap<BigInteger, String> permutateLexicographically( String startingIndex, String endingIndex, String dictionary, String separator )
		throws Exception
	{	
		BigInteger startIndex = new BigInteger( startingIndex );
		BigInteger endIndex = new BigInteger( endIndex );
		BigInteger sequenceLength = null;
		
		

		return null;
	}
}