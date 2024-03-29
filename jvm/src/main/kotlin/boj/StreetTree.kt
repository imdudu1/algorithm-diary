package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.IntStream

class StreetTree constructor(private val trees: Array<Int>) {

    private tailrec fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a

    fun solution(): Int {
        val d = gcd(trees[1] - trees[0], trees[2] - trees[1])
        return IntStream.range(0, trees.size - 1).map { i ->
            (trees[i + 1] - trees[i]) / d - 1
        }.sum()
    }
}

fun streetTree(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val trees = Array(br.readLine().trim().toInt()) {
        br.readLine().trim().toInt()
    }

    val solution = StreetTree(trees)

    print(solution.solution())
}
