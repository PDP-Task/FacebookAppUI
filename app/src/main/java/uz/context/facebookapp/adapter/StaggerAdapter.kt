package uz.context.facebookapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.context.facebookapp.R
import uz.context.facebookapp.model.Stagger

class StaggerAdapter(
    private val images: ArrayList<Stagger>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image = images[position]

        if (holder is ViewHolder) {

        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //val image: ImageView = view.findViewById(R.id.image_st)
    }
}