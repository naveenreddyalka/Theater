# Theater

App.java is the Main class

First full empty line will be used as end of seating arrangements
Second full empty line will be used for end of tickets need to be booked 

Below is the sample request and response.
We print the theater before and after ticketing.


Start theater : 6 6
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


                        =======SCREEN=======

               [_][_][_][_][_][_]   [_][_][_][_][_][_]   
      [_][_][_]   [_][_][_][_][_]   [_][_][_][_][_]   [_][_][_]   
[_][_][_][_]   [_][_][_][_][_][_]   [_][_][_][_][_][_]   [_][_][_][_]   
[_][_]   [_][_][_][_][_][_][_][_]   [_][_][_][_][_][_][_][_]   [_][_]   
               [_][_][_][_][_][_]   [_][_][_][_][_][_]   
Smith, row=1, section=1
Jones, row=1, section=2
Davis, row=3, section=2
Wilson,NO_TICKETS
Johnson, row=1, section=1
Williams, row=2, section=2
Brown, row=4, section=2
Miller,NEED_TO_SPLIT

                        =======SCREEN=======

               [x][x][x][x][x][_]   [x][x][x][x][x][_]   
      [_][_][_]   [x][x][x][x][_]   [_][_][_][_][_]   [_][_][_]   
[_][_][_][_]   [x][x][x][x][x][x]   [_][_][_][_][_][_]   [_][_][_][_]   
[_][_]   [x][x][x][x][x][x][x][x]   [_][_][_][_][_][_][_][_]   [_][_]   
               [_][_][_][_][_][_]   [_][_][_][_][_][_]  
