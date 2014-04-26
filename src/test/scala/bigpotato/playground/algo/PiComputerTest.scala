package bigpotato.playground.algo

import org.scalatest.FunSuite

/**
 * Created by wujin on 4/26/14.
 */
class PiComputerTest extends FunSuite {
  test("compute PI with specific precision") {
    val computer = new PiComputer
    val pi_iteration = computer.computePi(0.0000001)
    assert( Math.abs(Math.PI - pi_iteration._1)/Math.PI <= 0.0000001)
  }
}
