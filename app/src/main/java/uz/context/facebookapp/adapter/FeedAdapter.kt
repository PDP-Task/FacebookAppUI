package uz.context.facebookapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.imageview.ShapeableImageView
import uz.context.facebookapp.R
import uz.context.facebookapp.model.Feed
import uz.context.facebookapp.model.Stagger
import uz.context.facebookapp.model.Story

class FeedAdapter(
    val context: Context,
    private val items: ArrayList<Feed>

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM_HEAD = 0
        private const val TYPE_ITEM_STORY = 1
        private const val TYPE_ITEM_POST = 2
    }

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        if (feed.isHeader)
            return TYPE_ITEM_HEAD
        else if (feed.stories.size > 0)
            return TYPE_ITEM_STORY
        return TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed_header, parent, false)
            return HeaderViewHolder(view)
        } else if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeaderViewHolder) {
        }

        if (holder is StoryViewHolder) {
            refreshAdapter(feed.stories, holder.recyclerView)
        }
        if (holder is PostViewHolder) {
            holder.apply {
                ivProfile.setImageResource(feed.post!!.profile)
                tvFullName.text = feed.post!!.fullName
            }
        }
    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        private val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        init {
            recyclerView.layoutManager = manager
        }
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        private val recyclerview: RecyclerView = view.findViewById(R.id.recyclerview_st)
        val tvFullName: TextView = view.findViewById(R.id.tv_fullname)
        init {
            val adapter = StaggerAdapter(images())
            recyclerview.layoutManager = LinearLayoutManager(context)
            recyclerview.adapter = adapter
        }
    }

    private fun images(): ArrayList<Stagger> {
        val staggerList: ArrayList<Stagger> = ArrayList()
        staggerList.add(Stagger(R.drawable.img_android))
        staggerList.add(Stagger(R.drawable.img_java))
        staggerList.add(Stagger(R.drawable.kotlin_img))
        staggerList.add(Stagger(R.drawable.img_android))
        staggerList.add(Stagger(R.drawable.img_java))
        staggerList.add(Stagger(R.drawable.kotlin_img))
        return staggerList
    }
}