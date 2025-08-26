# Boxes Inside Boxes

This project solves the problem of determining the **maximum number of
boxes** that can be nested inside each other, given a list of 3D boxes
with random dimensions. The solution calculates the longest sequence of
boxes where each box fits entirely inside the next.

## Problem Description

Given a list of boxes with different dimensions (width, height, depth)
in random order, the goal is to find the largest possible sequence of
boxes such that each one can fit inside the next.

**Example:**

|Box|X|Y|Z|
|-|-|-|-|
|1|9|9|9|
|2|8|8|8|
|3|7|7|7|
|4|6|6|6|
|5|5|5|5|

For this dataset, the maximum chain length is **5**, because box `5` fits into `4`, which fits into `3`, which fits into `2`, which fits into `1`.

The algorithm also scales to handle larger datasets --- from small sets of **10 boxes** up to thousands or even millions of boxes.

|Box|X|Y|Z|
|-|-|-|-|
|1|759|287|208|
|2|596|152|103|
|3|688|301|445|
|4|679|677|94|
|5|620|921|141|
|6|45|115|657|
|7|366|929|253|
|8|872|525|24|
|...|...|...|...|
|n|42|216|806|

## Implementation Details

-   Implemented in **Java** using a **functional programming style**
    with lambda expressions and streams.
-   Boxes are sorted by dimensions, and a **directed graph** is
    constructed where each edge represents a valid nesting between two
    boxes.
-   The algorithm computes the **longest path** in the graph using a
    **Depth-First Search (DFS)** strategy with memoization for
    performance optimization.
-   Designed to efficiently handle datasets of varying sizes (from a few
    boxes up to very large inputs).

## Technologies Used

-   **Java 17+**
-   Functional programming constructs (streams, lambdas)
-   Graph algorithms (DFS, longest path)
-   Efficient data parsing and processing

## License
This project is open-source. See the [LICENSE](LICENSE) file for more details.
