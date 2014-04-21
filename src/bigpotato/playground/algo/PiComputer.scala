package bigpotato.playground.algo

import scala.util.Random

/**
 *
 * http://en.wikipedia.org/wiki/Monte_Carlo_method
 *
 *
 * 0.25 * pi * power(R, 2) / 1 = probability
 * pi = 4 * probability / power(R, 2)
 *
 */

object PiComputer {
  val R: Int = 1

  def computePi(iteration: Int): Double = {
    var inCircle = 0

    for (i <- Range(0, iteration)) {
      val x = Random.nextDouble() /*Random.nextDouble() returns a value between 0.0 and 1.0*/
      val y = Random.nextDouble()
      val distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
      if (distance <= R) {
        inCircle = inCircle + 1
      }
    }

    val probability = inCircle.toDouble / iteration.toDouble
    4 * probability
  }

  def computePi(precision: Double): (Double, Int) = {
    var inCircle = 0
    var totalIteration = 0
    var pi = 0.0
    do {
      for (x <- 1 to 1000) {
        //batch calculation
        totalIteration = totalIteration + 1
        val x = Random.nextDouble() /*Random.nextDouble() returns a value between 0.0 and 1.0*/
        val y = Random.nextDouble()
        val distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
        if (distance <= R) {
          inCircle = inCircle + 1
        }
      }
      val probability = inCircle.toDouble / totalIteration.toDouble
      pi = 4 * probability
    } while (Math.abs(Math.PI - pi) / Math.PI > precision)
    (pi, totalIteration)
  }

  def main(args: Array[String]) {
    val count = 500000
    val pi = PiComputer.computePi(count)
    printf("PI is %f after iterating %d times!\n", pi, count)

    val pi_iteration = PiComputer.computePi(0.0000001)
    printf("PI is %f after iterating %d times!\n", pi_iteration._1, pi_iteration._2)
  }
}