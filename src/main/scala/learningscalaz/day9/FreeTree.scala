package learningscalaz.day9

import scalaz._
import Scalaz._

object FreeTree {
  def main(args: Array[String]): Unit = {
    def freeTree: Tree[Char] =
      'P'.node(
        'O'.node(
          'L'.node('N'.leaf, 'T'.leaf),
          'Y'.node('S'.leaf, 'A'.leaf)),
        'L'.node(
          'W'.node('C'.leaf, 'R'.leaf),
          'A'.node('A'.leaf, 'C'.leaf)))

    def changeToP(tree: Tree[Char]): Tree[Char] = tree match {
      case Tree.Node(x, Stream(
        l, Tree.Node(y, Stream(
          Tree.Node(_, Stream(m, n)), r)))) =>
        x.node(l, y.node('P'.node(m, n), r))
    }
  }
}
