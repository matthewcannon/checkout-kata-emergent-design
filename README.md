# Checkout Kata
Implement the code for a supermarket checkout that calculates the total price of a number of items.

In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. In our store,
we’ll use individual letters of the alphabet (A, B, C, and so on) as item codes. Our goods are
priced individually.

In addition, some items are multipriced: buy `n` of them, and they’ll cost you `y` pence. For example,
item ‘A’ might cost 50 pence individually, but this week we have a special offer: buy three ‘A’s and
they’ll cost you £1.30.

|Item code|Unit price|Special price|
|---|---|---|
|A|50p|3 for £1.30|
|B|30p|2 for 45p|
|C|20p||
|D|15p||
