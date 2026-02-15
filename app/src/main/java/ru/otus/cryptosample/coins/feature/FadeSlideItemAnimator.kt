package ru.otus.cryptosample.coins.feature

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class FadeSlideItemAnimator : DefaultItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {

        holder.itemView.apply {
            alpha = 0f
            translationX = -50f
            animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(250)
                .setListener(null)
                .start()
        }

        dispatchAddFinished(holder)
        return false
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {

        holder.itemView.animate()
            .alpha(0f)
            .translationX(50f)
            .setDuration(250)
            .withEndAction {
                dispatchRemoveFinished(holder)
            }
            .start()

        return true
    }
}
