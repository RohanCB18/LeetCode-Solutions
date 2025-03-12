# First approach

## Brute force algorithm
Iterate throuh the array and count number of positives and negatives and return max.

### Time complexity
O(n) -> As whole array is traversed once.

### Space complexity
O(1) -> As no additional data structure is required.


# Second approach

## Optimised algorithm
Perform binary search on the array twice to get first zero and first positve.

### Intuition
[-2, -1, 0, 0, 1, 2]
Length of array = 6
First zero index = 2
First positive index = 4

Pos count = 6 - 4 = 2
Neg count = 2 (First zero index)

### Approach
#### Perform binary search to get lower bound
* Check if mid<= 0
* If it is, then store index and move to right half to check for further 0's.
* If not, move to right to check for 0's.

#### Perform binary search to get upper bound
* Check if mid > 0
* If it is, store index and move to left half to check for smaller positve numbers.
* If not, move right to get positve number.

### Time complexity
O(2 * log(n)) = O(log(n)) -> Binary search

### Space complexity
O(1) -> No data structures used.