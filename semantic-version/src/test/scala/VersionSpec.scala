/**
 * Created by trydofor on 7/13/15.
 */

import org.scalatest._

class VersionSpec extends FlatSpec {

  val version = new Version
  """"0.13.7", "0.9.10", "0.9.11-RC1"""" should "0.13.7" in {
    assert(version.latest(List("0.13.7", "0.9.10", "0.9.11-RC1")) == "0.13.7")
  }

  """"0.13.6", "0.13.7-RC1", "0.13.7-RC2""""  should "0.13.7-RC2" in {
    assert(version.latest(List("0.13.6", "0.13.7-RC1", "0.13.7-RC2")) == "0.13.7-RC2")
  }
}