package com.annalech.checkbin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.annalech.checkbin.data.database.BinInfoDBModel
import com.annalech.checkbin.databinding.BinInfoItemBinding
import dagger.hilt.android.AndroidEntryPoint


class BinAdapter : RecyclerView.Adapter<BinAdapter.ViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<BinInfoDBModel>() {
        override fun areItemsTheSame(oldItem: BinInfoDBModel, newItem: BinInfoDBModel): Boolean {
            return oldItem.bin == newItem.bin
        }

        override fun areContentsTheSame(oldItem: BinInfoDBModel, newItem: BinInfoDBModel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)


    class ViewHolder(val binding: BinInfoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BinInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = differ.currentList[position]

        with(holder.binding){
            tvScheme.text = "Тип карты: ${item.scheme }"
            tvBrand.text =  "Бренд: ${item.brand }"
            tvType.text = "Тип: ${item.type  }"
            tvPrepaid.text = "Предоплаченная: ${item.prepaid}}"
            tvCountry.text = "Страна: ${item.country}"

            tvBankName.text = "Банк: ${item.bankName }"
            tvBankCity.text = "Город банка: ${item.bankCity}"
            tvBankUrl.text =  "Сайт: ${item.bankUrl}"
            tvBankPhone.text = "Телефон: ${item.bankPhone}"

            }

    }
}