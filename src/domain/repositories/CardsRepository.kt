package domain.repositories

import domain.models.Card
import util.datastructures.Stack

class CardsRepository {
    private val cards: Stack<Card> = Stack()

    init {
        cards.push(Card("A001", 10.00))
        cards.push(Card("A002", 10.00))
        cards.push(Card("A003", 10.00))
        cards.push(Card("A004", 10.00))
        cards.push(Card("A005", 10.00))
        cards.push(Card("A006", 10.00))
        cards.push(Card("A007", 10.00))
        cards.push(Card("A008", 10.00))
        cards.push(Card("A009", 10.00))
    }

    fun popTheFirstCard(): Card? {
        return cards.pop()
    }
}