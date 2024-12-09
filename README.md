# Boxes inside of boxes, inside of boxes, inside of boxes...

For a given list of size boxes in a random order (XYZ, ZXY, YXZ...), what is the biggest number of boxes that fit in another? 

|X|X|Z|
|-|-|-|
|9|9|9|
|8|8|8|
|7|7|7|
|6|6|6|
|5|5|5|

For this list would be 5, because 5x5x5 fits inside 6x6x6, that fits inside 7x7x7, and so on.

And for this set of 10 boxes?

|X|X|Z|
|-|-|-|
|759|287|208|
|596|152|103|
|688|301|445|
|679|677|94|
|620|921|141|
|45|115|657|
|366|929|253|
|872|525|24|
|630|233|648|
|42|216|806|

And for a list with 100 boxes? 1k? 100k? 1M?

Implemented in Java using functional exepressions (lambda).
