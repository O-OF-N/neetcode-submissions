
def compute_time(start:int, target:int, speed:int)->int:
    return (target-start)/speed

class Solution:

    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        num_fleet = 0
        num_cars = len(position)
        speeds = []
        sorted_starts = sorted(zip(position,speed), reverse=True)
        slowest_time = 0
        for p,s in sorted_starts:
            time = compute_time(p, target, s)
            if time>slowest_time:
                num_fleet+=1
                slowest_time= time
        return num_fleet
            
        

"""
6, 8, 10
1,3,5,7,9,10
0,1,2,3,4,5,6,7,8,9,10
7,8,9,10

1 and 4

1 ->  1,0
2 ->  3, 1
3 -> 5,2
4 -> 7,3
5 -> 9,4
6 -> 10,5
7 -> 6
8 -> 7
9 -> 8
10-> 9
11 => 10
"""