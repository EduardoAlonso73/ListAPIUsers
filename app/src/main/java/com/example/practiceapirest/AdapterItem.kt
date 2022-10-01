package com.example.practiceapirestad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practiceapirest.Model.User
import com.example.practiceapirest.R
import com.example.practiceapirest.databinding.ItemUserBinding

class AdapterItem(private var nUser:MutableList<User>/*,private val listener: OnClickListener*/)
    : RecyclerView.Adapter<AdapterItem.ViewHolder>() {
private  lateinit var  mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        mContext=parent.context
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val itemEntity=nUser[position]
        with(holder){
            with(binding){

                tvId.text=itemEntity.id.toString()
                tvName.text=itemEntity.first_name+" "+itemEntity.last_name
                tvEmail.text=itemEntity.email

                Glide.with(mContext)
                    .load(itemEntity.avatar)
                    .centerCrop()
                    .circleCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgUser)

            }
        }
    }
    fun setListUser(storeList: MutableList<User>) {
        this.nUser=storeList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = nUser.size


    inner class  ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding=ItemUserBinding.bind(view)
        fun setListener(itemUser: User){
            //  binding.root.setOnClickListener { listener.onClick(itemEntity) }
            //  binding.cbDelete.setOnClickListener{ listener.onLongClick(itemEntity) }
        }
    }

}
