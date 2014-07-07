package permutateLexicographically;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;

import static convertToSequence.convertToSequence.convertToSequence;

/*
	NOTE: Always compile with '-d .' 
		And always run with <package-name>.<class-name> format
*/
public class permutateLexicographically{
	public static final String EMPTY_STRING = "";

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

		Map <BigInteger, String> sequenceList = null;
		try{
			sequenceList = permutateLexicographically( startingIndex, endingIndex, dictionary, separator );
		}catch( Exception exception ){
			System.err.print( exception.getMessage( ) );
			return;
		}

        if( sequenceList.size( ) > 0 ){
            String[ ] sequenceListArray = sequenceList.values( ).toArray( new String[ sequenceList.size( ) ] );
            System.out.print( Arrays.toString( sequenceListArray ).replaceAll( "^\\[|\\]$", "" ) );
        }else{
            throw new Exception( "no permutation happened" );
        }
	}

	public static final Map <BigInteger, String> permutateLexicographically( String startingIndex, String endingIndex, String dictionary, String separator )
		throws Exception
	{	
		BigInteger startIndex = new BigInteger( startingIndex );
		BigInteger endIndex = new BigInteger( endingIndex );
		LinkedHashMap <BigInteger, String> sequenceList = new LinkedHashMap<>( );

		if( endIndex.compareTo( startIndex ) == 1 ){
			BigInteger currentIndex = new BigInteger( startIndex.toString( ) );

			do{
				String sequence = convertToSequence( currentIndex.toString( ), dictionary, separator );
				sequenceList.put( currentIndex, sequence );

				currentIndex = currentIndex.add( BigInteger.ONE );
			}while( currentIndex.compareTo( endIndex ) <= 0 );
		}else{
			throw new Exception( "ending index is not greater than starting index" );
		}

		return sequenceList;
	}
}