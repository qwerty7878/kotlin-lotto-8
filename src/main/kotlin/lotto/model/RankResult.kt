package lotto.model

class RankResult(private val lottos: List<Lotto>) {
    private val rankCount = mutableMapOf<Rank, Int>()

    fun calculateRank(winningNumbers: Set<Int>, bonusNumber: Int) {
        lottos.forEach { lotto ->
            val matchCount = lotto.getNumbers().count { it in winningNumbers }
            val isBonus = bonusNumber in lotto.getNumbers()
            val rank = Rank.rankingDeterminate(matchCount, isBonus)

            if (rank != Rank.NONE) {
                rankCount[rank] = rankCount.getOrDefault(rank, 0) + 1
            }
        }
    }

    fun getRankCount(rank: Rank): Int {
        return rankCount.getOrDefault(rank, 0)
    }

    fun getTotalPrize(): Long {
        return rankCount.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        return (getTotalPrize().toDouble() / purchaseAmount) * 100
    }
}