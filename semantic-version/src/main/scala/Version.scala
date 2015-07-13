/**
 * Created by trydofor on 7/13/15.
 */

trait SemanticVersion {
  def latest(vers: Seq[String]): String
}

class Version extends SemanticVersion {

  def vernum(ver: String): Long = {
    val step = 10000L
    val count = 4
    val parts = ver.split( """\D+""", count + 1).take(count).map(_.toLong)
    val vernum = parts.reduceLeft(_ * step + _)
    val adjust = count - parts.length
    if (adjust == 0) vernum else (vernum * Math.pow(step, adjust)).toLong
  }

  @Override def latest(vers: Seq[String]): String = {
    require(vers != null)

    vers.map {
      case v => (v, vernum(v))
    }.maxBy(_._2)._1
  }
}
