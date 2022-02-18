package uz.context.facebookapp.adapter

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.context.facebookapp.R
import uz.context.facebookapp.model.Story

class StoryAdapter(
    context: Context,
    private val items: ArrayList<Story>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 0
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.create_story, parent, false)
            ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
            StoryViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                ivBack.setBackgroundResource(story.profile)
                ivProfile.setBackgroundResource(story.profile)
                tvFullName.text = story.fullName
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBack: ShapeableImageView = view.findViewById(R.id.iv_background)
        val ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_fullname)
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}