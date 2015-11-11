import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Cinema {
	
	// private data
	private String id;
	private String showtime;
	private List<Seat> seatList;
	
	// constructor
	public Cinema (String id, String showtime, int rowLim, int numLim)
	{
		this.id = id;
		this.showtime = showtime;
		seatGen (rowLim, numLim);		
	}
	
	public Cinema (String id, String showtime, List<Seat> seatList) 
	{
		this.id = id;
		this.showtime = showtime;
		this.seatList = seatList;
	}
	
	// built-in seat generator
	private void seatGen (int rowLim, int numLim)
	{
		seatList = new ArrayList<Seat>(rowLim * numLim);
		char row = 'A';
		for (int i = 0; i < rowLim; i++)
			for (int j = 0; j < numLim; j++)
			{
				String seatID = Character.toString((char) (row + i)) + (j + 1);
				Seat newSeat = new Seat(seatID);
				seatList.add(newSeat);
			}
	}
	
	// get & set method
	public String getId ()
	{
		return id;
	}
	public String getShowtime ()
	{
		return showtime;
	}
	public List<Seat> getSeatList ()
	{
		return seatList;
	}
	public void setID (String id)
	{
		this.id = id;
	}
	public void setShowtime (String showtime)
	{
		this.showtime = showtime;
	}
	public int countRows() 
	{
		int count = 0;
		String firstrowChar = seatList.get(0).getId().substring(0,1);
		for(Seat seat : seatList) {
			if(seat.getId().substring(0,1).equals(firstrowChar))
				count++;
			else
				break;
		}
		return count;
	}
	public void printSeats(int rowLim) {
		List<String> occupiedSeat = new ArrayList();
		char row = 'A';
		int numLim = seatList.size() / rowLim;
		for(Seat seat : seatList) {
			if(seat.isOccupied())
				occupiedSeat.add(seat.getId());
		}
		for (int i = 0; i < 3 * rowLim - 1; i++) {
				System.out.print("~");
		}
		System.out.println();
		for (int i = 0; i < numLim; i++) {
			for (int j = 0; j < rowLim; j++) {
				boolean occupied = false;
				String seatId = Character.toString((char) (row + i)) + (j + 1);
				for(String id : occupiedSeat) {
					if(id.equals(seatId)) 
						occupied = true;
				}
				if(occupied)
					System.out.print("XX");
				else
					System.out.print(seatId);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}





