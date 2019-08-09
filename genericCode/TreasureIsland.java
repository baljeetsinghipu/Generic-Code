package genericCode;

/*
Treasure Island
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. 
There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
Assume the map area is a two dimensional grid, represented by a matrix of characters.
You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
Output the minimum number of steps to get to the treasure.
from aonecode.com

e.g.
Input
[
[‘O’, ‘O’, ‘O’, ‘O’],
[‘D’, ‘O’, ‘D’, ‘O’],
[‘O’, ‘O’, ‘O’, ‘O’],
[‘X’, ‘D’, ‘D’, ‘O’],
]

Output from aonecode.com
Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps. 
.
K Nearest Post Offices
Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices. from aonecode.com

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output from aonecode.com
[[-1, 2], [0, 3], [4, 3]] 

*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
	
	final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int treasureIsland(char[][] islands){
        if(islands.length == 0 || islands[0].length == 0 || islands[0][0] == 'D') return -1;
        if(islands[0][0] == 'X') return 0;
        int R = islands.length, C = islands[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int steps = 1;
        queue.add(new int[]{0, 0}); islands[0][0] = 'D';
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int[] pos = queue.poll();
                for(int[] dir: dirs){
                    int x = pos[0] + dir[0], y = pos[1] + dir[1];
                    if(x < 0 || x >= R || y < 0 || y >= C || islands[x][y] == 'D') continue;
                    if(islands[x][y] == 'X') return steps;
                    queue.add(new int[]{x, y});
                    islands[x][y] = 'D';
                }
            }
            ++steps;
        }
        return -1;
    }

	public static void main(String[] args) {
		
		TreasureIsland obj = new TreasureIsland();
		char[][] arr = {{'O','O','O','O',},{'D','O','D','O',},{'O','O','O','O',},{'X','D','D','O',}};
		int result = obj.treasureIsland(arr);
		System.out.print(result);
		

	}

}
