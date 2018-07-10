/* Problem 2: Theatre Seating
You run a small theater and each month, you have patrons mail in requests for pre-sale tickets.  You need to process these ticket requests and either tell them where their party will sit or explain to the patron why you can't complete their order.
 
You have a few rules that you need to follow when you fill the orders
Fill as many orders as possible
Put parties as close to the front as possible.
If there are not enough seats available in the theater to handle a party, tell them "Sorry, we can't handle your party."
Each party must sit in a single row in a single section.  If they won't fit, tell them "Call to split party".
 
Your program must parse a theater layout and a list of ticket requests and produce a list of tickets or explanations in the same order as the requests.
 
The theater layout is made up of 1 or more rows.  Each row is made up of 1 or more sections separated by a space.

After the theater layout, there is one empty line, followed by 1 or more theater requests.  The theater request is made up of a name followed by a space and the number of requested tickets.
 
 
Sample input:
6 6
3 5 5 3
4 6 6 4
2 8 8 2
6 6 
 
Smith 2
Jones 5
Davis 6
Wilson 100
Johnson 3
Williams 4
Brown 8
Miller 12
 
Your program must produce results to standard output in the same order as the requests, with the name of the person who requested the ticket and either the row and section of the ticket or the explanations "Sorry, we can't handle your party" or "Call to split party."
 
 
Sample output:
 
Smith Row 1 Section 1
Jones Row 2 Section 2
Davis Row 1 Section 2
Wilson Sorry, we can't handle your party.
Johnson Row 2 Section 1
Williams Row 1 Section 1
Brown Row 4  Section 2
Miller Call to split party.
*/

package com.theater.seating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.theater.seating.service.TicketService;
import com.theater.seating.service.TicketServiceImpl;

public class App {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Start theater : ");
			List<String> seats = new ArrayList<String>();
			List<String> tickets = new ArrayList<String>();
			Boolean theaterUp = false;
			while (true) {
				String input = br.readLine();
				if (!theaterUp && input != null && !(input.trim().length() == 0)) {
					seats.add(input);
				} else if (input.trim().length() == 0) {
					if(theaterUp) {
						TicketService service = TicketServiceImpl.startTheater(seats, false);
						service.showMeTheater();
						tickets.forEach(t -> {
							String[] split = t.split(" ");
							System.out.println(service.bookATicket(split[0], Integer.parseInt(split[1])));
						});
						service.showMeTheater();
						System.exit(0);
					}
					theaterUp=true;
					continue;
				} else {
					tickets.add(input);
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
