# Space Filling Curves
---

There is a mathematical curious thing called "Space Filling Curves" that caught my attention several years ago, and ever since I've been studying its mathematical properties.  

Some [MIT Guy](http://people.csail.mit.edu/jaffer/Geometry/PSFC) defines it the following way:

> "A [space-filling curve](https://en.wikipedia.org/wiki/Space-filling_curve) is a parameterized function which maps a unit line segment to a continuous curve in the unit square, cube, hypercube, etc, which gets arbitrarily close to a given point in the unit cube as the parameter increases."

A more simple (yet incomplete) explanation would be:

>A 1-dimensional geometrical figure that _fills_ a 2-dimensional or higher space when its  length increases to a limit, based on a parameter.

The first person that discovered this kind of mathematical curiosities was [Giuseppe Peano](https://en.wikipedia.org/wiki/Giuseppe_Peano). One of his first discoveries was the following curve:

![Fig1](https://upload.wikimedia.org/wikipedia/commons/6/64/Peanocurve.svg)
_(Three iterations of the Peano curve construction, whose limit is a space-filling curve.)_

And after him there have been a lot of people that have contributed with their own designs ([David Hilbert](https://en.wikipedia.org/wiki/Hilbert_curve), [Wacław Sierpiński](https://en.wikipedia.org/wiki/Sierpi%C5%84ski_curve), among others).

## My contribution

I've been getting into the computer programming behind creating these curves, and I've been surprised with the results.

The first one I programmed is a very well known curve on the internet:

![Fig2](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d.gif)

It is built by dividing in 3 parts a right triangle and uniting it's [centroid](https://en.wikipedia.org/wiki/Triangle_center) points.

Here are the first three iterations:

![Fig3](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d-1.png)
_(Iteration 1)_

![Fig4](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d-2.png)
_(Iteration 2)_

![Fig5](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-1-3d-3.png)
_(Iteration 3)_

The following designs are of my own.

**Using the same methodology**, let's see how it looks when you divide the same right triangle into 4 parts. The design becomes very interesting, some kind of "cellular" like patterns appear after several iterations.

![Fig6](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-2-4d.gif)

Here are the first three iterations:

![Fig7](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-2-4d-1.png)
_(Iteration 1)_

![Fig8](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-2-4d-2.png)
_(Iteration 2)_

![Fig9](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-2-4d-3.png)
_(Iteration 3)_

**Even more interesting patterns appear when the right triangle is divided into 5 parts**.

![Fig10](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-3-5d.gif)

Here are the first three iterations:

![Fig11](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-3-5d-1.png)
_(Iteration 1)_

![Fig12](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-3-5d-2.png)
_(Iteration 2)_

![Fig13](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-3-5d-3.png)
_(Iteration 3)_

Know, I realized that the "speed" in which these curves converge to the limit where they completely fill the 2-dimensional space has no need to be a constant, what do I mean by that?, take any of the curves above, every part of the curve as a result of the division (by 3, 4 or 5) of the area  is more or less the same in terms of length.

The following curves vary in length dramatically depending of the particular sub-section of the area you chose to look, yet, they are also space-filling curves:

![Fig14](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-4-10dr.gif)

![Fig15](https://raw.githubusercontent.com/aaguilerav/space-filling-curves/master/src/main/resources/sfc-4-10d.gif)
