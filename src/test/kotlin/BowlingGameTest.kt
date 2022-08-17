import junit.framework.TestCase

class BowlingGameTest : TestCase() {
    private lateinit var game: BowlingGame

    override fun setUp() {
        game = BowlingGame()
    }

    private fun roll(frames: Int, pinsInEachFrame: Int) {
        for (i in 0 until frames)
            game.roll(pinsInEachFrame)
    }

    private fun rollSpare(
        firstRoll: Int = 5,
        secondRoll: Int = 5
    ) =
        game.apply {
            roll(firstRoll)
            roll(secondRoll)
        }

    private fun rollStrike() =
        game.roll(10)

    fun testGutterGame() {
        roll(20, 0)
        assertEquals(0, game.score())
    }

    fun testAllOnes() {
        val totalScore = 20

        roll(20, 1)
        assertEquals(totalScore, game.score())
    }

    fun testOneSpare() {
        rollSpare()
        game.roll(3)
        roll(17, 0)
        assertEquals(16, game.score())
    }

    fun testOneStrike() {
        rollStrike()
        game.roll(3)
        game.roll(4)
        roll(16, 0)
        assertEquals(24, game.score())
    }

    fun testPerfectGame() {
        roll(12, 10)
        assertEquals(300, game.score())
    }
}
