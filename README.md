# Space Filling Curves
---

There is a mathematical curious thing called "Space Filling Curves" that caught my attention several years ago, and ever since I've been studying its mathematical properties.  

Some [MIT](http://people.csail.mit.edu/jaffer/Geometry/PSFC) guy defines it the following way:

> "A [space-filling curve](https://en.wikipedia.org/wiki/Space-filling_curve) is a parameterized function which maps a unit line segment to a continuous curve in the unit square, cube, hypercube, etc, which gets arbitrarily close to a given point in the unit cube as the parameter increases."

A more simple (yet incomplete) explanation would be:

>A 1-dimensional geometrical figure that _fills_ a 2-dimensional or higher space when its  length increases to a limit, based on a parameter.

The first person that discovered this kind of mathematical curiosities was [Giuseppe Peano](https://en.wikipedia.org/wiki/Giuseppe_Peano). One of his first discoveries was the following curve:

![Fig1](https://upload.wikimedia.org/wikipedia/commons/6/64/Peanocurve.svg)
_(Three iterations of the Peano curve construction, whose limit is a space-filling curve.)_

And after him there have been a lot of people that have contributed with their own designs ([David Hilbert](https://en.wikipedia.org/wiki/Hilbert_curve), [Wacław Sierpiński](https://en.wikipedia.org/wiki/Sierpi%C5%84ski_curve), among others).

## My contribution

I've been getting into the computer programming behind creating these curves, and I've been surprised with the results.

The first one I programmed, is a very well known curve on the internet:

![Fig2](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d.gif)

It is built by dividing in 3 parts a right triangle and uniting it's [centroid](https://en.wikipedia.org/wiki/Triangle_center) points.

Here are the first two iterations:

||||
|::|::|::|
|![Fig3](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d-1.png)|![Fig4](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d-2.png)|![Fig5](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d-3.png)|

Using the same methodology, Let's see how it looks like when you divide the same right triangle in 4 parts:

![Fig5](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-2-4d.gif)
