package lotto.model

enum class Rank(
    val matchCount: Int,
    val isBouns: Boolean,
    val prize: Long,
    val message: String
) {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "");

    companion object {
        fun rankingDeterminate(matchCount: Int, isBouns: Boolean): Rank {
            return entries.firstOrNull { rank ->
                rank.matchCount == matchCount &&
                rank.isBouns == isBouns
            } ?: NONE
        }
    }
}