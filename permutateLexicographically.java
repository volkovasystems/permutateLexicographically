package permutateLexicographically;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;
import java.util.Collections;

import calculatePartition.calculatePartition;
import convertToSequence.convertToSequence;

public class permutateLexicographically{
	private static final String EMPTY_STRING = "";
	
	private static final String NUMBER_PATTERN = "^\\d+$";
	private static final String RANGE_SEPARATOR = "-";

	public static void main( String... parameters ){
		/*
			Parameters: 
				distance
				dictionary
				separator
		*/
		String distance = parameters[ 0 ];
		String dictionary = parameters[ 1 ];

		String separator = EMPTY_STRING;
		if( parameters.length == 3 ){
			separator = parameters[ 2 ];
		}

		HashMap<BigInteger, String> sequenceList = null;
		try{
			sequenceList = permutateLexicographically( distance, dictionary, separator );
		}catch( Exception exception ){
			System.err.print( exception.getMessage( ) );
			return;
		}
		
		Collection<String> sequenceResultList = sequenceList.values( );

		for( String sequence:sequenceResultList ){
			System.out.print( sequence );
		}
	}

	public static final HashMap<BigInteger, String> permutateLexicographically( String distance, String dictionary, String separator )
		throws Exception
	{	
		BigInteger startingIndex = null;
		BigInteger endingIndex = null;
		BigInteger sequenceLength = null;
		
		if( distance.matches( RANGE_SEPARATOR ) ){
			String[ ] rangeTuple = distance.split( RANGE_SEPARATOR );
			startingIndex = new BigInteger( rangeTuple[ 0 ] );
			endingIndex = new BigInteger( rangeTuple[ 1 ] );

			/*
				We're adding 1 because the permutation is not zero based.
			*/
			sequenceLength = endingIndex.subtract( startingIndex ).add( BigInteger.ONE );	
		}else if( distance.matches( NUMBER_PATTERN ) ){
			sequenceLength = new BigInteger( distance );

			startingIndex = BigInteger.ONE;
			endingIndex = sequenceLength;
		}else{
			throw new Exception( "invalid distance" );
		}

		return null;
	}
}