package com.davidson.breakingbad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davidson.breakingbad.databinding.BreakingBadCharacterCardBinding
import com.davidson.breakingbad.domain.BreakingBadCharacter

class RvBreakingBadHomeAdapter :
    ListAdapter<BreakingBadCharacter, RvBreakingBadHomeAdapter.ItemViewHolder>(DiffUtilCallBack()) {

    private var clickListener: ((imageView: ImageView, breakingBadCharacter: BreakingBadCharacter) -> Unit)? =
        null

    class ItemViewHolder private constructor(private val binding: BreakingBadCharacterCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            position: Int, breakingBadCharacter: BreakingBadCharacter,
            clickListener: ((imageView: ImageView, breakingBadCharacter: BreakingBadCharacter) -> Unit)?
        ) {
            binding.character = breakingBadCharacter
            binding.ivCharacterImage.transitionName = "character${position}"
            clickListener?.let {
                binding.root.setOnClickListener {
                    clickListener.invoke(binding.ivCharacterImage, breakingBadCharacter)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BreakingBadCharacterCardBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }

    fun setOnclickListenerR(clickListener: ((imageView: ImageView, breakingBadCharacter: BreakingBadCharacter) -> Unit)) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position, getItem(position), clickListener)
    }
}

class DiffUtilCallBack : DiffUtil.ItemCallback<BreakingBadCharacter>() {
    override fun areItemsTheSame(
        oldItem: BreakingBadCharacter,
        newItem: BreakingBadCharacter
    ): Boolean {
        return oldItem.characterId == newItem.characterId
    }

    override fun areContentsTheSame(
        oldItem: BreakingBadCharacter,
        newItem: BreakingBadCharacter
    ): Boolean {
        return oldItem == newItem
    }
}
