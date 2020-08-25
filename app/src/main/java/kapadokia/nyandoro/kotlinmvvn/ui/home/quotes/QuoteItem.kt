package kapadokia.nyandoro.kotlinmvvn.ui.home.quotes

import com.xwray.groupie.databinding.BindableItem
import kapadokia.nyandoro.kotlinmvvn.R
import kapadokia.nyandoro.kotlinmvvn.data.db.entities.Quote
import kapadokia.nyandoro.kotlinmvvn.databinding.ItemQuoteBinding

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>(){

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}