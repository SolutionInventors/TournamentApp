/**
 * author: Oguejiofor Chidiebere
 * Jul 31, 2017
 * Competitor.java
 * 9:32:17 PM
 *
 */
package com.solutioninventors.tournament.mainClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JFileChooser;

import com.solutioninventors.tournament.exceptions.ImageFormatException;
import com.solutioninventors.tournament.exceptions.NoCompetitorNameException;

public class Competitor
{
	
	/**
	 * This class encapsulates all the information about a competitor
	 * The class stores the name, numberOFWins, numberOfDraws, numberOfLosses
	 * points , image file , and a boolean which is true when the Competitor is eliminated
	 */
	private final String FIRST_NAME;
	private final String LAST_NAME;
	
	private int numberOfWin;
	private int numberOfDraw;
	private int numberOfLoss;
	
	private int goalsScored;
	private int goalsConceded;
	
	private File image;
	private boolean eliminated;
	private double point;
	
	
	public Competitor( String first, String last , File imageFile ) 
	{
		
		
		if ( first  != null  && last   != null )
		{
			FIRST_NAME = first ;
			LAST_NAME = last ;
		}
		else
			throw new 
				NoCompetitorNameException( "You tried to input null as a name" );
		setImage( imageFile );
		setEliminated( false );
		
	}


	public String getFirstName()
	{
		return FIRST_NAME ;
	}

	public String getLastName()
	{
		return LAST_NAME ;
	}
	
	public String getName()
	{
		return getFirstName() + " " + getLastName();
	}
	public int getNumberOfWin()
	{
		return numberOfWin;
	}


	public void incrementWins()
	{
		numberOfWin++;
	}


	public int getNumberOfDraw()
	{
		return numberOfDraw;
	}


	public void incrementDraw()
	{
		numberOfDraw++ ;
	}


	public int getNumberOfLoss()
	{
		return numberOfLoss;
	}


	public void incrementLoss()
	{
		numberOfLoss++ ;
	}


	public File getImage()
	{
		return image;
	}


	public boolean isEliminated()
	{
		return eliminated;
	}


	public void setEliminated(boolean eliminated)
	{
		this.eliminated = eliminated;
	}


	public double getPoint()
	{
		return point;
	}


	public void setPoint( int pWin , int pDraw , int pLoss)
	{
		point =  ( getNumberOfWin() * pWin )  + 
				 ( getNumberOfDraw() * pDraw ) + 
				 ( getNumberOfLoss() *  pLoss );
	}

	

	private void setImage(File imageFile)
	{
//		This method copies the image file and stores it in the class dir
//		It first validates the file and its format
		String imageName = imageFile.getName();
		

		if ( imageFile.exists()  || imageName.indexOf( "." ) < 0 ) 
		{
			String format = imageName.substring( 
					imageName.indexOf( "." ) , imageName.length() ) ; //get the format
			
			if ( format.matches( ".png|.jpg|.jpeg") )
			{
				image = new File( getName()  + format );
				copyFile(imageFile, image ); //copies the file
				
			}
			else
				throw new ImageFormatException( "The file is not a valid image file" );
				
		}
		else
			throw new ImageFormatException( "The URL is not a file" );
	}


	private void copyFile(File fileToCopy , File fileToPaste)
	{
		try
		{
			FileChannel input = new FileInputStream( fileToCopy ).getChannel();
			FileChannel output = new FileOutputStream( fileToPaste ).getChannel() ;
			output.transferFrom( input ,  0 , input.size() );
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	public int getGoalsScored()
	{
		return goalsScored;
	}


	public void incrementGoalsScoredBy(int goals)
	{
		goalsScored += goals ;
	}


	public int getGoalsConceded()
	{
		return goalsConceded;
	}


	public void incrementGoalsConcededBy(int goals)
	{
		goalsConceded+= goals ;
	}

	public int getGoalDifference()
	{
		return getGoalsScored() - getGoalsConceded();
	}

	
}
