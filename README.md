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

Implemented in Java using functional exepressions (lambda).
