package com.example.yogi_eottae

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
class RVAdapter(val context: Context,val List : MutableList<ContaentsModel>):RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    // item을 넣은 item을 가져와서 inflate해줍니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return ViewHolder(v)
    }

    interface ItemClick {
        fun onClick (view:View,position: Int) //아이템 클릭 구현
    }
    var itemClick : ItemClick? = null

    // onCreateViewHolder에서 가져와서 view에 실제 데이터 연결
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        if (itemClick != null) {
            holder?.itemView?.setOnClickListener { v->
                itemClick!!.onClick(v,position) //아이템 클릭 구현
            }
        }
        holder.bindItems(List[position])

    }

    // item의 총 갯수
    override fun getItemCount(): Int {

        return List.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
       fun bindItems(item : ContaentsModel) {// 아이템은 콘텐츠 모델이다
           val rv_text = itemView.findViewById<TextView>(R.id.rvTextArea)
           val rv_img = itemView.findViewById<ImageView>(R.id.rvImageArea)

           rv_text.text = item.titleText // item에 있는 text값을 적용시킴
           Glide.with(context)
               .load(item.imageUrl)//아이템 이미지url을 넣을 거다
               .into(rv_img) //rv_img에 넣는다

       }
    }
}